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

/**
 *
 * @author Myo Zaw
 */
public class Cpassword implements MenuItem {
        AllUsers allUsers;
        
    public Cpassword(AllUsers _allUsers) {
        allUsers = _allUsers;
    }
    
    @Override
    public void execute(){
        String uname, uid, upassword;
        boolean answer;
        boolean oexist;
        boolean cexist;
        boolean passchanged;
        int userchoice;
        System.out.print("Do you want to change your account password(y/n)?: ");
        String input = STDIN.next();
        
        answer = input.equals("y");
        if(answer)
        {   
            System.out.println("Choose your account type");
            System.out.println("1. Owner");
            System.out.println("2. Customer");
            userchoice = STDIN.nextInt();
            if(userchoice==1)
            {
            if(!allUsers.isOEmpty())
            {
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
                    System.out.println("There is no account to change password!");
            }
            }
            if(userchoice==2)
            {
                if(!allUsers.isCEmpty())
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
              else
                {
                    System.out.println("There is no account to change password!");
                }                
        }
        else
        {
            System.out.println("Thanks for making business");
        }
    }
    }
    
    @Override
    public String toString(){
        return "Change Password.";
    }
}
