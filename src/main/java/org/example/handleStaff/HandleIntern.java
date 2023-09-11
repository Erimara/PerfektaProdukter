package org.example.handleStaff;
import org.example.staff.Intern;
import org.example.lists.ListOfStaff;
import org.example.utility.Utility;

import java.util.List;
import java.util.Scanner;

public class HandleIntern {
    public void updateOrRemoveIntern(List<Intern> internList){
        Scanner scanner = new Scanner(System.in);
        ListOfStaff listOfStaff = new ListOfStaff();
        listOfStaff.getListOfInterns(internList);

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
        handleInternOptions(selectedIntern, internList);
    }
    private void handleInternOptions(Intern selectedIntern, List<Intern> internList){
        Scanner scanner = new Scanner(System.in);
        if (selectedIntern == null){
            System.out.println("ID does not exist");
            Utility.returnToMainMenu();
            return;
        }

        String internName = selectedIntern.name.toUpperCase();
        System.out.println("Selected worker: " + internName + "\n" + """
                1: Update Interns recommendation text
                2: Remove Intern
                0: Exit""");
        int choice = scanner.nextInt();

        if (choice == 0){
            return;
        }
        if (choice == 1){
            Intern.updateRecommendationText(selectedIntern);
            System.out.println("You have updated " + internName + "s" + " recommendation text to " + "'"+ selectedIntern.recommendationText +"'");
            Utility.returnToMainMenu();

        } else if (choice == 2) {
            System.out.println("Are you sure you want to remove " + internName + "? " + " 1: Confirm. 0:Return");
            int confirm = scanner.nextInt();
            if (confirm == 1){
                internList.remove(selectedIntern);
                System.out.println(internName + " removed");
                Utility.returnToMainMenu();
            }
        }
    }
}
