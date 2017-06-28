package com.professional.micromaster.photossocial.login;

/**
 * Created by Roberto on 28/06/17.
 */

public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
