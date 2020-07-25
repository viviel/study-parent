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
    
        User user = new User();
        user.setId(1);
        user.setName("vv");
        user.setCreateTime(new Date());
        em.persist(user);
    
        User user1 = em.find(User.class, 1);
        System.out.println(user);
    }
    
}
