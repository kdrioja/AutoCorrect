/*
    Kenia Rioja-Naranjo
 */

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        ArrayList<String> dict = Dictionary.createDictionary();

        ArrayList<String> sorted = Dictionary.sortDictionary(dict);

        System.out.println();
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }
    }
}
