/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import static Console.Console.getChoice;
import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuItem {

	private String name;
	private MenuStack menus;
	private final List<MenuItem> options;

	public Menu (String _name, MenuStack _menuStack){
		name = _name;
		menus = _menuStack;
		menus.add(this);
		options = new ArrayList<>();
	}
	
	public void addMenu(MenuItem option){
		options.add(option);
	}
	
	@Override
	public void execute(){
		options.get(getChoice(options)).execute();
	}
	
	@Override
	public String toString(){
		return name;
	}
}
