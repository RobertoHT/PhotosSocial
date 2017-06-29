package com.professional.micromaster.photossocial.photomap;

import com.professional.micromaster.photossocial.photomap.event.PhotoMapEvent;

/**
 * Created by Roberto on 29/06/17.
 */

public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
