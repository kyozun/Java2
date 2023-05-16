package Bai3.Dictionary;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        DictionaryManager dictionaryManager = new DictionaryManager();
        Scanner inputFromUser = new Scanner(System.in);
        int choice;
        boolean inputSuccess = false;
        dictionaryManager.loadData();
        while (!inputSuccess) {
            try {
                showMainMenu();
                try {
                    choice = inputFromUser.nextInt();
                } catch (Exception e) {
                    throw new Exception("Error, please enter a number");
                }
                switch (choice) {
                    case 1 -> dictionaryManager.addWord();
                    case 2 -> dictionaryManager.displayWord();
                    case 3 -> dictionaryManager.removeWord();
                    case 4 -> dictionaryManager.translateWord();
                    case 5 -> {
                        System.out.println("Goodbye my friend");
                        inputSuccess = true;
                    }
                    default -> System.out.println("Number does not exist, please try again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                inputFromUser.nextLine();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("MENU");
        System.out.println("====");
        System.out.println("1. Add word");
        System.out.println("2. Display word");
        System.out.println("3. Remove word");
        System.out.println("4. Translate");
        System.out.println("5. Exit");
        System.out.print("Please select [1 - 5]: ");
    }


}
