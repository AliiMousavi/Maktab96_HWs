package q1.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.entity.Person;
import q1.repository.PersonRepository;
import q1.repository.impl.TeacherRepositoryImpl;
import q1.service.PersonService;

import java.util.Collection;

public class PersonServiceImpl implements PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    protected final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;

    }

    @Override
    public Person saveOrUpdate(Person person) {
        logger.info("saveOrUpdate method started in service.");
        return repository.saveOrUpdate(person);
    }

    @Override
    public Person update(Person person) {
        logger.info("update method started in service.");
        return repository.update(person);
    }

    @Override
    public void deleteById(Long id) {
        logger.info("deleteById method started in service.");
        repository.deleteById(id);
    }

    @Override
    public Person load(Long id) {
        logger.info("load method started in service.");
        return repository.load(id);
    }

    @Override
    public Collection<Person> loadAll() {
        logger.info("loadAll method started in service.");
        return repository.loadAll();
    }

    @Override
    public Person signUp(String firstName,String lastName) {
        logger.info("signUp method started in service.");
        Person person = new Person(firstName , lastName);
        repository.saveOrUpdate(person);
        return person;
    }

    @Override
    public boolean contains(Long id) {
        logger.info("contains method started in service.");
        return repository.contains(id);
    }
}
