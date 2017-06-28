package com.professional.micromaster.photossocial.login;

/**
 * Created by Roberto on 28/06/17.
 */

public class SignupInteractorImpl implements SignupInteractor {
    private LoginRepository repository;

    public SignupInteractorImpl(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String email, String password) {
        repository.signUp(email, password);
    }
}
