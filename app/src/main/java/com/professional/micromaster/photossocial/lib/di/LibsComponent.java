package com.professional.micromaster.photossocial.lib.di;

import com.professional.micromaster.photossocial.PhotoSocialAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roberto on 28/06/17.
 */

@Singleton
@Component(modules = {LibsModule.class, PhotoSocialAppModule.class})
public interface LibsComponent {
}
