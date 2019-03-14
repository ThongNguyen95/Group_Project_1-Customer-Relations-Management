/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import static Console.Console.STDIN;
import Console.MenuItem;
import Model.AllUsers;
import Model.Customer;

//Zarni
public class CustomerSignIn implements MenuItem {
        AllUsers allUsers;
        
    public CustomerSignIn(AllUsers _allUsers){
        allUsers = _allUsers;
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
                        //subMenu(tempCustomer);
                        break;
                    }
                    else {
                        System.out.println("Invalid password");
                    }
                }
            }
            
        }while(tempCustomer == null);
    }

    @Override
    public String toString() {
        return "Sign In As Customer";
    }
}
