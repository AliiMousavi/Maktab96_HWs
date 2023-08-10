package q2.ui;

import q2.entity.Masterdegree;
import q2.entity.Person;
import q2.entity.Student;
import q2.entity.Teacher;
import q2.util.ApplicationContext;
import q2.util.Constant;

import java.sql.Date;
import java.util.Scanner;

import static q2.ui.Printer.printFinishLine;

public class Menu {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            printFinishLine();
            Printer.printMenu(Constant.FIRST_MENU_ITEMS);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.FIRST_MENU_ITEMS[0]);
                    personMenu();
                    pressEnterToContinue();
                    break;
                case 2:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.FIRST_MENU_ITEMS[1]);
                    studentMenu();
                    pressEnterToContinue();
                    break;
                case 3:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.FIRST_MENU_ITEMS[2]);
                    teacherMenu();
                    pressEnterToContinue();
                    break;
                case 4:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.FIRST_MENU_ITEMS[3]);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    private void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }


    private void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void personMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            printFinishLine();
            Printer.printMenu(Constant.PERSON_MENU_ITEMS);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[0]);
                    savePerson();
                    pressEnterToContinue();
                    break;
                case 2:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[1]);
                    updatePerson();
                    pressEnterToContinue();
                    break;
                case 3:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[2]);
                    deletePerson();
                    pressEnterToContinue();
                    break;
                case 4:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[3]);
                    loadPerson();
                    pressEnterToContinue();
                    break;
                case 5:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[4]);
                    loadAllPersons();
                    break;
                case 6:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[5]);
                    containsPerson();
                    break;
                case 7:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[6]);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 7);
        scanner.close();

    }

    private void savePerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To save a person, Answer the following questions.");
        pressEnterToContinue();

        System.out.print("first Name? ");
        String firstName = scanner.nextLine();

        System.out.print("last name? ");
        String lastName = scanner.nextLine();

        System.out.print("date Of Birth? ");
        Date dateOfBirth = Date.valueOf(scanner.nextLine());

        Person person = new Person(firstName,lastName,dateOfBirth);
        ApplicationContext.getPersonService().saveOrUpdate(person);

        System.out.println("The person saved!");
    }

    private void updatePerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To Update a person, give me a person.");
        pressEnterToContinue();

        System.out.print("Person id? ");
        Long id = scanner.nextLong();

        System.out.print("new first Name? ");
        String firstName = scanner.nextLine();

        System.out.print("new last name? ");
        String lastName = scanner.nextLine();

        System.out.print("new date Of Birth? ");
        Date dateOfBirth = Date.valueOf(scanner.nextLine());

        Person person = new Person(id,firstName,lastName,dateOfBirth);
        ApplicationContext.getPersonService().saveOrUpdate(person);

        System.out.println("The person saved!");
    }

    private void deletePerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To delete a person, give me a person id to deleted:");
        Long id = scanner.nextLong();
        ApplicationContext.getPersonService().deleteById(id);

        System.out.println("The person was deleted!");
    }

    private void loadPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To load a person, give me a person Id to load it:");
        Long id = scanner.nextLong();

        System.out.println(ApplicationContext.getPersonService().load(id));
    }

    private void loadAllPersons(){
        System.out.println(ApplicationContext.getPersonService().loadAll());
    }

    private void containsPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To check database contains Person , give me a person Id:");
        Long id = scanner.nextLong();

        ApplicationContext.getPersonService().contains(id);
    }

    private void studentMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            printFinishLine();
            Printer.printMenu(Constant.PERSON_MENU_ITEMS);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[0]);
                    saveStudent();
                    pressEnterToContinue();
                    break;
                case 2:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[1]);
                    updateStudent();
                    pressEnterToContinue();
                    break;
                case 3:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[2]);
                    deleteStudent();
                    pressEnterToContinue();
                    break;
                case 4:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[3]);
                    loadStudent();
                    pressEnterToContinue();
                    break;
                case 5:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[4]);
                    loadAllStudent();
                    break;
                case 6:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[5]);
                    containsStudent();
                    break;
                case 7:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[6]);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 7);
        scanner.close();

    }

    private void saveStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To save a Student, Answer the following questions.");
        pressEnterToContinue();

        System.out.print("first Name? ");
        String firstName = scanner.nextLine();

        System.out.print("last name? ");
        String lastName = scanner.nextLine();

        System.out.print("date Of Birth? ");
        Date dateOfBirth = Date.valueOf(scanner.nextLine());

        System.out.print("Student id? ");
        Long studentId = scanner.nextLong();

        System.out.print("field Of Study? ");
        String fieldOfStudy = scanner.nextLine();

        System.out.print("entry Year? ");
        int entryYear = scanner.nextInt();



        Student student = new Student(firstName,lastName,dateOfBirth , studentId , fieldOfStudy , entryYear);
        ApplicationContext.getStudentService().saveOrUpdate(student);


        System.out.println("The Student saved!");
    }

    private void updateStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To Update a Student, give me a Student.");
        pressEnterToContinue();

        System.out.print("Student's person id? ");
        Long id = scanner.nextLong();

        System.out.print("new first Name? ");
        String firstName = scanner.nextLine();

        System.out.print("new last name? ");
        String lastName = scanner.nextLine();

        System.out.print("new date Of Birth? ");
        Date dateOfBirth = Date.valueOf(scanner.nextLine());

        System.out.print("new Student id? ");
        Long studentId = scanner.nextLong();

        System.out.print("new field Of Study? ");
        String fieldOfStudy = scanner.nextLine();

        System.out.print("new entry Year? ");
        int entryYear = scanner.nextInt();

        Student student = new Student(firstName,lastName,dateOfBirth , studentId , fieldOfStudy , entryYear);
        ApplicationContext.getStudentService().saveOrUpdate(student);


        System.out.println("The student saved!");
    }

    private void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To delete a Student, give me a person id to deleted:");
        Long id = scanner.nextLong();
        ApplicationContext.getStudentService().deleteById(id);

        System.out.println("The Student was deleted!");
    }

    private void loadStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To load a Student, give me a person Id to load it:");
        Long id = scanner.nextLong();

        System.out.println(ApplicationContext.getStudentService().load(id));
    }

    private void loadAllStudent(){
        System.out.println(ApplicationContext.getStudentService().loadAll());
    }

    private void containsStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To check database contains Student , give me a person Id:");
        Long id = scanner.nextLong();

        ApplicationContext.getStudentService().contains(id);
    }

    private void teacherMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            printFinishLine();
            Printer.printMenu(Constant.PERSON_MENU_ITEMS);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[0]);
                    saveTeacher();
                    pressEnterToContinue();
                    break;
                case 2:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[1]);
                    updateTeacher();
                    pressEnterToContinue();
                    break;
                case 3:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[2]);
                    deleteTeacher();
                    pressEnterToContinue();
                    break;
                case 4:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[3]);
                    loadTeacher();
                    pressEnterToContinue();
                    break;
                case 5:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[4]);
                    loadAllTeacher();
                    break;
                case 6:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[5]);
                    containsTeacher();
                    break;
                case 7:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.PERSON_MENU_ITEMS[6]);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 7);
        scanner.close();
    }

    private void saveTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To save a teacher, Answer the following questions.");
        pressEnterToContinue();

        System.out.print("first Name? ");
        String firstName = scanner.nextLine();

        System.out.print("last name? ");
        String lastName = scanner.nextLine();

        System.out.print("date Of Birth? ");
        Date dateOfBirth = Date.valueOf(scanner.nextLine());

        System.out.print("Teacher id? ");
        Long studentId = scanner.nextLong();

        System.out.print("degree? ");
        String degree = scanner.nextLine();

        System.out.print("master degree? ");
        Masterdegree masterdegree = Masterdegree.valueOf(scanner.nextLine());



        Teacher teacher = new Teacher(firstName,lastName,dateOfBirth , studentId , degree , masterdegree);
        ApplicationContext.getTeacherService().saveOrUpdate(teacher);


        System.out.println("The teacher saved!");
    }

    private void updateTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To Update a teacher, give me a teacher.");
        pressEnterToContinue();

        System.out.print("teacher's person id? ");
        Long id = scanner.nextLong();

        System.out.print("new first Name? ");
        String firstName = scanner.nextLine();

        System.out.print("new last name? ");
        String lastName = scanner.nextLine();

        System.out.print("new date Of Birth? ");
        Date dateOfBirth = Date.valueOf(scanner.nextLine());

        System.out.print("new Teacher id? ");
        Long studentId = scanner.nextLong();

        System.out.print("new degree? ");
        String degree = scanner.nextLine();

        System.out.print("new master degree? ");
        Masterdegree masterdegree = Masterdegree.valueOf(scanner.nextLine());



        Teacher teacher = new Teacher(firstName,lastName,dateOfBirth , studentId , degree , masterdegree);
        ApplicationContext.getTeacherService().saveOrUpdate(teacher);


        System.out.println("The Teacher saved!");
    }

    private void deleteTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To delete a Teacher, give me a person id to deleted:");
        Long id = scanner.nextLong();
        ApplicationContext.getTeacherService().deleteById(id);

        System.out.println("The Teacher was deleted!");
    }

    private void loadTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To load a Teacher, give me a person Id to load it:");
        Long id = scanner.nextLong();

        System.out.println(ApplicationContext.getTeacherService().load(id));
    }

    private void loadAllTeacher(){
        System.out.println(ApplicationContext.getTeacherService().loadAll());
    }

    private void containsTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To check database contains Teacher , give me a person Id:");
        Long id = scanner.nextLong();

        ApplicationContext.getTeacherService().contains(id);
    }

}
