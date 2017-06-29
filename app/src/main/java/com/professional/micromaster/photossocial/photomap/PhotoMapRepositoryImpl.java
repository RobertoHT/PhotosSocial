package com.professional.micromaster.photossocial.photomap;

import android.text.TextUtils;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.professional.micromaster.photossocial.domain.FirebaseAPI;
import com.professional.micromaster.photossocial.domain.FirebaseEventListenerCallback;
import com.professional.micromaster.photossocial.entities.Photo;
import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.photomap.event.PhotoMapEvent;

/**
 * Created by Roberto on 29/06/17.
 */

public class PhotoMapRepositoryImpl implements PhotoMapRepository {
    private FirebaseAPI firebase;
    private EventBus eventBus;

    public PhotoMapRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.firebase = firebase;
        this.eventBus = eventBus;
    }

    @Override
    public void subscribe() {
        firebase.subscribe(new FirebaseEventListenerCallback() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                String email = firebase.getAuthEmail();

                boolean publishedByMe = !TextUtils.isEmpty(email) && !TextUtils.isEmpty(photo.getEmail()) && photo.getEmail().equals(email);
                photo.setPublishedByMe(publishedByMe);
                post(PhotoMapEvent.READ_EVENT, photo);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                post(PhotoMapEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                post(error.getMessage());
            }
        });
    }

    @Override
    public void unsubscribe() {
        firebase.unsubscribe();
    }

    private void post(int type, Photo photo) {
        post(type, photo, null);
    }

    private void post(String error) {
        post(0, null, error);
    }

    private void post(int type, Photo photo, String error) {
        PhotoMapEvent event = new PhotoMapEvent();
        event.setType(type);
        event.setPhoto(photo);
        event.setError(error);
        eventBus.post(event);
    }
}
