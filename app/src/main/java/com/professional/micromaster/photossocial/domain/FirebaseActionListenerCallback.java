package com.professional.micromaster.photossocial.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by Roberto on 28/06/17.
 */

public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
