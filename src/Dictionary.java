/*
    Kenia Rioja-Naranjo
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

    public static HashMap<String, String> createHashMap(ArrayList<String> sortedDict) {
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < sortedDict.size(); i++) {
            String temp = makeAlphabetical(sortedDict.get(i));
            hashMap.put(temp, sortedDict.get(i));
        }

        return hashMap;
    }

    public static ArrayList<String> sortDictionary(ArrayList<String> unsorted) {
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

            mergeSort(leftList, rightList, unsorted);
        }

        return unsorted;
    }


    private static void mergeSort(ArrayList<String> leftList, ArrayList<String> rightList, ArrayList<String> original) {
        int leftIndex = 0, rightIndex = 0, originalIndex = 0;

        while (leftIndex < leftList.size() && rightIndex < rightList.size()) {

            /*
            if s1 > s2, it returns positive number
            if s1 < s2, it returns negative number
            if s1 == s2, it returns 0
             */

            if (leftList.get(leftIndex).compareTo(rightList.get(rightIndex)) < 0) {
                original.set(originalIndex, leftList.get(leftIndex));
                leftIndex++;
            }
            else {
                original.set(originalIndex, rightList.get(rightIndex));
                rightIndex++;
            }

            originalIndex++;
        }

        ArrayList<String> leftover;
        int leftoverIndex;

        if (leftIndex >= leftList.size()) {
            leftoverIndex = rightIndex;
            leftover = rightList;
        }
        else {
            leftoverIndex = leftIndex;
            leftover = leftList;
        }

        for (int i = leftoverIndex; i < leftover.size(); i++) {
            original.set(originalIndex, leftover.get(i));
            originalIndex++;
        }
    }


    public static ArrayList<String> createDictionary() {
        ArrayList<String> dictionary = new ArrayList<>();
        File file = new File("C:\\Users\\KDR\\IdeaProjects\\AutoCorrect\\src\\dictionary.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String newWord = sc.nextLine();
                dictionary.add(newWord);
                //System.out.println(newWord);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }

        dictionary = sortDictionary(dictionary);

        return dictionary;
    }


    public static String makeAlphabetical(String input) {
        char[] characters = input.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
}
