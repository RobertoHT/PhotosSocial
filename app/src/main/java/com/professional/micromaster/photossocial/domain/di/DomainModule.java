package com.professional.micromaster.photossocial.domain.di;

import android.content.Context;
import android.location.Geocoder;

import com.firebase.client.Firebase;
import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.domain.Util;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto on 28/06/17.
 */

@Module
public class DomainModule {
    private final static String FIREBASE_URL = "https://photos-social.firebaseio.com/";

    @Provides @Singleton
    FirebaseAPI providesFirebaseAPI(Firebase firebase) {
        return new FirebaseAPI(firebase);
    }

    @Provides @Singleton
    Firebase providesFirebase() {
        return new Firebase(FIREBASE_URL);
    }

    @Provides @Singleton
    Util providesUtil(Geocoder geocoder) {
        return new Util(geocoder);
    }

    @Provides @Singleton
    Geocoder providesGeocoder(Context context) {
        return new Geocoder(context);
    }
}
