import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

class DOCTOR {
    // Doctor List
    public static ArrayList<DOCTOR> doctorlist = new ArrayList<>();
    Scanner scan_doc = new Scanner(System.in);

    private static int doctorCounter = 1; // Static counter for doctors
    private int doc_id;
    private String doc_name;
    private int doc_age;
    private String doc_speciality;
    private BigInteger doc_contact;
    private Date doc_availability;

    //////////////////////////////////////////////////////////////////////////////
    // Setters
    public void setDoc_id(int doc_id) {this.doc_id = doc_id;}
    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }
    public void setDoc_age(int doc_age) {
        this.doc_age = doc_age;
    }
    public void setDoc_speciality(String doc_speciality) {
        this.doc_speciality = doc_speciality;
    }
    public void setDoc_contact(BigInteger doc_contact) {
        this.doc_contact = doc_contact;
    }
    public void setDoc_availability(Date doc_availability) {
        this.doc_availability = doc_availability;
    }
    //////////////////////////////////////////////////////////////////////////////
    // Getters
    public int getDoc_id() {
        return doc_id;
    }
    public String getDoc_name() {
        return doc_name;
    }
    public int getDoc_age() {
        return doc_age;
    }
    public String getDoc_speciality() {
        return doc_speciality;
    }
    public BigInteger getDoc_contact() {
        return doc_contact;
    }
    public Date getDoc_availability() {
        return doc_availability;
    }
    //////////////////////////////////////////////////////////////////////////////
    // Doctor Menu
    public void doctorMenu() {
        while (true) {
            System.out.println(" ");
            System.out.println("========================================");
            System.out.println("|      WELCOME TO THE DOCTOR MENU      |");
            System.out.println("========================================");
            System.out.println("|   1. Add Doctor                      |");
            System.out.println("|   2. Enter Doctor's ID               |");
            System.out.println("|   3. View Doctors                    |");
            System.out.println("|--------------------------------------|");
            System.out.println("|    Type 'exit' to quit the system    |");
            System.out.println("========================================");
            System.out.print("Choose an option (1-3 or 'exit'): ");
            String option = scan_doc.nextLine();
            System.out.println();

            if (option.equalsIgnoreCase("exit")) {
                System.out.println("Exiting doctor menu...");
                break;
            }
            try {
                int choice = Integer.parseInt(option);
                switch (choice) {
                    case 1:
                        addingDoctor();
                        break;
                    case 2:
                        displayDoctorInfo();
                        break;
                    case 3:
                        viewDoctors();
                        break;
                    default:
                        System.out.println("Error: Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number or type 'exit' to quit.");
            }
        }
    }

    // Add Doctor
    private void addingDoctor() {
        DOCTOR newDoctor = new DOCTOR();
        System.out.println("======== ADDING A DOCTOR ========");
        newDoctor.setDoc_id(doctorCounter++);
        System.out.println("| DOCTOR ID: " + newDoctor.getDoc_id() + " |");

        // Name Input
        while (true) {
            try {
                System.out.print("Enter the Name of the Doctor: ");
                newDoctor.setDoc_name(scan_doc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid name.");
            }
        }

        // Age Input
        while (true) {
            try {
                System.out.print("Enter the Age of the Doctor: ");
                int age = scan_doc.nextInt();
                if (age > 0) {
                    newDoctor.setDoc_age(age);
                    scan_doc.nextLine(); // Consume leftover newline
                    break;
                } else {
                    System.out.println("Error: Age must be a positive integer.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer for age.");
                scan_doc.nextLine(); // Clear invalid input
            }
        }

        // Speciality Input
        while (true) {
            try {
                System.out.print("Enter the Speciality of the Doctor: ");
                newDoctor.setDoc_speciality(scan_doc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid speciality (avoid special characters).");
            }
        }

        // Contact Input
        while (true) {
            try {
                System.out.print("Enter the Doctor's Contact: ");
                BigInteger contact = scan_doc.nextBigInteger();
                if (contact.compareTo(BigInteger.ZERO) > 0) {
                    newDoctor.setDoc_contact(contact);
                    scan_doc.nextLine(); // Consume leftover newline
                    break;
                } else {
                    System.out.println("Error: Contact number must be a positive number.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid positive integer for contact.");
                scan_doc.nextLine(); // Clear invalid input
            }
        }

        // Availability Input
        while (true) {
            try {
                System.out.print("Enter the Doctor's availability date (e.g., yyyy-MM-dd): ");
                String dateInput = scan_doc.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false); // Ensures strict date validation
                Date availabilityDate = dateFormat.parse(dateInput);
                newDoctor.setDoc_availability(availabilityDate);
                break;
            } catch (ParseException e) {
                System.out.println("Error: Please enter the date in the correct format (yyyy-MM-dd).");
            }
        }

        // Add to Doctor List
        System.out.println("\n!! Doctor details have been successfully recorded. !!");
        doctorlist.add(newDoctor);
    }


    // Display Doctor Info
    public void displayDoctorInfo() {
        System.out.print("Enter Doctor ID to view their information: ");
        try {
            int doc_id = scan_doc.nextInt();
            scan_doc.nextLine();

            System.out.println("==== SEARCHING FOR DOCTOR ====");
            if (doctorlist.isEmpty()) {
                System.out.println("No doctors available. Please add a doctor first.");
            } else {
                for (DOCTOR doctor : doctorlist) {
                    if (doctor.getDoc_id() == doc_id) {
                        System.out.println("----------------------------");
                        System.out.println("|       Doctor Found:      |");
                        System.out.println("----------------------------");
                        System.out.println("| DOCTOR ID:      " + doctor.getDoc_id());
                        System.out.println("| NAME:           " + doctor.getDoc_name());
                        System.out.println("| AGE:            " + doctor.getDoc_age());
                        System.out.println("| SPECIALITY:     " + doctor.getDoc_speciality());
                        System.out.println("| CONTACT:        " + doctor.getDoc_contact());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        System.out.println("| AVAILABILITY:   " + dateFormat.format(doctor.getDoc_availability()));
                        System.out.println("---------------------------");
                        break;
                    } else {
                        System.out.println("Doctor with ID " + doc_id + " not found.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid doctor ID.");
            scan_doc.nextLine(); // Clear invalid input
        }
    }

    // View All Doctors
    private void viewDoctors() {
        if (doctorlist.isEmpty()) {
            System.out.println("No doctors available. Please add a doctor first.");
        } else {
            System.out.println("==== LIST OF DOCTORS ====");
            for (DOCTOR doctor : doctorlist) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("-----------------------------");
                System.out.println("| DOCTOR ID:      " + doctor.getDoc_id());
                System.out.println("| NAME:           " + doctor.getDoc_name());
                System.out.println("| SPECIALITY:     " + doctor.getDoc_speciality());
                System.out.println("| CONTACT:        " + doctor.getDoc_contact());
                System.out.println("| AVAILABILITY:   " + dateFormat.format(doctor.getDoc_availability()));
                System.out.println("-----------------------------");
            }
        }
    }
}
