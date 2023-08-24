package erpSystem.ui;

import erpSystem.entity.EducationDepartment;
import erpSystem.entity.Professor;
import erpSystem.entity.Student;
import erpSystem.entity.enums.ProfessorType;
import erpSystem.util.ApplicationContext;
import erpSystem.util.Constant;

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

    public static void printEmployeePayslip(String username){

        EducationDepartment foundEmployee = ApplicationContext.getEducationDepartmentService().getUserByUsername(username);

        Printer.printMsg("Info");

        System.out.println("Employee ID: " + foundEmployee.getEmployeeId());
        System.out.println("name: " + foundEmployee.getLastName() + " " + foundEmployee.getLastName());

        System.out.println("======================================================");

        System.out.println("Salary of this month:" + Constant.baseSalary);

    }

    public static void printProfessorPayslip(String username){

        Professor foundProfessor = ApplicationContext.getProfessorService().getUserByUsername(username);

        Printer.printMsg("Info");

        System.out.println("Employee ID: " + foundProfessor.getEmployeeId());
        System.out.println("name: " + foundProfessor.getLastName() + " " + foundProfessor.getLastName());
        System.out.println("contract type: " + foundProfessor.getProfessorType());

        System.out.println("======================================================");

        if(foundProfessor.getProfessorType() == ProfessorType.HAGHOLTADRIS)
            foundProfessor.setSalary(foundProfessor.getCourses().size() * 1000000);
        else
            foundProfessor.setSalary(foundProfessor.getCourses().size() * 1000000 + Constant.baseSalary);

        System.out.println("Salary of this month:" + foundProfessor.getSalary());

    }
    public static void printProfessorProfile(String username){

        Professor foundProfessor = ApplicationContext.getProfessorService().getUserByUsername(username);

        Printer.printMsg("Your Info");

        System.out.println("Employee ID: " + foundProfessor.getEmployeeId());
        System.out.println("contract type: " + foundProfessor.getProfessorType());
        System.out.println("Username: " + foundProfessor.getUsername());
        System.out.println("Password: " + foundProfessor.getPassword());
        System.out.println("Email: " + foundProfessor.getEmail());

    }

    public static void printStudentProfile(String username){

        Student foundStudent = ApplicationContext.getStudentService().getUserByUsername(username);

        Printer.printMsg("Your Info");

        System.out.println("Student ID: " + foundStudent.getStudentId());
        System.out.println("Username: " + foundStudent.getUsername());
        System.out.println("Password: " + foundStudent.getPassword());
        System.out.println("Email: " + foundStudent.getEmail());

    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
