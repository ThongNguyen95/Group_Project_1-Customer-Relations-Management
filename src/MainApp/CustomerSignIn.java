/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import static Console.Console.STDIN;
import Console.Menu;
import Console.MenuItem;
import Console.MenuStack;
import Console.Quit;
import Console.ReturnFromMenu;
import Model.AllUsers;
import Model.Customer;
/**
 *
 * @author Zarni
 */
public class CustomerSignIn implements MenuItem {
        AllUsers allUsers;
        MenuStack menus;
        
    public CustomerSignIn(AllUsers _allUsers, MenuStack _menus){
        allUsers = _allUsers;
        menus = _menus;
    }

    @Override
    public void execute() {
        Customer tempCustomer;
        System.out.println("Enter your ID");
        
        
        do{
            
            String str = STDIN.next();
            tempCustomer = allUsers.getCustomerBasedOnID(str);
            if(tempCustomer == null){
                System.out.println("Invalid ID");
                
            }else {
                while(str.equals(tempCustomer.getID())){
                    System.out.println("Enter your Password");
                    String str2 = STDIN.next();
                    
                    if(str2.equals(tempCustomer.getPassword())){
                        subMenu(tempCustomer);
                        break;
                    }
                    else {
                        System.out.println("Invalid password");
                    }
                }
            }
            
        }while(tempCustomer == null);
    }
    private void subMenu(Customer cust) {
        //System.out.println("Login successful!");
        //System.out.println("Business Owner Menu " + tempOwner.getCompanyName());
        //System.out.println("Credits: " + tempOwner.getCredit());
        String name = "Owner Menu: "    //Menu name
                + cust.getCustomerName()//Company name
                + "\nCredits: " + Double.toString(cust.getCredit()); //Credit
        
        Menu subMenu = new Menu(name, menus);
        subMenu.addMenu(new Quit(allUsers));
        subMenu.addMenu(new ReturnFromMenu(menus));
    }
    @Override
    public String toString() {
        return "Sign In As Customer";
    }
}
