package org.example.presenter.acoes;

import org.example.enums.Destinos;
import org.example.roteador.Roteador;

public class ErroPresenter {

    private final Roteador roteador;

    public ErroPresenter(Roteador roteador){
        this.roteador = roteador;
    }

    public void iniciar(){
        System.err.println("Ocorreu um erro inesperado!");
        System.out.println("Pressione ENTER para voltar ao menu Inicial...");

        try {
            System.in.read();
        }catch (Exception e){

        }

        roteador.irPara(Destinos.MENU_INICIAL, null);
    }
}
