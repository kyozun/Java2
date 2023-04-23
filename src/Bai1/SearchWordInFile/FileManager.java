package Bai1.SearchWordInFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    Scanner inputFromUser = new Scanner(System.in);
    public void showMenuOne() {
        try {
            System.out.print("Enter file path: ");
            String filePath = inputFromUser.nextLine();
            String getTextFromFile = this.readFile(filePath);
            System.out.print("Enter word: ");
            String wordToFind = inputFromUser.nextLine();
            int countWord = this.countWordInFile(getTextFromFile, wordToFind);
            System.out.printf("Found %d %s with \"%s\"%n", countWord, (countWord == 0) ? "result" : "results", wordToFind);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showMenuTwo() {
        try {
            System.out.print("Enter folder path: ");
            String folderPath = inputFromUser.nextLine();
            this.checkFolderPath(folderPath);
            System.out.print("Enter word: ");
            String wordToFind = inputFromUser.nextLine();
            this.getFileName(folderPath, wordToFind);
        } catch (Exception e) {
            System.out.println("Error, please enter folder path again");
        }
    }

    private String readFile(String filePath) throws Exception {
        try {
            File myFile = new File(filePath.replace("\"", ""));
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();

            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            throw new Exception("File not found, please try again");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private int countWordInFile(String text, String word) {
        int countWord = 0;

        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            countWord++;
        }
        return countWord;
    }

    private void getFileName(String folderPath, String wordToFind) throws Exception {
        try {
            int countExistFile = 0;
            File currentFolder = new File(folderPath.replace("\"", ""));
            for (File listFile : Objects.requireNonNull(currentFolder.listFiles())) {
                if (listFile.getName().endsWith("txt")) {
                    String getTextFromFile = this.readFile(listFile.getAbsolutePath());
                    if (this.countWordInFile(getTextFromFile, wordToFind) > 0) {
                        System.out.println("\t"+ listFile.getName());
                        countExistFile++;
                    }
                }
            }
            if (countExistFile == 0) {
                System.out.println("Not found any file");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private void checkFolderPath(String folderPath) throws Exception {
        File currentFolder = new File(folderPath.replace("\"", ""));
        if (!currentFolder.isDirectory()) {
            throw new Exception();
        }
    }

}
