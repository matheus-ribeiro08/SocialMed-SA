package org.example.roteador;

import org.example.enums.Destinos;
import org.example.model.*;
import org.example.presenter.factory.PresenterFactory;

public class Roteador {

    private final PresenterFactory presenterFactory;

    public Roteador(){
        this.presenterFactory = new PresenterFactory(this);
    }

    public void irPara(Destinos destino, UsuarioModel usuario){
        try {

            if (destino.isMenuUsuario() && usuario == null){
                throw new SecurityException("Usuario nao autenticado");
            }

            switch (destino){
                case MENU_INICIAL:{
                    presenterFactory.criarMenuInicialPresenter().iniciar();
                    break;
                }
                case CADASTRO:{
                    presenterFactory.criarCadastroPresenter().iniciarCadastro();
                    break;
                }
                case LOGIN:{
                    presenterFactory.criarLoginUsuarioPresenter().iniciarLogin();
                    break;
                }
                case SAIR:{
                    presenterFactory.criarSairPresenter().iniciar();
                    break;
                }
                case MENU_PACIENTE:{
                    presenterFactory.criarMenuPacientePresenter((PacienteModel) usuario).iniciar();
                    break;
                }
                case MENU_SECRETARIO:{
                    presenterFactory.criarMenuSecretarioPresenter((SecretarioModel) usuario).iniciar();
                    break;
                }
                case MENU_MEDICO:{
                    presenterFactory.criarMenuMedicoPresenter((MedicoModel) usuario).inicar();
                    break;
                }
                case MENU_ADMIN:{
                    presenterFactory.criarMenuAdminPresenter((AdminModel) usuario).iniciar();
                }
                case ERRO:{
                    presenterFactory.criarErroPresenter().iniciar();
                    break;
                }
                default:{
                    throw new IllegalArgumentException("Destino invalido!" + destino);
                }
            }
        }catch (SecurityException e){
            irPara(Destinos.LOGIN, null);
        }catch (Exception e){
            irPara(Destinos.ERRO, null);
        }
    }

}
