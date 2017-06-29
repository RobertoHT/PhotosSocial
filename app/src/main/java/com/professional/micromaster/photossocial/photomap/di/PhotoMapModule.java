package com.professional.micromaster.photossocial.photomap.di;

import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.photomap.PhotoMapInteractor;
import com.professional.micromaster.photossocial.photomap.PhotoMapInteractorImpl;
import com.professional.micromaster.photossocial.photomap.PhotoMapPresenter;
import com.professional.micromaster.photossocial.photomap.PhotoMapPresenterImpl;
import com.professional.micromaster.photossocial.photomap.PhotoMapRepository;
import com.professional.micromaster.photossocial.photomap.PhotoMapRepositoryImpl;
import com.professional.micromaster.photossocial.photomap.ui.PhotoMapView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto on 29/06/17.
 */

@Module
public class PhotoMapModule {
    private PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides @Singleton
    PhotoMapView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoMapPresenter providesPhotoContentPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor listInteractor) {
        return new PhotoMapPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoMapInteractor providesPhotoContentInteractor(PhotoMapRepository repository) {
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoMapRepository providesPhotoContentRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoMapRepositoryImpl(firebase, eventBus);
    }
}
