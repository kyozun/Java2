package Bai1.SearchWordInFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputFromUser = new Scanner(System.in);
        boolean inputSuccess = false;
        FileManager fileManager = new FileManager();

        do {
            try {
                showMainMenu();
                int choice = inputFromUser.nextInt();
                switch (choice) {
                    case 1 -> fileManager.showMenuOne();
                    case 2 -> fileManager.showMenuTwo();
                    case 3 -> {
                        System.out.println("Good bye and see you again");
                        inputSuccess = true;
                    }
                    default -> System.out.println("Number is not available, please try again");
                }
            } catch (Exception e) {
                System.out.println("Error, please enter a number");
                inputFromUser.nextLine();
            }

        } while (!inputSuccess);
    }

    public static void showMainMenu() {
        System.out.println("Word");
        System.out.println("====");
        System.out.println("\t1. Count word in a file");
        System.out.println("\t2. Find file by word");
        System.out.println("\t3. Exit");
        System.out.print("Please choose [1 - 3]: ");

    }




}
