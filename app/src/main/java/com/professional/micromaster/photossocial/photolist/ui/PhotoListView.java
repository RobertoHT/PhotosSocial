package com.professional.micromaster.photossocial.photolist.ui;

import com.professional.micromaster.photossocial.entities.Photo;

/**
 * Created by Roberto on 29/06/17.
 */

public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
