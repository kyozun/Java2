package Bai3.Dictionary;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryManager {
    private final String FILENAME = "data.txt";
    HashMap<String, MyDictionary> dictionaryHashMap = new HashMap<>();

    public void addWord() throws Exception {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter english word: ");
        String englishWord = inputFromUser.nextLine();
        if (englishWord.isBlank()) {
            throw new Exception("English word can not be empty, please try again");
        }
        System.out.print("Enter vietnamese word: ");
        String vietnameseWord = inputFromUser.nextLine();
        if (vietnameseWord.isBlank()) {
            throw new Exception("English word can not be empty, please try again");
        }
        MyDictionary myDictionary = new MyDictionary(englishWord, vietnameseWord);

        if (dictionaryHashMap.containsKey(englishWord)) {
            throw new Exception("English word exist, please try again");
        }

        dictionaryHashMap.put(englishWord, myDictionary);
        this.saveData();
        System.out.println("Word added successfully");

    }


    public void removeWord() {
        this.loadData();
        System.out.print("Enter english word: ");
        String englishWord = new Scanner(System.in).nextLine();
        if (dictionaryHashMap.containsKey(englishWord)) {
            dictionaryHashMap.remove(englishWord);
            this.saveData();
            System.out.printf("\"%s\" removed successfully\n", englishWord);
        } else {
            System.out.printf("\"%s\" not found\n", englishWord);
        }
    }

    public void translateWord() {
        this.loadData();

        System.out.print("Enter english word: ");
        String englishWord = new Scanner(System.in).nextLine();
        dictionaryHashMap.values().stream().filter(dictionary -> dictionary.getEnglishWord().contains(englishWord)).forEach(dictionary -> System.out.printf("Vietnamese meaning: %s\n", dictionary.getVietnameseWord()));

        if (!dictionaryHashMap.containsKey(englishWord)) {
            System.out.printf("'%s' not found\n", englishWord);
        }
    }

    public void displayWord() {
        this.loadData();

        if (dictionaryHashMap.size() != 0) {
            int length = 37;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-16s | %-16s |%n", "English", "Vietnamese");
            System.out.println("+" + line + "+");
            dictionaryHashMap.values().forEach(myDictionary -> System.out.printf("| %-16s | %-16s |\n", myDictionary.getEnglishWord(), myDictionary.getVietnameseWord()));
            System.out.println("+" + line + "+");
        } else {
            System.out.println("*** Data not found ***");
        }
    }

    /*Lấy đường dẫn của thư mục gốc rồi tạo file txt*/
    public void loadData() {
        File tempDirectory = new File(System.getProperty("user.dir"));
        File dataFile = new File(tempDirectory, FILENAME);
        try {
            if (dataFile.createNewFile()) {
                return;
            }
        } catch (Exception e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String englishWord = parts[0];
                String vietnameseWord = parts[1];
                dictionaryHashMap.put(englishWord, new MyDictionary(englishWord, vietnameseWord));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    private void saveData() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME))) {
            for (MyDictionary myDictionary : dictionaryHashMap.values()) {
                bufferedWriter.write(String.format("%s,%s\n", myDictionary.getEnglishWord(), myDictionary.getVietnameseWord()));
            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

