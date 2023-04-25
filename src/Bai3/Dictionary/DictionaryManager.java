package Bai3.Dictionary;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryManager {
    HashMap<String, MyDictionary> dictionaryHashMap = new HashMap<>();
    public void addWord() throws Exception {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter english word: ");
        String englishWord = inputFromUser.nextLine();
        System.out.print("Enter vietnamese word: ");
        String vietnameseWord = inputFromUser.nextLine();
        MyDictionary dictionary = new MyDictionary(englishWord, vietnameseWord);

        if (dictionaryHashMap.containsKey(englishWord)) {
            throw new Exception("English word exist, please try again");
        }

        dictionaryHashMap.put(englishWord, dictionary);
        System.out.println("Word added successfully");

    }


    public void removeWord() {
        System.out.print("Enter english word: ");
        String englishWord = new Scanner(System.in).nextLine();
        if (dictionaryHashMap.containsKey(englishWord)) {
            dictionaryHashMap.remove(englishWord);
            System.out.printf("'%s' removed successfully\n", englishWord);
        } else {
            System.out.printf("'%s' not found\n", englishWord);
        }
    }

    public void translateWord() {
        System.out.print("Enter english word: ");
        String englishWord = new Scanner(System.in).nextLine();
        dictionaryHashMap.values().stream().filter(dictionary -> dictionary.getEnglishWord().contains(englishWord)).forEach(dictionary -> System.out.printf("Vietnamese meaning: %s\n", dictionary.getVietnameseWord()));

        if (!dictionaryHashMap.containsKey(englishWord)) {
            System.out.printf("'%s' not found\n", englishWord);
        }
    }
}
