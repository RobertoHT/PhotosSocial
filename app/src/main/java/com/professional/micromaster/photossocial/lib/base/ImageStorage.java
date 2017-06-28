package com.professional.micromaster.photossocial.lib.base;

import java.io.File;

/**
 * Created by Roberto on 28/06/17.
 */

public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
