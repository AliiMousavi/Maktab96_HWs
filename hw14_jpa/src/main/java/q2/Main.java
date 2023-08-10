package q2;

import q2.entity.Person;
import q2.util.ApplicationContext;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("ali" , "Mousavi" , Date.valueOf("2001-08-17"));

        ApplicationContext.getPersonService().saveOrUpdate(person);
//        ApplicationContext.getPersonService().signUp(person.getFirstName(), person.getLastName());
//        System.out.println(ApplicationContext.getPersonService().contains(person));

    }
}
