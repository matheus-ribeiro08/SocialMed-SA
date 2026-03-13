package org.example.presenter;

import org.example.exception.NomeInvalido;
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
        String telefone = cadastroViewConsole.pedirTelefone();;
    }

    public void validarInformacoes(String nome, String senha, String email, ){
        if(nome == null || nome.length() < 1 || nome.length() > 2253){
            throw new NomeInvalido("Nome inválido!");
        }


    }


}
