package org.example.view.login;

import org.example.utils.Ferramentas;
import org.example.viewInterface.viewLogin.ILoginView;

public class LoginViewConsole implements ILoginView {

    public void mostrarTelaInicial()
    {

    }

    @Override
    public int mostrarMenuInicial() {
            System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println(Ferramentas.RESET+"                                       ███████╗ ██████╗  ██████╗██╗ █████╗ ██╗         ███╗   ███╗███████╗██████╗                                         ");
            System.out.println("                                       ██╔════╝██╔═══██╗██╔════╝██║██╔══██╗██║         ████╗ ████║██╔════╝██╔══██╗                                        ");
            System.out.println("                                       ███████╗██║   ██║██║     ██║███████║██║         ██╔████╔██║█████╗  ██║  ██║                                        ");
            System.out.println("                                       ╚════██║██║   ██║██║     ██║██╔══██║██║         ██║╚██╔╝██║██╔══╝  ██║  ██║                                        ");
            System.out.println("                                       ███████║╚██████╔╝╚██████╗██║██║  ██║███████╗    ██║ ╚═╝ ██║███████╗██████╔╝                                        ");
            System.out.println("                                       ╚══════╝ ╚═════╝  ╚═════╝╚═╝╚═╝  ╚═╝╚══════╝    ╚═╝     ╚═╝╚══════╝╚═════╝                                         ");
            System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println(Ferramentas.GREENclaro+"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+" OPÇÕES                                                                                                                                              ");
        System.out.println(Ferramentas.GREENclaro+"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+ Ferramentas.RESET);
        System.out.println(Ferramentas.RESET+" (1) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Fazer Login");
        System.out.println(Ferramentas.RESET+" (2) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Cadastrar-se");
        System.out.println(Ferramentas.RESET+" (0) "+ Ferramentas.GREEN+"➔"+ Ferramentas.RESET+" Sair");
        System.out.println(Ferramentas.GREENclaro+"──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Escolha: ");

        return Ferramentas.lInteiro();
    }

    @Override
    public String pedirSenha() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite a sua senha: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirEmail() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o seu email: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirCpf() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.print(Ferramentas.YELLOW+" ➤"+ Ferramentas.RESET+" Digite o seu cpf: ");

        return Ferramentas.lString();
    }



}
