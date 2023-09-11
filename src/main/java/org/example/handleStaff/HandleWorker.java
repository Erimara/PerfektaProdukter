package org.example.handleStaff;

import org.example.lists.ListOfStaff;
import org.example.staff.Worker;
import org.example.utility.Utility;

import java.util.List;
import java.util.Scanner;

public class HandleWorker {
    public void updateOrRemoveWorker(List<Worker> workerList) {
        Scanner scanner = new Scanner(System.in);
        ListOfStaff listOfStaff = new ListOfStaff();
        listOfStaff.getListOfWorkers(workerList);

        if (workerList.isEmpty()) {
            System.out.println("There are currently no workers");
            return;
        }

        System.out.println("Enter or copy and paste the id of the person you want to edit or remove");
        String enteredId = scanner.next().trim();

        Worker selectedWorker = null;

        for (Worker worker : workerList) {
            if (enteredId.equals(worker.id)) {
                selectedWorker = worker;
                break;
            }
        }
        handleWorkerOptions(selectedWorker, workerList);
    }

    public void handleWorkerOptions(Worker selectedWorker, List<Worker> workerList){
        Scanner scanner = new Scanner(System.in);
        if (selectedWorker == null) {
            System.out.println("ID does not exist");
            Utility.returnToMainMenu();
            return;
        }

        String workerName = selectedWorker.name.toUpperCase();
        System.out.println("Selected worker: " + workerName + "\n" + """
            1: Update salary
            2: Remove worker
            0: Exit""");

        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        }
        if (choice == 1) {
            Worker.updateSalary(selectedWorker);
            System.out.println("You have updated " + workerName + "s " + " salary to " + selectedWorker.salary + "€");
            Utility.returnToMainMenu();
        } else if (choice == 2) {
            System.out.println("Are you sure you want to remove " + workerName + "? " + " 1: Confirm. 0: Return");
            int confirm = scanner.nextInt();

            if (confirm == 1) {
                workerList.remove(selectedWorker);
                System.out.println(workerName + " removed");
                Utility.returnToMainMenu();
            }
        }
    }
}
