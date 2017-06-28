package com.professional.micromaster.photossocial.lib.di;

import android.support.v4.app.Fragment;

import com.professional.micromaster.photossocial.lib.GreenRobotEventBus;
import com.professional.micromaster.photossocial.lib.base.EventBus;

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
    Fragment providesFragment() {
        return this.fragment;
    }
}
