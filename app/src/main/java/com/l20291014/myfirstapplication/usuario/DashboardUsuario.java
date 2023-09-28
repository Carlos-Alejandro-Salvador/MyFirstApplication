package com.l20291014.myfirstapplication.usuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import android.widget.TextView;

import com.l20291014.myfirstapplication.R;
import com.l20291014.myfirstapplication.usuario.model.Usuario;
import com.l20291014.myfirstapplication.usuario.repository.UsuarioRepository;

public class DashboardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_usuario);
        //Se crea la instancia
        ur = UsuarioRepository.getInstance();

        //Se consiguen los datos que recibimos de la otra activity
        String usuario = getIntent().getStringExtra("usuario");
        String pass = getIntent().getStringExtra("pass");

        //Obtenemos informacion del usuario logueado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);

        //EditText etUser = findViewById(R.id.etUser);
        //EditText etPassword = findViewById(R.id.etPassword);
        EditText etName = findViewById(R.id.etName);
        EditText etAge = findViewById(R.id.etAge);
        EditText etEmail = findViewById(R.id.etEmail);

        //etUser.setText(userInfo.getUsuario().toString());
        //etPassword.setText(userInfo.getPass().toString());
        etName.setText(userInfo.getNombre().toString());
        etAge.setText(String.valueOf(userInfo.getEdad()));
        etEmail.setText(userInfo.getEmail().toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar toolbar = findViewById(R.id.toolbar);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}