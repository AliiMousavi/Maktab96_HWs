package erpSystem.ui.menu;

import erpSystem.entity.Student;
import erpSystem.ui.Printer;
import erpSystem.util.ApplicationContext;

import java.util.Scanner;

import static erpSystem.util.Constant.professorItem;
import static erpSystem.util.Constant.studentItem;

public class StudentMenu {

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        Printer.printMsg("Welcome back!");
        do{
            Printer.printFinishLine();
            Printer.printMenu(studentItem, "Student Profile");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    viewProfile();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    viewCourses();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    System.out.println("piade sazi nashode!");
                    Printer.pressEnterToContinue();
                    break;

                case 4:
                    Printer.printFinishLine();
                    viewPassedCourses();
                    Printer.pressEnterToContinue();
                    break;
                case 5:
                    Printer.printMsg("back!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void viewCourses(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter your username:");
        ApplicationContext.getCourseService().findAll();
    }

    private static void viewPassedCourses(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter your username:");
       Student student = ApplicationContext.getStudentService().getUserByUsername(scanner.nextLine());

        System.out.println(student.getPassedCourses());
    }

    private static void viewProfile(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter your username:");
        Printer.printStudentProfile(scanner.nextLine());
    }
}
