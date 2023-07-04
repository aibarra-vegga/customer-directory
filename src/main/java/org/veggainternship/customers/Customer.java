package org.veggainternship.customers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    Scanner scan = new Scanner(System.in);
    private String NIF;
    private String Name;
    private String Surname;
    private String Email;
    private String City;
    private String Country;

    //Constructor buit i constructor ple
    public Customer() {
        this.NIF = "";
        this.Name = "";
        this.Surname = "";
        this.Email = "";
        this.City = "";
        this.Country = "";
    }

    public Customer(String NIF, String name, String surname, String email, String city, String country) {
        this.NIF = NIF;
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.City = city;
        this.Country = country;
    }

    ArrayList<Customer> customers = new ArrayList<>();

    public void create(Customer customer) {

        System.out.println("NIF: ");
        this.NIF = customer.validateNIF(this.NIF);
        System.out.println("Name: ");
        this.Name = scan.nextLine();
        System.out.println("Surname: ");
        this.Surname = scan.nextLine();
        customer.validateNames(this.Name, this.Surname);
        System.out.println("Email: ");
        this.Email = scan.nextLine();
        customer.validateEmail(this.Email);
        System.out.println("City: ");
        this.City = scan.nextLine();
        System.out.println("Country: ");
        this.Country = scan.nextLine();
        customers.add(customer);

    }
    public void delete(String NIFtoErase) {

        System.out.println("NIF of the customer you want to erase from the database: ");
        NIFtoErase = scan.nextLine();

        outer:
        for (Customer customer : customers) {
            if (customer.getNIF().equalsIgnoreCase(NIFtoErase)) {
                customers.remove(customer);
                System.out.println("Customer with NIF " + this.getNIF() + " has been successfully removed from the database.");
                break outer;
            } else {
                System.out.println("Customer with NIF " + this.getNIF() + " was not found in the database.");
            }
        }

    }

    public void update(String NIFtoUpdate) {
        System.out.println("NIF of the customer that you want to update: ");
        NIFtoUpdate = scan.nextLine();
        boolean customerFound = false;
        int c1 = 0; // client counter

        outer:
        for (Customer customer : customers) {
            if (customer.getNIF().equalsIgnoreCase(NIFtoUpdate) && c1 == 0) {

                c1++;
                System.out.println("NIF: ");
                customer.setNIF(customer.validateNIF(scan.nextLine()));

                System.out.println("Name: ");
                this.setName(scan.nextLine());

                System.out.println("Surname: ");
                this.setSurname(scan.nextLine());

                System.out.println("Email: ");
                this.setEmail(scan.nextLine());

                System.out.println("City: ");
                customer.setCity(scan.nextLine());

                System.out.println("Country: ");
                customer.setCountry(scan.nextLine());

                System.out.println("Customer with NIF " + customer.getNIF() + " has been updated.");
                customerFound = true;
                customers.add(customer);

            }
            System.out.println(customers);
        }

        if (!customerFound) {
            System.out.println("Customer with NIF " + NIFtoUpdate + " was not found in the database.");
        }
    }

    public void findByNIF(String NIF) {
        System.out.println("NIF of the customer you want to see: ");
        NIF = scan.nextLine();
        for (Customer customer : customers) {
            if (NIF.equalsIgnoreCase(this.getNIF())) {
                System.out.println("The customer with the NIF " + customer.getNIF() + " information is: ");
                System.out.println(customer.toString());
            }
        }
    }

    public void listAll(ArrayList<Customer> customers){
        for (Customer customer : customers){
            System.out.println(customer.toString());
        }
    }

    //Validacions
    public String validateEmail(String Email) {
        ArrayList<String> correus = new ArrayList<String>();
        correus.add(Email);
        String patro = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(patro);
        for (String correu : correus) {
            Matcher matcher = pattern.matcher(correu);
            System.out.println(correu + " : " + matcher.matches() + "\n");
        }
        return Email;
    }

    public String validateNIF(String NIF) {

        NIF = scan.nextLine();
        boolean valid = false;
        String numNIF = "";

        if (NIF.length() == 9) {
            for (int i = 0; i <= 7; i++) {

                numNIF += NIF.charAt(i);

                if ((Character.isDigit(NIF.charAt(i)))) {
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("This NIF is not correct. ");
                    return null;
                }
            }

            if (Character.isAlphabetic(NIF.charAt(8))) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Last character of the NIF is not a letter");
            }
        } else {
            System.out.println("This NIF does not have 9 characters");
        }

        // Validación del DNI
        if (valid) {
            char lletraDNI = NIF.charAt(8);

            int numDNI = Integer.parseInt(numNIF);
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
                System.out.println("This NIF is correct");
            } else {
                System.out.println("This NIF is not well calculated");
            }
            return NIF;

        } else {
            return null;
        }
    }

    public void validateNames(String name, String surname) {
        String validatedName = "";
        String validatedSurname = "";

        for (char c : name.toCharArray()) {
            if (Character.isLetter(c) || c == ' ') {
                validatedName += c;
            }
        }

        for (char c : surname.toCharArray()) {
            if (Character.isLetter(c) || c == ' ') {
                validatedSurname += c;
            }
        }

        System.out.println(" ");
        System.out.println("The full name of this person is: " + validatedName + " " + validatedSurname);
        this.Name = validatedName;
        this.Surname = validatedSurname;

    }

    //Getters i setters i tostring
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "NIF='" + this.NIF + '\'' +
                ", Name='" + this.Name + '\'' +
                ", Surname='" + this.Surname + '\'' +
                ", Email='" + this.Email + '\'' +
                ", City='" + this.City + '\'' +
                ", Country='" + this.Country + '\'' +
                '}';
    }
}
