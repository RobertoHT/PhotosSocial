package com.professional.micromaster.photossocial.login.di;

import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.login.LoginInteractor;
import com.professional.micromaster.photossocial.login.LoginInteractorImpl;
import com.professional.micromaster.photossocial.login.LoginPresenter;
import com.professional.micromaster.photossocial.login.LoginPresenterImpl;
import com.professional.micromaster.photossocial.login.LoginRepository;
import com.professional.micromaster.photossocial.login.LoginRepositoryImpl;
import com.professional.micromaster.photossocial.login.SignupInteractor;
import com.professional.micromaster.photossocial.login.SignupInteractorImpl;
import com.professional.micromaster.photossocial.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto on 28/06/17.
 */

@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor, SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }

    @Provides @Singleton
    LoginRepository providesLoginRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new LoginRepositoryImpl(firebase, eventBus);
    }
}
