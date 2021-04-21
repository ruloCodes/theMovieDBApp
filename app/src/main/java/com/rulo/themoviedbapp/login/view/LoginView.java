package com.rulo.themoviedbapp.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rulo.themoviedbapp.R;
import com.rulo.themoviedbapp.beans.Usuario;
import com.rulo.themoviedbapp.login.contract.LoginContract;
import com.rulo.themoviedbapp.login.presenter.LoginPresenter;
import com.rulo.themoviedbapp.peliculas.listasPeliculas.view.PeliculasView;

public class LoginView extends AppCompatActivity implements LoginContract.View {

    private EditText etUserMail;
    private EditText etUserPass;
    private Button btIniciarSesion;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        initComponents();

        btIniciarSesion.setOnClickListener(v -> compruebaUsuario());
    }

    private void initComponents() {
        etUserMail = findViewById(R.id.etUserMail);
        etUserPass = findViewById(R.id.etUserPass);
        btIniciarSesion = findViewById(R.id.btIniciarSesion);

        presenter = new LoginPresenter(this);
    }

    private void compruebaUsuario() {
        if (etUserMail.getText().toString().isEmpty() || etUserPass.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.login_view_campos_incompletos, Toast.LENGTH_SHORT).show();
            return;
        }

        String userMail = etUserMail.getText().toString();
        String userPass = etUserPass.getText().toString();

        Usuario user = new Usuario(userMail, userPass);

        presenter.getUser(user);
    }

    public void success() {
        Intent intent = new Intent(this, PeliculasView.class);
        startActivity(intent);
        finish();
    }

    public void error () {
        Toast.makeText(this, R.string.login_view_error, Toast.LENGTH_SHORT).show();
    }

}