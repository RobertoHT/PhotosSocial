package com.professional.micromaster.photossocial.photolist;

import android.text.TextUtils;

import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.domain.FirebaseActionListenerCallback;
import com.professional.micromaster.photossocial.domain.FirebaseEventListenerCallback;
import com.professional.micromaster.photossocial.entities.Photo;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.photolist.event.PhotoListEvent;

/**
 * Created by Roberto on 29/06/17.
 */

public class PhotoListRepositoryImpl implements PhotoListRepository {
    private FirebaseAPI firebase;
    private EventBus eventBus;

    public PhotoListRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.firebase = firebase;
        this.eventBus = eventBus;
    }

    @Override
    public void subscribe() {
        firebase.checkForData(new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {}

            @Override
            public void onError(FirebaseError error) {
                if (error != null) {
                    post(PhotoListEvent.READ_EVENT, error.getMessage());
                } else {
                    post(PhotoListEvent.READ_EVENT, "");
                }
            }
        });

        firebase.subscribe(new FirebaseEventListenerCallback() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                String email = firebase.getAuthEmail();

                boolean publishedByMe = !TextUtils.isEmpty(email) && !TextUtils.isEmpty(photo.getEmail()) && photo.getEmail().equals(email);
                photo.setPublishedByMe(publishedByMe);
                post(PhotoListEvent.READ_EVENT, photo);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                post(PhotoListEvent.READ_EVENT, error.getMessage());
            }
        });
    }

    @Override
    public void unsubscribe() {
        firebase.unsubscribe();
    }

    @Override
    public void remove(final Photo photo) {
        firebase.remove(photo, new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onError(FirebaseError error) {}
        });
    }

    private void post(int type, String error) {
        post(type, null, error);
    }

    private void post(int type, Photo photo) {
        post(type, photo, null);
    }

    private void post(int type, Photo photo, String error) {
        PhotoListEvent event = new PhotoListEvent();
        event.setType(type);
        event.setPhoto(photo);
        event.setError(error);
        eventBus.post(event);
    }
}
