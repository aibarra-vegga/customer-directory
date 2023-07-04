package org.veggainternship.customers;

import java.lang.management.GarbageCollectorMXBean;
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
    public void delete(ArrayList<Customer> customers) {

        System.out.println("NIF of the customer you want to erase from the database: ");
        String NIFtoErase = scan.nextLine();
        boolean customerFound = false;

        outer:
        for (Customer customer : customers) {
            if (customerFound == false) {
                if (customer.getNIF().equalsIgnoreCase(NIFtoErase)) {
                    System.out.println("Customer with NIF " + NIFtoErase + " has been successfully removed from the database.");
                    customers.remove(customer);
                    customerFound = true;
                    break outer; // per a que no peti si nomes hi ha un client a l arraylist
                } else {
                    System.out.println("Customer with NIF " + NIFtoErase + " was not found in the database.");
                }
            }
        }
    }
    public void update(ArrayList<Customer> customers) {
        System.out.println("NIF of the customer that you want to update: ");
        String NIFtoUpdate = scan.nextLine();
        boolean customerFound = false;

        for (Customer customer : customers) {
            if (!customerFound) {
                if (customer.getNIF().equalsIgnoreCase(NIFtoUpdate)) {
                    System.out.println("NIF: ");
                    customer.setNIF(customer.validateNIF(customer.getNIF()));

                    System.out.println("Name: ");
                    customer.setName(scan.nextLine());

                    System.out.println("Surname: ");
                    customer.setSurname(scan.nextLine());

                    customer.validateNames(customer.getName(), customer.getSurname());

                    System.out.println("Email: ");
                    customer.setEmail(scan.nextLine());
                    customer.validateEmail(customer.getEmail());

                    System.out.println("City: ");
                    customer.setCity(scan.nextLine());

                    System.out.println("Country: ");
                    customer.setCountry(scan.nextLine());

                    System.out.println("Customer with NIF " + customer.getNIF() + " has been updated.");
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Customer with NIF " + NIFtoUpdate + " was not found in the database.");
        }
    }


    //finds
    public void findByNIF(ArrayList<Customer> customers) {
        System.out.println("NIF of the customer you want to see: ");
        NIF = scan.nextLine();
        boolean customerFound = false;

        for (Customer customer : customers) {
            if(customerFound == false) {
                if (NIF.equalsIgnoreCase(customer.getNIF())) {
                    System.out.println("The customer with the NIF " + customer.getNIF() + " information is: ");
                    System.out.println(customer.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Customer with NIF " + NIF + " was not found in the database.");
        }
    }
    public void findByEmail(ArrayList<Customer> customers) {
        System.out.println("Email of the customer you want to see: ");
        Email = scan.nextLine();
        boolean customerFound = false;

        for (Customer customer : customers) {
            if(customerFound == false) {
                if (Email.equalsIgnoreCase(customer.getEmail())) {
                    System.out.println("The customer with the email " + customer.getEmail() + " information is: ");
                    System.out.println(customer.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Customer with email " + Email + " was not found in the database.");
        }
    }
    public void findByName(ArrayList<Customer> customers) {
        System.out.println("NIF of the customer you want to see: ");
        Name = scan.nextLine();
        boolean customerFound = false;

        for (Customer customer : customers) {
            if(customerFound == false) {
                if (Name.equalsIgnoreCase(customer.getName())) {
                    System.out.println("The customer with the name " + customer.getName() + " information is: ");
                    System.out.println(customer.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Customer with name " + Name + " was not found in the database.");
        }
    }

    public void findBySurname(ArrayList<Customer> customers) {
        System.out.println("NIF of the customer you want to see: ");
        Surname = scan.nextLine();
        boolean customerFound = false;

        for (Customer customer : customers) {
            if(customerFound == false) {
                if (Surname.equalsIgnoreCase(customer.getSurname())) {
                    System.out.println("The customer with the name " + customer.getSurname() + " information is: ");
                    System.out.println(customer.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Customer with surname " + Surname + " was not found in the database.");
        }
    }

    public void findByCity(ArrayList<Customer> customers) {
        System.out.println("City of the customer you want to see: ");
        City = scan.nextLine();
        boolean customerFound = false;

        for (Customer customer : customers) {
            if(customerFound == false) {
                if (City.equalsIgnoreCase(customer.getCity())) {
                    System.out.println("The customer with the NIF " + customer.getCity() + " information is: ");
                    System.out.println(customer.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Customer with city " + City + " was not found in the database.");
        }
    }
    public void findByCountry(ArrayList<Customer> customers) {
        System.out.println("NIF of the customer you want to see: ");
        Country = scan.nextLine();
        boolean customerFound = false;

        for (Customer customer : customers) {
            if(customerFound == false) {
                if (Country.equalsIgnoreCase(customer.getCity())) {
                    System.out.println("The customer with the NIF " + customer.getCountry() + " information is: ");
                    System.out.println(customer.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Customer with country " + Country + " was not found in the database.");
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
