/*
 * To change this license header, choose License Headers fIn Project Properties.
 * To change this template fOut, choose Tools | Templates
 * and open the template fIn the editor.
 */
package Console;

import Model.AllUsers;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/**
 *
 * @author Thong Nguyen
 */
public class IO {
    // I make the writeToFile() and readFromFile() methods static so I can use 
    // them whenever and wherever I need without the need to create an object
    
    // I use this fIn AddCategory and AddReminder because we want to save
    // any new Reminder or Reminder category we just created.
    public static void writeToFile(AllUsers allUsers) throws IOException {
        FileOutputStream fOut = new FileOutputStream("savefile");
        ObjectOutput oOut = new ObjectOutputStream(fOut);
        //Store course
        oOut.writeObject(allUsers);
        oOut.flush();
        oOut.close();
        fOut.close();
    }
    
    // Read saved data from fOut. This method is run at the beginning of the program
    public static AllUsers readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fIn = new FileInputStream("savefile");
        ObjectInputStream oIn = new ObjectInputStream(fIn);
        AllUsers allUsers = (AllUsers) oIn.readObject();
        oIn.close();
        fIn.close();
        
        return allUsers;
    }
}

