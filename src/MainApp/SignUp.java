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
 * @author Thong Nguyen
 */

//Thong Nguyen
public class SignUp implements MenuItem {

    AllUsers allUsers;

    public SignUp(AllUsers _allUsers) {
        allUsers = _allUsers;
    }

    @Override
    public void execute() {
        String name, id, password;
        boolean isOwner;
        boolean exist;
        
        System.out.println("\n");
        System.out.println("********         Sign Up Form          **********");
        System.out.println("* Enter -1 at any time to get back to main menu *");
        System.out.println("*************************************************");
        
        System.out.print("Do you want to sign up as a business owner(y/n): ");
        String ans = STDIN.next();
        if (ans.equals("-1")) return;   //Back to previous menu
        
        isOwner = ans.toLowerCase().equals("y");
        if (isOwner) {
            System.out.println("Signing up as a business owner...");
        } else {
            System.out.println("Signing up as a customer...");
        }
        do {
            //Get name
            System.out.print("Enter your name: ");
            do {
                name = STDIN.nextLine();
            } while (name.trim().equals(""));
            if (name.equals("-1")) return;   //Back to previous menu
            
            //Get ID
            System.out.print("Enter your user ID: ");
            do {
                id = STDIN.nextLine();
            } while (id.trim().equals(""));
            if (id.equals("-1")) return;   //Back to previous menu
            
            
            //Check if ID or name exists
            if (isOwner) {
                exist = allUsers.businessExists(id, name);
            } else {
                exist = allUsers.customerExists(id, name);
            }

            if (exist) {
                System.out.println("This name or ID is already taken."
                        + " Try another one! Or enter -1 to get back to previous menu.");
            }

        } while (exist);

        //Create password
        do {
            System.out.print("Enter your password: ");
            do {
                password = STDIN.nextLine();
            } while (password.trim().equals(""));
            if (password.equals("-1")) return;   //Back to previous menu
        } while (password.isEmpty());

        // Add the new account to the list of existing accounts
        Owner owner;
        Customer customer;
        if (isOwner) {
            owner = new Owner(id, password, name, 0);
            allUsers.addOwner(owner);
        } else {
            customer = new Customer(id, password, name, null);
            String ownerName;
            Owner tempOwner;
            do {
                System.out.print("Which business are you a customer of?  ");
                do {
                    ownerName = STDIN.nextLine();
                } while (ownerName.trim().equals(""));
                if (ownerName.equals("-1")) return;   //Back to previous menu
                
                //Look for the business in the business list
                tempOwner = allUsers.getOwnerBasedOnName(ownerName);
                if (tempOwner == null) {
                    System.out.println("This business is not exist. Try again!");
                } else {
                    tempOwner.addCustomer(customer);
                    customer.setBusiness(tempOwner);
                }

            } while (tempOwner == null);
            //Add it to the customer list
            allUsers.addCustomer(customer);
        }
        System.out.println("Congratulation! Your account is successfully created!");
    }

    @Override

    public String toString() {
        return "Sign up";
    }
}