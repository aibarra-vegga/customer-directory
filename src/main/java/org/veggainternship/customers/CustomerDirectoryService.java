package org.veggainternship.customers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDirectoryService implements CustomerDirectory {

    Menu menu = new Menu();
    ArrayList<Customer> customerDirectory = new ArrayList<>();

    public void create(Customer customer) {

        //Nif

        String Nif = "49535056p";
        customer.setNif(Nif);

        if (!validateNif(Nif)) {
            System.out.println(Nif + " is not valid, this should be your Nif: 49535056W ");
            customer.setNif("49535056W");
        }

        //Email
        String Email = "abel13ibarra#gmail.com";
        customer.setEmail(Email);

        if (!validateEmail(Email)) {
            System.out.println("abel13ibarra#gmail.com is not valid, this should be your Email: abel13ibarra@gmail.com");
            customer.setEmail("abel13ibarra@gmail.com");
        }

        //Name & Surname
        String name = "Ab44el", surname = "Ibar33ra";
        customer.setName(name);
        customer.setSurname(surname);

        if ((!validateName(name))){
            System.out.println("Ab44el is not valid, this should be your name without numbers: Abel");
            customer.setName("Abel");
        }
        if(!validateSurname(surname)){
            System.out.println("Ibar33ra is not valid, this should be your surname without numbers: Ibarra");
            customer.setSurname("Ibarra");
        }

        //City
        String city = "Llei44da";
        customer.setCity(city);

        if (!validateCity(city)){
            System.out.println(city + "is not a valid city name, it should be Lleida");
            customer.setCity("Lleida");
        }

        //Country
        String country = "Marrueco00s";

        if (!validateCountry(country)){
            System.out.println(country + "is not a valid city name, it should be Marruecos");
            customer.setCountry("Marruecos");
        }

        customerDirectory.add(customer);
    }
    public void delete(Customer customer) {

        String NIFtoErase = "49535056w";
        boolean customerFound = false;

        for (Customer c : customerDirectory) {
            if(!customerFound) {
                if (c.getNif().equalsIgnoreCase(NIFtoErase)){
                    System.out.println("Customer with NIF " + NIFtoErase + " has been successfully removed from the database.");
                    customerDirectory.remove(c);
                    customerFound = true;
                }
            }
        }
        if (!customerFound) {
            System.out.println("Customer with NIF " + NIFtoErase + " was not found in the database.");
        }
    }
    public void update(Customer customer) {

        boolean valid = false;
        boolean customerFound = false;
        do {

            String NIFtoUpdate = menu.NIFtoUpdate();
            Customer updatedCustomer = null;

            for (Customer c : customerDirectory) {
                if (!customerFound) {
                    if (c.getNif().equalsIgnoreCase(NIFtoUpdate)) {
                        customerFound = true;
                        updatedCustomer = c;
                        customer = c;
                    }
                }
            }

            if (!customerFound) {
                System.out.println("Customer with NIF " + NIFtoUpdate + " was not found in the database.");
            } else {
                String newNIF = menu.nif();

                if (newNIF.equalsIgnoreCase(updatedCustomer.getNif()) || validateNifNoRepeated(newNIF)) {

                    updatedCustomer.setNif(newNIF);
                    String newEmail = menu.email();

                    if (newEmail.equalsIgnoreCase(updatedCustomer.getEmail()) || validateEmailNoRepeated(newEmail)) {

                        updatedCustomer.setEmail(newEmail);
                        updatedCustomer.setName(menu.name());
                        updatedCustomer.setSurname(menu.surname());
                        updatedCustomer.setCity(menu.city());
                        updatedCustomer.setCountry(menu.country());

                        System.out.println("Customer with NIF " + NIFtoUpdate + " has been successfully updated in the database.");
                        valid = true;
                    } else {
                        System.out.println("That email already exists.");
                    }
                } else {
                    System.out.println("That NIF already exists.");
                }
            }
        } while (!valid);
    }
    public ArrayList<Customer> listAll() {

        ArrayList<Customer> list = customerDirectory;
        for(Customer c : list){
            System.out.println(c.toString());
            System.out.println("-----------------------------------------------------------------------------------------");
        }

        return list;

    }
    public boolean validateNifNoRepeated(String nif) {
        boolean valid = true;
        boolean exists = false;
        String originalNif = "";
        boolean original = false;

        for (Customer customer : customerDirectory) {
            if (!original) {
                originalNif = customer.getNif();
                original = true;
            }

            if (originalNif.equalsIgnoreCase(customer.getNif())) {
                original = true;
            }

            if (customer.getNif().equals(nif) && !exists) {
                exists = true;
                nif = customer.getNif();
            }
        }

        if (exists) {
            valid = false;
            System.out.println("Customer with NIF " + nif + " already exists");
        }

        return valid;
    }
    public boolean validateEmailNoRepeated(String email) {
        boolean valid = true;
        boolean exists = false;
        String originalEmail = "";
        boolean original = false;

        for (Customer customer : customerDirectory) {
            if (!original) {
                originalEmail = customer.getEmail();
                original = true;
            }

            if (originalEmail.equalsIgnoreCase(customer.getEmail())) {
                original = true;
            }

            if (customer.getEmail().equals(email) && !exists) {
                exists = true;
                email = customer.getEmail();
            }
        }

        if (exists) {
            valid = false;
            System.out.println("Customer with email " + email + " already exists");
        }

        return valid;
    }
    public Optional<Customer> findByNif(String nif) {

        Customer c = new Customer();
        boolean customerFound = false;

        for (Customer customer : customerDirectory) {
            if (nif.equalsIgnoreCase(customer.getNif()) && (!customerFound)) {
                customerFound = true;
                c = customer;
            }
        }
        if (!customerFound){
            System.out.println("Customer with nif " + nif + " was not found in the database.");
        }
        return Optional.of(c);
    }
    public Optional<Customer> findByEmail(String email) {

        Customer c = new Customer();
        boolean customerFound = false;

        for (Customer customer : customerDirectory) {
            if (email.equalsIgnoreCase(customer.getEmail())) {
                customerFound = true;
                c = customer;
            }
        }
        if (!customerFound) {
            System.out.println("Customer with email " + email + " was not found in the database.");
        }
        return Optional.of(c);
    }
    public ArrayList<Customer> findByName(String name) {

        ArrayList<Customer> list = new ArrayList<>();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (name.equalsIgnoreCase(customer.getName())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("Customer with name " + name + " was not found in the database.");
        }
        return list;
    }
    public ArrayList<Customer> findBySurname(String surname) {

        ArrayList<Customer> list = new ArrayList<>();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (surname.equalsIgnoreCase(customer.getSurname())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("Customer with surname " + surname + " was not found in the database.");
        }
        return list;
    }
    public ArrayList<Customer> findByCity(String city) {

        ArrayList<Customer> list = new ArrayList<>();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (city.equalsIgnoreCase(customer.getCity())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("Customer with city " + city + " was not found in the database.");
        }
        return list;
    }
    public ArrayList<Customer> findByCountry(String country) {

        ArrayList<Customer> list = new ArrayList<>();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (country.equalsIgnoreCase(customer.getCountry())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("CustomerDirectoryService with country " + country + " was not found in the database.");
        }
        return list;
    }
    public boolean validateNif(String Nif){

        boolean valid = false;
        outer:
        do {

            System.out.println("NIF: ");
            String numnif = "";

            if (Nif.length() == 9) {

                for (int i = 0; i <= 7; i++) {
                    numnif += Nif.charAt(i);
                    if (!Character.isDigit(Nif.charAt(i))) {

                        valid = false;
                        System.out.println("This nif is not correct, " + Nif.charAt(i) + " is not a number");
                        continue outer;

                    }
                }

                if (Character.isAlphabetic(Nif.charAt(8))) {
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

                char lletraDNI = Nif.charAt(8);

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
                    Nif = numnif + DNI;
                    valid = true;

                } else {
                    System.out.println("This nif is not well calculated, please try another nif: ");
                    valid = false;
                }

            } else {
                System.out.println("This nif is not valid, try again: ");
            }
        } while (!valid);

        return valid;

    }
    public boolean validateEmail(String email) {

        boolean valid = true;
        do {

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

        return valid;
    }
    public boolean validateName(String name){

        boolean valid = false;
        int counter = 0;

        do {

            for (char c : name.toCharArray()) {

                if (Character.isLetter(c) || c == ' ') {
                    name += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a name ");
                    valid = false;
                }
            }

            if ((!valid) && (counter > 0) || name.isBlank()) {
                valid = false;
            }
            counter++;
        } while (!valid);

        return valid;
    }
    public boolean validateSurname(String surname){

        boolean valid = false;
        int counter = 0;

        do {

            for (char c : surname.toCharArray()) {

                if (Character.isLetter(c) || c == ' ') {
                    surname += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a surname ");
                    valid = false;
                }
            }

            if ((!valid) && (counter > 0) || surname.isBlank()) {
                valid = false;
            }
            counter++;
        } while (!valid);

        return valid;
    }
    public boolean validateCity(String city){

        Scanner scan = new Scanner(System.in);
        boolean valid = false;

        Locale[] locales = Locale.getAvailableLocales();

        do {

            boolean trobada = false;

            if (city.isBlank()) {
                System.out.println("You have entered an empty name of a city, please try again: ");
            } else {
                for (char c : city.toCharArray()) {
                    if (Character.isLetter(c)) {
                        valid = true;
                        city += c;
                    } else {
                        System.out.println(c + " is not a valid character for a city ");
                        valid = false;
                    }
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

        return valid;
    }
    public boolean validateCountry(String country){

        boolean valid = false;
        Locale[] locales = Locale.getAvailableLocales();

        do {

            for (Locale locale : locales) {
                if (!valid) {
                    if (country.equalsIgnoreCase(locale.getDisplayCountry()) && ((country != null) || (country != " "))) {
                        valid = true;
                        country = locale.getDisplayCountry();
                    }
                }
            }

        } while (!valid);

        return valid;
    }
}
