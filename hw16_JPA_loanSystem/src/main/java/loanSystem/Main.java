package loanSystem;

import loanSystem.entity.Student;
import loanSystem.ui.Menu.MainMenu;
import loanSystem.util.ApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student();
//        student.setFirstName("ali");
//        ApplicationContext.getStudentService().saveOrUpdate(student);

//        Student studentByUsername = ApplicationContext.getStudentService().getStudentByUsername("2283244897");
//        System.out.println(studentByUsername.getDegree());

        MainMenu.run();
    }
}
