/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
public class AllUsers implements Serializable {
    
    ArrayList<Owner> owners;
    ArrayList<Customer> customers;

    //Constructor
    public AllUsers() {
        owners = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addOwner(Owner _owner) {
        owners.add(_owner);
    }

    public void addCustomer(Customer _customer) {
        customers.add(_customer);
    }

    public Owner getOwnerBasedOnName(String name) {
        // Loop through the customers list and compare id
        for (Owner owner : owners) {
            if (owner.getCompanyName().equals(name)) {
                return owner;
            }
        }
        return null;
    }
    
    public Customer getCustomerBasedOnName(String name) {
        // Loop through the customers list and compare id
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
    
    public Owner getOwnerBasedOnID(String id) {
        // Loop through the customers list and compare id
        for (Owner owner : owners) {
            if (owner.getID().equals(id)) {
                return owner;
            }
        }
        return null;
    }

    public boolean businessExists(String id, String name) {
        //Loop through owners list to see if it is in there
        for (Owner owner : owners) {
            if (owner.getID().equals(id) || owner.getCompanyName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean customerExists(String id, String name) {
        //Loop through customers list to see if it is in there
        for (Customer cust : customers) {
            if (cust.getID().equals(id) || cust.getCustomerName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //For testing purpose
    public void displayInfo() {
        System.out.println("Owner list: " + owners.size() + "\nCustomer list: "
                + customers.size());
        for (Owner owner : owners) {
            System.out.println("ID: " + owner.getID() + "\nName: " + owner.getCompanyName()
                    + "\nPassword: " + owner.getPassword());
            System.out.println();
        }
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getID() + "\nName: " + customer.getCustomerName()
                    + "\nPassword: " + customer.getPassword());
        }
    }

    //Zarni's function
    public int getOwnerSize() {
        return owners.size();
    }

    //Zarni's function
    public int getCustomerSize() {
        return customers.size();
    }
}
