package Bai1.TimKiem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    Scanner inputFromUser = new Scanner(System.in);

    public void showMenuOne() {
        try {
            System.out.print("Enter path: ");
            this.readFile(inputFromUser.nextLine());
            System.out.print("Enter word: ");
            this.findWordInFile("cuong", inputFromUser.nextLine());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void readFile(String filePath) throws Exception {
        try {
            File myFile = new File(filePath.replace("\"", ""));
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            fileReader.close();


        } catch (FileNotFoundException e) {
            throw new Exception("Không tìm thấy file");
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

        System.out.println(countWord);


    }


}
