package com.rulo.themoviedbapp.login.model;

import android.os.AsyncTask;

import com.rulo.themoviedbapp.beans.Usuario;
import com.rulo.themoviedbapp.login.contract.LoginContract;

public class LoginModel implements LoginContract.Model {

    private OnLoginUserListener onLoginUserListener;

    private final String USER_MAIL = " ";
    private final String USER_PASS = " ";
    private Usuario user;

    @Override
    public void getUser(Usuario user, OnLoginUserListener onLoginUserListener) {
        this.onLoginUserListener = onLoginUserListener;
        this.user = user;
        new getUserBack().execute();
    }

    class getUserBack extends AsyncTask<Usuario, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Usuario... usuarios) {
            return user.getEmail().equals(USER_MAIL) && user.getPassword().equals(USER_PASS);
        }

        @Override
        protected void onPostExecute(Boolean existe) {
            if (existe)
                onLoginUserListener.correcto();
            else
                onLoginUserListener.erroneo();
        }
    }

}
