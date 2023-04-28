package Bai5.StudentManagement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputFromUser = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
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
                    case 1 -> studentManager.addStudent();
                    case 2 -> studentManager.displayStudent();
                    case 3 -> studentManager.updateStudent();
                    case 4 -> studentManager.findStudent();
                    case 5 -> studentManager.removeStudent();
                    case 6 -> studentManager.sortStudent();
                    case 7 -> {
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
        System.out.println("1. Add student");
        System.out.println("2. Display student");
        System.out.println("3. Update student by ID");
        System.out.println("4. Find student by ID");
        System.out.println("5. Remove student by ID");
        System.out.println("6. Sort student");
        System.out.println("7. Exit");
        System.out.print("Please select [1 - 7]: ");
    }
}
