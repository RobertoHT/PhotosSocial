package com.professional.micromaster.photossocial.login;

/**
 * Created by Roberto on 28/06/17.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository repository;

    public LoginInteractorImpl(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String email, String password) {
        repository.signIn(email, password);
    }
}
