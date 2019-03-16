/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import Console.MenuItem;
import Console.MenuStack;
import Model.Customer;
import Model.Owner;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author zarni
 */
public class DisplayAppointmentList implements MenuItem {
    Owner owner;
    private final MenuStack menus;
    ArrayList<Calendar> tempCal;
    ArrayList<Customer> tempCust;
    
    public DisplayAppointmentList(Owner _owner,MenuStack _menus){
        owner = _owner;
        menus = _menus;
        tempCal = new ArrayList<>();
        tempCust = new ArrayList<>();
    }
    @Override
    public void execute(){
        // get an appointment date and customer from owner class
        tempCal = owner.getAppointmentDateList();
        tempCust = owner.getAppointmentCustList();
        
        // loop for more than one appointment
        for(int i=0; i<tempCal.size(); i++){
            int mm,dd,yy;
            mm = tempCal.get(i).get(Calendar.MONTH);
            dd = tempCal.get(i).get(Calendar.DAY_OF_MONTH);
            yy = tempCal.get(i).get(Calendar.YEAR);
            // owner can see the date and customer that have an appointment
            System.out.println("You have an appointment on " + mm + "/" + dd + "/" + yy +
                                " with " + tempCust.get(i).getCustomerName() + ".");
            // helper function for jUnit test
            printAppoint(mm,dd,yy,tempCust.get(i));
           
        }
    }
    
    // for jUnit test
    public String printAppoint(int mm, int dd, int yy, Customer tempCust)
    {
    
        return "You have an appointment on " + Integer.toString(mm) + "/" + Integer.toString(dd) + "/" + Integer.toString(yy) +
                                " with " + tempCust.getCustomerName() + "." ;
    }
    
    @Override
    public String toString(){
        return "Display all appointment.";
    }
}
