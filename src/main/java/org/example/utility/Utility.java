package org.example.utility;

import org.example.staff.Intern;
import org.example.staff.Worker;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Utility {
    public void totalNumOfStaff(List<Worker> workers, List<Intern> interns) {
        int total = workers.size() + interns.size();
        System.out.println( "The total number of people currently employed at the company : " +
                total
        );
    }
    public void sortWorkersByStartDate(List<Worker> workers){
        Collections.sort(workers);
        for(Worker worker : workers){
            System.out.println("Start Date: " + worker.startDate + "Name: " + worker.name);
        }
    }

    public String createRandomID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public String checkIfValidDate(String startDate){
         String dateFormat = "\\d{4}-\\d{2}-\\d{2}";
         String checkDate = "((?:19|20)[0-9][0-9])-((?:0[1-9]|1[0-2]))-((?:0[1-9]|[12][0-9]|3[01]))";
        Scanner scanner = new Scanner(System.in);
        while(!startDate.matches(dateFormat) || !startDate.matches(checkDate)){
            System.out.println("Invalid date, try again");
            startDate = scanner.next();
        }
        return startDate;
    }
    public static void returnToMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To return to the main menu, press 'c' ");
        scanner.nextLine();
    }
}
