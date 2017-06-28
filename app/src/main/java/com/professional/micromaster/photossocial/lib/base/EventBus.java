package com.professional.micromaster.photossocial.lib.base;

/**
 * Created by Roberto on 28/06/17.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
