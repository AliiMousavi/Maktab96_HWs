package q1.repository;

import q1.entity.Person;

import java.util.Collection;

public interface PersonRepository {
    Person saveOrUpdate(Person person);
    Person update(Person person);
    void deleteById(Long id);
    Person load(Long id);
    Collection<Person> loadAll();
    boolean contains(Long id);

    void beginTransaction();

    void commitTransaction();

    void rollBack();

}
