package org.example.staff;

import java.time.LocalDate;
import java.util.Scanner;
public class Intern extends Staff {
    public LocalDate endDate;
    public String recommendationText;
public Intern(String id, LocalDate endDate, String name, String gender, String recommendationText) {
      super(id, name, gender);
        this.endDate = endDate;
        this.recommendationText = recommendationText;
    }
    static Scanner scanner = new Scanner(System.in);
    public static void updateRecommendationText(Intern intern){
        System.out.println("Write your text: ");
        String recommendationText = scanner.nextLine();
        intern.setRecommendationText(recommendationText);
        System.out.println("Text updated : " + intern.recommendationText);
    }
    public void setRecommendationText(String recommendationText) {
        this.recommendationText = recommendationText;
    }
    }
