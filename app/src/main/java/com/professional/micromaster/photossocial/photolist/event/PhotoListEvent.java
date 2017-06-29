package com.professional.micromaster.photossocial.photolist.event;

import com.professional.micromaster.photossocial.entities.Photo;

/**
 * Created by Roberto on 29/06/17.
 */

public class PhotoListEvent {
    public final static int READ_EVENT = 0;
    public final static int DELETE_EVENT = 1;

    private int type;
    private Photo photo;
    private String error;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
