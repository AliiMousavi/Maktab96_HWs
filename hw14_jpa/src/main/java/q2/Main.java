package q2;

import q2.entity.Person;
import q2.ui.Menu;
import q2.util.ApplicationContext;

import java.sql.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("ali" , "Mousavi" , Date.valueOf("2001-08-17"));
        Person person1 = new Person(2L,"alii" , "Mousavi" , Date.valueOf("2001-08-17"));

        Menu menu = new Menu();
        menu.run();


//        ApplicationContext.getPersonService().saveOrUpdate(person);
//        ApplicationContext.getPersonService().signUp(person.getFirstName(), person.getLastName());
//        System.out.println(ApplicationContext.getPersonService().contains(person1.getId()));

    }
}
