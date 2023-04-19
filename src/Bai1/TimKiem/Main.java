package Bai1.TimKiem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputFromUser = new Scanner(System.in);
        boolean inputSuccess = false;

        do {
            try {
                showMainMenu();
                int choose = inputFromUser.nextInt();
                switch (choose) {
                    case 1 -> System.out.println("Choose 1");
                    case 2 -> System.out.println("Choose 2");
                    default -> {
                        System.out.println("Good bye and see you again");
                        inputSuccess = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Number is not available, please try again");
                inputFromUser.nextLine();
            }

        } while (!inputSuccess);
    }

    public static void showMainMenu() {
        System.out.println("Word");
        System.out.println("====");
        System.out.println("\t1. Count word in file");
        System.out.println("\t2. Find file by word");
        System.out.println("\t3. Exit");
        System.out.print("Please choose [1 - 3]: ");

    }
}
