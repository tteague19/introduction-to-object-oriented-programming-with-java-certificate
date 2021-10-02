// This is a class representing the vet clinic.

// Variables
// File patientFile
// File with patient information
//
// int day
//
// Constructors
// Clinic(File file)
// File that contains patient info - assign to patientFile
// Name
// Type of pet (includes pet info)
// Appointment Info
// timeIn(military time)
// health(before Treatment)
// painLevel(before Treatment)
// TimeOut(military time)
// TimeOut(military time)
// Day initialized to 1
//
// Clinic(String fileName)
// String includes filename extension – don't add “.csv”
// Chains to the other constructor
//
// Methods
// String nextDay(File f) throws FileNotFoundException
//
// String nextDay(String fileName) throws FileNotFoundException
// Reads File f that contains the name, type of pet, and time of the
//  appointments for the day
// See example file “Appointments.csv” for the format
// Eg: If there was a Cat Chloe, with a miceCaught count of 5,
// scheduled for 2:30 pm, Chloe’s information in Appointments.csv
// would look like: Chloe,Cat,5,1430
// You will have one file for each different day
// Use a Scanner object to take in user input
// Print “Consultation for [name] the [typeOfPet] at [time].\nWhat is the health of [name]?\n”
// If typeOfPet is not valid (i.e. not a Dog or Cat, case-sensitive)
// throw InvalidPetException
// Do not catch the exception in your code! The caller of the method
// should handle the exception.
// Take in user input for health
// If input is not a number, continue prompting user until they
// provide a number
// Print “On a scale of 1 to 10, how much pain is [name] in right now?\n”
// Take in user input for painLevel
// If input is not a number, continue prompting user until they
// provide a number
// Call speak()
// Treat pet
// Calculate time out (there exists a method for this)
// Note: Don’t try to read the file and write to it at the same time –
// this method is intended only to read the file.
// Don’t forget the increment the day!
// Returns a String with patient information to be used when treating
// patients and updating the file.
// The string being returned should hold the updated information for
// all patients seen in the day separated by a newline character.
// Each appointment should be formatted as follows:
// [Name],[Species],[DroolRate/MiceCaught],[Day],[EntryTime],[ExitTime],[InitialHealth],[InitialPainLevel]
// E.x.: If there are 2 appointments on day 2:
// Appointment 1 on Day 2:
// Dog Dobie with droolRate 2.7
// Entry time: 1715 (5:15 pm) and Exit time: 1735 (5:35 pm)
// Health was 0.5 and painLevel was 5 before treating
// Appointment 2 on Day 2:
// Cat Marlin with miceCaught 84
// Entry time: 1655 (4:55 pm) and Exit time: 1700 (5:00 pm)
// Health was 0.4 and painLevel was 4 before treating
// The output of nextDay would be:
// Dobie,Dog,2.7,Day 2,1715,1735,0.5,5
// Marlin,Cat,84,Day 2,1655, 1700,0.4,4

