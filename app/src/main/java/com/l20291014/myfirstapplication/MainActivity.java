package com.l20291014.myfirstapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l20291014.myfirstapplication.usuario.DashboardUsuario;
import com.l20291014.myfirstapplication.usuario.repository.UsuarioRepository;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private HashMap<String,String> registeredUsers = new HashMap<String, String>();
    UsuarioRepository ur = UsuarioRepository.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //registeredUsers.put("asd1","asd1");
        //registeredUsers.put("asd2","asd2");
        //registeredUsers.put("asd3","asd3");
    }

    private AlertDialog createAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message);
                /*Los mutables son aquellos que cuando accedemos podemos modificar sus valores, y los inmutables
                //es cuando no se modifican, en este caso puede ser String por que su metodo toUpperCase no modifica la String en si
                //Si no que devuelve un valor, la unica forma en que la podemos modificar es modificar o crear nuevas
                */
        return builder.create();
    }

    public void onBtnIngresarTap(View view){
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog =  builder.create();
        */
        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass = findViewById(R.id.etPass);
        String user, pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if(!ur.getRegisteredUsers().containsKey(user)){
            //dialog.setTitle("Atención");
            //dialog.setMessage("El usuario no coincide");
            //dialog.show();
            this.createAlertDialog("Atencion","Usuario no Registrado").show();
            return;
        }

        if(!ur.getRegisteredUsers().get(user).containsKey(pass)){
            //dialog.setTitle("Atención");
            //dialog.setMessage("La contraseña no coincide");
            //dialog.show();
            this.createAlertDialog("Atencion","Contraseña no Coincide").show();
            return;
        }
        //user.toUpperCase();
        //dialog.setTitle("Felicidades, has iniciado sesión");
        //dialog.setMessage(String.format("Datos ingresados\nUsuario: %s \nContraseña: %s", user, pass));
        //dialog.show();
        String message = "Felicidades, ha iniciado sesion con exito";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        Intent i = new Intent(this,DashboardUsuario.class);//packageContext, quien lo va a lanzar, el siguiente es a quien

        //Ponemos los datos, algo asi como cuando inyectamos datos en php
        i.putExtra("usuario",user);
        i.putExtra("pass",pass);

        //Iniciamos la activity
        startActivity(i);
    }

}