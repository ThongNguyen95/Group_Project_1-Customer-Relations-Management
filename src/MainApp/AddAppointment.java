/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import Console.Console;
import static Console.Console.STDIN;
import Console.MenuItem;
import Console.MenuStack;
import Model.AllUsers;
import Model.Owner;
import java.util.GregorianCalendar;

/**
 *
 * @author zarni
 */
public class AddAppointment implements MenuItem {
    
    private GregorianCalendar cal;
    private final MenuStack menus;
    Owner owner;
    AllUsers allUser;
    
   
    public AddAppointment(Owner _owner,MenuStack _menus,AllUsers _allUser){
        owner = _owner;
        menus = _menus;
        allUser = _allUser;
    }
    
    @Override
    public void execute(){
        int mm,dd,yy;   // temp holder for month, day and year
        // ask month,day and year from owner that have an appointment
        System.out.println("Enter an appointment.");    
        mm = Console.intInRange("Enter a month: ", 1, 12) -1;
        dd = Console.intInRange("Enter a day: ", 1, 31);
        yy = Console.intInRange("Enter a year: ", 2019, 2119);
        cal = new GregorianCalendar(yy,mm,dd);
        // get customer that have an appointment
        System.out.println("Enter your customer ID that you have an appointment with.");
        String str = STDIN.next();
        owner.addAppointment(cal,allUser.getCustomerBasedOnID(str));
        System.out.println("You added an appointment."); 
        
    }
    @Override
    public String toString(){
        return "Add an appointment.";
    }
}
