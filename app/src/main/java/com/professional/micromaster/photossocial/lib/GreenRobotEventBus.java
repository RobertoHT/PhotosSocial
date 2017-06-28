package com.professional.micromaster.photossocial.lib;

import com.professional.micromaster.photossocial.lib.base.EventBus;

/**
 * Created by Roberto on 28/06/17.
 */

public class GreenRobotEventBus implements EventBus {
    private org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus() {
        eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
