package org.example.presenter;

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
        String dataNascimento = cadastroViewConsole.pedirDataNascimento();
        String cpf = cadastroViewConsole.pedirCPF();
        String telefone = cadastroViewConsole.pedirTelefone();;
    }


}
