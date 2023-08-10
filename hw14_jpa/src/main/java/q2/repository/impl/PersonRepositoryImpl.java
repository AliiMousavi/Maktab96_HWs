package q2.repository.impl;

import q2.entity.Person;
import q2.repository.PersonRepository;

import javax.persistence.EntityManager;
import java.util.Collection;

public class PersonRepositoryImpl implements PersonRepository {

    protected EntityManager em;

    public PersonRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Person saveOrUpdate(Person person) {
        beginTransaction();
        Person person1 = saveWithoutTransaction(person);
        commitTransaction();
        em.clear();
        return person1;
    }


    private Person saveWithoutTransaction(Person person) {
        if (person.getId() == null)
            em.persist(person);
        else
            person = em.merge(person);

        return person;
    }

    @Override
    public Person update(Person person) {
        person = em.merge(person);
        return person;
    }

    @Override
    public void deleteById(Long id) {
        beginTransaction();
        em.remove(id);
        commitTransaction();
    }

    @Override
    public Person load(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public Collection<Person> loadAll() {
        return em.createQuery("from " + Person.class.getSimpleName(), Person.class).getResultList();
    }

    @Override
    public boolean contains(Long id) {
        return isPersonExist(em.find(Person.class, id));
    }

    @Override
    public void beginTransaction() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    @Override
    public void rollBack() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();

    }

    private boolean isPersonExist(Person person){
        return person != null;

    }
}
