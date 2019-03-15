/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import static Console.Console.STDIN;
import Console.MenuItem;
import Model.Message;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
public class ViewMessageBox implements MenuItem {
    ArrayList<Message> msgBox;
    
    public ViewMessageBox(ArrayList<Message> _msgBox) {
        msgBox = _msgBox;
    }
    
    
    @Override
    public void execute() {
        if (msgBox.isEmpty()){
            System.out.println("Your message box is empty.");
            return;
        }
        //Display all the message
        System.out.println("Message Box:");
        for (int i = 0; i < msgBox.size(); i++) {
            System.out.print(i + ". ");
            msgBox.get(i).info();
        }
        System.out.println("Choose a message to read: ");
        int option = STDIN.nextInt();
        
        System.out.println();
        if (option >= 0 && option < msgBox.size())
            msgBox.get(option).view();
        else
            System.out.println("Invalid input!");
    }

    @Override
    public String toString() {
        return "View Message Box";
    }
}
