/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import static Console.Console.STDIN;
import Console.MenuItem;
import Model.AllUsers;
import Model.Owner;


//Zarni
public class OwnerSignIn implements MenuItem {
    AllUsers allUsers;
    
    public OwnerSignIn(AllUsers _allUsers){
        allUsers = _allUsers;
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
                        //subMenu(tempOwner);
                        break;
                    }
                    else {
                        System.out.println("Invalid password");
                    }
                }
            }
            
        }while(tempOwner == null);
    }


    @Override
    public String toString() {
        return "Sign In As Owner";
    }
    
}
