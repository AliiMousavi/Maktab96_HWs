package q1.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.Main;
import q1.entity.Person;
import q1.repository.PersonRepository;

import javax.persistence.EntityManager;
import java.util.Collection;

public class PersonRepositoryImpl implements PersonRepository {
    private static final Logger logger = LoggerFactory.getLogger(PersonRepositoryImpl.class);

    protected EntityManager em;

    public PersonRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Person saveOrUpdate(Person person) {
        logger.info("saveOrUpdate method" + PersonRepositoryImpl.class.getSimpleName() +  "started.");
        beginTransaction();
        Person person1 = saveWithoutTransaction(person);
        commitTransaction();
        em.clear();
        logger.info(person1.getFirstName() + " " + person1.getLastName() + " is savesd in database!",PersonRepositoryImpl.class.getSimpleName());
        return person1;
    }


    private Person saveWithoutTransaction(Person person) {
        logger.info("saveWithoutTransaction method started.");
        if (person.getId() == null)
            em.persist(person);
        else
            person = em.merge(person);
        logger.info(person.getFirstName() + " " + person.getLastName() + " is persist!",PersonRepositoryImpl.class.getSimpleName());
        return person;
    }

    @Override
    public Person update(Person person) {
        logger.info("update method started.");
        person = em.merge(person);
        logger.info(person.getFirstName() + " " + person.getLastName() + " is updated!",PersonRepositoryImpl.class.getSimpleName());
        return person;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("deleteById method started.");
        beginTransaction();
        em.remove(id);
        commitTransaction();
        logger.info("person with id(" + id + ") is deleted!",PersonRepositoryImpl.class.getSimpleName());
    }

    @Override
    public Person load(Long id) {
        logger.info("load person method started.");
        logger.info("person with id(" + id + ") is loaded!",PersonRepositoryImpl.class.getSimpleName());
        return em.find(Person.class, id);
    }

    @Override
    public Collection<Person> loadAll() {
        logger.info("loadAll person method started.");
        logger.info("all person are loaded!",PersonRepositoryImpl.class.getSimpleName());
        return em.createQuery("from " + Person.class.getSimpleName(), Person.class).getResultList();
    }

    @Override
    public boolean contains(Long id) {
        logger.info("contains person method started.");
        return isPersonExist(em.find(Person.class, id));
    }

    @Override
    public void beginTransaction() {
        logger.info("beginTransaction method started.");
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
            logger.info("Transaction begin.");
        }
    }

    @Override
    public void commitTransaction() {
        logger.info("commitTransaction method started.");
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
            logger.info("Transaction commited.");
        }
    }

    @Override
    public void rollBack() {
        logger.info("rollBack method started.");
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            logger.info("Transaction roll backed!.");
        }

    }

    private boolean isPersonExist(Person person){
        logger.info("isPersonExist method run.");
        return person != null;

    }
}
