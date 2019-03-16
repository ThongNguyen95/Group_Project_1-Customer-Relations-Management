/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zarni;

import Console.MenuStack;
import MainApp.DisplayAppointmentList;
import Model.AllUsers;
import Model.Customer;
import Model.Owner;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zarni
 */
public class ZarniTest {
    Owner owner;
    Customer customer;
    
    AllUsers alluser;
    MenuStack menus;
    
    GregorianCalendar cal;
   
    public ZarniTest() {
        // create a Owner and Customer
        owner = new Owner("zarni123","1234","zarni",0);
        customer = new Customer("pyae123","1234","pyae",owner);
        
        // add them into AllUsers
        alluser = new AllUsers();
        alluser.addOwner(owner);
        alluser.addCustomer(customer);
        
        menus = new MenuStack(); // menus stack
        
        cal = new GregorianCalendar(2019,5,15);
    }

    /**
     * Test of class AddAppointment.
     */
    @Test
    public void Addappointment() {
        // owner add an apointment list
        owner.addAppointment(cal, customer);
        
        //after add an apointment, the test result should be 1.
        assertEquals(1,owner.getAppointmentDateList().size());
        
    }
    
    /**
     * Test of of class DisplayAppointmentList.
     */
    @Test
    public void DisplayAppointmentList() {
        
        owner.addAppointment(cal, customer); // owner add an appointment
        
        // create a DisplayAppointmentList obj
        DisplayAppointmentList dAL = new DisplayAppointmentList(owner,menus);
        
        // get string from the hellper function that make for jUnit test
        String str = dAL.printAppoint(5, 15, 2019, customer);
        
        // the result should be the same as string 'str'
        assertEquals("You have an appointment on 5/15/2019 with pyae.",str);
    }

}
