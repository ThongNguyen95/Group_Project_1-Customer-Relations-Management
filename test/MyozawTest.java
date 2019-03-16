/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.AllUsers;
import Model.Customer;
import Model.Owner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Myo Zaw
 */
public class MyozawTest {
    
           AllUsers allUsers;
    Owner owner,owner2;
    Customer customer,customer1;

    @Test
    public void ChangeOPasswordTest(){
        allUsers = new AllUsers();
        owner = new Owner("1","1","1",1000);
        customer = new Customer("1","1","1",owner);
        String npassword = "hello";
        allUsers.addCustomer(customer);
        allUsers.addOwner(owner);
        boolean val = allUsers.ChangeOpass("1", "1", "1",npassword);
        assertTrue(val); 
    }
    
    @Test
    public void ChangeCPasswordTest(){
        allUsers = new AllUsers();
        owner = new Owner("1","1","1",1000);
        customer = new Customer("1","1","1",owner);
        String npassword = "hello";
        allUsers.addCustomer(customer);
        allUsers.addOwner(owner);
        boolean val = allUsers.ChangeCpass("1", "1", "1",npassword);
        assertTrue(val); 
    }
    
    @Test
    public void DeleteOAccountTest(){
        allUsers = new AllUsers();
        owner = new Owner("1","1","1",1000);
        owner2 = new Owner("2","2","2",1000);
        allUsers.addOwner(owner);
        allUsers.addOwner(owner2);
        allUsers.DeleteOaccount("1", "1", "1");
        assertEquals(1,allUsers.getOwnerSize());    
    }
    
    @Test
    public void DeleteCAccountTest(){
        allUsers = new AllUsers();
        owner = new Owner("1","1","1",1000);
        allUsers.addOwner(owner);
        customer = new Customer("1","1","1",owner);
        customer = new Customer("2","2","2",owner);
        allUsers.addCustomer(customer);
        allUsers.addCustomer(customer1);
        allUsers.DeleteCaccount("2", "2", "2");
        assertEquals(1,allUsers.getCustomerSize());    
    }
    
    public void testToString() {
    }
}
