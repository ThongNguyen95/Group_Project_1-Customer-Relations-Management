/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Eric Gatpandan
 */
public class Customer implements Serializable {
    private String id;
    private String password;
    private String customerName;
    private String businessName;
    private double credit;
    
    
    public Customer(String myid, String mypassword, String mycustomerName, String _bus)
    {
        id = myid;
        password = mypassword;
        customerName = mycustomerName;
        businessName = _bus;
        credit = 0;
    }
    public void setID(String myid)
    {
    id = myid;
    }
    public void setPassword(String mypassword)
    {
    password = mypassword;
    }
     public String getID()
    {
        return id;
    }
    public String getPassword()
    {
        return password;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public void setBusinessName(String name)
    {
        businessName = name;
    }
    public String getBusName()
    {
        return businessName;
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
    public void sendMessage()
    {
        
    }

}
