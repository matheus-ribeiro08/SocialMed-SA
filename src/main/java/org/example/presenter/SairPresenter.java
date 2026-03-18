package org.example.presenter;

import org.example.roteador.Roteador;
import org.example.utils.Ferramentas;

public class SairPresenter {

    private final Roteador roteador;

    public SairPresenter(Roteador roteador){
        this.roteador = roteador;
    }

    public void iniciar(){
        System.out.println("Saindo do sistema...");
        Ferramentas.Delay(1500);
    }
}
