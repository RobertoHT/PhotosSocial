package com.professional.micromaster.photossocial.photolist;

import com.professional.micromaster.photossocial.entities.Photo;

/**
 * Created by Roberto on 29/06/17.
 */

public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();
    void removePhoto(Photo photo);
}
