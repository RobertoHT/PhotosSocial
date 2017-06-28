package com.professional.micromaster.photossocial;

import android.app.Application;

import com.firebase.client.Firebase;
import com.professional.micromaster.photossocial.domain.di.DomainModule;
import com.professional.micromaster.photossocial.lib.di.LibsModule;
import com.professional.micromaster.photossocial.login.di.DaggerLoginComponent;
import com.professional.micromaster.photossocial.login.di.LoginComponent;
import com.professional.micromaster.photossocial.login.di.LoginModule;
import com.professional.micromaster.photossocial.login.ui.LoginView;

/**
 * Created by Roberto on 28/06/17.
 */

public class PhotoSocialApp extends Application {
    private final static String EMAIL_KEY = "email";
    private LibsModule libsModule;
    private DomainModule domainModule;
    private PhotoSocialAppModule photoSocialAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public static String getEmailKey() {
        return EMAIL_KEY;
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
        photoSocialAppModule = new PhotoSocialAppModule(this);
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoSocialAppModule(photoSocialAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();
    }
}
