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
    private MenuStack menus;
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
        tempCal = owner.getAppointmentDateList();
        tempCust = owner.getAppointmentCustList();
        
        for(int i=0; i<tempCal.size(); i++){
            int mm,dd,yy;
            mm = tempCal.get(i).get(Calendar.MONTH);
            dd = tempCal.get(i).get(Calendar.DAY_OF_MONTH);
            yy = tempCal.get(i).get(Calendar.YEAR);
            System.out.println("You have an appointment on " + mm + "/" + dd + "/" + yy +
                                " with " + tempCust.get(i).getCustomerName() + ".");
           
        }
    }
    @Override
    public String toString(){
        return "Display all appointment.";
    }
}
