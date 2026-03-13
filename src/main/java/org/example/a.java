package org.example;

import org.example.utils.Ferramentas;

import java.time.format.DateTimeParseException;

public class a {

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
            verifica = true;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida! Use o formato dd/mm/aaaa");
        }
    }while (!verifica);

    verifica = false;


    do {
        System.out.print("Telefone: ");
        try {
            telefone = Ferramentas.lString();
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

    dados[0] = email;
    dados[1] = senha;

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

