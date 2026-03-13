package org.example.presenter;

import org.example.exception.*;
import org.example.model.UsuarioModel;
import org.example.roteador.RoteadorCadastro;
import org.example.view.CadastroViewConsole;

public class CadastrarUsuarioPresenter {

    private RoteadorCadastro roteadorCadastro;
    private CadastroViewConsole cadastroViewConsole;

    public CadastrarUsuarioPresenter (RoteadorCadastro roteadorCadastro, CadastroViewConsole cadastroViewConsole){
        this.roteadorCadastro = roteadorCadastro;
        this.cadastroViewConsole = cadastroViewConsole;
    }

    public void ColetarInformacoes(){
        String nome = cadastroViewConsole.pedirNome();
        String senha = cadastroViewConsole.pedirSenha();
        String email = cadastroViewConsole.pedirEmail();
        String cpf = cadastroViewConsole.pedirCPF();
        String telefone = cadastroViewConsole.pedirTelefone();

        validarInformacoes(nome,senha,email,cpf,telefone);

        UsuarioModel usuario = new UsuarioModel(nome,senha,email,cpf,telefone);

    }

    public void validarInformacoes(String nome, String senha, String email, String cpf, String telefone){
        if(nome == null || nome.length() < 1 || nome.length() > 2253){
            throw new NomeInvalido("Nome inválido!");
        }

        if (email == null || email.isBlank() || !email.contains("@") || email.length() > 345){
            throw new EmailInvalido("Email inválido!");
        }

        if (senha == null || senha.isBlank()){
            throw new SenhaInvalida("A senha não pode ser vazia!");
        }

        if(senha.length() < 8){
            throw new SenhaInvalida("Senha deve conter 8 digitos ou mais!");
        }

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).+$";

        if(!senha.matches(regex)){
            throw new SenhaInvalida("A senha deve conter caracteres especiais!");
        }

        if(cpf == null || cpf.isBlank()){
            throw new CpfInvalido("Cpf inválido!");
        }

        if(telefone == null || telefone.isBlank()){
            throw new TelefoneInvalido("Telefone inválido!");
        }

    }


}
