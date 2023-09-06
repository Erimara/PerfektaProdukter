package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Intern extends Staff{
    public LocalDate endDate;
private String recommendationText;
public Intern(String id,LocalDate endDate,String name, String gender, String recommendationText) {
      super(id, name, gender);
        this.endDate = endDate;
        this.recommendationText = recommendationText;
    }
    static Scanner scanner = new Scanner(System.in);
    public static void updateOrRemoveIntern(List<Intern> internList){
        getInternList(internList);

        for (int i = 0; i < internList.size(); i++) {
            Intern intern = internList.get(i);
            System.out.println("""
                    1:Update the recommendation text?
                     2:Remove an intern
                    0: Exit""");
            int choice = scanner.nextInt();
            if (choice == 0){
                break;
            }
            if (choice == 1){
                System.out.println("Copy the id of or press 0 to cancel:");
                String internId = scanner.next();
                if(Objects.equals(internId, intern.id)){
                    System.out.println("Please press 1 to confirm that you want to update: " + intern.name+"\n" +
                            "Press 0 to cancel");
                    int confirm = scanner.nextInt();

                    if (confirm == 0){
                        break;
                    }
                    else if (confirm == 1) {
                        continue;
                    }
                    Intern.updateRecommendationText(intern);
                } else {
                    System.out.println("Name does not exist");
                    RestartProgram.restartProgram();
                }
            } else if (choice == 2){
                System.out.println("Copy the id of or press 0 to cancel:");
                String internID = scanner.next();

                if(Objects.equals(internID, intern.id)){
                    System.out.println("Please press 1 to confirm that you want to remove: " + intern.name+"\n" +
                            "Press 0 to cancel");
                    int confirm = scanner.nextInt();

                    if (confirm == 0){
                        break;
                    }
                    else if (confirm == 1) {
                        continue;
                    }

                    internList.remove(intern);
                    i--;
                    System.out.println("Name: " + intern.name + " removed " + " Press 0 to exit");
                    scanner.nextInt();
                    RestartProgram.restartProgram();
                } else {
                    System.out.println("Name does not exist");
                    RestartProgram.restartProgram();
                }
            }
            }
        }
    public static void getInternList(List<Intern> internList) {
        for (Intern intern : internList) {
            System.out.println(" ID: " + intern.id + " Name: " + intern.name +
                    " Text: " + intern.recommendationText +
                    " End date: " + intern.endDate +
                    " Gender: " + intern.gender);
        }
    }
    public static void updateRecommendationText(Intern intern){
        scanner.nextLine();
        System.out.println("Write your text: ");
        String recommendationText = scanner.nextLine();
        intern.setRecommendationText(recommendationText);
        System.out.println("Text updated : " + intern.recommendationText);
    }

    public void setRecommendationText(String recommendationText) {
        this.recommendationText = recommendationText;
    }
}
