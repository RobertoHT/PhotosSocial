package com.professional.micromaster.photossocial.main;

import android.location.Location;

import com.professional.micromaster.photossocial.main.event.MainEvent;

/**
 * Created by Roberto on 28/06/17.
 */

public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);
}
