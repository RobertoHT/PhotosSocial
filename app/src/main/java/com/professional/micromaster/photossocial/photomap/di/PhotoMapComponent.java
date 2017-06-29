package com.professional.micromaster.photossocial.photomap.di;

import com.professional.micromaster.photossocial.PhotoSocialAppModule;
import com.professional.micromaster.photossocial.domain.di.DomainModule;
import com.professional.micromaster.photossocial.lib.di.LibsModule;
import com.professional.micromaster.photossocial.photomap.ui.PhotoMapFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roberto on 29/06/17.
 */

@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoSocialAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment fragment);
}
