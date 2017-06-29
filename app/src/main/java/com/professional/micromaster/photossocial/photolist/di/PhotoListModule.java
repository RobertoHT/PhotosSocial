package com.professional.micromaster.photossocial.photolist.di;

import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.domain.Util;
import com.professional.micromaster.photossocial.entities.Photo;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.lib.base.ImageLoader;
import com.professional.micromaster.photossocial.photolist.PhotoListInteractor;
import com.professional.micromaster.photossocial.photolist.PhotoListInteractorImpl;
import com.professional.micromaster.photossocial.photolist.PhotoListPresenter;
import com.professional.micromaster.photossocial.photolist.PhotoListPresenterImpl;
import com.professional.micromaster.photossocial.photolist.PhotoListRepository;
import com.professional.micromaster.photossocial.photolist.PhotoListRepositoryImpl;
import com.professional.micromaster.photossocial.photolist.ui.PhotoListView;
import com.professional.micromaster.photossocial.photolist.ui.adapter.OnItemClickListener;
import com.professional.micromaster.photossocial.photolist.ui.adapter.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto on 29/06/17.
 */

@Module
public class PhotoListModule {
    private PhotoListView view;
    private OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    PhotoListView providesPhotoListView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoListRepositoryImpl(firebase, eventBus);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotoListAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Photo> providesPhotoList() {
        return new ArrayList<Photo>();
    }
}
