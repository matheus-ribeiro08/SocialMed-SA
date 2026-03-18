package org.example.presenter;

import org.example.exception.ValorInvalido;
import org.example.roteador.Roteador;
import org.example.view.adm.viewADM;

public class ADMpresenter {

    private final viewADM view;
    private final Roteador roteador;


    public ADMpresenter(Roteador roteador, viewADM view) {
        this.roteador = roteador;
        this.view = view;
    }

    public void MenuADM() {
        try {
            int op = view.mostrarMenuPrincipalADM();

            switch (op) {
                case 1 -> CadastrarUsuario();
                case 2 -> roteador.irPara("menuInicial");
                default -> {
                    System.out.println("Valor inválido!!!");
                    MenuADM();
                }
            }
        } catch (ValorInvalido e) {
            System.out.println(e.getMessage());
            MenuADM();
        }
    }

    public void CadastrarUsuario() {
        roteador.irPara("cadastro");
    }
}