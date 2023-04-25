package Bai2.DoctorHashMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoctorManager {
    HashMap<String, Doctor> doctorHashMap = new HashMap<>();

    public void addDoctor() throws Exception {
        String code, name, specialization;
        int availability;
        Scanner inputFromUser = new Scanner(System.in);

        System.out.print("Enter code: ");
        code = inputFromUser.nextLine();
        Pattern patternCode = Pattern.compile("^[cC]\\d{3}$");
        Matcher matcherCode = patternCode.matcher(code);
        if (!matcherCode.matches()) {
            throw new Exception("Code must be at least 4 characters and start with \"c\"");
        }

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

    public void displayDoctor() {
        if (doctorHashMap.size() != 0) {
            int length = 69;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", "CODE", "NAME", "SPECIALIZATION", "AVAILABILITY");
            System.out.println("+" + line + "+");

            doctorHashMap.values().forEach(doctor -> System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", doctor.getCode().toUpperCase(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability()));

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
        System.out.print("Enter name: ");
        String name = inputFromUser.nextLine();

        if (this.checkDoctorExist(name)) {
            int length = 69;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", "CODE", "NAME", "SPECIALIZATION", "AVAILABILITY");
            System.out.println("+" + line + "+");

            doctorHashMap.values().stream().filter(doctor -> doctor.getName().contains(name)).forEach(doctor -> System.out.printf("| %-8s | %-16s | %-20s | %-14s |%n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability()));

            System.out.println("+" + line + "+");
        } else {
            System.out.println("*** Doctor not found ***");
        }
    }

    private boolean checkDoctorExist(String name) {
        return doctorHashMap.values().stream().anyMatch(doctor -> doctor.getName().contains(name));
    }

    public void updateDoctor() throws Exception {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = inputFromUser.nextLine();
        if (doctorHashMap.containsKey(code)) {
            System.out.print("Enter name: ");
            doctorHashMap.get(code).setName(inputFromUser.nextLine());
            System.out.print("Enter specialization: ");
            doctorHashMap.get(code).setSpecialization(inputFromUser.nextLine());
            System.out.print("Enter availability: ");
            try {
                doctorHashMap.get(code).setAvailability(inputFromUser.nextInt());
            } catch (Exception e) {
                throw new Exception("Availability must be number, please try again");
            }

        } else {
            System.out.println("*** Data not found ***");
        }

    }
}
