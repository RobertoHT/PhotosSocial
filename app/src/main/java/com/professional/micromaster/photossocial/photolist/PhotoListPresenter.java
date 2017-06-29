package com.professional.micromaster.photossocial.photolist;

import com.professional.micromaster.photossocial.entities.Photo;
import com.professional.micromaster.photossocial.photolist.event.PhotoListEvent;

/**
 * Created by Roberto on 29/06/17.
 */

public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
