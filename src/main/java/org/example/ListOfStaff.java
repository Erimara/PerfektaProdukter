package org.example;

import java.util.List;

public class ListOfStaff {
    public void getListOfWorkers(List<Worker> workerList) {
        for (Worker worker : workerList) {
            System.out.println(" ID: " + worker.id + " NAME: " + worker.name + "," +
                    " SALARY: " + worker.salary + "," +
                    " START DATE: " + worker.startDate + "," +
                    " GENDER: " + worker.gender);

        }
    };
    public void getListOfInterns(List<Intern> internList) {
        for (Intern intern : internList) {
            System.out.println(" ID: " + intern.id + " NAME: " + intern.name + "," +
                    " TEXT: " + intern.recommendationText + "," +
                    " END DATE: " + intern.endDate + "," +
                    " GENDER: " + intern.gender);
        }
    };
}
