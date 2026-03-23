package org.example.presenter.menuInicial;

import org.example.enums.Destinos;
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
                roteador.irPara(Destinos.LOGIN, null);
                break;
            }
            case 2:{
                roteador.irPara(Destinos.CADASTRO, null);
                break;
            }
            case 0:{
                roteador.irPara(Destinos.SAIR, null);
                break;
            }
            default:{
                System.err.println("Opção invalida");
                iniciar();
            }
        }
    }
}
