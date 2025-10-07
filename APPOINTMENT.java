import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class APPOINTMENT {
    Scanner scan_appointment = new Scanner(System.in);
    public static ArrayList<APPOINTMENT> appointmentList = new ArrayList<>();

    private int patient_id;
    private String patient_name;
    private String patient_sickness;
    private int doctor_id;
    private String doctor_name;
    private String doctor_speciality;
    private Date doctor_availability;

    /////////////////////////////////////////////////////////////////////////////////
    // Setters
    public void setPatient_sickness(String patient_sickness) {this.patient_sickness = patient_sickness;}
    public void setPatient_id(int patient_id) {this.patient_id = patient_id;}
    public void setPatient_name(String patient_name) {this.patient_name = patient_name;}
    public void setDoctor_speciality(String doctor_speciality) {this.doctor_speciality = doctor_speciality;}
    public void setDoctor_id(int doctor_id) {this.doctor_id = doctor_id;}
    public void setDoctor_name(String doctor_name) {this.doctor_name = doctor_name;}
    public void setDoctor_availability(Date doctor_availability) {this.doctor_availability = doctor_availability;}
    /////////////////////////////////////////////////////////////////////////////////
    // Getters
    public String getPatient_sickness() {return patient_sickness;}
    public int getPatient_id() {return patient_id;}
    public String getPatient_name() {return patient_name;}
    public String getDoctor_speciality() {return doctor_speciality;}
    public int getDoctor_id() {return doctor_id;}
    public String getDoctor_name() {return doctor_name;}
    public Date getDoctor_availability() {return doctor_availability;}
    /////////////////////////////////////////////////////////////////////////////////
    // Show Current Date
    public void appointmentDate() {
        Date currDate = new Date();
        SimpleDateFormat time = new SimpleDateFormat("MMMM/d/yyyy: EEEE h:mm a");
        System.out.println("Current Date: " + time.format(currDate));
    }

    // Appointment Menu
    public void appointmentMenu() {
        while (true) {
            System.out.println(" ");
            System.out.println("========================================================");
            System.out.println("|              WELCOME TO APPOINTMENT MENU             |");
            System.out.println("========================================================");
            System.out.println("|   1. Add Appointment                                 |");
            System.out.println("|   2. Enter Patient's ID to see their Appointment     |");
            System.out.println("|   3. View Appointments                               |");
            System.out.println("|   4. View Appointments on a particular date          |");
            System.out.println("|------------------------------------------------------|");
            System.out.println("|             Type 'exit' to quit the menu             |");
            System.out.println("========================================================");
            System.out.print("Choose an option (1-3 or type 'exit' to quit): ");
            String option = scan_appointment.nextLine();
            System.out.println();
            if (option.equalsIgnoreCase("exit")) {
                System.out.println("Exiting appointment menu...");
                break;
            }
            try {
                int choice = Integer.parseInt(option);
                switch (choice) {
                    case 1:
                        addAppointment();
                        break;
                    case 2:
                        displayAppointment();
                        break;
                    case 3:
                        viewAppointments();
                        appointmentDate();
                        System.out.println("-----------------------------------------------");
                        break;
                    case 4:
                        particularAppointment();
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number or 'exit' to quit.");
            }
        }
    }

    // Add Appointment
    public void addAppointment() {
        System.out.println("======== ADDING AN APPOINTMENT ========");
        System.out.println("--------------------");
        System.out.println("| List of Patients |");
        System.out.println("--------------------");

        if (PATIENT.patientList.isEmpty()) {
            System.out.println("No patients available (Please Add Doctors and Patients First).");
            return;
        }

        for (PATIENT patient : PATIENT.patientList) {
            System.out.println(
                    "PATIENT ID: " + patient.getPatient_id() +
                            " / NAME: " + patient.getPatient_name() +
                            " / AGE: " + patient.getPatient_age() +
                            " / SICKNESS: " + patient.getPatient_sickness()
            );
        }

        System.out.println("==================================================");
        APPOINTMENT newAppointment = new APPOINTMENT();
        System.out.print("Enter Patient's ID: ");
        newAppointment.setPatient_id(scan_appointment.nextInt());
        scan_appointment.nextLine();

        while (true) {
            try {
                System.out.print("Enter the Name of the Patient: ");
                newAppointment.setPatient_name(scan_appointment.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid name.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the Sickness of the Patient: ");
                newAppointment.setPatient_sickness(scan_appointment.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid sickness (avoid special characters).");
            }
        }

        if (DOCTOR.doctorlist.isEmpty()) {
            System.out.println("No doctors available (Please Add Doctors and Patients First).");
            return;
        }

        System.out.println("-------------------");
        System.out.println("| List of Doctors |");
        System.out.println("-------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (DOCTOR doctor : DOCTOR.doctorlist) {
            System.out.println(
                    "| DOCTOR ID: " + doctor.getDoc_id() +
                            " / NAME: " + doctor.getDoc_name() +
                            " / AGE: " + doctor.getDoc_age() +
                            " / SPECIALITY: " + doctor.getDoc_speciality() +
                            " / CONTACT: " + doctor.getDoc_contact()
                            + "/ DOCTOR AVAILABILITY: " + dateFormat.format(doctor.getDoc_availability()) + "|"
            );
        }

        System.out.print("Enter Doctor's ID: ");
        newAppointment.setDoctor_id(scan_appointment.nextInt());
        scan_appointment.nextLine();

        while (true) {
            try {
                System.out.print("Enter the Name of the Doctor: ");
                newAppointment.setDoctor_name(scan_appointment.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid name.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the Speciality of the Doctor: ");
                newAppointment.setDoctor_speciality(scan_appointment.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid speciality (avoid special characters).");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the Doctor's availability date (e.g., yyyy-MM-dd): ");
                String dateInput = scan_appointment.nextLine();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                formatDate.setLenient(false);
                Date availabilityDate = formatDate.parse(dateInput);
                newAppointment.setDoctor_availability(availabilityDate);
                break;
            } catch (ParseException e) {
                System.out.println("Error: Please enter the date in the correct format (yyyy-MM-dd).");
            }
        }

        appointmentList.add(newAppointment);
        System.out.println("\n!! Appointment added successfully !!");
    }

    // Display Appointment Info
    public void displayAppointment() {
        System.out.print("Enter Patient's ID to search their appointment: ");
        int patient_id = scan_appointment.nextInt();
        scan_appointment.nextLine();
        System.out.println("==== SEARCHING FOR APPOINTMENT ====");
        if (appointmentList.isEmpty()) {
            System.out.println("There are no Appointments entered yet.");
        }
        for (APPOINTMENT appointment : appointmentList) {
            if (appointment.getPatient_id() == patient_id) {
                System.out.println("--------------------");
                System.out.println("| Appointment Found |");
                System.out.println("--------------------");
                System.out.println("| PATIENT ID: " + appointment.getPatient_id()
                        + " || PATIENT'S NAME: " + appointment.getPatient_name()
                        + "| PATIENT SICKNESS: " + appointment.getPatient_sickness());
                System.out.println("| DOCTOR ID: " + appointment.getDoctor_id()
                        + " || DOCTOR'S NAME: " + appointment.getDoctor_name()
                        + "| DOCTOR SPECIALITY: " + appointment.getDoctor_speciality());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("| APPOINTMENT TIME: " + dateFormat.format(appointment.getDoctor_availability()) + "|");
                System.out.println("-------------------------------------------");
                return;
            }
        }
        System.out.println("Patient with ID " + patient_id + " not found.");
    }

    // View All Appointments
    public void viewAppointments() {
        System.out.println("------------------------");
        System.out.println("| List of Appointments | :");
        System.out.println("------------------------");
        if (appointmentList.isEmpty()) {
            System.out.println("There are no Appointments entered yet.");
        }
        for (APPOINTMENT appointment : appointmentList) {
            System.out.println("-----------------------------------------------");
            System.out.println("| PATIENT ID: " + appointment.getPatient_id() + "|");
            System.out.println("| PATIENT NAME: " + appointment.getPatient_name()
                    + " || PATIENT SICKNESS: " + appointment.getPatient_sickness());
            System.out.println("| DOCTOR NAME: " + appointment.getDoctor_name()
                    + " || DOCTOR SPECIALITY: " + appointment.getDoctor_speciality());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("| APPOINTMENT TIME: " + dateFormat.format(appointment.getDoctor_availability()) + " |");
            System.out.println("-----------------------------------------------");
        }
    }

    public void particularAppointment() {
        System.out.println("======== VIEW APPOINTMENTS FOR A PARTICULAR DATE ========");
        // Loop to ask the user to input a date in the correct format
        while (true) {
            try {
                System.out.print("Enter the date to search for appointments (yyyy-MM-dd): ");
                String dateInput = scan_appointment.nextLine();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                formatDate.setLenient(false);
                formatDate.parse(dateInput); // Parsing the date to ensure correct format

                System.out.println("--------------------------------");
                System.out.println("| Appointments for " + dateInput + " |");
                System.out.println("--------------------------------");
                // Check if the appointment list is empty
                if (appointmentList.isEmpty()) {
                    System.out.println("There are no Appointments added yet (Please add an Appointment first).");
                    return; // Exit the method if the list is empty
                }

                // Loop through the appointments and compare the date
                for (APPOINTMENT appointment : appointmentList) {
                    SimpleDateFormat appointmentDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String appointmentDate = appointmentDateFormat.format(appointment.getDoctor_availability());

                    if (appointmentDate.equals(dateInput)) {
                        System.out.println("-----------------------------------------------");
                        System.out.println("| PATIENT ID: " + appointment.getPatient_id() + " |");
                        System.out.println("| PATIENT NAME: " + appointment.getPatient_name()
                                + " || PATIENT SICKNESS: " + appointment.getPatient_sickness());
                        System.out.println("| DOCTOR NAME: " + appointment.getDoctor_name()
                                + " || DOCTOR SPECIALITY: " + appointment.getDoctor_speciality());
                        System.out.println("| APPOINTMENT TIME: " + appointmentDate + " |");
                        System.out.println("-----------------------------------------------");
                    } else {
                        System.out.println("No appointments found for " + dateInput + ".");
                    }
                }
                break; // Exit the loop once processing is complete
            } catch (ParseException e) {
                System.out.println("Error: Please enter the date in the correct format (yyyy-MM-dd).");
            }
        }
    }
}

