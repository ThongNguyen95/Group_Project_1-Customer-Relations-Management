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
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
public class OwnerSendMessage implements MenuItem {
    Owner owner;
    public OwnerSendMessage(Owner _owner) {
        owner = _owner;
    }
    @Override
    public void execute() {
        //Choose which customer to send message to
        System.out.println("Select the message receiver:");
        ArrayList<Customer> custList = owner.getCustomerList();
        for (int i = 0; i < custList.size(); i++) {
            System.out.println(i + ". " + custList.get(i).getCustomerName());
        }
        System.out.print("Option:");
        int option = STDIN.nextInt();
        Customer cust = custList.get(option);
        
        System.out.println("Sending message to " + cust.getCustomerName());
        System.out.print("Subject: ");
        String subject;
        do {
            subject = STDIN.nextLine();
        } while (subject.trim().equals(""));
        if (subject.isEmpty()) subject = subject.concat("<Blank>");
        System.out.println("Content: ");
        String content;
        do {
            content = STDIN.nextLine();
        } while (content.trim().equals(""));
        if (content.isEmpty()) content = content.concat("<Blank>");
        
        owner.sendMessage(cust, subject, content);
        System.out.println("Message successfully sent!");
    }
    
    @Override
    public String toString() {
        return "Send Message";
    }
}
