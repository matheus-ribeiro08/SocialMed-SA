package org.example.view.cadastro;

import org.example.presenter.usuario.UsuarioPresenter;
import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceCadastro.ICadastroView;

import java.time.format.DateTimeFormatter;

public class CadastroViewConsole implements ICadastroView {

    private UsuarioPresenter presenter;
    private DateTimeFormatter dateFormatter;

    @Override
    public int mostrarMenuPrincipal() {
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.RESET+"                     ███╗   ███╗███████╗███╗   ██╗██╗   ██╗     ██████╗ █████╗ ██████╗  █████╗ ███████╗████████╗██████╗  ██████╗                       ");
        System.out.println("                     ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔═══██╗                      ");
        System.out.println("                     ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██║     ███████║██║  ██║███████║███████╗   ██║   ██████╔╝██║   ██║                      ");
        System.out.println("                     ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║     ██╔══██║██║  ██║██╔══██║╚════██║   ██║   ██╔══██╗██║   ██║                      ");
        System.out.println("                     ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ╚██████╗██║  ██║██████╔╝██║  ██║███████║   ██║   ██║  ██║╚██████╔╝                      ");
        System.out.println("                     ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝                       ");
        System.out.println(Ferramentas.GREENclaro+"───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"+Ferramentas.RESET);

        return Ferramentas.lInteiro();
    }

    @Override
    public String pedirEmail(){
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.YELLOW+" ➤ "+Ferramentas.RESET+" Digite o seu email: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirEndereco(){
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.YELLOW+" ➤ "+Ferramentas.RESET+"Digite o seu endereço: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirSenha() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.YELLOW+" ➤ "+Ferramentas.RESET+" Digite a sua senha");

        return Ferramentas.lString();
    }

    @Override
    public String pedirNome() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.YELLOW+" ➤ "+Ferramentas.RESET+" Digite o seu nome: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirCPF() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.YELLOW+" ➤ "+Ferramentas.RESET+" Digite o seu cpf: ");

        return Ferramentas.lString();
    }

    @Override
    public String pedirTelefone() {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Ferramentas.YELLOW+" ➤ "+Ferramentas.RESET+" Digite o seu telefone: ");

        return Ferramentas.lString();
    }


}







