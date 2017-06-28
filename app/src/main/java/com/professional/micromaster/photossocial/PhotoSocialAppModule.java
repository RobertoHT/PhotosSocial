package com.professional.micromaster.photossocial;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto on 28/06/17.
 */

@Module
public class PhotoSocialAppModule {
    private final static String SHARED_PREFERENCES_NAME = "UsersPrefs";
    private Application application;

    public PhotoSocialAppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return application.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Provides @Singleton
    Context providesContext() {
        return application.getApplicationContext();
    }

    @Provides @Singleton
    Application providesApplication() {
        return application;
    }
}
