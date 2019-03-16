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
 * @author zarni
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
        // ask customer id, until correct
        System.out.println("Enter your ID");
        do{
            String str = STDIN.next();
            // check the ID that alread sing up
            tempCustomer = allUsers.getCustomerBasedOnID(str);
            if(tempCustomer == null){
                System.out.println("Invalid ID");
            }else {
                while(str.equals(tempCustomer.getID())){
                     // if the id correct, ask password
                    System.out.println("Enter your Password");
                    String str2 = STDIN.next();
                    if(str2.equals(tempCustomer.getPassword())){
                        //call customer sub menu function
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
    
    // sub menu for customer after singed in
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
        subMenu.addMenu(new CreditMenu(cust, menus, allUsers));
        subMenu.addMenu(new ChangePassword(cust,allUsers));
        subMenu.addMenu(new ViewMessageBox(cust.getMsgBox()));
        subMenu.addMenu(new CustomerSendMessage(cust));
        subMenu.addMenu(new DeleteAccount(cust,allUsers));
        
        
    }
    @Override
    public String toString() {
        return "Sign In As Customer";
    }
}
