package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Worker extends Staff implements Comparable<Worker>{
    public int salary;
public LocalDate startDate;
    public Worker(String id,int salary, LocalDate startDate,String name, String gender) {
        super(id, name, gender);
        this.salary = salary;
        this.startDate = startDate;
    }

    public static int getAverageSalaryForMen(List<Worker> workers) {
        int totalSalary = 0;
        int maleHolder = 0;
        for (Worker worker : workers) {
            if ("MALE".equals(worker.gender)) {
                totalSalary += worker.salary;
                maleHolder++;
            }
        }
        if(maleHolder > 0){
            return totalSalary / maleHolder;
        }
        return totalSalary;
    }
    public static int getAverageSalaryForWomen(List<Worker> workers) {
        int totalSalary = 0;
        int femaleHolder = 0;
        for (Worker worker : workers) {
            if ("FEMALE".equals(worker.gender)) {
                totalSalary += worker.salary;
                femaleHolder++;
            }
        }
        if(femaleHolder > 0){
            return totalSalary / femaleHolder;
        }

        return totalSalary;
    }

    public static void getWorkerList(List<Worker> workerList){
        for (Worker worker : workerList) {
            System.out.println(" ID: " + worker.id + " Name: " + worker.name +
                    " Salary: " + worker.salary +
                    " Start date: " + worker.startDate +
                    " Gender: " + worker.gender);

        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static void updateOrRemoveWorker(List<Worker> workerList){
        getWorkerList(workerList);

        if (workerList.isEmpty()){
            System.out.println("No persons in the system. Returning");
        }
        for (int i = 0; i < workerList.size(); i++) {
            Worker worker = workerList.get(i);
            System.out.println("""
                    1:Update a workers salary\s
                     2:Remove a worker
                    0: Exit""");
            int choice = scanner.nextInt();
            if (choice == 0){
                break;
            }
            if (choice == 1){
                System.out.println("Copy the id of the person you would like to edit\n" +
                        " Press 0 to cancel");
                String internId = scanner.next();

                if(Objects.equals(internId, worker.id)){
                    System.out.println("Please press 1 to confirm that you want to update the salary for: " + worker.name+"\n" +
                            "Press 0 to cancel");
                    int confirm = scanner.nextInt();

                    if (confirm == 0){
                        break;
                    }
                    else if (confirm == 1) {
                        continue;
                    }
                    Worker.updateSalary(worker);
                } else {
                    System.out.println("Name does not exist");
                    RestartProgram.restartProgram();
                }
            } else if (choice == 2){
                System.out.println("Copy the id of the person you would like to remove\n" +
                        " Press 0 to cancel");
                String internID = scanner.next();

                if(Objects.equals(internID, worker.id)){
                    System.out.println("Please press 1 to confirm that you want to remove: " + worker.name+"\n" +
                            "Press 0 to cancel");
                    int confirm = scanner.nextInt();

                    if (confirm == 0){
                        break;
                    }
                    else if (confirm == 1) {
                        continue;
                    }
                    workerList.remove(worker);
                    i--;

                    System.out.println("Name: " + worker.name + " removed " + " Press 0 to exit");
                    scanner.nextInt();

                    RestartProgram.restartProgram();
                } else {
                    System.out.println("ID does not exist");
                    RestartProgram.restartProgram();
                }
            }
        }
    }
    public static void updateSalary(Worker worker){
        scanner.nextLine();
        System.out.println("Current salary: " + worker.salary + " Write a new salary: ");
        int newSalary = scanner.nextInt();

        worker.setSalary(newSalary);
        System.out.println("Salary updated : " + worker.salary + " for " + worker.name);
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public int compareTo(Worker date) {
        return this.startDate.compareTo(date.startDate);
    }
}
