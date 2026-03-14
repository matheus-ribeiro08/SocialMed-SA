package org.example.presenter;

import org.example.exception.ValorInvalido;
import org.example.view.adm.viewADM;

public class ADMpresenter {

    viewADM viewADM = new viewADM();
    CadastrarUsuarioPresenter cadastrarUsuarioPresenter = new CadastrarUsuarioPresenter();

    public void MenuADM()
    {
        try
        {
        int op = viewADM.mostrarMenuPrincipalADM();

        switch (op)
        {
            case 1 -> CadastrarUsuario();
          //  case 2 -> menuLogin();
            default -> System.out.println("Valor invalido!!!");
        }
        }catch (ValorInvalido e)
        {
            System.out.println(e.getMessage());
        }

        }

    public void CadastrarUsuario() {

        cadastrarUsuarioPresenter.ColetarInformacoes();


    }
}
