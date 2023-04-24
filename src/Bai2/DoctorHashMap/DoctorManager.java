package Bai2.DoctorHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class DoctorManager {
    HashMap<String, Doctor> doctorHashMap = new HashMap<>();

    public void addDoctor() throws Exception {
        String code, name, specialization;
        int availability;
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter code: ");
        code = inputFromUser.nextLine();
        System.out.print("Enter name: ");
        name = inputFromUser.nextLine();
        System.out.print("Enter specialization: ");
        specialization = inputFromUser.nextLine();
        System.out.print("Enter availability: ");
        try {
            availability = inputFromUser.nextInt();
        } catch (Exception e) {
            throw new Exception("Availability must be number, please try again");
        }

        Doctor doctor = new Doctor(code, name, specialization, availability);
        if (doctorHashMap.containsKey(code)) {
            throw new Exception("Doctor exist, please enter code again");
        }
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
        int count = 0;
        System.out.print("Enter name: ");
        String name = inputFromUser.nextLine();


        if (checkDoctorExist(name)) {
            int length = 69;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", "CODE", "NAME", "SPECIALIZATION", "AVAILABILITY");
            System.out.println("+" + line + "+");

//            System.out.println(doctorHashMap.values().stream().filter(result -> result.getName().contains(name)).map(Doctor::toString));

            for (Doctor doctor : doctorHashMap.values()) {
                if (doctor.getName().contains(name)) {
                    System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
                }
            }

            System.out.println("+" + line + "+");
        } else {
            System.out.println("*** Doctor not found ***");
        }
    }

    private boolean checkDoctorExist(String name) {
        for (Doctor doctor : doctorHashMap.values()) {
            if (doctor.getName().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public void updateDoctor() {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = inputFromUser.nextLine();
        if (doctorHashMap.containsKey(code)) {

        } else {
            System.out.println("*** Data not found ***");
        }

    }
}
