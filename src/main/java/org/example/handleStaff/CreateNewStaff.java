package org.example.handleStaff;

import org.example.utility.Utility;

import java.util.Scanner;

public class CreateNewStaff implements CreateStaff {
    @Override
    public String getDate(int opt){
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
    @Override
    public String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name");
        return scanner.nextLine();
    }
    @Override
    public String getGender(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a gender: Only Male, female or other");
        return scanner.next();
    }
    @Override
    public String getRecommendationText(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a recommendation about the intern. Press '-' to fill in later");
        return scanner.next();
    }

    @Override
    public int getSalary(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a salary");
        return scanner.nextInt();
    }
}
