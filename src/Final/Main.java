package Final;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputFromUser = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        boolean inputSuccess = false;
        int choice;

        while (!inputSuccess) {
            try {
                showMainMenu();
                try {
                    choice = inputFromUser.nextInt();
                } catch (Exception e) {
                    throw new RuntimeException("Error, please enter a number sir");
                }
                switch (choice) {
                    case 1 -> contactManager.addContact();
                    case 2 -> contactManager.findContact();
                    case 3 -> contactManager.displayContact();
                    case 4 -> {
                        System.out.print("Goodbye and see you again");
                        inputSuccess = true;
                    }
                    default -> System.out.println("Number does not exist, please try again");
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
                inputFromUser.nextLine();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("MENU");
        System.out.println("====");
        System.out.println("1. Add new contact");
        System.out.println("2. Find a contact by name");
        System.out.println("3. Display contact");
        System.out.println("4. Exit");
        System.out.print("Please select [1 - 4]: ");
    }
}
