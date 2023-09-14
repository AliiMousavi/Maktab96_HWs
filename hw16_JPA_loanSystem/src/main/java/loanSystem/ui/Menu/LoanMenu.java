package loanSystem.ui.Menu;

import loanSystem.entity.*;
import loanSystem.entity.enums.Degree;
import loanSystem.entity.enums.LoanType;
import loanSystem.ui.Printer;
import loanSystem.util.ApplicationContext;
import loanSystem.util.SecurityContext;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static loanSystem.util.Constant.*;

public class LoanMenu {
    static LoanType loanType;

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isLoggedIn = true;
        do {
            Printer.printFinishLine();
            Printer.printMenu(loanItem, "welcome dear " + SecurityContext.firstName);
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    registration();
//                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    repayment();
//                    Printer.pressEnterToContinue();
                    break;
                case 3:
                    Printer.printFinishLine();
                    isLoggedIn = false;
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        } while (isLoggedIn && scanner.hasNextLine());
        scanner.close();
    }

    public static void registration() {
//        Student correntStudent = ApplicationContext.getStudentService().getStudentByUsername(SecurityContext.username);
//        LocalDate currentDate = LocalDate.now();
//        Month currentMonth = currentDate.getMonth();
//        int currentDay = currentDate.getDayOfMonth();
//
//        boolean isBetweenAban = currentMonth == Month.OCTOBER && currentDay >= 23 && currentDay <= 29;
//        boolean isBetweenBahman = currentMonth == Month.FEBRUARY && currentDay >= 14 && currentDay <= 20;
//
//        if ((!hasGraduated(correntStudent) && (isBetweenAban || isBetweenBahman)) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isLoggedIn = true;
        do {
            Printer.printFinishLine();
            Printer.printMenu(loanRegistrationItem, "Loan Registration");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    loanType = LoanType.SHAHRIYE;
                    Printer.printFinishLine();
                    submitWalletInformation();
                    Printer.printMsg("loan be shoma  takhsis dade shod!");
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    loanType = LoanType.TAHSILI;
                    Printer.printFinishLine();
                    submitWalletInformation();
                    Printer.printMsg("loan be shoma  takhsis dade shod!");
                    Printer.pressEnterToContinue();
                case 3:
                    loanType = LoanType.MASKAN;
                    Printer.printFinishLine();
//                    submitmaskanInformation();
                    submitWalletInformation();
                    Printer.printMsg("loan be shoma  takhsis dade shod!");
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printFinishLine();
                    isLoggedIn = false;
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        } while (isLoggedIn && scanner.hasNextLine());
        scanner.close();
//        }else {
//            System.out.println(" sabte nam baraye shoma faal nist!");
//        }
    }

    public static void repayment() {
//        Student correntStudent = ApplicationContext.getStudentService().getStudentByUsername(SecurityContext.username);
//
//        if (hasGraduated(correntStudent)){
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isLoggedIn = true;
        do {
            Printer.printFinishLine();
            Printer.printMenu(loanRepaymentItem, "Loan repayment Menu");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Printer.printFinishLine();
                    pardakhtShodemenu();
                    Printer.pressEnterToContinue();
                    break;
                case 2:
                    Printer.printFinishLine();
                    noPardakhtShodemenu();
                    Printer.pressEnterToContinue();
                case 3:
                    Printer.printFinishLine();
                    pardakhtmenu();
                    Printer.pressEnterToContinue();
                    break;
                case 4:
                    Printer.printFinishLine();
                    isLoggedIn = false;
                    Printer.printMsg("back!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        } while (isLoggedIn && scanner.hasNextLine());
        scanner.close();
//    }else{
//            System.out.println("Shoma hanooz fareqoltahsil nashodid");
//        }
    }

    public static void pardakhtShodemenu() {

        Student newStudent = ApplicationContext.getStudentService().getStudentByUsername(SecurityContext.username);
        System.out.println(newStudent.getLoan().getPardakhtShodeGhests().toString());

    }

    public static void noPardakhtShodemenu() {

        Student newStudent = ApplicationContext.getStudentService().getStudentByUsername(SecurityContext.username);
        System.out.println(newStudent.getLoan().getNoPardakhtShodeGhests().toString());

    }

    public static void pardakhtmenu() {

        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet();

        Student newStudent = ApplicationContext.getStudentService().getStudentByUsername(SecurityContext.username);

        System.out.print("Enter your card number: ");
        wallet.setCardNumber(scanner.nextLine().trim());

        System.out.print("Enter your cvv2: ");
        wallet.setCvv2(scanner.nextLine().trim());

        System.out.print("Enter your Card Expiration Date(yy-mm): ");
        String expirationDate = scanner.nextLine().trim();
        wallet.setCardExpirationDate(Date.valueOf("14" + expirationDate + "-01"));

        if (wallet.getCardNumber().equals(newStudent.getWallet().getCardNumber()) &&
                wallet.getCvv2().equals(newStudent.getWallet().getCvv2()) &&
                wallet.getCardExpirationDate().equals(newStudent.getWallet().getCardExpirationDate())) {
            NoPardakhtShodeGhest NoPardakhtShodeGhest = ApplicationContext.getGhestService().getAndDeleteFirstNoPardakhtShodeGhest();
            PardakhtShodeGhest pardakhtShodeGhest = new PardakhtShodeGhest();
            pardakhtShodeGhest.setNumber(NoPardakhtShodeGhest.getNumber());
            pardakhtShodeGhest.setPardakhtDate(Date.valueOf(LocalDate.now()));
            List<PardakhtShodeGhest> pardakhtShodeGhests = new ArrayList<>();
            pardakhtShodeGhests.add(pardakhtShodeGhest);

            newStudent.getLoan().setPardakhtShodeGhests(pardakhtShodeGhests);

            ApplicationContext.getStudentService().saveOrUpdate(newStudent);
            System.out.println("pardakht ba movafaqiat done shod!");

        } else {
            System.out.println("etelaat card motabeqat nadarad!");
        }

    }

    public static void submitWalletInformation() {
        Printer.printMsg("submit Wallet Information for loan");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet();
        Student newStudent = ApplicationContext.getStudentService().getStudentByUsername(SecurityContext.username);
//        newStudent.setId(SecurityContext.id);

        System.out.print("Enter your card number: ");
        wallet.setCardNumber(scanner.nextLine().trim());

        System.out.print("Enter your cvv2: ");
        wallet.setCvv2(scanner.nextLine().trim());

        System.out.print("Enter your Card Expiration Date(yy-mm): ");
        String expirationDate = scanner.nextLine().trim();
        wallet.setCardExpirationDate(Date.valueOf("14" + expirationDate + "-01"));

        newStudent.setWallet(wallet);
        Loan loan = new Loan();
        loan.setLoanType(loanType);

        newStudent.setLoan(loan);

        if (loanType.equals(LoanType.SHAHRIYE))
            setShahriyeLoanAmount(newStudent);
        if (loanType.equals(LoanType.TAHSILI))
            setTahsiliLoanAmount(newStudent);
        if (loanType.equals(LoanType.MASKAN))
            setMaskanLoanAmount(newStudent);


        setAghsat(newStudent);

        ApplicationContext.getStudentService().saveOrUpdate(newStudent);
    }

//    public static void submitmaskanInformation() {
//        Printer.printMsg("submit maskan Information for loan");
//        System.out.println();
//
//        Scanner scanner = new Scanner(System.in);
//        Student newStudent = ApplicationContext.getStudentService().getStudentByUsername(SecurityContext.username);
////        newStudent.setId(SecurityContext.id);
//
//        System.out.print("Enter your wife student id: ");
//        Student wife = new Student();
//        wife.setStudentId(scanner.nextLine().trim());
//        newStudent.setWife(wife);
//
//        System.out.print("Enter your maskan shomare qarardad: ");
//        newStudent.setMaskanShomareQarardad(scanner.nextInt());
//
//
//        System.out.print("Enter your city: ");
//        newStudent.setCity(scanner.nextLine().trim());
//
//        ApplicationContext.getStudentService().saveOrUpdate(newStudent);
//    }

    public static void setShahriyeLoanAmount(Student student) {
        if (student.getDegree() == Degree.KARDANI || student.getDegree() == Degree.KARSHENASI)
            student.getLoan().setAmount(1300000);
        if (student.getDegree().equals(Degree.ARSHADNOPEYVASTE) ||
                student.getDegree().equals(Degree.HERFEIIDOCTORA) ||
                student.getDegree().equals(Degree.PEYVASTEDOCTORA))
            student.getLoan().setAmount(2600000);

        if (student.getDegree().equals(Degree.TAKHASOSINAPEYVASTEDOCTORA))
            student.getLoan().setAmount(65000000);

    }

    public static void setTahsiliLoanAmount(Student student) {
        if (student.getDegree().equals(Degree.KARDANI) || student.getDegree().equals(Degree.KARSHENASI))
            student.getLoan().setAmount(1900000);
        if (student.getDegree().equals(Degree.ARSHADNOPEYVASTE) ||
                student.getDegree().equals(Degree.HERFEIIDOCTORA) ||
                student.getDegree().equals(Degree.PEYVASTEDOCTORA))
            student.getLoan().setAmount(2250000);

        if (student.getDegree().equals(Degree.TAKHASOSINAPEYVASTEDOCTORA))
            student.getLoan().setAmount(2600000);
    }

    public static void setMaskanLoanAmount(Student student) {
        student.getLoan().setAmount(19500000);
        if (student.getCity().equalsIgnoreCase("tehran"))
            student.getLoan().setAmount(32000000);
        for (String element : bigCitys) {
            if (element.equalsIgnoreCase(student.getCity())) {
                student.getLoan().setAmount(26000000);
                break;
            }
        }
    }

    public static void setAghsat(Student student) {
        int x = student.getLoan().getAmount() / 372;
        List<NoPardakhtShodeGhest> aghsat = new ArrayList<>();

        LocalDate installmentDate = LocalDate.of(student.getEntryYear() + 4, Month.OCTOBER, LocalDate.now().getDayOfMonth());

        for (int i = 1; i <= 60; i++) {
            int amount;
            if (i <= 12)
                amount = x;
            else if (i <= 24)
                amount = 2 * x;
            else if (i <= 36)
                amount = 4 * x;
            else if (i <= 48)
                amount = 8 * x;
            else
                amount = 16 * x;

            aghsat.add(new NoPardakhtShodeGhest(i, Date.valueOf(installmentDate), amount));

            installmentDate = installmentDate.plusMonths(1);
        }
        student.getLoan().setNoPardakhtShodeGhests(aghsat);

    }

    public static boolean hasGraduated(Student student) {

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        int duration = 0;
        if (student.getDegree().equals(Degree.KARSHENASI)) {
            duration = 4;
        } else if (student.getDegree().equals(Degree.KARDANI) || student.getDegree().equals(Degree.ARSHADNOPEYVASTE)) {
            duration = 2;
        } else if (student.getDegree().equals(Degree.ARSHADPEYVASTE)) {
            duration = 6;
        } else if (student.getDegree().equals(Degree.NAPEYVASTEDOCTORA)) {
            duration = 5;
        }

        int graduationYear = student.getEntryYear() + duration;

        if (currentYear >= graduationYear)
            student.setGraduated(true);
        else
            student.setGraduated(false);

        return student.isGraduated();
    }

}
