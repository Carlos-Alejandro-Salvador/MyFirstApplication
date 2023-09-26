package com.l20291014.myfirstapplication.usuario.repository;

import com.l20291014.myfirstapplication.usuario.model.Usuario;

import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;

public class UsuarioRepository {
    private static UsuarioRepository repository = null;
    private HashMap<String,HashMap<String, Usuario>> registeredUsers;

    private UsuarioRepository(){
        Usuario u1 = new Usuario("asd1","asd1","asd1",12,"asd1");
        Usuario u2 = new Usuario("asd2","asd2","asd2",12,"asd2");
        Usuario u3 = new Usuario("asd3","asd3","asd3",12,"asd3");

        this.registeredUsers = new HashMap<String,HashMap<String,Usuario>>();

        registeredUsers.put(u1.getUsuario(), new HashMap<String,Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPass(),u1);

        registeredUsers.put(u2.getUsuario(), new HashMap<String,Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPass(),u2);

        registeredUsers.put(u3.getUsuario(), new HashMap<String,Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPass(),u3);
    }

    public static UsuarioRepository getInstance(){
        if (repository == null)
            repository = new UsuarioRepository();

        return repository;
    }

    public HashMap<String, HashMap<String, Usuario>> getRegisteredUsers() {
        return registeredUsers;
    }
}
