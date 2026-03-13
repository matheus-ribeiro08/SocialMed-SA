package org.example.service;

import org.example.dao.UsuarioDAO;
import org.example.exception.EmailInvalido;
import org.example.model.UsuarioModel;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(){
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrar(UsuarioModel usuario){

        if(usuarioDAO.existeEmail(usuario.getEmailUsuario()){
            throw new EmailInvalido("O email ja foi cadastrado")
        }

        if(usuarioDao.buscarPorCpf(usuario.getCpf()) != null){

        }




    }


}