package com.professional.micromaster.photossocial.login.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.professional.micromaster.photossocial.MainActivity;
import com.professional.micromaster.photossocial.PhotoSocialApp;
import com.professional.micromaster.photossocial.R;
import com.professional.micromaster.photossocial.login.LoginPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {
    @Bind(R.id.editTxtEmail)
    EditText editTxtEmail;
    @Bind(R.id.editTxtPassword)
    EditText editTxtPassword;
    @Bind(R.id.btnSignin)
    Button btnSignin;
    @Bind(R.id.btnSignup)
    Button btnSignup;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.layoutMainContainer)
    RelativeLayout layoutMainContainer;

    @Inject
    LoginPresenter presenter;
    @Inject
    SharedPreferences sharedPreferences;
    private PhotoSocialApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        app = (PhotoSocialApp) getApplication();

        setupInjection();
        presenter.onCreate();
        presenter.login(null, null);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void setupInjection() {
        app.getLoginComponent(this).inject(this);
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    @OnClick(R.id.btnSignup)
    public void handleSignUp() {
        presenter.registerNewUser(editTxtEmail.getText().toString(), editTxtPassword.getText().toString());
    }

    @Override
    @OnClick(R.id.btnSignin)
    public void handleSignIn() {
        presenter.login(editTxtEmail.getText().toString(), editTxtPassword.getText().toString());
    }

    @Override
    public void newUserSucess() {
        Snackbar.make(layoutMainContainer, R.string.login_notice_message_useradded, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void setUserEmail(String email) {
        if (email != null) {
            String key = app.getEmailKey();
            sharedPreferences.edit().putString(key, email).commit();
        }
    }

    @Override
    public void loginError(String error) {
        editTxtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        editTxtPassword.setError(msgError);
    }

    @Override
    public void newUserError(String error) {
        editTxtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup), error);
        editTxtPassword.setError(msgError);
    }

    private void setInputs(boolean enable) {
        btnSignin.setEnabled(enable);
        btnSignup.setEnabled(enable);
        editTxtEmail.setEnabled(enable);
        editTxtPassword.setEnabled(enable);
    }
}
