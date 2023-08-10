import entity.Person;
import util.ApplicationContext;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("ali" , "Mousavi" , Date.valueOf("2001-08-17"));

        ApplicationContext.getPersonService().saveOrUpdate(person);
        ApplicationContext.getPersonService().saveOrUpdate(person);
//        ApplicationContext.getPersonService().signUp(person.getFirstName(), person.getLastName());
//        System.out.println(ApplicationContext.getPersonService().contains(person));

    }
}
