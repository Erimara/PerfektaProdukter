package org.example;

import java.time.LocalDate;
import java.util.*;
public class HandleStaff {

    String dateFormatRegex = "\\d{4}-\\d{2}-\\d{2}";
    private List<Worker> workers = new ArrayList<>();
    public List<Intern> interns = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addWorker() {

        System.out.println("Please enter a salary");
        int salary = scanner.nextInt();
        System.out.println("Please enter a start date yyyy-mm-dd");
        String startDate = scanner.next();
        while(!startDate.matches(dateFormatRegex)){
            System.out.println("try again");
            startDate = scanner.next();
        }

        System.out.println("Please enter a name");
        String name = scanner.next();
        System.out.println("Please enter a gender? male/female"); //TODO: WRITE CHECK to ensure they entered MAlE/FEMALE/OTHER
        String gender = scanner.next();
        System.out.println(
                "You have entered the following:\n" +
                        "\nSalary:" + salary +
                        "\nStart date:" + startDate +
                        "\nName:" + name +
                        "\nGender:" + gender  +
                        "\nPress Y to confirm, N to return or E to exit:"
        );
        String confirmation = scanner.next();
        if (Objects.equals(confirmation, "Y".toLowerCase())){

            Worker worker = new Worker(createRandomID(), salary, LocalDate.parse(startDate), name.toUpperCase(), gender.toUpperCase());
            workers.add(worker);
            System.out.println("Worker: " + worker.name + " created");
            RestartProgram.restartProgram();
        }
        if (Objects.equals(confirmation, "N".toLowerCase())){
            addWorker();
        }
        if (Objects.equals(confirmation, "E".toLowerCase())){
            RestartProgram.restartProgram();
        }
    }
    public void addIntern() {
        System.out.println("Please enter a end date yyyy-mm-dd");
        String endDate = scanner.next();
        while(!endDate.matches(dateFormatRegex)){
            System.out.println("try again");
            endDate = scanner.next();
        }
        System.out.println("Please enter a name");
        String name = scanner.next();
            System.out.println("Please enter a gender: Only Male, female or other");
        String gender = scanner.next();
        System.out.println("Write a text about the intern. Leave blank to fill in later");
        String recommendation = scanner.next();
        System.out.println(
                "You have entered the following:\n" +
                        "\nEnd date:" + endDate +
                        "\nName:" + name +
                        "\nGender:" + gender  +
                        "\nRecommendation:" + recommendation  +
                        "\nPress Y to confirm, N to return or E to exit:"
        );
        String confirmation = scanner.next();
        if (Objects.equals(confirmation, "Y".toLowerCase())){
            Intern intern = new Intern(createRandomID(), LocalDate.parse(endDate), name, gender.toUpperCase(), recommendation);
            interns.add(intern);
            System.out.println("Intern: " + intern.name + " created");
            RestartProgram.restartProgram();
        }
        if (Objects.equals(confirmation, "N".toLowerCase())){
            addIntern();
        }
        if (Objects.equals(confirmation, "E".toLowerCase())){
            RestartProgram.restartProgram();
        }
    }

    public String createRandomID() {
      UUID uuid = UUID.randomUUID();
      return uuid.toString();
    }
    public void totalNumOfStaff() {
        int total = workers.size() + interns.size();
            System.out.println( "Total number in the workforce: " +
                    total
            );
        }

    public void sortWorkersByStartDate(){
        Collections.sort(workers);
        for(Worker worker : workers){
            System.out.println("Start Date: " + worker.startDate + "Name: " + worker.name);
        }
    }

    public List<Worker> getWorkers() {
        return workers;
    }
    public List<Intern> getInterns() {
        return interns;
    }
}