package com.professional.micromaster.photossocial.domain;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/**
 * Created by Roberto on 28/06/17.
 */

public interface FirebaseEventListenerCallback {
    void onChildAdded(DataSnapshot dataSnapshot);
    void onChildRemoved(DataSnapshot dataSnapshot);
    void onCancelled(DatabaseError error);
}
