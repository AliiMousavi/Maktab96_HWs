package q2.service.impl;

import q2.entity.Person;
import q2.repository.PersonRepository;
import q2.service.PersonService;

import java.util.Collection;

public class PersonServiceImpl implements PersonService {

    protected final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return repository.saveOrUpdate(person);
    }

    @Override
    public Person update(Person person) {
        return repository.update(person);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Person load(Long id) {
        return repository.load(id);
    }

    @Override
    public Collection<Person> loadAll() {
        return repository.loadAll();
    }

    @Override
    public Person signUp(String firstName,String lastName) {
        Person person = new Person(firstName , lastName);
        repository.saveOrUpdate(person);
        return person;
    }

    @Override
    public boolean contains(Long id) {
        return repository.contains(id);
    }
}
