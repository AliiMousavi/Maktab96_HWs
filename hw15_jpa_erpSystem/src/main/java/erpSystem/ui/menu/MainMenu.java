package erpSystem.ui.menu;

import erpSystem.entity.enums.LogInRole;
import erpSystem.ui.Printer;
import erpSystem.util.ApplicationContext;
import erpSystem.util.Constant;

import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {

    public static void run() {
        Printer.printMsg("Login");
        loginMenu();
    }


    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] credentials = new String[3];
            System.out.println("Enter your username:");
            credentials[0] = scanner.nextLine();
            System.out.println("Enter your email: ");
            credentials[1] = scanner.nextLine();
            System.out.println("Enter your password: ");
            credentials[2] = scanner.nextLine();

            if (credentials[0].equals("back")) break;
            boolean validateCredential
                    = ApplicationContext.getUserService().isValidCredential(credentials[0], credentials[1],credentials[2]);
            if (validateCredential){
                String UserRole = ApplicationContext.getUserService().getLogInRoleByUsername(credentials[0]);
                switch (UserRole) {
                    case "EducationDepartment" -> EducationDepartmentMenu.run();
                    case "Professor" -> ProfessorMenu.run();
                    case "Student" -> StudentMenu.run();
                }
                break;
            }
            else
                System.out.println("Bad credentials... try again");

        }
    }


}
