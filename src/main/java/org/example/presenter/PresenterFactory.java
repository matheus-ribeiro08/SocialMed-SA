package org.example.presenter;

import org.example.model.AdminModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.roteador.Roteador;
import org.example.view.cadastro.CadastroViewConsole;
import org.example.view.login.LoginViewConsole;

public class PresenterFactory {

    private final Roteador roteador;

    public PresenterFactory(Roteador roteador){
        this.roteador = roteador;
    }

    public MenuInicialPresenter criarMenuInicialPresenter(){
        return new MenuInicialPresenter(roteador);
    }

    public CadastrarUsuarioPresenter criarCadastroPresenter(){
        return new CadastrarUsuarioPresenter(roteador, new CadastroViewConsole());
    }

    public LoginUsuarioPresenter loginUsuarioPresenter(){
        return new LoginUsuarioPresenter(roteador, new LoginViewConsole());
    }

    public SairPresenter criarSairPresenter(){
        return new SairPresenter(roteador);
    }

    public MenuPacientePresenter criarMenuPacientePresenter(PacienteModel paciente){
        return new MenuPacientePresenter(roteador, paciente);
    }

    public MenuSecretarioPresenter criarMenuSecretarioPresenter(SecretarioPresenter secretario){
        return new MenuSecretarioPresenter(roteador, paciente);
    }

    public MenuMedicoPresenter criarMenuMedicoPresenter(MedicoModel medico){
        return new MenuMedicoPresenter(roteador, medico);
    }

    public MenuAdminPresenter criarMenuAdminPresenter(AdminModel admin){
        return new MenuAdminPresenter(roteador, admin);
    }

    public ErroPresenter criarErroPresenter(){
        return new ErroPresenter(roteador);
    }
}
