package pers.vv.study.jpa.openjpa;

import pers.vv.study.jpa.openjpa.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class OpenJpaMain {
    
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "EmployeeService", System.getProperties()
        );
        EntityManager em = factory.createEntityManager();
    
        User entity = new User();
        entity.setId(1);
        entity.setName("vv");
        entity.setCreateTime(new Date());
        em.persist(entity);
    
        User result = em.find(User.class, 1);
        System.out.println(result);
    }
    
}
