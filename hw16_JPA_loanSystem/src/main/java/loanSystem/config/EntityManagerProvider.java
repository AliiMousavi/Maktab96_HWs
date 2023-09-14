package loanSystem.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    static final EntityManagerFactory emf;
    static final EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("loanSystem");
        em = emf.createEntityManager();
    }
    public static EntityManager getEntityManager(){
        return em;
    }
}
