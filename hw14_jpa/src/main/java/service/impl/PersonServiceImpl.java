package service.impl;

import entity.Person;
import repository.PersonRepository;
import service.PersonService;

import java.util.Collection;
import java.util.Optional;

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
    public Person load(Person person) {
        return repository.load(person);
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
    public boolean contains(Person person) {
        return repository.contains(person);
    }
}
