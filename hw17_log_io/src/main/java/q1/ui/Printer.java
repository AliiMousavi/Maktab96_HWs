package q1.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.service.impl.TeacherServiceImpl;

public class Printer {
    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
    public static void printMenu(String[] items){
        logger.info("containsTeacher method in Menu class started.");
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
        logger.info("containsTeacher method in Menu class started.");
        System.out.println("***" + msg + "***");
    }

    public static void printFinishLine(){
        logger.info("containsTeacher method in Menu class started.");
        System.out.println("-------------------------------------------------------------");
    }
}
