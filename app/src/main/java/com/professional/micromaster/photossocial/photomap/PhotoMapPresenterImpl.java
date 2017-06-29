package com.professional.micromaster.photossocial.photomap;

import com.professional.micromaster.photossocial.lib.base.EventBus;
import com.professional.micromaster.photossocial.photomap.event.PhotoMapEvent;
import com.professional.micromaster.photossocial.photomap.ui.PhotoMapView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Roberto on 29/06/17.
 */

public class PhotoMapPresenterImpl implements PhotoMapPresenter {
    private EventBus eventBus;
    private PhotoMapView view;
    private PhotoMapInteractor interactor;

    public PhotoMapPresenterImpl(EventBus eventBus, PhotoMapView view, PhotoMapInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void subscribe() {
        interactor.subscribe();
    }

    @Override
    public void unsubscribe() {
        interactor.unsubscribe();
    }

    @Override
    @Subscribe
    public void onEventMainThread(PhotoMapEvent event) {
        if (view != null) {
            String error = event.getError();
            if (error != null) {
                view.onPhotosError(error);
            } else {
                if (event.getType() == PhotoMapEvent.READ_EVENT) {
                    view.addPhoto(event.getPhoto());
                }
                else if (event.getType() == PhotoMapEvent.DELETE_EVENT) {
                    view.removePhoto(event.getPhoto());
                }
            }
        }
    }
}
