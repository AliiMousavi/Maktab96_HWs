package erpSystem;

import erpSystem.entity.Student;
import erpSystem.ui.menu.MainMenu;
import erpSystem.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setFirstName("ali");
        student.setLastName("mousavi");
        student.setUsername("alimsv");
        student.setPassword("12345");
        student.setEmail("alimwdfejkn@gmail.com");
        student.setMobileNumber("09171981902");
        student.setGpaOfPreviousSemester(12.23F);
        student.setPassedCourses(new ArrayList<>());

        Student student1 = new Student();
        student1.setId(1L);

        ApplicationContext.getStudentService().saveOrUpdate(student);

        MainMenu.run();



    }
}
