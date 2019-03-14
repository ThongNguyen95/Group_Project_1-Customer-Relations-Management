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
import Model.Owner;
import Model.ViewCustomerMenu;


//Zarni

public class OwnerSignIn implements MenuItem {
    AllUsers allUsers;
    MenuStack menus;
    
    public OwnerSignIn(AllUsers _allUsers, MenuStack _menus){
        allUsers = _allUsers;
        menus = _menus;
    }
    
    @Override
    public void execute() {
        Owner tempOwner;
        System.out.println("Enter your ID");
        
        do{
            
            String str = STDIN.next();
            tempOwner = allUsers.getOwnerBasedOnID(str);
            if(tempOwner == null){
                System.out.println("Invalid ID");
                
            }else {
                while(str.equals(tempOwner.getID())){
                    System.out.println("Enter your Password");
                    String str2 = STDIN.next();
                    
                    if(str2.equals(tempOwner.getPassword())){
                        subMenu(tempOwner);
                        break;
                    }
                    else {
                        System.out.println("Invalid password");
                    }
                }
            }
            
        }while(tempOwner == null);
    }

    private void subMenu(Owner tempOwner) {
        //System.out.println("Login successful!");
        //System.out.println("Business Owner Menu " + tempOwner.getCompanyName());
        //System.out.println("Credits: " + tempOwner.getCredit());
        String name = "Owner Menu: "    //Menu name
                + tempOwner.getCompanyName() //Company name
                + "\nCredits: " + Double.toString(tempOwner.getCredit()); //Credit
        
        Menu subMenu = new Menu(name, menus);
        subMenu.addMenu(new Quit(allUsers));
        subMenu.addMenu(new ReturnFromMenu(menus));
        subMenu.addMenu(new Cpassword(allUsers));
    }
    @Override
    public String toString() {
        return "Sign In As Owner";
    }
    
}
