package org.example;

import java.util.Objects;
import java.util.Scanner;
public class RestartProgram {
    public static void restartProgram(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To return to the main menu, press 'c' ");
        String choice = scanner.next();
        if (Objects.equals(choice, "Y".toLowerCase())){
            UserSelection.userSelection();
        }
    }
    }
