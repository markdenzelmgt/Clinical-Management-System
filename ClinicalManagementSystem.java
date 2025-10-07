import java.util.Scanner;

public class ClinicalManagementSystem {
    public static void main(String[] args) {
        /////////////////////////////////////////
        // we are inputting every method from the 4 subclasses by calling them out and creating new objects
        Scanner choose = new Scanner(System.in);
        DOCTOR doctor = new DOCTOR();
        PATIENT patient = new PATIENT();
        APPOINTMENT appointment = new APPOINTMENT();
        TREATMENT treatment = new TREATMENT();
        /////////////////////////////////////////
        while (true) {
            System.out.println();
            System.out.println("=============================================");
            System.out.println("|         CLINICAL MANAGEMENT SYSTEM        |");
            System.out.println("=============================================");
            System.out.println("|   1. Doctor                               |");
            System.out.println("|   2. Patient                              |");
            System.out.println("|   3. Appointment                          |");
            System.out.println("|   4. Treatment                            |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|      Type 'exit' to quit the system       |");
            System.out.println("=============================================");
            System.out.print("Choose an option (1-4 or 'exit'): ");

            String option = choose.nextLine().trim();
            System.out.println(); // Add some spacing after input

            if (option.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Clinical Management System. Goodbye!");
                break;
            } else if (option.equalsIgnoreCase("doctor")) {
                doctor.doctorMenu();
            } else if (option.equalsIgnoreCase("patient")) {
                patient.patientMenu();
            } else if (option.equalsIgnoreCase("appointment")) {
                appointment.appointmentMenu();
            } else if (option.equalsIgnoreCase("treatment")) {
                treatment.treatmentMenu();
            } else {
                try {
                    int choice = Integer.parseInt(option);
                    switch (choice) {
                        case 1:
                            doctor.doctorMenu();
                            break;
                        case 2:
                            patient.patientMenu();
                            break;
                        case 3:
                            appointment.appointmentMenu();
                            break;
                        case 4:
                            treatment.treatmentMenu();
                            break;
                        default:
                            System.out.println("Error: Please choose a valid option (1-4) or type 'exit' to quit.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid input (eg. 'doctor', 1-4, or 'exit').");
                }
            }
        }
    }
}
