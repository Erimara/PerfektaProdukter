package org.example.handleStaff;

import org.example.staff.Intern;
import org.example.utility.Utility;
import org.example.staff.Worker;

import java.time.LocalDate;
import java.util.*;
public class AddStaff {
    private final List<Worker> workers = new ArrayList<>();
    private final List<Intern> interns = new ArrayList<>();
    private void addWorker() {
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();

        String name = getName();
        String startDate = getDate(1);
        String gender = getGender();
        int salary = getSalary();
        System.out.println(
                "You have entered the following:\n" +
                        "\nName:" + name.toUpperCase() +
                        "\nGender:" + gender.toUpperCase() +
                        "\nStart Date:" + startDate +
                        "\nSalary:" + salary  + "€" +
                        "\nPress Y to confirm, R to restart or E to to exit to main menu:"
        );
        String confirmation = scanner.next();
        if (Objects.equals(confirmation, "Y".toLowerCase())){

            Worker worker = new Worker(utility.createRandomID(), salary, LocalDate.parse(startDate), name.toUpperCase(), gender.toUpperCase());
            workers.add(worker);
            System.out.println("Worker: " + worker.name + " created");
            Utility.returnToMainMenu();
        }
        if (Objects.equals(confirmation, "R".toLowerCase())){
            addWorker();
        }
        if (Objects.equals(confirmation, "E".toLowerCase())){
            Utility.returnToMainMenu();
        }
    }
    private void addIntern() {
        Scanner scanner = new Scanner(System.in);

        Utility utility = new Utility();
        String name = getName();
        String endDate = getDate(2);
        String gender = getGender();
        String recommendationText = getRecommendationText();
        System.out.println(
                "You have entered the following:\n" +
                        "\nName:" + name.toUpperCase() +
                        "\ngender:" + gender.toUpperCase() +
                        "\nEnd Date:" + endDate  +
                        "\nRecommendation:" + recommendationText +
                        "\nPress Y to confirm, R to restart or E to to exit to main menu:"
        );

        String confirmation = scanner.next();
        if (Objects.equals(confirmation, "Y".toLowerCase())){
            Intern intern = new Intern(utility.createRandomID(),LocalDate.parse(endDate), name.toUpperCase(), gender.toUpperCase(), recommendationText);
            interns.add(intern);
            System.out.println("Intern: " + intern.name + " created");
            Utility.returnToMainMenu();
        }
        if (Objects.equals(confirmation, "R".toLowerCase())){
            addIntern();
        }
        if (Objects.equals(confirmation, "E".toLowerCase())){
            Utility.returnToMainMenu();
        }
    }
    private String getDate(int opt){
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();
        if (opt == 1){
            System.out.println("Please enter a start date yyyy-mm-dd");

        } else if (opt == 2){
            System.out.println("Please enter a end date yyyy-mm-dd");
        }
        String date = scanner.next();
        date = utility.checkIfValidDate(date);
        return date;
    }
    private String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name");
        return scanner.nextLine();
    }
    private String getGender(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a gender: Only Male, female or other");
      return scanner.next();
    }
    private String getRecommendationText(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a recommendation about the intern. Press '-' to fill in later");
        return scanner.next();
    }
    private int getSalary(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a salary");
        return scanner.nextInt();
    }
    public List<Worker> getWorkers() {
        return workers;
    }
    public List<Intern> getInterns() {
        return interns;
    }
    public void selectWorkerOrIntern(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add an intern or a worker");
        System.out.println("1: Worker\n2: Intern");
        int staffChoice = scanner.nextInt();
        if (staffChoice == 1) {
            addWorker();
        } else if (staffChoice == 2) {
            addIntern();
        }
    }
}