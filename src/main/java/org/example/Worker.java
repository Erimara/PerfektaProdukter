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
    public static void updateOrRemoveWorker(List<Worker> workerList) {
        getWorkerList(workerList);

        if (workerList.isEmpty()) {
            System.out.println("No persons in the system. Returning");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the person you want to edit or remove:");
        String enteredId = scanner.next().trim();

        Worker selectedWorker = null;

        for (Worker worker : workerList) {
            if (enteredId.equals(worker.id)) {
                selectedWorker = worker;
                break;
            }
        }

        if (selectedWorker == null) {
            System.out.println("ID does not exist");
            RestartProgram.restartProgram();
            return;
        }

        System.out.println("""
            1: Update a worker's salary
            2: Remove a worker
            0: Exit""");

        int choice = scanner.nextInt();

        if (choice == 0) {
            return;
        }

        if (choice == 1) {
            System.out.println("Update salary for " + selectedWorker.name + "?");
            Worker.updateSalary(selectedWorker);
        } else if (choice == 2) {
            System.out.println("Are you sure you want to remove " + selectedWorker.name + "? (1 to confirm, 0 to cancel)");
            int confirm = scanner.nextInt();

            if (confirm == 1) {
                workerList.remove(selectedWorker);
                System.out.println(selectedWorker.name + " removed");
            }
        }

    }
    public static void updateSalary(Worker worker){
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
