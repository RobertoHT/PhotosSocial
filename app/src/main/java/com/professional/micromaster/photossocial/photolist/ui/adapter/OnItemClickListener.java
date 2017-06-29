package com.professional.micromaster.photossocial.photolist.ui.adapter;

import android.widget.ImageView;

import com.professional.micromaster.photossocial.entities.Photo;

/**
 * Created by Roberto on 29/06/17.
 */

public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
}
