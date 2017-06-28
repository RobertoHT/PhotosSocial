package com.professional.micromaster.photossocial.login.ui;

/**
 * Created by Roberto on 28/06/17.
 */

public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void newUserSucess();
    void navigateToMainScreen();
    void setUserEmail(String email);

    void loginError(String error);
    void newUserError(String error);
}
