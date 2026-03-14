package org.example.presenter;

import org.example.dao.UsuarioDAO;
import org.example.exception.EmailInvalido;
import org.example.exception.SenhaInvalida;
import org.example.model.UsuarioModel;
import org.example.roteador.RoteadorCadastro;
import org.example.service.UsuarioService;
import org.example.viewInterface.viewLogin.ILoginView;

public class LoginUsuarioPresenter {

    private RoteadorCadastro roteadorCadastro;
    private ILoginView view;
    private UsuarioService usuarioService;

    public LoginUsuarioPresenter(RoteadorCadastro roteadorCadastro, ILoginView view){
        this.roteadorCadastro = roteadorCadastro;
        this.view = view;
        this.usuarioService = new UsuarioService();
    }

    public void iniciarLogin(){
        try {
            String email = view.pedirEmail();
            String senha = view.pedirSenha();

            validarCredenciais(email, senha);

            UsuarioModel usuario = usuarioService.login(email, senha);

            //if ("secretario".equals(usuario.getTipo())) {
            //      roteadorCadastro.irPara("menuSecretario", usuario);
            //} else {
            //      roteadorCadastro.irPara("menuPaciente", usuario);
            //}
        }catch (Exception e){
            System.err.println("Erro!");
        }
    }


    public void validarCredenciais(String email, String senha){
        if(email == null || email.isBlank()){
            throw new EmailInvalido("Email invalido");
        }
        if(senha == null || senha.isBlank()){
            throw new SenhaInvalida("Senha invalida");
        }
    }
}
