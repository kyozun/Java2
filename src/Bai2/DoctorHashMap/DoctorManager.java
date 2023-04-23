package Bai2.DoctorHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class DoctorManager {
    HashMap<String, Doctor> doctorHashMap = new HashMap<>();

    public void addDoctor() {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = inputFromUser.nextLine();
        System.out.print("Enter name: ");
        String name = inputFromUser.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = inputFromUser.nextLine();
        System.out.print("Enter availability: ");
        int availability = inputFromUser.nextInt();

        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctorHashMap.put(code, doctor);
        System.out.println("Doctor added successfully");
    }

    /**
     * Hàm hiển thị, hiển thị khi size != 0
     */
    public void displayDoctor() {
        if (doctorHashMap.size() != 0) {
            int length = 69;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", "CODE", "NAME", "SPECIALIZATION", "AVAILABILITY");
            System.out.println("+" + line + "+");
            for (Doctor doctor : doctorHashMap.values()) {
                System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
            System.out.println("+" + line + "+");
        } else {
            System.out.println("*** Data not found ***");
        }
    }

    public void deleteDoctor() {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = inputFromUser.nextLine();
        if (doctorHashMap.containsKey(code)) {
            doctorHashMap.remove(code);
            System.out.printf("Doctor with code = \"%s\" removed successfully\n", code);
        } else {
            System.out.println("*** Doctor not found ***");
        }
    }

    public void searchDoctor() {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = inputFromUser.nextLine();

        if (doctorHashMap.containsKey(code)) {
            int length = 69;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", "CODE", "NAME", "SPECIALIZATION", "AVAILABILITY");
            System.out.println("+" + line + "+");

            System.out.print(doctorHashMap.get(code).toString());

            System.out.println("+" + line + "+");
        } else {
            System.out.println("*** Doctor not found ***");
        }
    }
}
