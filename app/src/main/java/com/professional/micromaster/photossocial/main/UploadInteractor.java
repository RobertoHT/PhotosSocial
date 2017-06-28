package com.professional.micromaster.photossocial.main;

import android.location.Location;

/**
 * Created by Roberto on 28/06/17.
 */

public interface UploadInteractor {
    void execute(Location location, String path);
}
