package q2.repository;

import q2.entity.Person;

import java.util.Collection;

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
