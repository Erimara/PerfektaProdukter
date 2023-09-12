package org.example.handleStaff;
import org.example.staff.Intern;
import org.example.utility.Utility;
import org.example.staff.Worker;
import java.time.LocalDate;
import java.util.*;
public class AddStaff {
    private final List<Worker> workers = new ArrayList<>();
    private final List<Intern> interns = new ArrayList<>();
    public void addWorker() {
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();
        CreateNewStaff createNewStaff = new CreateNewStaff();
        String name = createNewStaff.getName();
        String startDate = createNewStaff.getDate(1);
        String gender = createNewStaff.getGender();
        int salary = createNewStaff.getSalary();
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
        resetOrExit(confirmation,1);
    }
    public void addIntern() {
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();
        CreateNewStaff createNewStaff = new CreateNewStaff();

        String name = createNewStaff.getName();
        String endDate = createNewStaff.getDate(2);
        String gender = createNewStaff.getGender();
        String recommendationText = createNewStaff.getRecommendationText();
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
        resetOrExit(confirmation, 2);
    }
    private void resetOrExit(String confirmation, int opt){
        if (Objects.equals(confirmation, "R".toLowerCase())){
            if(opt == 1){
                addWorker();
            } else if (opt == 2) {
                addIntern();
            }
        }
        if (Objects.equals(confirmation, "E".toLowerCase())){
            Utility.returnToMainMenu();
        }
    }
    public void AddWorkerOrInternOption(){
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
    public void updateOrRemoveOption(){
        Scanner scanner = new Scanner(System.in);
        HandleWorker handleWorker = new HandleWorker();
        HandleIntern handleIntern = new HandleIntern();
        System.out.println("Update/remove an intern or a worker");
        System.out.println("1: List of Worker\n2: List of Intern");
        int staffChoice = scanner.nextInt();
        if (staffChoice == 1) {
            handleWorker.updateOrRemoveWorker(getWorkers());
        } else if (staffChoice == 2) {
            handleIntern.updateOrRemoveIntern(getInterns());
        }
    }
    public List<Worker> getWorkers() {
        return workers;
    }
    public List<Intern> getInterns() {
        return interns;
    }
}