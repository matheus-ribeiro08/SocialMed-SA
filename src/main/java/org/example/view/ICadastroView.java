package org.example.view;

import org.example.model.UsuarioModel;

import java.util.List;

public interface ICadastroView {

    int mostrarMenuPrincipal();

    UsuarioModel getDadosCadastro();
    UsuarioModel getDadosLogin();

    void mostrarMensagem(String mensagem);
    void mostrarErro(String mensagem);
    void mostrarSucesso(String mensagem);
    void mostrarAviso(String mensagem);

    boolean confirmarOperacao(String mensagem);

    void limparTela();
    void aguardarTecla();
    void pausar();
}