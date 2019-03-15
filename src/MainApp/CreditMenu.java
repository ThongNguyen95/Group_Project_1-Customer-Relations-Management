/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import Console.Menu;
import Console.MenuItem;
import Console.MenuStack;
import Console.Quit;
import Console.ReturnFromMenu;
import Model.AllUsers;
import Model.Customer;
import Model.Owner;

/**
 *
 * @author Eric
 */
public class CreditMenu implements MenuItem {

    Owner owner;
    Customer customer;
    MenuStack menus;
    AllUsers allusers;

    public CreditMenu(Owner _owner, MenuStack _menus, AllUsers _allusers) {
        owner = _owner;
        customer = null;
        menus = _menus;
        allusers = _allusers;
    }

    public CreditMenu(Customer _customer, MenuStack _menus, AllUsers _allusers) {
        customer = _customer;
        owner = null;
        menus = _menus;
        allusers = _allusers;

    }

    @Override
    public void execute() {
        Menu subMenu = new Menu("Add/Sub Credits", menus);
        subMenu.addMenu(new Quit(allusers));
        subMenu.addMenu(new ReturnFromMenu(menus));
        if (customer == null) //Interacting with Owner
        {
            System.out.println("----------------------------------" + "\nCredit Menu\n");
            System.out.println(owner.getCompanyName() + " credits: " + owner.getCredit());

            subMenu.addMenu(new AddCreditSubMenu(owner));
            subMenu.addMenu(new SubCreditSubMenu(owner));
            subMenu.addMenu(new SendCreditSubMenu(owner,allusers));
        } else //interact with customer
        {
            System.out.println(customer.getCustomerName() + " credits: " + customer.getCredit());
            subMenu.addMenu(new AddCreditSubMenu(customer));
            subMenu.addMenu(new SubCreditSubMenu(customer));
            subMenu.addMenu(new SendCreditSubMenu(customer,allusers));
        }

    }

    @Override
    public String toString() {
        return "Credit Menu";
    }

}
