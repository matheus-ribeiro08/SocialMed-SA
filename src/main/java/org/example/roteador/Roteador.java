package org.example.roteador;

import org.example.enums.TipoUsuario;
import org.example.model.*;
import org.example.presenter.CadastrarUsuarioPresenter;
import org.example.presenter.LoginUsuarioPresenter;
import org.example.presenter.MenuPacientePresenter;
import org.example.utils.Ferramentas;
import org.example.view.cadastro.CadastroViewConsole;
import org.example.view.login.LoginViewConsole;
import org.example.view.paciente.MenuPacienteView;
import org.example.viewInterface.viewLogin.ILoginView;

public class Roteador {

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

            case "menuPaciente":
            case "menuSecretario":
            case "menuMedico":
            case "menuAdmin":{
                if(usuario == null){
                    System.err.println("Erro: Usuario não informado!");
                    irPara("menuInicial");
                    break;
                }
            redirecionarPorTipoUsuario(usuario);
            break;

        }

            default:{
                System.out.println("Destino invalido: " + destino);
                irPara("menuInicial");
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

    private void redirecionarPorTipoUsuario(UsuarioModel usuario){

        TipoUsuario tipo = usuario.getTipoUsuario();

        switch (tipo){
            case PACIENTE:{
                MenuPacientePresenter menuPaciente = new MenuPacientePresenter(this, (PacienteModel) usuario);
                menuPaciente.iniciar();
                break;
            }
            case SECRETARIO:{
                MenuSecretarioPresenter menu Paciente = newSecretarioPresenter(this,(SecretarioModel) usuario);
                menuSecretario.inicar();
                break;
            }
            case MEDICO:{
                MenuMedicoPresenter menuMedico = new MenuMedicoPresenter(this,(MedicoModel) usuario);
                menuMedico.inicar();
                break;
            }
            case ADM:{
                MenuAdminPresenter menuAdmin = new MenuAdminPresenter(this,(AdminModel) usuario);
                menuAdmin.inicicar();
                break;
            }
            default:{
                System.err.println("Tipo de usuario desconhido: " + tipo);
                irPara("menuInicial");
            }
        }
    }


}
