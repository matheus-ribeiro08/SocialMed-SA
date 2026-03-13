package org.example.roteador;

import org.example.presenter.CadastrarUsuarioPresenter;
import org.example.view.CadastroViewConsole;

public class RoteadorCadastro {

    public void irPara(String destino){
        switch (destino){
            case "cadastro": {
                CadastroViewConsole cadastroView = new CadastroViewConsole();
                CadastrarUsuarioPresenter cadastroPresenter = new CadastrarUsuarioPresenter(this, cadastroView);
                cadastroPresenter.iniciarCadastro();
                break;
            }

            case "login":

        }
    }
}