// boolean addToFile(String patientInfo)
// Consumes a string representing a single appointment
// Eg. In format:
// [Name],[Species],[DroolRate/MiceCaught],[Day],[EntryTime],[ExitTime],[InitialHealth],[InitialPainLevel]
// Write info to patientFile
// If old patient, only the appointment info should be added to the
// patient file, which includes:
// Day #
// Time in and time out
// Health and pain
// If new patient, all info should be added to the clinic’s patient
// file
// Assume the vet will never see two different pets with the same name
// See Patients.csv for an example
// Returns true if the appointment info was successfully written, and
// false if an error occurs or a checked exception is caught
// Note (cont’d): Don’t try to read the file and write to it at the
// same time – this method is intended to rewrite the file.
//
// String addTime(String timeIn, int treatmentTime)
// This method should only be accessible in the Clinic class
// This method should calculate the time the patient’s appointment
// ends
// Return timeOut
// Remember: timeIn and timeOut should be represented in military time
// You can assume that timeIn and timeOut will NOT go across multiple
// days (ex. timeIn = “23:30” and timeOut = “00:30”)
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clinic {
    private File patientFile;
    private int day = 1;

    public Clinic(File file) {
        this.patientFile = file;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    String nextDay(File f) throws FileNotFoundException {
        Scanner fileScan = null;
        Scanner lineScan = null;
        Scanner input = new Scanner(System.in);
        String outputString = "";

        fileScan = new Scanner(f);
        String line = "";

        while (fileScan.hasNextLine()) {

                line = fileScan.nextLine();
                lineScan = new Scanner(line);
                lineScan.useDelimiter(",");
                String name = lineScan.next();
                String typeOfPet = lineScan.next();

                // This value is either a miceCaught for a Cat or a
                // droolRate for a Dog.
                double value = lineScan.nextDouble();
                String timeIn = lineScan.next();
                Pet currentPet;

                boolean isValidHealth = false;
                double health = 0.0;
                while (!isValidHealth) {
                    try {
                        System.out.print("Consultation for " + name + " the "
                                            + typeOfPet + " at " + timeIn
                                            + "\nWhat is the health of "
                                            + name + "?\n");
                        health = input.nextDouble();
                        isValidHealth = true;
                        }
                    catch(InputMismatchException e) {}
                    finally {
                        // We clear the input buffer.
                        input.nextLine();
                    }
                }

                boolean isValidPainLevel = false;
                int painLevel = 1;
                while (!isValidPainLevel) {
                    try {
                        System.out.print("On a scale of 1 to 10, how much pain is "
                                            + name + " in right now?\n");
                        painLevel = input.nextInt();
                        isValidPainLevel = true;
                        }
                    catch(InputMismatchException e) {}
                    finally {
                        // We clear the input buffer.
                        input.nextLine();
                    }
                }

                if (!(typeOfPet.equals("Dog") || typeOfPet.equals("Cat"))) {
                    throw new InvalidPetException();
                }

                // At this stage, we are guarunteed to have either a
                // Cat or a Dog.
                if (typeOfPet.equals("Cat")) {
                    currentPet = new Cat(name, health, painLevel, (int) value);
                }
                else {
                    currentPet = new Dog(name, health, painLevel, value);
                }

                currentPet.speak();
                int treatmentTime = currentPet.treat();
                outputString = outputString + currentPet.getName() + ","
                                + typeOfPet + ","
                                + (typeOfPet.equals("Cat")
                                    ? ((Cat) currentPet).getMiceCaught()
                                    : ((Dog) currentPet).getDroolRate()) + ","
                                + "Day " + this.day + ","
                                + timeIn + ","
                                + this.addTime(timeIn, treatmentTime) + ","
                                + health + ","
                                + painLevel + "\n";

            }

        if (fileScan != null) {
            fileScan.close();
        }
        if (lineScan != null) {
            lineScan.close();
        }

        this.day++;

        return outputString;
    }

    String nextDay(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        return this.nextDay(f);
    }

    public boolean addToFile(String patientInfo) {
        boolean isOldPatient = false;
        boolean successfulWrite = false;
        Scanner fileScan = null;
        Scanner lineScan = null;
        String outputString = "";

        Scanner inputScan = new Scanner(patientInfo);
        inputScan.useDelimiter(",");
        String patientName = inputScan.next();

        try {
            fileScan = new Scanner(this.patientFile);
            while(fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                lineScan = new Scanner(line);
                lineScan.useDelimiter(",");
                String lineName = lineScan.next();

                // TODO Fix the following. I think it works now.
                if (lineName.equals(patientName)) {
                    // We discard the species and drool rate / number
                    // of mice caught.
                    inputScan.next();
                    inputScan.next();
                    // We add the day, entry time, exit time, initial
                    // health, and initial pain level.
                    outputString = outputString + line + ","
                                    + inputScan.next() + ","
                                    + inputScan.next() + ","
                                    + inputScan.next() + ","
                                    + inputScan.next() + ","
                                    + inputScan.next() + "\n";
                    isOldPatient = true;
                }
                else {
                    outputString = outputString + line + "\n";
                }
            }
            if (!isOldPatient) {
                outputString = outputString + patientInfo + "\n";
            }
        }
        catch (FileNotFoundException e) {}
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
            if (lineScan != null) {
                lineScan.close();
            }
            if (inputScan != null) {
                inputScan.close();
            }
        }


        PrintWriter filePrint = null;
        try {
            filePrint = new PrintWriter(this.patientFile);
            filePrint.print(outputString);
            successfulWrite = true;
        }
        catch (FileNotFoundException e) {}
        finally {
            if (filePrint != null) {
                filePrint.close();
            }
        }

        return successfulWrite;
    }

    protected String addTime(String timeIn, int treatmentTime) {
        int timeInInt = Integer.valueOf(timeIn);
        int timeInHours = timeInInt / 100;
        int timeInMinutes = timeInInt % 100;
        int timeOutMinutes = timeInMinutes + treatmentTime;

        int hoursToAdd = 0;
        int minutesInHour = 60;
        while ((timeOutMinutes - minutesInHour) >= 0) {
            timeOutMinutes = timeOutMinutes - minutesInHour;
            hoursToAdd = hoursToAdd + 1;
        }
        int timeOutHours = timeInHours + hoursToAdd;

        String outputString = null;
        // We zero-pad the output.
        if (timeOutHours < 10) {
            outputString = "0" + Integer.toString(timeOutHours)
                            + Integer.toString(timeOutMinutes);
        }
        else {
            outputString = Integer.toString(timeOutHours)
                            + Integer.toString(timeOutMinutes);
        }

        return outputString;
    }
}
