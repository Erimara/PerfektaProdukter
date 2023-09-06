package org.example;

import java.time.LocalDate;
import java.util.List;
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

        if (internList.isEmpty()){
            System.out.println("There are currently no interns");
            return;
        }
        System.out.println("Enter or copy and paste the id of the person you want to edit or remove");
        String enteredID = scanner.next().trim();

        Intern selectedIntern = null;

        for (Intern intern : internList){
            if (enteredID.equals(intern.id)){
                selectedIntern = intern;
                break;
            }
        }

        if (selectedIntern == null){
            System.out.println("ID does not exist");
           // RestartProgram.restartProgram();
            return;
        }
        System.out.println("""
                1:Update Interns recommendation text
                2: Remove Intern
                0: Exit""");
        int choice = scanner.nextInt();

        if (choice == 0){
            return;
        }

        if (choice == 1){
            Intern.updateRecommendationText(selectedIntern);
            System.out.println("You have updated" + selectedIntern.name + "s" + " recommendation text to" + selectedIntern.recommendationText);

        } else if (choice == 2) {
            System.out.println("Are you sure you want to remove" + selectedIntern.name + "?" + "1: Confirm. 0:Return");
            int confirm = scanner.nextInt();
            if (confirm == 1){
                internList.remove(selectedIntern);
                System.out.println(selectedIntern.name + " removed");
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
