package org.example.presenter.login;

import org.example.enums.Destinos;
import org.example.enums.TipoUsuario;
import org.example.exception.EmailInvalido;
import org.example.exception.SenhaInvalida;
import org.example.model.UsuarioModel;
import org.example.roteador.Roteador;
import org.example.service.usuario.UsuarioService;
import org.example.viewInterface.viewLogin.ILoginView;

public class LoginUsuarioPresenter {

    private Roteador roteadorCadastro;
    private ILoginView view;
    private UsuarioService usuarioService;

    public LoginUsuarioPresenter(Roteador roteadorCadastro, ILoginView view){
        this.roteadorCadastro = roteadorCadastro;
        this.view = view;
        this.usuarioService = new UsuarioService();
    }

    public void iniciarLogin(){
        try {
            String cpf = view.pedirCpf();
            String senha = view.pedirSenha();

            validarCredenciais(cpf, senha);

            UsuarioModel usuario = usuarioService.login(cpf, senha);

            TipoUsuario tipo = usuario.getTipoUsuario();

            System.out.println("Login realizado com sucesso!");

            switch (tipo){
                case SECRETARIO:{
                    roteadorCadastro.irPara(Destinos.MENU_SECRETARIO, usuario);
                    break;
                }
                case MEDICO:{
                    roteadorCadastro.irPara(Destinos.MENU_MEDICO, usuario);
                    break;
                }
                case ADM:{
                    roteadorCadastro.irPara(Destinos.MENU_ADMIN, usuario);
                    break;
                }
                case PACIENTE:{
                    roteadorCadastro.irPara(Destinos.MENU_PACIENTE, usuario);
                    break;
                }
                default:{

                }
            }

        }catch (Exception e){
            System.err.println("Erro!" + e);
        }
    }


    public void validarCredenciais(String cpf, String senha){
        if(cpf == null || cpf.isBlank()){
            throw new EmailInvalido("Email invalido");
        }
        if(senha == null || senha.isBlank()){
            throw new SenhaInvalida("Senha invalida");
        }
    }
}
