/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Eric Gatpandan
 */
public class Owner {
    private String id;
    private String password;
    private String companyName;
    private double credit;
    private final ArrayList<Customer> customers;
    
    
    public Owner(String myid, String mypass, String mycomp,double mycredit)
    {
        id = myid;
        password = mypass;
        companyName = mycomp;
        credit = mycredit;
        customers = new ArrayList<>();
    }
    public void viewCustomers()
    {
        System.out.println("Customers: ");
        for(int c = 0; c < customers.size(); c++)
        {
            System.out.println(c + ": " + customers.get(c).getCustomerName());
        }
    }
    public void addCustomer(Customer cust)
    {
        customers.add(cust);
    }
    public void setID(String myid)
    {
        id = myid;
    }
    public void setPassword(String mypassword)
    {
        password = mypassword;
    }
    public void setCompanyName(String myCompany)
    {
        companyName = myCompany;
    }
    public void setCredit(double num)
    {
        credit = num;
    }
    public void addCredit(double num)
    {
        credit += num;
    }
    public void subCredit(double num)
    {
        credit -= num;
    }
    public double getCredit()
    {
        return credit;
    }
    public String getID()
    {
        return id;
    }
    public String getPassword()
    {
        return password;
    }
    public String getCompanyName()
    {
        return companyName;
    }
    
    public void sendMessage()
    {
        
    }
    
}
