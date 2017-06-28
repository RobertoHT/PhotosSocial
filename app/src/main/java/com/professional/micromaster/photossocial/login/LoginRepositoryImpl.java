package com.professional.micromaster.photossocial.login;

import android.support.annotation.NonNull;

import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.domain.FirebaseActionListenerCallback;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.login.event.LoginEvent;

/**
 * Created by Roberto on 28/06/17.
 */

public class LoginRepositoryImpl implements LoginRepository {
    private EventBus eventBus;
    private FirebaseAPI firebase;
    private DatabaseReference databaseReference;
    private DatabaseReference myUserReference;

    public LoginRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.eventBus = eventBus;
        this.firebase = firebase;
    }

    @Override
    public void signUp(final String email, final String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        post(LoginEvent.onSignUpSuccess);
                        signIn(email, password);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        post(LoginEvent.onSignUpError, e.getMessage());
                    }
                });
    }

    @Override
    public void signIn(String email, String password) {
        if (email != null && password != null) {
            try {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                String email = firebase.getAuthEmail();
                                post(LoginEvent.onSignInSuccess, null, email);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                post(LoginEvent.onSignInError, e.getMessage());
                            }
                        });
            } catch (Exception e) {
                post(LoginEvent.onSignInError, e.getMessage());
            }
        } else {
            firebase.checkForSession(new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    String email = firebase.getAuthEmail();
                    post(LoginEvent.onSignInSuccess, null, email);
                }

                @Override
                public void onError(FirebaseError error) {
                    post(LoginEvent.onFailedToRecoverSession);
                }
            });
        }
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String errorMessage) {
        post(type, errorMessage, null);
    }

    private void post(int type, String errorMessage, String loggedUserEmail) {
        LoginEvent event = new LoginEvent();
        event.setEventType(type);
        if (errorMessage != null) {
            event.setErrorMesage(errorMessage);
        }
        event.setLoggedUserEmail(loggedUserEmail);
        eventBus.post(event);
    }
}
