package com.rulo.themoviedbapp.login.presenter;

import com.rulo.themoviedbapp.beans.Usuario;
import com.rulo.themoviedbapp.login.contract.LoginContract;
import com.rulo.themoviedbapp.login.model.LoginModel;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View vista;
    private LoginContract.Model model;

    public LoginPresenter(LoginContract.View vista) {
        this.vista = vista;
        this.model = new LoginModel();
    }

    @Override
    public void getUser(Usuario user) {
        model.getUser(user, new LoginContract.Model.OnLoginUserListener() {
            @Override
            public void correcto() {
                vista.success();
            }

            @Override
            public void erroneo() {
                vista.error();
            }
        });
    }

}
