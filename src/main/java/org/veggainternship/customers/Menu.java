package org.veggainternship.customers;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("4: Find user by Nif ");
        System.out.println("5: Find user by Email ");
        System.out.println("6: Find user by Name ");
        System.out.println("7: Find user by Surname ");
        System.out.println("8: Find user by City ");
        System.out.println("9: Find user by Country ");
        System.out.println("10: List all customers ");
        System.out.println("11: Test user ");
        System.out.println("12: Test user ");

        outer:
        do {

            System.out.println("Enter an option: ");

            if (scan.hasNextInt()) {
                option = scan.nextInt();

                if (option > 0 && option <= 13) {
                    entrar = true;
                } else if (option == 0) {
                    System.out.println("Successfully exited ");
                    entrar = false;
                    break outer;
                } else {
                    System.out.println("Invalid option. Please enter a number between 0 and 13.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer number.");
                scan.next();
            }
        } while (!entrar);

        return option;
    }

    public String email() {

        Scanner scan = new Scanner(System.in);
        System.out.println("email: ");

        String email = "";
        boolean valid = true;

        do {

            email = scan.nextLine();
            String patro = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(patro);
            Matcher matcher = pattern.matcher(email);
            if (!email.isBlank()) {
                if (matcher.matches()) {
                    email = email.replaceAll("\\s", "");
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("You have not entered a valid email, please enter a valid one: ");
                }
            } else {
                System.out.println("The email has a whitespace, please try again: ");
                valid = false;
            }

        } while (!valid);

        return email;
    }
    public String nif() {

        Scanner scan = new Scanner(System.in);
        String nif = "";
        boolean valid = false;
        outer:
        do {

            System.out.println("NIF: ");
            nif = scan.nextLine();
            String numnif = "";

            if (nif.length() == 9) {

                for (int i = 0; i <= 7; i++) {
                    numnif += nif.charAt(i);
                    if (!Character.isDigit(nif.charAt(i))) {

                        valid = false;
                        System.out.println("This nif is not correct, " + nif.charAt(i) + " is not a number");
                        continue outer;

                    }
                }

                if (Character.isAlphabetic(nif.charAt(8))) {
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("Last character of the nif is not a letter");
                }
            } else {
                System.out.println("This nif does not have 9 characters");
            }

            // Validación del DNI
            if (valid) {

                char lletraDNI = nif.charAt(8);

                int numDNI = Integer.parseInt(numnif);
                String DNI = "";
                String[] lletresMaj = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
                String[] lletresMin = {"t", "r", "w", "a", "g", "m", "y", "f", "p", "d", "x", "b", "n", "j", "z", "s", "q", "v", "h", "l", "c", "k", "e"};

                int modDNI = numDNI % 23;
                if (Character.isUpperCase(lletraDNI)) {
                    DNI += lletresMaj[modDNI];
                } else if (Character.isLowerCase(lletraDNI)) {
                    DNI += lletresMin[modDNI];
                }
                if (lletraDNI == DNI.charAt(0)) {
                    nif = numnif + DNI;
                    valid = true;

                } else {
                    System.out.println("This nif is not well calculated, please try another nif: ");
                    valid = false;
                }

            } else {
                System.out.println("This nif is not valid, try again: ");
            }
        } while (!valid);

        return nif;

    }
    public String name() {

        Scanner scan = new Scanner(System.in);
        String name = "", validatedName = "";
        boolean valid = false;
        int counter = 0;

        System.out.println("Name: ");

        do {
            validatedName = scan.nextLine();

            for (char c : validatedName.toCharArray()) {

                if (Character.isLetter(c) || c == ' ') {
                    name += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a name ");
                    valid = false;
                }
            }

            if ((!valid) && (counter > 0) || name.isBlank()) {
                System.out.println("That was an incorrect name, write a valid name: ");
                validatedName = "";
                name = "";
                valid = false;
            }
            counter++;
        } while (!valid);

        return name;
    }

    public String surname() {

        Scanner scan = new Scanner(System.in);
        String validatedSurname = "";
        String surname = "";
        boolean valid = false;
        int counter = 0;

        System.out.println("Surname: ");

        do {
            String input = scan.nextLine();

            for (char c : input.toCharArray()) {
                if (Character.isLetter(c) || c == ' ') {
                    surname += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a surname ");
                    valid = false;
                }
            }
            if ((!valid) && (counter > 0) || surname.isBlank()) {
                System.out.println("That was an incorrect surname, write a valid surname: ");
                validatedSurname = "";
                surname = "";
                valid = false;
            }
            counter++;
        } while (!valid);

        return surname;
    }

    public String city() {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;

        System.out.println("City: ");
        String city = "";
        Locale[] locales = Locale.getAvailableLocales();

        do {

            boolean trobada = false;
            city = scan.nextLine();
            String validatedCity = "";

            if (city.isBlank()) {
                System.out.println("You have entered an empty name of a city, please try again: ");
            } else {
                for (char c : city.toCharArray()) {
                    if (Character.isLetter(c)) {
                        valid = true;
                        validatedCity += c;
                    } else {
                        System.out.println(c + " is not a valid character for a city ");
                        valid = false;
                    }
                    city = validatedCity;
                }
                for (Locale locale : locales) {

                    if (!trobada) {
                        if (city.equalsIgnoreCase(locale.getDisplayCountry())) {
                            valid = false;
                            trobada = true;
                        } else {
                            valid = true;
                            trobada = false;
                        }
                    }
                }
                if (trobada) {
                    System.out.println("That's a country ");
                }
                if (!valid) {
                    System.out.println("Please try again: ");
                }
            }

        } while (!valid);

        return city;
    }

    public String country() {

        Scanner scan = new Scanner(System.in);
        String country = "";
        boolean valid = false;
        Locale[] locales = Locale.getAvailableLocales();
        System.out.println("Country: ");

        do {

            country = scan.nextLine();
            for (Locale locale : locales) {
                if (!valid) {
                    if (country.equalsIgnoreCase(locale.getDisplayCountry()) && ((country != null) || (country != " "))) {
                        valid = true;
                        country = locale.getDisplayCountry();
                    }
                }
            }

            if (!valid) {
                System.out.println("You have not entered a valid country, please try again.");
            }

        } while (!valid);

        return country;
    }

    public String NIFtoErase() {

        Scanner scan = new Scanner(System.in);
        System.out.println("NIF of the customer you want to erase: ");
        String NIF = nif();

        return NIF;
    }

    public String NIFtoUpdate() {

        Scanner scan = new Scanner(System.in);
        System.out.println("NIF of the customer you want to update: ");
        String NIF = nif();

        return NIF;
    }

    public String NIFtoFind() {
        String NIFtoFind = nif();
        return NIFtoFind;
    }

    public String emailToFind() {
        String email = email();
        return email;
    }

    public String nameToFind() {
        String name = name();
        return name;
    }

    public String surnameToFind() {
        String surname = surname();
        return surname;
    }

    public String cityToFind() {
        String city = city();
        return city;
    }

    public String countryToFind() {
        System.out.println("Enter the country of the customer you want to find: ");
        String country = country();
        return country;
    }

}