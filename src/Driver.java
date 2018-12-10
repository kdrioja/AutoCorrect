/*
    Kenia Rioja-Naranjo
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

    public static void getInput() {
        ArrayList<String> dict = Dictionary.createDictionary();
        HashMap<String, String> hashMap = Dictionary.createHashMap(dict);

        System.out.print("Welcome!\nTo quit enter DONE\nEnter a word: ");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();

        while (!input.equals("DONE")) {
            String word = Dictionary.makeAlphabetical(input);
            //System.out.println(word);
            String suggestion = hashMap.get(word);
            //System.out.println(suggestion);

            if (input.equals(suggestion)) {
                System.out.println("Correct.\n");
            }
            else if (suggestion != null) {
                System.out.println("Did you mean " + suggestion + "?\n");
            }
            else {
                System.out.println("No suggestions.\n");
            }

            System.out.print("Enter a word: ");
            input = reader.next();
        }
        System.out.println("See you next time!");
    }

    public static void main(String[] args) {
        getInput();
    }
}