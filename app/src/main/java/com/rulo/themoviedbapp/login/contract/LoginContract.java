package com.rulo.themoviedbapp.login.contract;

import com.rulo.themoviedbapp.beans.Usuario;

public interface LoginContract {

    interface View {
        void success();
        void error();
    }

    interface Presenter {
        void getUser(Usuario user);
    }

    interface Model {
        void getUser(Usuario user, OnLoginUserListener onLoginUserListener);
        interface OnLoginUserListener {
            void correcto();
            void erroneo();
        }
    }

}
