package com.professional.micromaster.photossocial.main.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.lib.base.ImageStorage;
import com.professional.micromaster.photossocial.main.MainPresenter;
import com.professional.micromaster.photossocial.main.MainPresenterImpl;
import com.professional.micromaster.photossocial.main.MainRepository;
import com.professional.micromaster.photossocial.main.MainRepositoryImpl;
import com.professional.micromaster.photossocial.main.SessionInteractor;
import com.professional.micromaster.photossocial.main.SessionInteractorImpl;
import com.professional.micromaster.photossocial.main.UploadInteractor;
import com.professional.micromaster.photossocial.main.UploadInteractorImpl;
import com.professional.micromaster.photossocial.main.ui.MainView;
import com.professional.micromaster.photossocial.main.ui.adapter.MainSectionsPagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto Hdez. on 28/06/17.
 */

@Module
public class MainModule {
    private MainView view;
    private String[] titles;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;

    public MainModule(MainView view, FragmentManager fragmentManager, Fragment[] fragments, String[] titles) {
        this.view = view;
        this.titles = titles;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Provides @Singleton
    MainView providesMainView() {
        return this.view;
    }

    @Provides @Singleton
    MainPresenter providesMainPresenter(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        return new MainPresenterImpl(view, eventBus, uploadInteractor, sessionInteractor);
    }

    @Provides @Singleton
    UploadInteractor providesUploadInteractor(MainRepository repository) {
        return new UploadInteractorImpl(repository);
    }

    @Provides @Singleton
    SessionInteractor providesSessionInteractor(MainRepository repository) {
        return new SessionInteractorImpl(repository);
    }

    @Provides @Singleton
    MainRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        return new MainRepositoryImpl(eventBus, firebase, imageStorage);
    }

    @Provides @Singleton
    MainSectionsPagerAdapter providesMainSectionsPagerAdapter(FragmentManager fm, Fragment[] fragments, String[] titles) {
        return new MainSectionsPagerAdapter(fm, fragments, titles);
    }

    @Provides @Singleton
    FragmentManager providesFragmentManager() {
        return this.fragmentManager;
    }

    @Provides @Singleton
    Fragment[] providesFragmentArrayForAdapter() {
        return this.fragments;
    }

    @Provides @Singleton
    String[] providesStringArrayForAdapter() {
        return this.titles;
    }
}
