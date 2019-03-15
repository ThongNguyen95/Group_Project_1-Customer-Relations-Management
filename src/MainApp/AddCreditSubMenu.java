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
public class AddCreditSubMenu implements MenuItem {

    Owner owner;
    Customer customer;

    public AddCreditSubMenu(Owner _owner) {
        owner = _owner;
        customer = null;
    }

    public AddCreditSubMenu(Customer _cust) {
        customer = _cust;
        owner = null;
    }

    @Override
    public void execute() {
        System.out.println();
        if (owner == null) {
            System.out.println("Current credits: " + customer.getCredit());
        } else {
            System.out.println("Current credits: " + owner.getCredit());
        }

        System.out.println("How much to add?: ");
        double input = STDIN.nextDouble();

        if (owner == null) {
            customer.addCredit(input);//add to customer
        } else {
            owner.addCredit(input);//add to owner
        }

    }

    @Override
    public String toString() {
        return "Add Credits";
    }
}
