package org.example.service;

import org.example.dao.UsuarioDAO;
import org.example.exception.CpfInvalido;
import org.example.exception.EmailInvalido;
import org.example.model.UsuarioModel;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(){
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrar(UsuarioModel usuario){

        if(usuarioDAO.existeEmail(usuario.getEmailUsuario()) != null){
            throw new EmailInvalido("O email ja foi cadastrado");
        }

        if(usuarioDAO.existeCpf(usuario.getCpfUsuario()) != null){
            throw new CpfInvalido("O Cpf ja foi cadastrado");
        }

        usuarioDAO.cadastrarUsuario(usuario);
    }

    public UsuarioModel login(String email, String senha){

        UsuarioModel usuario = usuarioDAO.buscarPorEmail(email);

        if(usuario == null){
            throw new RuntimeException("Usuario não encontrado");
        }

        if(!usuario.getSenhaUsuario().equals(senha)){
            throw new RuntimeException("Senha incorreta");
        }

        return usuario;
    }


}