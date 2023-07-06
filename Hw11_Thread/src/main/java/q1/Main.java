package main.java.q1;

import main.java.q1.Threads.FirstThread;
import main.java.q1.Threads.SecondThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your max number:");
        Integer input = new Integer(scanner.next());

        NumberGenerator numberGenerator = new NumberGenerator(input);

        numberGenerator.generateEvenNumbers();
        numberGenerator.generateOddNumbers();

        Thread oddThread = new Thread(new FirstThread( numberGenerator.getEvennumbers() , numberGenerator.finalnumbers));
        oddThread.start();


        Thread evenThread = new Thread(new SecondThread(numberGenerator.getOddnumbers() , numberGenerator.finalnumbers));
        evenThread.start();

        Thread.sleep(1000);

        System.out.println(numberGenerator.getEvennumbers());
        System.out.println(numberGenerator.getOddnumbers());
        System.out.println(numberGenerator.getFinalnumbers());
    }
}
