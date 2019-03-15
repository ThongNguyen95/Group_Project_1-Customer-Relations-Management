/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.AllUsers;
import Model.Customer;
import Model.Owner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
public class EricJUnitCreditTest {

    AllUsers allusers;
    Owner owner;
    Owner owner2;
    Customer customer;

    public EricJUnitCreditTest() {
        allusers = new AllUsers();
        owner = new Owner("yes", "yes", "Google", 0);
        owner2 = new Owner("yes", "no", "Google", 0);
        customer = new Customer("yes", "yes", "Yeet McYoten", owner);
        allusers.addOwner(owner);
        allusers.addCustomer(customer);
    }

    @Test
    public void testCredit() {

        owner.addCredit(150);
        owner.subCredit(15);
        assertEquals(135, owner.getCredit(), 0);
    }

    @Test
    public void testSendCredit() {
        customer.addCredit(1000);
        customer.sendCreditTo(owner, 150);
        assertEquals(150, owner.getCredit(), 0);
    }
    
    @Test
    public void testPassword()
    {
         boolean pass = allusers.ChangeOpass("yes", "Google", "yes");
         assertEquals(owner,owner2);
    }
}


