package Bai1.TimKiem;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    Scanner inputFromUser = new Scanner(System.in);

    public void showMenuOne() {
        try {
            System.out.print("Enter path: ");
            String getTextFromFile = this.readFile(inputFromUser.nextLine());
            System.out.print("Enter word: ");
            this.findWordInFile(getTextFromFile, inputFromUser.nextLine());

        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    public void findWordInFile(String text, String word) {
        int countWord = 0;

        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            countWord++;
        }

        System.out.printf("Found %d %s%n", countWord, (countWord == 0) ? "result" : "results");

    }


}
