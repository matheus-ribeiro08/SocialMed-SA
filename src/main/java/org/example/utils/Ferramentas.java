package org.example.utils;

import java.util.Scanner;

public class Ferramentas {

    private static Scanner ler = new Scanner(System.in);

    private Ferramentas() {

    }

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String GREENclaro ="\u001B[38;2;134;226;131m";
    public static final String GREENescuro ="\u001B[38;2;0;128;0m";

    // Fundos (backgrounds)
    public static final String BG_BLACKBLUE ="\033[44m";
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

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


