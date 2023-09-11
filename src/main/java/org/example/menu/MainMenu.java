package org.example.menu;

import org.example.lists.ListOfStaff;
import org.example.staff.Worker;
import org.example.handleStaff.AddStaff;
import org.example.handleStaff.HandleIntern;
import org.example.handleStaff.HandleWorker;
import org.example.utility.Utility;

import java.util.Scanner;
public class MainMenu {
    static AddStaff addStaff = new AddStaff();
    public void userSelection() {
        Scanner scanner = new Scanner(System.in);
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
            MainMenu mainMenu = new MainMenu();
            switch (choice) {
                case 1 -> addStaff.selectWorkerOrIntern();

                case 2 ->  mainMenu.updateStaffChoices();

                case 3 -> {
                    Utility utility = new Utility();
                    utility.sortWorkersByStartDate(addStaff.getWorkers());
                    Utility.returnToMainMenu();
                }
                case 4 -> {
                    Utility utility = new Utility();
                    utility.totalNumOfStaff(addStaff.getWorkers(), addStaff.getInterns());
                    Utility.returnToMainMenu();
                }
                case 5 -> {
                    int averageSalary = Worker.getAverageSalary(addStaff.getWorkers());
                    System.out.println("Average salary: " + averageSalary + "€");
                    Utility.returnToMainMenu();
                }

                case 6 -> {
                    ListOfStaff listOfStaff = new ListOfStaff();
                    System.out.println("Interns: ");
                    listOfStaff.getListOfInterns(addStaff.getInterns());
                    System.out.println("Workers: ");
                    listOfStaff.getListOfWorkers(addStaff.getWorkers());
                    Utility.returnToMainMenu();
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
    public void updateStaffChoices(){
        Scanner scanner = new Scanner(System.in);
        HandleWorker handleWorker = new HandleWorker();
        HandleIntern handleIntern = new HandleIntern();
        System.out.println("Update/remove an intern or a worker");
        System.out.println("1: List of Worker\n2: List of Intern");
        int staffChoice = scanner.nextInt();
        if (staffChoice == 1) {
            handleWorker.updateOrRemoveWorker(addStaff.getWorkers());
        } else if (staffChoice == 2) {
            handleIntern.updateOrRemoveIntern(addStaff.getInterns());
        }
    }
}
