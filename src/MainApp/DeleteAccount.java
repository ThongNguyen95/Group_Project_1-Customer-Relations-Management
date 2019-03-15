/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import static Console.Console.STDIN;
import Console.MenuItem;
import Console.ReturnFromMenu;
import Model.AllUsers;
import Model.Customer;
import Model.Owner;

/**
 *
 * @author Myo Zaw
 */
public class DeleteAccount implements MenuItem {
    
    AllUsers allUsers;
    Owner owner;
    Customer customer;
    
     public DeleteAccount(Owner _owner,AllUsers _allUsers) {
        owner = _owner;
        allUsers = _allUsers;
        customer = null;
    }
    
    public DeleteAccount(Customer _customer,AllUsers _allUsers){
        customer = _customer;
        owner = null;
        allUsers = _allUsers;
    }
    
    @Override
    public void execute() {
       String uname, uid, upassword;
        boolean answer;
        boolean oexist;
        boolean cexist;
        boolean AccountDeleted;
        
        System.out.print("Do you to deactivate your account(y/n)?: ");
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
                    AccountDeleted = allUsers.DeleteOaccount(uid, uname,upassword);
                    if(AccountDeleted)
                    {   
                        System.out.println("Your owner account is successfully deatviated.");
                        System.out.println("Sorry to see you go!");
                        allUsers.displayInfo();
                       
                        
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
                    AccountDeleted = allUsers.DeleteCaccount(uid, uname,upassword);
                    if(AccountDeleted)
                    {
                        System.out.println("Your customer account is successfully deatviated.");
                        System.out.println("Sorry to see you go!");
                        allUsers.displayInfo();
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
        else 
        {
            System.out.println("Thanks for keeping account with us.");
        }
    }
    
    @Override
    public String toString(){
        return "Deactivate your account.";
    }
}
