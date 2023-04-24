package Bai2.DoctorHashMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputFromUser = new Scanner(System.in);
        DoctorManager doctorManager = new DoctorManager();
        boolean inputSuccess = false;
        int chooseNumber;

        while (!inputSuccess) {
            try {
                showMainMenu();
                try {
                    chooseNumber = inputFromUser.nextInt();
                } catch (Exception e) {
                    throw new RuntimeException("Error, please enter a number sir");
                }
                switch (chooseNumber) {
                    case 1 -> doctorManager.addDoctor();
                    case 2 -> doctorManager.displayDoctor();
                    case 3 -> doctorManager.updateDoctor();
                    case 4 -> doctorManager.deleteDoctor();
                    case 5 -> doctorManager.searchDoctor();
                    case 6 -> {
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
        System.out.println("1. Add Doctor");
        System.out.println("2. Display Doctor");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");
        System.out.println("5. Search Doctor");
        System.out.println("6. Exit");
        System.out.print("Please choose [1 - 6]: ");
    }

}
