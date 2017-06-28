package com.professional.micromaster.photossocial.login.di;

import com.professional.micromaster.photossocial.PhotoSocialAppModule;
import com.professional.micromaster.photossocial.domain.di.DomainModule;
import com.professional.micromaster.photossocial.lib.di.LibsModule;
import com.professional.micromaster.photossocial.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roberto on 28/06/17.
 */

@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, PhotoSocialAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
