/*
    Kenia Rioja-Naranjo
 */

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

public class Dictionary {

    public static ArrayList<String> sortDictionary(ArrayList<String> unsorted) {
        ArrayList<String> sorted = new ArrayList<>();

        ArrayList<String> leftList = new ArrayList<>();
        ArrayList<String> rightList = new ArrayList<>();
        int middle;

        if (unsorted.size() == 1) {
            return unsorted;
        }
        else {
            middle = unsorted.size() / 2;

            for (int i = 0; i < middle; i++) {
                leftList.add(unsorted.get(i));
            }

            for (int i = middle; i < unsorted.size(); i++) {
                rightList.add(unsorted.get(i));
            }

            leftList = sortDictionary(leftList);
            rightList = sortDictionary(rightList);


        }

        return sorted;
    }

    /*
    if s1 > s2, it returns positive number
    if s1 < s2, it returns negative number
    if s1 == s2, it returns 0
     */

    private void mergeSort(ArrayList<String> leftList, ArrayList<String> rightList, ArrayList<String> original) {
        int leftIndex = 0, rightIndex = 0, originalIndex = 0;

        while (leftIndex < leftList.size() && rightIndex < rightList.size()) {

        }

    }

    public static ArrayList<String> createDictionary() {
        ArrayList<String> dictionary = new ArrayList<>();
        File file = new File("C:\\Users\\KDR\\IdeaProjects\\AutoCorrect\\src\\dictionary.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String newWord = sc.nextLine();
                dictionary.add(newWord);
                System.out.println(newWord);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }

        return dictionary;
    }

    public static String makeAlphabetical(String input) {
        char[] characters = input.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
}
