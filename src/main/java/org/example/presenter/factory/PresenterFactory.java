package org.example.presenter.factory;

import org.example.model.AdminModel;
import org.example.model.MedicoModel;
import org.example.model.PacienteModel;
import org.example.model.SecretarioModel;
import org.example.presenter.acoes.ErroPresenter;
import org.example.presenter.acoes.SairPresenter;
import org.example.presenter.admin.MenuAdminPresenter;
import org.example.presenter.cadastro.CadastrarUsuarioPresenter;
import org.example.presenter.login.LoginUsuarioPresenter;
import org.example.presenter.medico.MenuMedicoPresenter;
import org.example.presenter.menuInicial.MenuInicialPresenter;
import org.example.presenter.paciente.MenuPacientePresenter;
import org.example.presenter.secretario.MenuSecretarioPresenter;
import org.example.roteador.Roteador;
import org.example.view.adm.MenuAdminConsoleView;
import org.example.view.cadastro.CadastroViewConsole;
import org.example.view.login.LoginViewConsole;
import org.example.view.medico.MenuMedicoConsoleView;
import org.example.view.paciente.MenuPacienteConsoleView;
import org.example.view.secretario.MenuSecretarioConsoleView;
import org.example.viewInterface.viewInterfaceAdm.IMenuAdminView;

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

    public LoginUsuarioPresenter criarLoginUsuarioPresenter(){
        return new LoginUsuarioPresenter(roteador, new LoginViewConsole());
    }

    public SairPresenter criarSairPresenter(){
        return new SairPresenter(roteador);
    }

    public MenuPacientePresenter criarMenuPacientePresenter(PacienteModel paciente){
        return new MenuPacientePresenter(roteador, paciente, new MenuPacienteConsoleView());
    }

    public MenuSecretarioPresenter criarMenuSecretarioPresenter(SecretarioModel secretario){
        return new MenuSecretarioPresenter(roteador, secretario, new MenuSecretarioConsoleView());
    }

    public MenuMedicoPresenter criarMenuMedicoPresenter(MedicoModel medico){
        return new MenuMedicoPresenter(roteador, medico, new MenuMedicoConsoleView());
    }

    public MenuAdminPresenter criarMenuAdminPresenter(AdminModel admin){
        IMenuAdminView view = new MenuAdminConsoleView();
        return new MenuAdminPresenter(roteador, admin, view);
    }

    public ErroPresenter criarErroPresenter(){
        return new ErroPresenter(roteador);
    }
}
