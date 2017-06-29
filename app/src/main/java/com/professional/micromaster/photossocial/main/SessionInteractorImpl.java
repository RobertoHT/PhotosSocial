package com.professional.micromaster.photossocial.main;

/**
 * Created by Roberto Hdez. on 28/06/17.
 */

public class SessionInteractorImpl implements SessionInteractor {
    private MainRepository repository;

    public SessionInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logout() {
        repository.logout();
    }
}
