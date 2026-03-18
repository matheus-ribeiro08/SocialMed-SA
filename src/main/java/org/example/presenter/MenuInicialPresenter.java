package org.example.presenter;

import org.example.roteador.Roteador;
import org.example.view.login.LoginViewConsole;

public class MenuInicialPresenter {

    private final Roteador roteador;
    private final LoginViewConsole view;

    public MenuInicialPresenter(Roteador roteador){
        this.roteador = roteador;
        this.view = new LoginViewConsole();
    }

    public void iniciar(){
        int opcao = view.mostrarMenuInicial();

        switch (opcao){
            case 1:{
                roteador.irPara(Roteador.Destino.LOGIN);
                break;
            }
            case 2:{
                roteador.irPara(Roteador.Destino.CADASTRO);
                break;
            }
            case 0:{
                roteador.irPara(Roteador.Destino.SAIR);
                break;
            }
            default:{
                System.err.println("Opção invalida");
                iniciar();
            }
        }
    }
}
