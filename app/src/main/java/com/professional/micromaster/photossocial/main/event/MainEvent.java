package com.professional.micromaster.photossocial.main.event;

/**
 * Created by Roberto on 28/06/17.
 */

public class MainEvent {
    public static final int UPLOAD_INIT = 0;
    public static final int UPLOAD_COMPLETE = 1;
    public static final int UPLOAD_ERROR = 2;

    private int type;
    private String error;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
