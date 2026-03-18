package org.example.view.login;

import org.example.utils.Ferramentas;
import org.example.viewInterface.viewLogin.ILoginView;

public class LoginViewConsole implements ILoginView {

    @Override
    public int mostrarMenuInicial() {
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("        ███╗   ███╗███████╗███╗   ██╗██╗   ██╗  ██╗     ██████╗  ██████╗ ██╗███╗   ██╗        ");
        System.out.println("        ████╗ ████║██╔════╝████╗  ██║██║   ██║  ██║    ██╔═══██╗██╔════╝ ██║████╗  ██║        ");
        System.out.println("        ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║  ██║    ██║   ██║██║  ███╗██║██╔██╗ ██║        ");
        System.out.println("        ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║  ██║    ██║   ██║██║   ██║██║██║╚██╗██║        ");
        System.out.println("        ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝  ███████╚██████╔╝╚██████╔╝██║██║ ╚████║        ");
        System.out.println("        ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝   ╚══════ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝        ");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────");

        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" OPÇÕES                                                                                                                                              ");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Cadastrar-se");
        System.out.println("0 - Sair");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" ➤ Escolha: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String pedirEmail() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" ➤ Digite o seu email");

        return Ferramentas.lString();
    }

    @Override
    public String pedirSenha() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(" ➤ Digite a sua senha; ");

        return Ferramentas.lString();
    }


}
