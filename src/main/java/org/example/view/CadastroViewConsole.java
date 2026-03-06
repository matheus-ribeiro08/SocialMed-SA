package org.example.view;

import org.example.model.UsuarioModel;
import org.example.utils.Ferramentas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CadastroViewConsole implements ICadastroView{

    private DateTimeFormatter dateFormatter;

    @Override
    public int mostrarMenuPrincipal(){
        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                     ███╗   ███╗███████╗███╗   ██╗██╗   ██╗     ██████╗ █████╗ ██████╗  █████╗ ███████╗████████╗██████╗  ██████╗                       │");
        System.out.println("│                     ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔═══██╗                      │");
        System.out.println("│                     ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██║     ███████║██║  ██║███████║███████╗   ██║   ██████╔╝██║   ██║                      │");
        System.out.println("│                     ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║     ██╔══██║██║  ██║██╔══██║╚════██║   ██║   ██╔══██╗██║   ██║                      │");
        System.out.println("│                     ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ╚██████╗██║  ██║██████╔╝██║  ██║███████║   ██║   ██║  ██║╚██████╔╝                      │");
        System.out.println("│                     ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝                       │");
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ OPÇÕES                                                                                                                                              │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ (1) ➔ Login                                                                                                                                         │");
        System.out.println("│ (2) ➔ Cadastro                                                                                                                                      │");
        System.out.println("│ (3) ➔ Sair                                                                                                                                          │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.printf("│ ➤ Digite a opção desejada: ");

        try {
            return Integer.parseInt(Ferramentas.lString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public String[] getDadosCadastro() {

        String[] dados = new String[7];

        String nome = "";
        String email = "";
        String senha = "";
        String cpf = "";
        String dataNascimento = "";
        String telefone = "";

        boolean verifica = false;

        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                     ███╗   ███╗███████╗███╗   ██╗██╗   ██╗     ██████╗ █████╗ ██████╗  █████╗ ███████╗████████╗██████╗  ██████╗                       │");
        System.out.println("│                     ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔═══██╗                      │");
        System.out.println("│                     ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██║     ███████║██║  ██║███████║███████╗   ██║   ██████╔╝██║   ██║                      │");
        System.out.println("│                     ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║     ██╔══██║██║  ██║██╔══██║╚════██║   ██║   ██╔══██╗██║   ██║                      │");
        System.out.println("│                     ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ╚██████╗██║  ██║██████╔╝██║  ██║███████║   ██║   ██║  ██║╚██████╔╝                      │");
        System.out.println("│                     ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝                       │");
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");

        do {
            System.out.print("Nome completo: ");
            try {
                nome = Ferramentas.lString();
                verifica = true;
            } catch (Exception e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (!verifica);

        verifica = false;

        do {
            System.out.print("Email: ");
            try {
                email = Ferramentas.lString();
                verifica = true;
            } catch (Exception e) {
                mostrarErro("Erro!");
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (!verifica);

        verifica = false;

        do {
            System.out.print("Senha: ");
            try {
                senha = Ferramentas.lString();
                verifica = true;
            } catch (Exception e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (!verifica);

        verifica = false;

        do {
            System.out.print("Cpf: ");
            try {
                cpf = Ferramentas.lString();
                verifica = true;
            } catch (Exception e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (!verifica);

        verifica = false;

        do {


            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            try {
                dataNascimento = Ferramentas.lString();
                LocalDate.parse(dataNascimento, dateFormatter);
                verifica = true;
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Data inválida! Use o formato dd/mm/aaaa");
            }
        }while (!verifica);

        verifica = false;


        do {
            System.out.print("Telefone: ");
            try {
                nome = Ferramentas.lString();
                verifica = true;
            } catch (Exception e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (!verifica);

        verifica = false;

        dados[0] = nome;
        dados[1] = email;
        dados[2] = senha;
        dados[3] = cpf;
        dados[4] = dataNascimento;
        dados[5] = telefone;

        return dados;
    }

    @Override
    public String[] getDadosLogin() {
        String[] dados = new String[2];

        String email = "";
        String senha = "";
        boolean verifica = false;

        do {
            System.out.print("Email: ");
            try {
                email = Ferramentas.lString();
                verifica = true;
            } catch (Exception e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (!verifica);

        verifica = false;

        do {
            System.out.print("Senha: ");
            try {
                senha = Ferramentas.lString();
                verifica = true;
            } catch (Exception e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (!verifica);

        return dados;
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public void mostrarErro(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public void mostrarSucesso(String mensagem) {
        System.out.println(mensagem);
    }

}
