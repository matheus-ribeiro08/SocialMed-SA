package org.example.roteador;

import org.example.model.*;
import org.example.presenter.factory.PresenterFactory;

public class Roteador {

    public enum Destino{
        MENU_INICIAL,
        CADASTRO,
        LOGIN,
        MENU_PACIENTE,
        MENU_SECRETARIO,
        MENU_MEDICO,
        MENU_ADMIN,
        SAIR,
        ERRO;
    }

    public boolean requerAutentificacao(){
        return  this == MENU_PACIENTE ||
                this == MENU_SECRETARIO ||
                this == MENU_MEDICO ||
                this == MENU_ADMIN;
    }

    private final PresenterFactory presenterFactory;

    public Roteador(){
        this.presenterFactory = new PresenterFactory(this);
    }

    public void irPara(Destino destino, UsuarioModel usuario){
        try {

            if (destino.requerAutentificacao() && usuario == null){
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
                    presenterFactory.criarLoginPresenter().inicar();
                    break;
                }
                case SAIR:{
                    presenterFactory.criarSairPresenter().iniciar();
                    break;
                }
                case MENU_PACIENTE:{
                    presenterFactory.criarMenuPacientePresenter((PacienteModel) usuario).inicar();
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
            irPara(Destino.LOGIN);
        }catch (Exception e){
            irPara(Destino.ERRO);
        }
    }

}
