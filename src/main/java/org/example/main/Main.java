package org.example.main;

import org.example.enums.Destinos;
import org.example.roteador.Roteador;

public class Main {
    public static void main(String[] args) {

        try {
            Roteador roteador = new Roteador();

            roteador.irPara(Destinos.MENU_INICIAL, null);
        }catch (Exception e){
            System.out.println("Erro fatal no sistema!");
        }
    }
}