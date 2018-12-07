/*
    Kenia Rioja-Naranjo
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {
    public static ArrayList<String> createDictionary() {
        ArrayList<String> result = new ArrayList<>();

        String abc = "bhda";



        return result;
    }

    //create function to sort the Strings in the ArrayList

    public static String makeAlphabetical(String input) {
        char[] characters = input.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
}
