package loanSystem.ui.Menu;

import loanSystem.entity.Student;
import loanSystem.entity.enums.College;
import loanSystem.entity.enums.Degree;
import loanSystem.ui.Printer;
import loanSystem.util.ApplicationContext;

import java.sql.Date;
import java.util.Scanner;

import static loanSystem.util.Constant.startupItem;
import static loanSystem.util.PasswordGenerator.generatePassword;

public class MainMenu {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(startupItem, "start Menu");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    signUpMenu();
//                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    loginMenu();
//                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
//                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        } while (choice != 3 && scanner.hasNextLine());
        scanner.close();
    }


    public static void loginMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] credentials = new String[3];
            System.out.print("Enter your username(default: your National Code):");
            credentials[0] = scanner.nextLine();
            System.out.print("Enter your email: ");
            credentials[1] = scanner.nextLine();
            System.out.print("Enter your password: ");
            credentials[2] = scanner.nextLine();

            if (credentials[0].equals("back")) break;
            boolean validateCredential
                    = ApplicationContext.getStudentService().isValidCredential(credentials[0], credentials[1],credentials[2]);
            if (validateCredential){
                LoanMenu.run();
            }
            else
                System.out.println("Bad credentials... try again");

        }
    }

    public static void signUpMenu(){
        Printer.printMsg("sign Up New Student");
        System.out.println();

        Scanner scanner=new Scanner(System.in);
        Student newStudent = new Student();

        System.out.println("Enter your first name: ");
        newStudent.setFirstName(scanner.next().trim());

        System.out.println("Enter your last name: ");
        newStudent.setLastName(scanner.next().trim());

        System.out.println("Enter your father name: ");
        newStudent.setFatherName(scanner.next().trim());

        System.out.println("Enter your mother name: ");
        newStudent.setMotherName(scanner.next().trim());

        System.out.println("Enter your National Id: ");
        newStudent.setNationalId(scanner.next().trim());

        System.out.println("Enter your National code: ");
        newStudent.setNationalCode(scanner.next().trim());
        newStudent.setUsername(newStudent.getNationalCode());

        System.out.println("Enter your date of birth(yyyy-mm-dd): ");
        newStudent.setDateOfBirth(Date.valueOf(scanner.next().trim()));

        System.out.println("Enter your email: ");
        newStudent.setEmail(scanner.next().trim());

        System.out.println("Enter your Student id:");
        newStudent.setStudentId(scanner.next().trim());

        System.out.println("Enter your collage name:");
        newStudent.setCollageName(scanner.next().trim());

        System.out.println("""
                Enter your collage type:
                    (DOLATIROOZ,
                    DOLATISHAB,
                    SHABANE,
                    NOENTEFAEE,
                    PARDIS,
                    ZARFIATMAZAD,
                    PAYAMNOOR,
                    ELMIKARBORDI,
                    AZAD):""");
        newStudent.setCollegeType(College.valueOf(scanner.next().toUpperCase().trim()));

        System.out.println("Enter your Entry Year:");
        newStudent.setEntryYear(Integer.parseInt(scanner.next().trim()));

        System.out.println("""
                Enter your Degree:\s
                    (KAEDANI,
                    KARSHENASI,
                    HERFEIIDOCTORA,
                    PEYVASTEDOCTORA,
                    NAPEYVASTEDOCTORA,
                    TAKHASOSINAPEYVASTEDOCTORA)""");
        newStudent.setDegree(Degree.valueOf(scanner.next().toUpperCase().trim()));

        String password = generatePassword();
        newStudent.setPassword(password);
        ApplicationContext.getStudentService().saveOrUpdate(newStudent);
        Printer.printMsg("sign Up successfully! your password is: " + password);
    }
}
