package com.professional.micromaster.photossocial.domain.di;

import com.professional.micromaster.photossocial.PhotoSocialAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roberto on 28/06/17.
 */

@Singleton
@Component(modules = {DomainModule.class, PhotoSocialAppModule.class})
public interface DomainComponent {
}
