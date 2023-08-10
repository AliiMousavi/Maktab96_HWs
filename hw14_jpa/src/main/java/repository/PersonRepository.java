package repository;

import entity.Person;

import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

public interface PersonRepository {
    Person saveOrUpdate(Person person);
    Person update(Person person);
    Person load(Person person);
    Collection<Person> loadAll();
    boolean contains(Person person);

    void beginTransaction();

    void commitTransaction();

    void rollBack();

}
