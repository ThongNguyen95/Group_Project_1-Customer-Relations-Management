/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;
/**
 *
 * @author Zarni
 */
public class ReturnFromMenu implements MenuItem {
    MenuStack menus;
    public ReturnFromMenu(MenuStack _menus) {
        menus = _menus;
    }
    
    //Return to previous menu
    @Override
    public void execute() {
         menus.toPreviousMenu();
    }
    
    @Override
    public String toString() {
        return "Return to previous menu";
    }
}
