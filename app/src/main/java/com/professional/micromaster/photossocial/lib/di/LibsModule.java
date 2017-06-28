package com.professional.micromaster.photossocial.lib.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.professional.micromaster.photossocial.lib.CloudinaryImageStorage;
import com.professional.micromaster.photossocial.lib.GlideImageLoader;
import com.professional.micromaster.photossocial.lib.GreenRobotEventBus;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.lib.base.ImageLoader;
import com.professional.micromaster.photossocial.lib.base.ImageStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto on 28/06/17.
 */

@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }

        return imageLoader;
    }

    @Provides @Singleton
    ImageStorage providesImageStorage(Context context, EventBus eventBus) {
        ImageStorage imageStorage = new CloudinaryImageStorage(context, eventBus);

        return imageStorage;
    }

    @Provides @Singleton
    Fragment providesFragment() {
        return this.fragment;
    }
}
