/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import Model.Owner;

/**
 *
 * @author Myo Zaw
 */
public class ChangePassword implements MenuItem {
    
    AllUsers allUsers;
    Owner owner;
    Customer customer;
    
    public ChangePassword(Owner _owner,AllUsers _allUsers) {
        owner = _owner;
        customer = null;
        allUsers = _allUsers;
    }
    
    public ChangePassword(Customer _customer,AllUsers _allUsers){
        customer = _customer;
        owner = null;
        allUsers = _allUsers;
    }
    
    @Override
    public void execute(){
        String uname, uid, upassword;
        boolean answer;
        boolean oexist;
        boolean cexist;
        boolean passchanged;
        
        System.out.print("Do you want to change your account password(y/n)?: ");
        String input = STDIN.next();
        
        answer = input.equals("y");
        if(answer)
        {
            if(customer==null)
            {   
                //System.out.println("Owner Accounts");
                System.out.println("Enter your Id:");  
                do {
                uid = STDIN.next();
                 } while (uid.trim().equals(""));
                System.out.println("Enter Your name: "); 
                do {
                uname = STDIN.next();
                 } while (uname.trim().equals(""));
                oexist = allUsers.businessExists(uid,uname);
               
                if(oexist)
                {
                    System.out.println("Enter your password!");
                    do {
                            upassword = STDIN.next();
                       } while (upassword.trim().equals(""));
                    passchanged = allUsers.ChangeOpass(uid, uname,upassword);
                    if(passchanged)
                    {
                        System.out.println("Your password is successfully changed.");
                        //allUsers.displayInfo();
                    }
                    else 
                    {
                        System.out.println("Wrong Password!");
                    }
                }
                else
                {
                    System.out.println("Your account doesn't exist!");
                }
            }
            else
            {     
                //System.out.println("Customer Accounts");
                {
                    System.out.println("Enter your Id:");  
                do {
                uid = STDIN.next();
                 } while (uid.trim().equals(""));
                System.out.println("Enter Your name: "); 
                do {
                uname = STDIN.next();
                 } while (uname.trim().equals(""));
                cexist = allUsers.customerExists(uid,uname);       
                if(cexist)
                {
                    System.out.println("Enter your password!");
                    do {
                            upassword = STDIN.next();
                       } while (upassword.trim().equals(""));
                    passchanged = allUsers.ChangeCpass(uid, uname,upassword);
                    if(passchanged)
                    {
                        System.out.println("Your Customer account password successfully changed.");
                        //allUsers.displayInfo();
                    }
                    else
                    {
                        System.out.println("Wrong password!");
                    }
                }
                else
                {
                    System.out.println("Your account doesn't exist!");
                }   
            }
            }
        }
        
    }
    
    @Override
    public String toString(){
        return "Change Password.";
    }
}
