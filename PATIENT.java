import java.util.Scanner;
import java.util.ArrayList;

class PATIENT {
    // Scanner and List
    Scanner scan_patient = new Scanner(System.in);
    public static ArrayList<PATIENT> patientList = new ArrayList<>();

    private static int patientCounter = 1; // Static counter for patient IDs
    private int patient_id;
    private String patient_name;
    private int patient_age;
    private String patient_sickness;

    //////////////////////////////////////////////////////////////////////////////
    // Setters
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }
    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }
    public void setPatient_sickness(String patient_sickness) {
        this.patient_sickness = patient_sickness;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Getters
    public int getPatient_id() {
        return patient_id;
    }
    public String getPatient_name() {
        return patient_name;
    }
    public int getPatient_age() {
        return patient_age;
    }
    public String getPatient_sickness() {
        return patient_sickness;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Patient Menu
    public void patientMenu() {
        while (true) {
            System.out.println(" ");
            System.out.println("===================================");
            System.out.println("|     WELCOME TO PATIENT MENU     |");
            System.out.println("===================================");
            System.out.println("|   1. Add Patient                |");
            System.out.println("|   2. Enter Patient's ID         |");
            System.out.println("|   3. View Patients              |");
            System.out.println("|---------------------------------|");
            System.out.println("|   Type 'exit' to quit the menu  |");
            System.out.println("===================================");
            System.out.print("Choose an option (1-3 or 'exit'): ");
            String option = scan_patient.nextLine();
            System.out.println();

            if (option.equalsIgnoreCase("exit")) {
                System.out.println("Exiting patient menu...");
                break;
            }

            try {
                int choice = Integer.parseInt(option);

                switch (choice) {
                    case 1:
                        addingPatient();
                        break;
                    case 2:
                        displayPatientInfo();
                        break;
                    case 3:
                        viewPatients();
                        break;
                    default:
                        System.out.println("Error: Please enter a valid option (1-3).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number or type 'exit' to quit.");
            }
        }
    }

    // Add Patient
    public void addingPatient() {
        PATIENT newPatient = new PATIENT();
        System.out.println("======== ADDING A PATIENT ========");
        // Automatically assign a unique ID
        newPatient.setPatient_id(patientCounter++);
        System.out.println("| PATIENT ID: " + newPatient.getPatient_id() + " |");

        // Name Input
        while (true) {
            try {
                System.out.print("Enter Patient's Name: ");
                newPatient.setPatient_name(scan_patient.nextLine());
                if (!newPatient.getPatient_name().isEmpty()) break;
                System.out.println("Error: Name cannot be empty.");
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid name.");
            }
        }

        // Age Input
        while (true) {
            try {
                System.out.print("Enter Patient's Age: ");
                int age = scan_patient.nextInt();
                if (age > 0) {
                    newPatient.setPatient_age(age);
                    scan_patient.nextLine(); // Consume leftover newline
                    break;
                } else {
                    System.out.println("Error: Age must be a positive integer.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer for age.");
                scan_patient.nextLine(); // Clear invalid input
            }
        }

        // Medical History Input
        while (true) {
            try {
                System.out.print("Enter Patient's Medical History: ");
                newPatient.setPatient_sickness(scan_patient.nextLine());
                if (!newPatient.getPatient_sickness().isEmpty()) break;
                System.out.println("Error: Medical history cannot be empty.");
            } catch (Exception e) {
                System.out.println("Error: Please enter valid medical history.");
            }
        }

        patientList.add(newPatient);
        System.out.println("\n!! Patient details have been successfully recorded. !!");
    }

    // Display Patient Info
    public void displayPatientInfo() {
        System.out.print("Enter Patient's ID to view their information: ");
        try {
            int patient_id = scan_patient.nextInt();
            scan_patient.nextLine(); // Consume leftover newline
            System.out.println("==== SEARCHING FOR PATIENT ====");
            if (patientList.isEmpty()) {
                System.out.println("No patients available. Please add a patient first.");
                return;
            }
            for (PATIENT patient : patientList) {
                if (patient.getPatient_id() == patient_id) {
                    System.out.println("---------------------------");
                    System.out.println("|      Patient Found:     |");
                    System.out.println("---------------------------");
                    System.out.println("| PATIENT ID:    " + patient.getPatient_id());
                    System.out.println("| NAME:          " + patient.getPatient_name());
                    System.out.println("| AGE:           " + patient.getPatient_age());
                    System.out.println("| SICKNESS:      " + patient.getPatient_sickness());
                    System.out.println("---------------------------");
                    break;
                } else {
                    System.out.println("Patient with ID " + patient_id + " not found.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid patient ID.");
            scan_patient.nextLine(); // Clear invalid input
        }
    }


    // View All Patients
    public void viewPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available. Please add a patient first.");
        } else {
            System.out.println("==== LIST OF PATIENTS ====");
            for (PATIENT patient : patientList) {
                System.out.println("-----------------------------");
                System.out.println("| PATIENT ID:    " + patient.getPatient_id());
                System.out.println("| NAME:          " + patient.getPatient_name());
                System.out.println("| AGE:           " + patient.getPatient_age());
                System.out.println("| SICKNESS:      " + patient.getPatient_sickness());
                System.out.println("-----------------------------");
            }
        }
    }
}
