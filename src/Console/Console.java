/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thong Nguyen
 */
public class Console {
    public final static Scanner STDIN = new Scanner(System.in);
    
    public static int intInRange(String text, int min, int max) {
        StringBuilder prompt = new StringBuilder(text);
        prompt.append(" (");
        prompt.append(min);
        prompt.append('-');
        prompt.append(max);
        prompt.append("): ");
        System.out.print(prompt);
        //Ask for a user input
        return STDIN.nextInt();
    }
    
    // Display options and return index of selected option
    public static <T> int getChoice(List<T> options) {
        System.out.println("\nOptions:");
        for (int choice = 0; choice < options.size(); choice++) {
            System.out.println(choice + ". " + options.get(choice));
        }
        return Console.intInRange("Enter an option", 0, options.size() - 1);
    }
}
