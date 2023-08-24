package erpSystem.ui.menu;

import erpSystem.entity.Student;
import erpSystem.ui.Printer;
import erpSystem.util.ApplicationContext;

import java.util.Scanner;

import static erpSystem.util.Constant.edItem;
import static erpSystem.util.Constant.professorItem;

public class ProfessorMenu {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(professorItem, "Professor Profile");
            Printer.printMsg("Welcome back!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    viewProfile();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    enterGrades();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    viewPayslip();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printFinishLine();
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void viewProfile(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter your username:");
        Printer.printProfessorProfile(scanner.nextLine());
    }

    private static void enterGrades(){
        Scanner scanner = new Scanner(System.in);
        Student student;
        String input;

        System.out.println("Enter student Username and grades (press 'Esc' to exit):");

        while (true) {
            System.out.print("Username: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("esc")) {
                System.out.println("Exiting the program...");
                break;
            }

            student = ApplicationContext.getStudentService().getUserByUsername(input);

            System.out.print("Grade: ");
            input = scanner.nextLine();

            try {
                int grade = Integer.parseInt(input);
                student.setGrade(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade! Please enter a valid number or 'Esc' to exit.");
            }
        }
        scanner.close();
    }
    private static void viewPayslip(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter your username:");
        Printer.printProfessorPayslip(scanner.nextLine());
    }
}
