/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gym;

import java.util.Calendar;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;

@Stateful
public class VisitSessionBean implements VisitSessionBeanRemote, VisitSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;
 
    @TransactionAttribute(REQUIRED)
    public Subscriptions getSubscription(int id) {
        Subscriptions subs = new Subscriptions();
        Query query = em.createNamedQuery("Subscriptions.findById");
        query.setParameter("id", id);
        subs = (Subscriptions)query.getResultList().get(0);
        
        return subs;
    }
    
    @TransactionAttribute(REQUIRED)
    public Users getUser(int id_sub) {
        Users user = new Users();
        Query query = em.createNamedQuery("Users.findByIdSub");
        query.setParameter("idSub", id_sub);
        user = (Users)query.getResultList().get(0);
        
        return user;
    }
    
    @Override
    @TransactionAttribute(REQUIRED)
    public String visit(int id) {
        Subscriptions sub;
        sub = getSubscription(id);
        
        if (null == sub) {
            return "Такого абонемента не существует!";
        }
        
        Users user;
        user = getUser(id);
        
        if (null == user) {
            return "Такого пользователя не обнаружено";
        }
        
        String message = "Уважаемый, " + user.getFirstname() + " " + user.getLastname() + "!<br>";
        boolean valid = false;
        
        Calendar startTime = new GregorianCalendar();
        startTime.set(startTime.get(Calendar.YEAR), startTime.get(Calendar.MONTH), startTime.get(Calendar.DATE), 9, 0, 0);

        Calendar middleTime = new GregorianCalendar();
        middleTime.set(middleTime.get(Calendar.YEAR), middleTime.get(Calendar.MONTH), middleTime.get(Calendar.DATE), 16, 0, 0);

        Calendar finishTime = new GregorianCalendar();
        finishTime.set(finishTime.get(Calendar.YEAR), finishTime.get(Calendar.MONTH), finishTime.get(Calendar.DATE), 23, 0, 0);

        Calendar currentTime = new GregorianCalendar();
        
        boolean condition1 = sub.getTimeType() == 0 && currentTime.getTimeInMillis() > startTime.getTimeInMillis() && currentTime.getTimeInMillis() < middleTime.getTimeInMillis();
        boolean condition2 = sub.getTimeType() == 1 && currentTime.getTimeInMillis() > middleTime.getTimeInMillis() && currentTime.getTimeInMillis() < finishTime.getTimeInMillis();
        boolean condition3 = sub.getTimeType() == 2 && currentTime.getTimeInMillis() > startTime.getTimeInMillis() && currentTime.getTimeInMillis() < finishTime.getTimeInMillis();
        
        // План посещения: абонемент на 1-6 посещений с учетом времени
        if (sub.getNumOfVisits() > 0) {
           if (condition1 || condition2 || condition3) {
                message += "Добро пожаловать в клуб!<br>";
                sub.setNumOfVisits(sub.getNumOfVisits()-1);
                em.persist(sub);
                addVisit(id);                    
                message += "Оставшееся количество посещений: " + sub.getNumOfVisits();
           }
           else {
                message += "Извините, Ваш абонемент не действует в данное время!";
           }
           return message;
        }
        
        // План посещения: абонемент на 12 посещений, не более 3 раз в неделю, с учетом времени
        if (sub.getNumOfVisits() == -12) {
            Query query = em.createNamedQuery("Visits.findByIdSub");
            query.setParameter("idSub", id);

            List visits = query.getResultList();
            
            if (visits.size() >= 12) {
                message += "У Вас исчерпан лимит посещений. Для приобретения нового абонемента обратитесь к администратору.";
                return message;
            }
            
            Calendar weekTime = new GregorianCalendar();
            weekTime.set(startTime.get(Calendar.YEAR), startTime.get(Calendar.MONTH), startTime.get(Calendar.DATE)-7, 9, 0, 0);
            
            int count = 0;
            
            for (int i = 0; i < visits.size(); i++) {
                if (((Visits)visits.get(i)).getDate().getTime() - weekTime.getTimeInMillis() > 0) {
                    count++;
                }
            }
            
            if (count >= 3) {
                message += "Вы уже посетили зал 3 раза на этой неделе. Приходите на следующей неделе, будем Вам рады!";
            }
            else {
                if (condition1 || condition2 || condition3) {
                    message += "Добро пожаловать в клуб!<br> У вас осталось " + (11 - visits.size()) + " посещений";
                    addVisit(id);                    
                }
                else {
                    message += "Извините, Ваш абонемент не действует в данное время!";
                }
            }
            return message;
        }
        
        // План посещения: неограниченое количество посещений в рабочее время клуба в течение полугода
        if (sub.getNumOfVisits() == -6) {
            Calendar halfyearTime = new GregorianCalendar();
            halfyearTime.set(startTime.get(Calendar.YEAR), startTime.get(Calendar.MONTH)-6, startTime.get(Calendar.DATE), 9, 0, 0);
            if (sub.getDateOfCreation().getTime() - halfyearTime.getTimeInMillis() < 0) {
                message += "Срок вашего абонемента истек. Для приобретения нового абонемента обратитесь к администратору.";
            }
            else {
                if (condition3) {
                    message += "Добро пожаловать в клуб!";
                    addVisit(id);
                }
            }
            return message;
        }
        
        return message+"У Вас не осталось посещений! Приобретите новый абонемент";
    }
    
    @TransactionAttribute(REQUIRED)
    public void addVisit(int id) {
        Date date = new Date();
        Visits newVisit = new Visits();
        newVisit.setIdSub(id);
        newVisit.setDate(date);
        newVisit.setTime(date);
        
        em.persist(newVisit);
    }
    
}
