package org.example.service;

import org.example.dao.UsuarioDAO;
import org.example.model.UsuarioModel;

public class UsuarioService {
    private UsuarioDAO dao;

    public UsuarioService() {
        this.dao = new UsuarioDAO();
    }

    public boolean cadastrar(UsuarioModel usuario) {

        if (usuario.getNomeUsuario() == null || usuario.getNomeUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (usuario.getEmailUsuario() == null || !usuario.getEmailUsuario().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (usuario.getSenhaUsuario() == null || usuario.getSenhaUsuario().length() < 6) {
            throw new IllegalArgumentException("Senha deve ter no mínimo 6 caracteres");
        }
        if (usuario.getCpfUsuario() == null || usuario.getCpfUsuario().length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos");
        }

        return dao.cadastrarUsuario(usuario);
    }

    public UsuarioModel login(String email, String senha) {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email obrigatório");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Senha obrigatória");
        }

        return dao.login(email, senha);
    }
}