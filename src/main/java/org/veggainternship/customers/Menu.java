package org.veggainternship.customers;

import java.util.Scanner;

public class Menu {
    public boolean menuPrincipal(boolean entrar) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to enter? ");
        String opcio = scan.nextLine().trim();

        while (!opcio.equalsIgnoreCase("yes") && !opcio.equalsIgnoreCase("no")) {
            System.out.println("You have not entered a valid option, will you try again? ");
            opcio = scan.nextLine().trim();
        }

        if (opcio.equalsIgnoreCase("yes")) {
            entrar = true;
            System.out.println("Successfully entered ");
        } else if (opcio.equalsIgnoreCase("no")) {
            System.out.println("Successfully exited ");
            entrar = false;
        }

        return entrar;
    }

    public int optionsMenu() {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        boolean entrar = false;

        System.out.println("What do you want to do? ");
        System.out.println("0: Exit ");
        System.out.println("1: Create user ");
        System.out.println("2: Update user ");
        System.out.println("3: Delete user ");
        System.out.println("4: Find user by ID ");
        System.out.println("5: Find user by Email ");
        System.out.println("6: Find user by Name ");
        System.out.println("7: Find user by Surname ");
        System.out.println("8: Find user by City ");
        System.out.println("9: Find user by Country ");
        System.out.println("10: List all customers ");

        outer:
        do {
            System.out.println("Enter an option: ");

            if (scan.hasNextInt()) {
                option = scan.nextInt();

                if (option > 0 && option <= 10) {
                    System.out.println("Successfully entered ");
                    entrar = true;
                } else if (option == 0) {
                    System.out.println("Successfully exited ");
                    entrar = false;
                    break outer;
                }else{
                    System.out.println("Invalid option. Please enter a number between 0 and 8.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer number.");
                scan.next();
            }
        } while (!entrar);

        return option;
    }
}