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

        System.out.print("Welcome!\nType in a word: ");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();

        while (!input.equals("DONE")) {
            String word = Dictionary.makeAlphabetical(input);
            String suggestion = hashMap.get(word);

            if (suggestion == null) {
                System.out.println("No suggestions.");
            }
            else if (input.equals(suggestion)) {
                System.out.println("Correct.");
            }
            else if (word.equals(suggestion)) {
                System.out.println("Did you mean " + suggestion);
            }


        }

    }

    public static void main(String[] args) {
        ArrayList<String> dict = Dictionary.createDictionary();

        //ArrayList<String> sorted = Dictionary.sortDictionary(dict);
        /*
        System.out.println();
        for (int i = 0; i < dict.size(); i++) {
            System.out.println(dict.get(i));
        }
        */
        HashMap<String, String> hashMap = Dictionary.createHashMap(dict);
        System.out.println(hashMap.get("oo"));

        getInput();
    }
}