/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gym;

import javax.ejb.Remote;

/**
 *
 * @author FlasheR
 */
@Remote
public interface UserSessionBeanRemote {
    
    void addAll(int num_of_visits, int time_type, String fistname, String lastname, String email);

    Subscriptions addSubsciption(int num_of_visits, int time_type);
            
    void addUser(String fistname, String lastname, String email, int valid_subscription);
    
    Users getUser(String firstName, String lastName);
    
    
    
}
