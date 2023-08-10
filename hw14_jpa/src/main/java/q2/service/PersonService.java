package q2.service;

import q2.entity.Person;

import java.util.Collection;

public interface PersonService {
    Person saveOrUpdate(Person person);
    Person update(Person person);
    void deleteById(Long id);
    Person load(Long id);
    Collection<Person> loadAll();

    Person signUp(String firstName,String lastName);
    boolean contains(Long id);
}
