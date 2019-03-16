/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.util.ArrayDeque;
/**
 *
 * @author Zarni
 */
public class MenuStack {
    
        // stack of menus
	ArrayDeque<Menu> menus;
	
	//Constructor
	public MenuStack() {
            // initialize the stack
            menus = new ArrayDeque<>();
	}

	//Get the item from the top of the stack
	public Menu getCurrent() {
            return menus.getFirst();
	}
	
	//add a new menu to the stack	
	public void add(Menu menu) {
            menus.addFirst(menu);
	}
        
        //Remove the first object on top of the stack
	public void toPreviousMenu() {
		menus.removeFirst();
	}
        
        //Execute the current menu object
	public void run() {
            if (!menus.isEmpty()) {
                this.getCurrent().execute();
            }
	}
}

