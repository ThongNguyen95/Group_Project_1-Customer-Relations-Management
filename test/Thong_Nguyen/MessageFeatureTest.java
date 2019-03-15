/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thong_Nguyen;

import Model.Customer;
import Model.Message;
import Model.Owner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thong Nguyen
 */
public class MessageFeatureTest {
    Owner owner;
    Customer customer;
    public MessageFeatureTest() {
        owner = new Owner("owner","owner", "Owner",0);
        customer = new Customer("customer", "customer", "Customer", owner);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    @Test
    public void customerToOwner() {
        //Check size of both message boxes if it is empty
        assertEquals(0, owner.getMsgBox().size());
        customer.sendMessage("Testing Message", "Message from customer");
        //Check if Owner's message box size is 1 now
        assertEquals(1, owner.getMsgBox().size());
        
        Message message = owner.getMsgBox().get(0);
        String sender = message.getSender();
        boolean name = (sender.equals(customer.getCustomerName()));
        //Test if the name of the sender match "Customer"
        assertTrue(name);
        assertEquals("Customer", sender);
        
        //Test the subject of the message
        assertEquals("Testing Message", message.getSubject());
        
        //Test the content of the message
        assertEquals("Message from customer", message.getContent());
    }
    
    @Test
    public void ownerToCustomer() {
        //Check size of both message boxes if it is empty
        assertEquals(0, customer.getMsgBox().size());
        owner.sendMessage(customer, "Testing Message 2", "Message from customer 2");
        //Check if Owner's message box size is 1 now
        assertEquals(1, customer.getMsgBox().size());
        
        Message message = customer.getMsgBox().get(0);
        String sender = message.getSender();
        boolean name = (sender.equals(owner.getCompanyName()));
        //Test if the name of the sender match "Customer"
        assertTrue(name);
        assertEquals("Owner", sender);
        
        //Test the subject of the message
        assertEquals("Testing Message 2", message.getSubject());
        
        //Test the content of the message
        assertEquals("Message from customer 2", message.getContent());
    }
}
