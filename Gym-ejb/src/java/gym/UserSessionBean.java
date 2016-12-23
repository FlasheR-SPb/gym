package gym;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

@Stateless
public class UserSessionBean implements UserSessionBeanRemote, UserSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    @TransactionAttribute(REQUIRED)
    public void addAll(int num_of_visits, int time_type, String fistname, String lastname, String email) {
        Subscriptions subscr = addSubsciption(num_of_visits, time_type);
        addUser(fistname, lastname, email, subscr.getId());
        
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public Subscriptions addSubsciption(int num_of_visits, int time_type) {
        Date date = new Date();
        Subscriptions subscr = new Subscriptions();
        subscr.setNumOfVisits(num_of_visits);
        subscr.setDateOfCreation(date);
        subscr.setTimeOfCreation(date);
        subscr.setTimeType(time_type);
        subscr.setValid(1);
        
        em.persist(subscr);
        
        return subscr;
    }
    
    @Override
    @TransactionAttribute(REQUIRED)
    public void addUser(String fistname, String lastname, String email, int valid_subscription) {
        Users user = new Users();
        user.setFirstname(fistname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setIdSub(valid_subscription);
        
        em.persist(user);
    }

    @Override
    public Users getUser(String firstName, String lastName) {
        Users user = new Users();
        Query query = em.createNamedQuery("Users.findByFullname");
        query.setParameter("firstname", firstName);
        query.setParameter("lastname", lastName);
        user = (Users)query.getResultList().get(0);
        
        return user;
    }

    
    
}
