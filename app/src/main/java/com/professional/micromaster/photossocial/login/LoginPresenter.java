package com.professional.micromaster.photossocial.login;

import com.professional.micromaster.photossocial.login.event.LoginEvent;

/**
 * Created by Roberto on 28/06/17.
 */

public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
    void registerNewUser(String email, String password);
}
