package com.professional.micromaster.photossocial.main;

import android.location.Location;

/**
 * Created by Roberto on 28/06/17.
 */

public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
