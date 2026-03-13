package org.example.view;

import org.example.presenter.UsuarioPresenter;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceCadastro.ICadastroView;

import java.time.format.DateTimeFormatter;

public class CadastroViewConsole implements ICadastroView {

    private UsuarioPresenter presenter;
    private DateTimeFormatter dateFormatter;

    @Override
    public int mostrarMenuPrincipal() {
        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                     ███╗   ███╗███████╗███╗   ██╗██╗   ██╗     ██████╗ █████╗ ██████╗  █████╗ ███████╗████████╗██████╗  ██████╗                       │");
        System.out.println("│                     ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔═══██╗                      │");
        System.out.println("│                     ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██║     ███████║██║  ██║███████║███████╗   ██║   ██████╔╝██║   ██║                      │");
        System.out.println("│                     ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║     ██╔══██║██║  ██║██╔══██║╚════██║   ██║   ██╔══██╗██║   ██║                      │");
        System.out.println("│                     ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ╚██████╗██║  ██║██████╔╝██║  ██║███████║   ██║   ██║  ██║╚██████╔╝                      │");
        System.out.println("│                     ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝                       │");
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");

        return Ferramentas.lInteiro();
    }

    @Override
    public String pedirEmail(){
        System.out.println("Digite o seu email: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirSenha() {
        System.out.println("Digite a sua senha");

        return Ferramentas.lString();
    }

    @Override
    public String pedirNome() {
        System.out.println("Digite o seu nome: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirCPF() {
        System.out.println("Digite o seu cpf: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirTelefone() {
        System.out.println("Digite o seu telefone: ");

        return Ferramentas.lString();
    }


}







