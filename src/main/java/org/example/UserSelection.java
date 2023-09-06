package org.example;

import java.util.Scanner;
public class UserSelection {

    static HandleStaff handleStaff = new HandleStaff();
    static Scanner scanner = new Scanner(System.in);
    public static void userSelection() {
        while (true) {
            System.out.println("Welcome, what would you like to do today?");
            System.out.println("""
                    1: Add staff
                    2: Update Staff
                    3: Show list of staff, sorted by date
                    4: Show whole workforce
                    5: Show median wage for women and men
                    6: Show list of both workers and interns. With all properties""");
            System.out.println("Enter your choice. Press 0 to exit ");
            int choice = scanner.nextInt();
            if(choice == 0){
                break;
            }
            switch (choice) {
                case 1 -> addStaffChoices();

                case 2 -> {
                    updateStaffChoices();
                }
                case 3 -> {
                    handleStaff.sortWorkersByStartDate();
                    RestartProgram.restartProgram();
                }
                case 4 -> {
                    handleStaff.totalNumOfStaff();
                    RestartProgram.restartProgram();
                }
                case 5 -> {
                    medianWageChoices();
                }
                case 6 -> {
                    System.out.println("Interns: ");
                    Intern.getInternList(handleStaff.getInterns());

                    System.out.println("Workers: ");
                    Worker.getWorkerList(handleStaff.getWorkers());
                }

                default -> System.out.println("Invalid choice");
            }

        }
    }
    public static void updateStaffChoices(){
        System.out.println("Update/remove an intern or a worker");
        System.out.println("1: List of Worker\n2: List of Intern");
        int staffChoice = scanner.nextInt();
        if (staffChoice == 1) {
            Worker.updateOrRemoveWorker(handleStaff.getWorkers());
        } else if (staffChoice == 2) {
            Intern.updateOrRemoveIntern(handleStaff.getInterns());
        }
    }
    public static void addStaffChoices() {
        System.out.println("Add an intern or a worker");
        System.out.println("1: Worker\n2: Intern");
        int staffChoice = scanner.nextInt();
        if (staffChoice == 1) {
            handleStaff.addWorker();
        } else if (staffChoice == 2) {
            handleStaff.addIntern();
        }
    }
    public static void medianWageChoices(){
        System.out.println("1: Male\n2: Female");
        int maleOrFemale = scanner.nextInt();
        if (maleOrFemale == 1) {
            int averageMaleSalary = Worker.getAverageSalaryForMen(handleStaff.getWorkers());
            System.out.println("Average salary for men " + averageMaleSalary);
            RestartProgram.restartProgram();
        } else if (maleOrFemale == 2) {
            int averageFemaleSalary = Worker.getAverageSalaryForWomen(handleStaff.getWorkers());
            System.out.println("Average salary for women " + averageFemaleSalary);
            RestartProgram.restartProgram();
        }
    }
}
