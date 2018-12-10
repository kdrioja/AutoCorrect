/*
    Kenia Rioja-Naranjo
 */

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        String apple = "apple";
        String baby = "baby";
        System.out.println(Dictionary.makeAlphabetical(apple));

        ArrayList<String> dict = Dictionary.createDictionary();
        System.out.println(dict.get(0));

        if (baby.compareTo(apple) < 0) {
            System.out.println(baby.compareTo(apple));
        }
    }
}
