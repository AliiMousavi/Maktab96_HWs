package q2.util;

import q2.repository.PersonRepository;
import q2.repository.impl.PersonRepositoryImpl;
import q2.service.PersonService;
import q2.service.impl.PersonServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {

    static final EntityManagerFactory emf;
    static final EntityManager em;


    private static final PersonService personService;
    private static final PersonRepository personRepository;

    static {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();

        personRepository = new PersonRepositoryImpl(em);
        personService = new PersonServiceImpl(personRepository);
    }

    public static PersonRepository getPersonRepository(){
        return personRepository;
    }

    public static PersonService getPersonService(){
        return personService;
    }
}