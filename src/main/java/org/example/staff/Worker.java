package org.example.staff;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Worker extends Staff implements Comparable<Worker>{
    public int salary;
    public LocalDate startDate;
    public Worker(String id,int salary, LocalDate startDate,String name, String gender) {
        super(id, name, gender);
        this.salary = salary;
        this.startDate = startDate;
    }
    public static int getAverageSalary(List<Worker> workers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Male\n2: Female");
        int maleOrFemale = scanner.nextInt();

        int totalSalaryForWomen = 0;
        int totalSalaryForMen = 0;
        int men = 0;
        int women = 0;
        for (Worker worker : workers) {

            if (maleOrFemale == 1){
                if ("MALE".equals(worker.gender)) {
                    totalSalaryForMen += worker.salary;
                    men++;
                }
            }

            if (maleOrFemale == 2){
                if ("FEMALE".equals(worker.gender)) {
                    totalSalaryForWomen += worker.salary;
                    women++;
                }
            }
        }
        if(men > 0){
            return totalSalaryForMen / men;
        }
        if(women > 0){
            return totalSalaryForWomen / women;
        }
        return totalSalaryForMen + totalSalaryForWomen;
    }
    public static void updateSalary(Worker worker){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Worker: " + worker.name  + " Current salary " + worker.salary + "\n" +
                "Please write a new salary");
        int newSalary = scanner.nextInt();

        worker.setSalary(newSalary);
        System.out.println("Salary updated : " + worker.salary + " for " + worker.name);
    }
    private void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public int compareTo(Worker date) {
        return this.startDate.compareTo(date.startDate);
    }

}
