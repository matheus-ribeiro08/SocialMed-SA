package org.example.service;

import org.example.dao.UsuarioDAO;
import org.example.model.UsuarioModel;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(){
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrar(UsuarioModel usuario){

        //if(usuarioDao.buscarPorEmail(usuario.getEmail()) != null){}

        //if(usuarioDao.buscarPorCpf(usuario.getCpf()) != null){}




    }


}