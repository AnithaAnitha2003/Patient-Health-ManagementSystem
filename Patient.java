import java.util.ArrayList;
import java.util.Scanner;

// Base class: Person
class Person {
    private String name;
    private int age;
    private String gender;

    public void setPersonDetails(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void printPersonDetails() {
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Gender : " + gender);
    }
}

// Derived class: Patient
class Patient extends Person {
    private int patientId;
    private String diagnosis;
    private String prescription;

    public void setPatientDetails(int patientId, String diagnosis, String prescription) {
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public int getPatientId() {
        return patientId;
    }

    // Method overriding (Polymorphism)
    public void printPatientRecord() {
        System.out.println("\n===== Patient Health Record =====");
        System.out.println("Patient ID : " + patientId);
        printPersonDetails();
        System.out.println("Diagnosis  : " + diagnosis);
        System.out.println("Prescription: " + prescription);
        System.out.println("=================================\n");
    }
}

// Main Class
public class PatientSystemApp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        int choice;
        do {
            System.out.println("===== Patient Health Record System =====");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scn.nextInt();
            scn.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    Patient p = new Patient();

                    System.out.print("Enter Patient ID: ");
                    int id = scn.nextInt();
                    scn.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scn.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scn.nextInt();
                    scn.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = scn.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scn.nextLine();

                    System.out.print("Enter Prescription: ");
                    String prescription = scn.nextLine();

                    p.setPersonDetails(name, age, gender);
                    p.setPatientDetails(id, diagnosis, prescription);
                    patients.add(p);

                    System.out.println("✅ Patient record added successfully!\n");
                    break;

                case 2:
                    if (patients.isEmpty()) {
                        System.out.println("⚠️ No patient records found.\n");
                    } else {
                        for (Patient pat : patients) {
                            pat.printPatientRecord();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scn.nextInt();
                    boolean found = false;

                    for (Patient pat : patients) {
                        if (pat.getPatientId() == searchId) {
                            pat.printPatientRecord();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ No patient found with ID " + searchId + "\n");
                    }
                    break;

                case 4:
                    System.out.println("👋 Exiting... Stay healthy!");
                    break;

                default:
                    System.out.println("❗ Invalid choice. Try again.\n");
            }
        } while (choice != 4);

        scn.close();
    }
}
