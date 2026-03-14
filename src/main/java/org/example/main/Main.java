package org.example.main;

import org.example.roteador.RoteadorCadastro;

public class Main {
    public static void main(String[] args) {

        try {
            RoteadorCadastro roteador = new RoteadorCadastro();

            roteador.irPara("menuInicial");
        }catch (Exception e){
            System.out.println("Erro fatal no sistema!");
        }
    }
}