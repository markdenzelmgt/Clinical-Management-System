import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

class TREATMENT {
    Scanner scan_treatment = new Scanner(System.in);
    public ArrayList<TREATMENT> treatmentList = new ArrayList<>();

    private int patient_id;
    private String patient_name;
    private String patient_sickness;
    private String treatment_description;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setTreatment(String treatment_description) {this.treatment_description = treatment_description;}
    public void setPatient_sickness(String patient_sickness) {this.patient_sickness = patient_sickness;}
    public void setPatient_id(int patient_id) {this.patient_id = patient_id;}
    public void setPatient_name(String patient_name) {this.patient_name = patient_name;}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getTreatment() {return treatment_description;}
    public String getPatient_sickness() {return patient_sickness;}
    public int getPatient_id() {return patient_id;}
    public String getPatient_name() {return patient_name;}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void treatmentMenu() {
        while (true) {
            System.out.println(" ");
            System.out.println("=================================================");
            System.out.println("|         WELCOME TO THE TREATMENT MENU         | :");
            System.out.println("=================================================");
            System.out.println("|   1. Add Treatments                           |");
            System.out.println("|   2. Enter Patient's ID to see Treatment      |");
            System.out.println("|   3. View Treatments                          |");
            System.out.println("|-----------------------------------------------|");
            System.out.println("|         Type 'exit' to quit the menu          |");
            System.out.println("=================================================");
            System.out.print("Choose an option (or type 'exit' to quit): ");
            String option = scan_treatment.nextLine();
            System.out.println();
            if (option.equalsIgnoreCase("exit")) {
                System.out.println("Exiting appointment menu...");
                break;
            }
            try {
                int choice = Integer.parseInt(option);
                switch (choice) {
                    case 1: //ADDING THE TREATMENT
                        addingTreatment();
                        break;
                    case 2: //VIEWING THE TREATMENTS
                        displayTreatment();
                        break;

                    case 3: //VIEW ALL TREATMENTS
                        viewTreatments();
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
    public void addingTreatment () {
        System.out.println("========ADDING A TREATMENT========");
        System.out.println("------------------------");
        System.out.println("| List of Appointments | :");
        System.out.println("------------------------");
        if (APPOINTMENT.appointmentList.isEmpty()){
            System.out.println("No Appointments Available");
            return;
        }
        for (APPOINTMENT appointment : APPOINTMENT.appointmentList) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("---------------");
            System.out.println("|PATIENT ID: " + appointment.getPatient_id() + "|");
            System.out.println("---------------");
            System.out.println("| PATIENT NAME: " + appointment.getPatient_name()
                             + "|| PATIENT SICKNESS: " + appointment.getPatient_sickness());
            System.out.println("| DOCTOR NAME: " + appointment.getDoctor_name());
            System.out.println("| APPOINTMENT TIME: " + dateFormat.format(appointment.getDoctor_availability()) + " |");
            System.out.println("-----------------------------------------------");
            appointment.appointmentDate();
        }
        System.out.println("==================================================");
        TREATMENT newTreatment = new TREATMENT();
        System.out.print("Enter Patient's ID: ");
        newTreatment.setPatient_id(scan_treatment.nextInt());
        scan_treatment.nextLine();

        while (true) {
            try {
                System.out.print("Enter the Name of the Patient: ");
                newTreatment.setPatient_name(scan_treatment.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid name.");
            }
        }

            while (true) {
                try {
                    System.out.print("Enter the Sickness of the Patient: ");
                newTreatment.setPatient_sickness(scan_treatment.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid sickness (avoid special characters).");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the Treatment Needed: ");
                newTreatment.setTreatment(scan_treatment.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid sickness (avoid special characters).");
            }
        }

        System.out.println("\n!! Treatment Successfully Added !!");

        treatmentList.add(newTreatment);
    }
    public void displayTreatment() {
        System.out.print("Enter Patient's ID to find their treatment");
        int patient_id = scan_treatment.nextInt();
        scan_treatment.nextLine();

        System.out.println("\n=====SEARCHING FOR TREATMENT=====");
        if (treatmentList.isEmpty()) {
            System.out.println("There are no Treatments entered yet.");
        }
        for(TREATMENT treatment : treatmentList) {
            if(treatment.getPatient_id() == patient_id) {
                System.out.println("-------------------");
                System.out.println("| Treatment Found |");
                System.out.println("-------------------");
                System.out.println("-------------------------------------------------------");
                System.out.println("| PATIENT ID: " + treatment.getPatient_id());
                System.out.println("| PATIENT NAME: " + treatment.getPatient_name()
                                  +"| PATIENT'S SICKNESS: " + treatment.getPatient_sickness());
                System.out.println("| TREATMENTS NEEDED: " + treatment.getTreatment());
                System.out.println("-------------------------------------------------------");
                return;
            }
            System.out.println("Patient with ID " + patient_id + " not found.");
        }
    }
    public void viewTreatments () {
        System.out.println("----------------------");
        System.out.println("| List of Treatments | :");
        System.out.println("----------------------");
        if (treatmentList.isEmpty()){
            System.out.println("There are no Treatments entered yet");
        }
        for (TREATMENT treatment : treatmentList) {
            System.out.println("----------------");
            System.out.println("| PATIENT ID: " + treatment.getPatient_id() + "|");
            System.out.println("----------------");
            System.out.println("| PATIENT NAME: " + treatment.getPatient_name()
                              +"| PATIENT'S SICKNESS: " + treatment.getPatient_sickness()
                              +"| TREATMENTS NEEDED: " + treatment.getTreatment() + " |");
            System.out.println("-------------------------------------------------------");

        }
    }
}