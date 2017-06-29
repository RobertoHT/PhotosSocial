package com.professional.micromaster.photossocial.main.di;

import com.professional.micromaster.photossocial.PhotoSocialAppModule;
import com.professional.micromaster.photossocial.domain.di.DomainModule;
import com.professional.micromaster.photossocial.lib.di.LibsModule;
import com.professional.micromaster.photossocial.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roberto Hdez. on 28/06/17.
 */

@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoSocialAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
