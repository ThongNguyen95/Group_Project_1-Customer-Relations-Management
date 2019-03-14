/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import static Console.Console.STDIN;
import Console.MenuItem;
import Model.Customer;
import Model.Owner;


/**
 *
 * @author Eric
 */
public class SubCreditSubMenu implements MenuItem{
        Owner owner;
    Customer customer;
    public SubCreditSubMenu(Owner _owner)
    {
        owner = _owner;
        customer = null;
    }
    public SubCreditSubMenu(Customer _cust)
    {
        customer = _cust;
        owner = null;
    }
    @Override 
    public void execute()
    {
        System.out.println();
        if(owner == null)
            System.out.println("Current credits: " + customer.getCredit());
        else
            System.out.println("Current credits: " + owner.getCredit());
        
        System.out.println("How much to subtract?: ");
        double input = STDIN.nextDouble();
        
        if(owner == null)
            subCust(input);
        else
            subOwn(input);
                if(owner == null);
                    
 
    }

    private void subCust(double num)
    {
        customer.subCredit(num);
    }

    private void subOwn(double num)
    {
        owner.subCredit(num);
    }
    @Override
    public String toString()
    {
        return "Subtract Credits";
    }
}
