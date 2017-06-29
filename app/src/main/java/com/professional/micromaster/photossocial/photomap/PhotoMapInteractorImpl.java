package com.professional.micromaster.photossocial.photomap;

/**
 * Created by Roberto on 29/06/17.
 */

public class PhotoMapInteractorImpl implements PhotoMapInteractor {
    private PhotoMapRepository repository;

    public PhotoMapInteractorImpl(PhotoMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }
}
