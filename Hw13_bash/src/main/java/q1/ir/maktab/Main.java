package q1.ir.maktab;


import q1.ir.maktab.model.Person;
import q1.ir.maktab.model.PersonSummary;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static q1.ir.maktab.mockdata.MockData.getPeople;

public class Main {

    public static List<Person> filterByAge(List<Person> persons){

        return persons.stream()
                .filter(person -> person.getAge() < 50)
                .toList();
    }

    public static List<Person> sortByUsername(List<Person> persons){

        return persons.stream()
                .sorted(Comparator.comparing(Person::getUsername))
                .toList();
    }

    public static List<Person> sortByAgeAndLname(List<Person> persons){

        return persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .sorted(Comparator.comparing(Person::getLastName))
                .toList();
    }

    public static void mapByIpv4(List<Person> persons){

        System.out.println(persons.stream()
                .map(Person::getIpv4)
                .collect(Collectors.toList()));
    }

    public static Map<String, Person>  b5(List<Person> persons){

        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .filter(p -> p.getGender().equals("Female") && p.getAge() > 40)
                .dropWhile(p -> p.getFirstName().startsWith("A"))
                .skip(5)
                .limit(100)
                .collect(Collectors.toMap(p -> p.getFirstName() + " " + p.getLastName(), p -> p));
    }

//    public static List<PersonSummary>  b6(List<Person> persons){
//
//        List<PersonSummary> summaries = persons.stream()
//                .map(p -> {
//                    try {
//                        return new PersonSummary(
//                                p.getId(),
//                                p.getFirstName(),
//                                p.getLastName(),
//                                p.getAge(),
//
//                        );
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                        return null;
//                    }
//                })
//                .collect(Collectors.toList());
//    }




    public static void main(String[] args) {
        List<Person> persons = getPeople();

//        System.out.println(persons.size());

//        System.out.println(filterByAge(persons));
//        System.out.println(sortByUsername(persons));
        System.out.println(persons);

    }
}