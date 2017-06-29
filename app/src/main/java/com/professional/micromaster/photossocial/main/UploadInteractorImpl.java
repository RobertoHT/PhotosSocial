package com.professional.micromaster.photossocial.main;

import android.location.Location;

/**
 * Created by Roberto Hdez. on 28/06/17.
 */

public class UploadInteractorImpl implements UploadInteractor {
    private MainRepository repository;

    public UploadInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Location location, String path) {
        repository.uploadPhoto(location, path);
    }
}
