package org.example.view;

import org.example.model.UsuarioModel;

import java.util.List;

public interface ICadastroView {

    int mostrarMenuPrincipal();
    String[] getDadosCadastro();
    String[] getDadosLogin();
    void mostrarMensagem(String mensagem);
    void mostrarErro(String mensagem);
    void mostrarSucesso(String mensagem);
}