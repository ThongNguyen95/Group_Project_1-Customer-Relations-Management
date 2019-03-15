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
 * @author Eric
 */
public class SendCreditSubMenu implements MenuItem {

    Owner owner;
    Customer cust;
    AllUsers allusers;

    public SendCreditSubMenu(Owner own, AllUsers _allusers) {
        owner = own;
        cust = null;
        allusers = _allusers;
    }

    public SendCreditSubMenu(Customer _cust, AllUsers _allusers) {
        cust = _cust;
        owner = null;
        allusers = _allusers;

    }

    @Override
    public void execute() {
        if (cust == null)//interacting with owner
        {
            Customer tempcust = owner.selectCustomer();
            System.out.println("How much to send? ");
            double input = STDIN.nextDouble();
            owner.sendCreditTo(tempcust,input);
        } else //interacting with customer
        {
            String ownername = cust.getBus().getCompanyName();
            System.out.println("Your business is: " + ownername);
            Owner tempOwn = cust.getBus();
            System.out.println("How much to send? ");
            double input = STDIN.nextDouble();
            cust.sendCreditTo(tempOwn,input);

        }
    }

    @Override
    public String toString() {
        return "Send Credits";
    }
}
