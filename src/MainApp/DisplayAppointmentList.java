/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import Console.MenuItem;
import Console.MenuStack;
import Model.Owner;

/**
 *
 * @author zarni
 */
public class DisplayAppointmentList implements MenuItem {
    Owner owner;
    private MenuStack menus;
    public DisplayAppointmentList(Owner _owner,MenuStack _menus){
        owner = _owner;
        menus = _menus;
    }
    @Override
    public void execute(){
        owner.getAppointmentList();
    }
    @Override
    public String toString(){
        return "Display all appointment.";
    }
}
