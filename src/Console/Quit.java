/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Model.AllUsers;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thong Nguyen
 */

//Thong Nguyen
public class Quit implements MenuItem{
    AllUsers allUsers;
    public Quit(AllUsers _allUsers) {
        allUsers = _allUsers;
    }
    @Override
    public void execute() {
        //Save data before quitting
        try {
            IO.writeToFile(allUsers);
        } catch (IOException ex) {
            Logger.getLogger(Quit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Quit
        System.out.println("Goodbye! Thank you for using the application!");
        System.exit(0);
    }
    
    @Override
    public String toString() {
        return "Quit";
    }
}