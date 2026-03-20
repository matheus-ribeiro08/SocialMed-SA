package org.example.utils;

import java.util.Scanner;

public class Ferramentas {

    private static Scanner ler = new Scanner(System.in);

    private Ferramentas() {

    }

    public static long lLong(){
        long num = ler.nextLong();

        ler.nextLine();

        return num;
    }

    public static void Delay(int ms) {
        try{Thread.sleep(ms);}catch(InterruptedException e){}
    }

    public static double lDouble() {
        double num = ler.nextDouble();

        ler.nextLine();

        return num;
    }

    public static String lString() {
        return ler.nextLine();
    }

    public static int lInteiro() {
        int num = ler.nextInt();

        ler.nextLine();

        return num;
    }

    public static void limpaTerminal() {
        for(int i = 0; i < 50; i ++) {
            System.out.println();
        }
    }

    public static void limpaTerminalOpcional(int valor){
        for (int i = 0; i < valor;i++){
            System.out.println();
        }
    }

}

