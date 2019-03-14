/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Console.Menu;
import Console.MenuItem;
import Console.MenuStack;
import Console.Quit;
import Console.ReturnFromMenu;

/**
 *
 * @author Eric
 */
public class ViewCustomerMenu implements MenuItem{
    private MenuStack menus;
    private Owner owner;
    
    
    
    public ViewCustomerMenu(MenuStack _menus,  Owner _own)
    {
        menus = _menus;
        owner = _own;
    }

    @Override
    public void execute() {
        System.out.println();
        owner.viewCustomers();
        System.out.println();
        System.out.println("What would you like to do?");
        Menu subMenu = new Menu("Customer Interaction Menu", menus);
        subMenu.addMenu(new ReturnFromMenu(menus));
    }
    
    @Override
    public String toString()
    {
        return "View Customers";
    }
    
}
