package loanSystem.ui;

import java.util.Scanner;

public class Printer {
    public static void printMenu(String[] items, String title){

        System.out.println("---------------------------------");
        System.out.println("          " + title + "         ");
        System.out.println("---------------------------------");

        for (int i = 0; i<items.length; i++){
            System.out.println((i+1) + " " + items[i] + ".");
        }
        System.out.print("Enter your choice(");
        for (int j = 1; j <= items.length ; j++){
            if(j != items.length)
                System.out.print(j + ", ");
            else
                System.out.print(j);
        }
        System.out.print("): ");

    }
    public static void printMsg(String msg){
        System.out.println("==========" + msg + "==========");
    }
    public static void printFinishLine(){
        System.out.println("---------------------------------");
    }
    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
