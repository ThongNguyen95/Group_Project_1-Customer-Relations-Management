/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import Console.IO;
import Console.Menu;
import Console.MenuStack;
import Console.Quit;
import Model.AllUsers;
import java.io.IOException;

/**
 *
 * @author Thong Nguyen
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    
    //Thong
    public static void main(String[] args) {
        //Create list of customers and business owner
        AllUsers allUsers;
        //Load data from file
        try {
            allUsers = IO.readFromFile();
        
        } catch (ClassNotFoundException | IOException o) {
            allUsers = new AllUsers();
        }
        //Create the menu and options
        MenuStack menus = new MenuStack();
        Menu mainMenu = new Menu("Main Menu", menus);
        mainMenu.addMenu(new Quit(allUsers));
        mainMenu.addMenu(new SignUp(allUsers));
        mainMenu.addMenu(new OwnerSignIn(allUsers, menus));
        mainMenu.addMenu(new CustomerSignIn(allUsers, menus));
        while (true) {
            menus.run();
            
        }
    }   
}