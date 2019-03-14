/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import static Console.Console.STDIN;
import Console.MenuItem;
import Model.Customer;

/**
 *
 * @author Thong Nguyen
 */
public class CustomerSendMessage implements MenuItem {

    Customer cust;

    public CustomerSendMessage(Customer _cust) {
        cust = _cust;
    }

    @Override
    public void execute() {
        System.out.println("Sending message to " + cust.getBus().getCompanyName());
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
        
        cust.sendMessage(subject, content);
        System.out.println("Message successfully sent!");
    }

    @Override
    public String toString() {
        return "Send Message";
    }
}
