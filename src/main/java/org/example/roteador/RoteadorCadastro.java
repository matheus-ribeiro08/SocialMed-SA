package org.example.roteador;

import org.example.model.UsuarioModel;
import org.example.presenter.CadastrarUsuarioPresenter;
import org.example.presenter.LoginUsuarioPresenter;
import org.example.utils.Ferramentas;
import org.example.view.cadastro.CadastroViewConsole;
import org.example.view.login.LoginViewConsole;
import org.example.viewInterface.viewLogin.ILoginView;

public class RoteadorCadastro {

    public void irPara(String destino){
        irPara(destino, null);
    }

    public void irPara(String destino, UsuarioModel usuario){
        switch (destino){
            case "menuInicial":{
                mostrarMenuInicial();
                break;
            }

            case "cadastro": {
                CadastroViewConsole cadastroView = new CadastroViewConsole();
                CadastrarUsuarioPresenter cadastroPresenter = new CadastrarUsuarioPresenter(this, cadastroView);
                cadastroPresenter.iniciarCadastro();
                break;
            }

            case "login":{
                ILoginView loginView = new LoginViewConsole();
                LoginUsuarioPresenter loginUsuarioPresenter = new LoginUsuarioPresenter(this, loginView);
                loginUsuarioPresenter.iniciarLogin();
                break;
            }

            case "menuPaciente":{


                break;
            }

            case "menuSecretario":{

                break;
            }

        }
    }

    public void mostrarMenuInicial(){
        ILoginView viewTemp = new LoginViewConsole();
        int opcao = viewTemp.mostrarMenuInicial();

        switch (opcao){
            case 1:{
                irPara("login");
                break;
            }
            case 2:{
                irPara("cadastro");
                break;
            }
            case 0:{
                System.out.println("Saindo do sistema...");
                Ferramentas.Delay(1500);
                break;
            }
            default:{
                System.out.println("Opção invalida");
                mostrarMenuInicial();
            }
        }
    }
}
