package erpSystem.ui.menu;

import erpSystem.entity.EducationDepartment;
import erpSystem.entity.Employee;
import erpSystem.entity.Professor;
import erpSystem.entity.Student;
import erpSystem.ui.Printer;
import erpSystem.util.ApplicationContext;

import java.util.Optional;
import java.util.Scanner;

import static erpSystem.util.Constant.*;

public class EducationDepartmentMenu {

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(edItem, "Education Department Profile");
            Printer.printMsg("Welcome back!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    studentSettingMenu();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    professorSettingMenu();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    EmployeeSettingMenu();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printFinishLine();
                    viewPayslip();
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

    private static void studentSettingMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(edSettingItem, "Student Setting");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    registerStudent();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    deleteStudent();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    editeStudent();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void registerStudent(){

        Printer.printMsg("Register New Student");
        System.out.println();

        Scanner scanner=new Scanner(System.in);
        Student newStudent = new Student();

        System.out.println("Enter new Student first name:");
        newStudent.setFirstName(scanner.next().trim());

        System.out.println("Enter new Student last name:");
        newStudent.setLastName(scanner.next().trim());

        System.out.println("Set Student Id:");
        newStudent.setStudentId(scanner.next().trim());


        ApplicationContext.getStudentService().saveOrUpdate(newStudent);
        Printer.printMsg("The Student Registered successfully!");
        System.out.println("*students should complete they profile later*");

    }

    private static void deleteStudent(){

        Printer.printMsg("Delete Student");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Student username that you wanna delete:");
        Student foundStudent = ApplicationContext.getStudentService().getUserByUsername(scanner.nextLine());
        ApplicationContext.getStudentService().deleteById(foundStudent.getId());

        System.out.println("The Student deleted successfully!");

    }

    private static void editeStudent(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(editeStudentItem, "Edite Student");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    editeStudentUsername();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    editeStudentEmail();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    editeStudentPassword();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void editeStudentUsername(){
        Printer.printMsg("Edite Student Username");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Student username:");
        Student foundStudent = ApplicationContext.getStudentService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new username:");
        foundStudent.setUsername(scanner.nextLine());
        ApplicationContext.getStudentService().saveOrUpdate(foundStudent);

        System.out.println("The Student username successfully changed!");
    }

    private static void editeStudentEmail(){
        Printer.printMsg("Edite Student Email");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Student username:");
        Student foundStudent = ApplicationContext.getStudentService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new Email:");
        foundStudent.setEmail(scanner.nextLine());
        ApplicationContext.getStudentService().saveOrUpdate(foundStudent);

        System.out.println("The Student Email successfully changed!");
    }

    private static void editeStudentPassword(){
        Printer.printMsg("Edite Student Password");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Student username:");
        Student foundStudent = ApplicationContext.getStudentService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new Password:");
        foundStudent.setPassword(scanner.nextLine());
        ApplicationContext.getStudentService().saveOrUpdate(foundStudent);

        System.out.println("The Student Password successfully changed!");
    }

    private static void professorSettingMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(edSettingItem, "Professor Setting");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    registerProfessor();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    deleteProfessor();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    editeProfessor();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void registerProfessor(){

        Printer.printMsg("Register New Professor");
        System.out.println();

        Scanner scanner=new Scanner(System.in);
        Professor newProfessor = new Professor();

        System.out.println("Enter new Professor first name:");
        newProfessor.setFirstName(scanner.next().trim());

        System.out.println("Enter new Professor last name:");
        newProfessor.setLastName(scanner.next().trim());

        System.out.println("Set Professor Id:");
        newProfessor.setEmployeeId(scanner.next().trim());


        ApplicationContext.getProfessorService().saveOrUpdate(newProfessor);
        Printer.printMsg("The Professor Registered successfully!");
        System.out.println("*Professors should complete they profile later*");

    }

    private static void deleteProfessor(){

        Printer.printMsg("Delete Professor");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Professor username that you wanna delete:");
        Professor foundProfessor = ApplicationContext.getProfessorService().getUserByUsername(scanner.nextLine());
        ApplicationContext.getStudentService().deleteById(foundProfessor.getId());

        System.out.println("The Professor deleted successfully!");

    }

    private static void editeProfessor(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(editeStudentItem, "Edite Professor");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    editeProfessorUsername();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    editeProfessorEmail();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    editeProfessorPassword();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void editeProfessorUsername(){
        Printer.printMsg("Edite Professor Username");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Professor username:");
        Professor foundProfessor = ApplicationContext.getProfessorService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new username:");
        foundProfessor.setUsername(scanner.nextLine());
        ApplicationContext.getProfessorService().saveOrUpdate(foundProfessor);

        System.out.println("The Professor username successfully changed!");
    }

    private static void editeProfessorEmail(){
        Printer.printMsg("Edite Professor Email");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Professor username:");
        Professor foundProfessor = ApplicationContext.getProfessorService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new Email:");
        foundProfessor.setEmail(scanner.nextLine());
        ApplicationContext.getProfessorService().saveOrUpdate(foundProfessor);

        System.out.println("The Professor Email successfully changed!");
    }

    private static void editeProfessorPassword(){
        Printer.printMsg("Edite Professor Password");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Professor username:");
        Professor foundProfessor = ApplicationContext.getProfessorService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new Password:");
        foundProfessor.setPassword(scanner.nextLine());
        ApplicationContext.getProfessorService().saveOrUpdate(foundProfessor);

        System.out.println("The Professor Password successfully changed!");
    }

    private static void EmployeeSettingMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printMenu(edSettingItem, "Employee Setting");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    registerEmployee();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    deleteEmployee();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    editeEmployee();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void registerEmployee(){

        Printer.printMsg("Register New Employee");
        System.out.println();

        Scanner scanner=new Scanner(System.in);
        EducationDepartment newEmployee = new EducationDepartment();

        System.out.println("Enter new Employee first name:");
        newEmployee.setFirstName(scanner.next().trim());

        System.out.println("Enter new Employee last name:");
        newEmployee.setLastName(scanner.next().trim());

        System.out.println("Set Professor Id:");
        newEmployee.setEmployeeId(scanner.next().trim());


        ApplicationContext.getEducationDepartmentService().saveOrUpdate(newEmployee);
        Printer.printMsg("The Employee Registered successfully!");
        System.out.println("*Employees should complete they profile later*");

    }

    private static void deleteEmployee(){

        Printer.printMsg("Delete Employee");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Employee username that you wanna delete:");
        EducationDepartment foundEmployee = ApplicationContext.getEducationDepartmentService().getUserByUsername(scanner.nextLine());
        ApplicationContext.getStudentService().deleteById(foundEmployee.getId());

        System.out.println("The Employee deleted successfully!");

    }

    private static void editeEmployee(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Printer.printFinishLine();
            Printer.printMenu(editeStudentItem, "Edite Employee");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    editeEmployeeUsername();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    editeEmployeeEmail();
                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    editeEmployeePassword();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void editeEmployeeUsername(){
        Printer.printMsg("Edite Employee Username");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Employee username:");
        EducationDepartment foundEmployee = ApplicationContext.getEducationDepartmentService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new username:");
        foundEmployee.setUsername(scanner.nextLine());
        ApplicationContext.getEducationDepartmentService().saveOrUpdate(foundEmployee);

        System.out.println("The Employee username successfully changed!");
    }

    private static void editeEmployeeEmail(){
        Printer.printMsg("Edite Employee Email");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Employee username:");
        EducationDepartment foundEmployee = ApplicationContext.getEducationDepartmentService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new Email:");
        foundEmployee.setEmail(scanner.nextLine());
        ApplicationContext.getEducationDepartmentService().saveOrUpdate(foundEmployee);

        System.out.println("The Employee Email successfully changed!");
    }

    private static void editeEmployeePassword(){
        Printer.printMsg("Edite Employee Password");
        System.out.println();

        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter the Employee username:");
        EducationDepartment foundEmployee = ApplicationContext.getEducationDepartmentService().getUserByUsername(scanner.nextLine());
        System.out.println("Now, enter new Password:");
        foundEmployee.setPassword(scanner.nextLine());
        ApplicationContext.getEducationDepartmentService().saveOrUpdate(foundEmployee);

        System.out.println("The Employee Password successfully changed!");
    }

    private static void viewPayslip(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter your username:");
        Printer.printEmployeePayslip(scanner.nextLine());
    }
}
