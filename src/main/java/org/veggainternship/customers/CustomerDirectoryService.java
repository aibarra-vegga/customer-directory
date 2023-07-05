package org.veggainternship.customers;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDirectoryService implements CustomerDirectory {
    Scanner scan = new Scanner(System.in);
    private String NIF;
    private String Name;
    private String Surname;
    private String Email;
    private String City;
    private String Country;

    //Constructor buit i constructor ple
    public CustomerDirectoryService() {
        this.NIF = "";
        this.Name = "";
        this.Surname = "";
        this.Email = "";
        this.City = "";
        this.Country = "";
    }

    public CustomerDirectoryService(String NIF, String name, String surname, String email, String city, String country) {
        this.NIF = NIF;
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.City = city;
        this.Country = country;
    }

    ArrayList<CustomerDirectoryService> customerDirectories = new ArrayList<>();

    public void create(CustomerDirectoryService customerDirectory, ArrayList<CustomerDirectoryService> customerDirectories) {

        boolean valid = false;

        do {
            System.out.println("Name: ");
            this.Name = scan.nextLine();
            System.out.println("Surname: ");
            this.Surname = scan.nextLine();
            customerDirectory.validateNames(this.Name, this.Surname);
            System.out.println("City: ");
            this.City = scan.nextLine();
            System.out.println("Country: ");
            this.Country = scan.nextLine();
            customerDirectory.validateCountry(this.getCountry());

            System.out.println("Email: ");
            this.Email = scan.nextLine();
            customerDirectory.validateEmail(this.Email);
            this.NIF = customerDirectory.validateNIF(this.NIF);

            if (validateNoRepeated(customerDirectories)) {
                valid = true;
            }

        } while (!valid);
    }

    public void delete(ArrayList<CustomerDirectoryService> customerDirectories) {

        System.out.println("NIF of the customer you want to erase from the database: ");
        String NIFtoErase = scan.nextLine();
        boolean customerFound = false;

        outer:
        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (customerDirectory.getNIF().equalsIgnoreCase(NIFtoErase)) {
                    System.out.println("CustomerDirectoryService with NIF " + NIFtoErase + " has been successfully removed from the database.");
                    customerDirectories.remove(customerDirectory);
                    customerFound = true;
                    break outer; // per a que no peti si nomes hi ha un client a l arraylist
                } else {
                    System.out.println("CustomerDirectoryService with NIF " + NIFtoErase + " was not found in the database.");
                }
            }
        }
    }

    public void update(ArrayList<CustomerDirectoryService> customerDirectories) {
        System.out.println("NIF of the customer that you want to update: ");
        String NIFtoUpdate = scan.nextLine();
        boolean customerFound = false;

        boolean valid = false;
        do {
            for (CustomerDirectoryService customerDirectory : customerDirectories) {

                if (!customerFound) { //per no actualitzar mes d un customer

                    if (customerDirectory.getNIF().equalsIgnoreCase(NIFtoUpdate)) {

                        customerDirectory.setNIF(customerDirectory.validateNIF(customerDirectory.getNIF()));

                        System.out.println("Name: ");
                        customerDirectory.setName(scan.nextLine());

                        System.out.println("Surname: ");
                        customerDirectory.setSurname(scan.nextLine());

                        customerDirectory.validateNames(customerDirectory.getName(), customerDirectory.getSurname());

                        System.out.println("City: ");
                        customerDirectory.setCity(scan.nextLine());

                        System.out.println("Country: ");
                        customerDirectory.setCountry(scan.nextLine());

                        System.out.println("Email: ");
                        customerDirectory.setEmail(scan.nextLine());
                        customerDirectory.validateEmail(customerDirectory.getEmail());

                        System.out.println("Customer with NIF " + customerDirectory.getNIF() + " has been updated.");
                        customerFound = true;

                        if (validateNoRepeated(customerDirectories)) {
                            valid = true;
                        }
                    }
                }
            }

            if (!customerFound) {
                System.out.println("CustomerDirectoryService with NIF " + NIFtoUpdate + " was not found in the database.");
            }

        } while (!valid);
    }

    //finds
    public void findByNIF(ArrayList<CustomerDirectoryService> customerDirectories) {
        System.out.println("NIF of the customer you want to see: ");
        NIF = scan.nextLine();
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (NIF.equalsIgnoreCase(customerDirectory.getNIF())) {
                    System.out.println("The customerDirectory with the NIF " + customerDirectory.getNIF() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with NIF " + NIF + " was not found in the database.");
        }
    }

    public void findByEmail(ArrayList<CustomerDirectoryService> customerDirectories) {
        System.out.println("Email of the customer you want to see: ");
        Email = scan.nextLine();
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (Email.equalsIgnoreCase(customerDirectory.getEmail())) {
                    System.out.println("The customerDirectory with the email " + customerDirectory.getEmail() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with email " + Email + " was not found in the database.");
        }
    }

    public void findByName(ArrayList<CustomerDirectoryService> customerDirectories) {
        System.out.println("NIF of the customer you want to see: ");
        Name = scan.nextLine();
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (Name.equalsIgnoreCase(customerDirectory.getName())) {
                    System.out.println("The customerDirectory with the name " + customerDirectory.getName() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with name " + Name + " was not found in the database.");
        }
    }

    public void findBySurname(ArrayList<CustomerDirectoryService> customerDirectories) {
        System.out.println("NIF of the customer you want to see: ");
        Surname = scan.nextLine();
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (Surname.equalsIgnoreCase(customerDirectory.getSurname())) {
                    System.out.println("The customerDirectory with the name " + customerDirectory.getSurname() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with surname " + Surname + " was not found in the database.");
        }
    }

    public void findByCity(ArrayList<CustomerDirectoryService> customerDirectories) {
        System.out.println("City of the customer you want to see: ");
        City = scan.nextLine();
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (City.equalsIgnoreCase(customerDirectory.getCity())) {
                    System.out.println("The customerDirectory with the NIF " + customerDirectory.getCity() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with city " + City + " was not found in the database.");
        }
    }

    public void findByCountry(ArrayList<CustomerDirectoryService> customerDirectories) {
        System.out.println("NIF of the customer you want to see: ");
        Country = scan.nextLine();
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (Country.equalsIgnoreCase(customerDirectory.getCity())) {
                    System.out.println("The customerDirectory with the NIF " + customerDirectory.getCountry() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with country " + Country + " was not found in the database.");
        }
    }

    public void listAll(ArrayList<CustomerDirectoryService> customerDirectories) {
        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            System.out.println(customerDirectory.toString());
        }
    }

    //Validacions
    public String validateEmail(String Email) {

        boolean valid = true;

        do {
            String patro = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(patro);
            Matcher matcher = pattern.matcher(Email);
            System.out.println(Email + " : " + matcher.matches() + "\n");
            if (matcher.matches()) {
                this.setEmail(Email);
                valid = true;
            } else {
                valid = false;
                System.out.println("You have not entered a valid email, please enter a valid one: ");
                Email = scan.nextLine();
            }

        } while (!valid);

        return Email;
    }

    public String validateNIF(String NIF) {

        boolean valid = false;
        do {

            System.out.println("Introduce your NIF please: ");
            NIF = scan.nextLine();
            String numNIF = "";

            if (NIF.length() == 9) {
                for (int i = 0; i <= 7; i++) {

                    numNIF += NIF.charAt(i);

                    if ((Character.isDigit(NIF.charAt(i)))) {
                        valid = true;
                    } else {
                        valid = false;
                        System.out.println("This NIF is not correct. ");
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
                    valid = true;
                } else {
                    System.out.println("This NIF is not well calculated, please try another NIF:");
                    valid = false;
                }

            } else {
                System.out.println("NIF is not valid, try again: ");
            }
        } while (!valid);
        return NIF;
    }

    public void validateNames(String name, String surname) {
        String validatedName = "";
        String validatedSurname = "";
        boolean valid = true;
        int counter = 0;

        do {

            if ((!valid) && (counter > 0)) {
                System.out.println("That was an incorrect name, write a valid name: ");
                name = scan.nextLine();
                validatedName = "";
                System.out.println("That was an incorrect surname, write a valid surname: ");
                surname = scan.nextLine();
                validatedSurname = "";
            }

            for (char c : name.toCharArray()) {
                if (Character.isLetter(c) || c == ' ') {
                    validatedName += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a name");
                    valid = false;
                }
            }

            for (char c : surname.toCharArray()) {

                if (Character.isLetter(c) || c == ' ') {
                    validatedSurname += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a surname");
                    valid = false;
                }
            }
            counter++;
        } while (!valid);

        System.out.println(" ");
        System.out.println("The full name of this person is: " + validatedName + " " + validatedSurname);
        this.Name = validatedName;
        this.Surname = validatedSurname;

    }

    public void validateCountry(String country) { // es guarde el primer valor de country encara que estigui malament
        boolean valid = false;
        Locale[] locales = Locale.getAvailableLocales();
        do {

            for (Locale locale : locales) {
                if (!valid) {
                    if (country.equalsIgnoreCase(locale.getDisplayCountry())) {
                        valid = true;
                        this.Country = locale.getDisplayCountry();
                    }
                }
            }

            if (valid) {
                System.out.println("You have entered a valid country.");
            } else {
                System.out.println("You have not entered a valid country, please try again.");
                country = scan.nextLine();
            }
        } while (!valid);

    }

    public boolean validateNoRepeated(ArrayList<CustomerDirectoryService> customerDirectories) {
        boolean valid = true;
        boolean isNIFRepeated = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {

            if (customerDirectory.getNIF().equals(this.NIF) && isNIFRepeated == false) {
                isNIFRepeated = true;
            }
        }

        if (isNIFRepeated) {
            valid = false;
            System.out.println("Customer with NIF " + this.NIF + " already exists ");
        }

        boolean isEmailRepeated = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {

            if (customerDirectory.getEmail().equals(this.Email) && isEmailRepeated == false) {
                isEmailRepeated = true;
            }

        }

        if (isEmailRepeated) {

            valid = false;
            isEmailRepeated = true;
            System.out.println("Customer with email " + this.Email + " already exists ");

        }

        return valid;
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
        return "CustomerDirectoryService{" +
                "NIF='" + this.NIF + '\'' +
                ", Name='" + this.Name + '\'' +
                ", Surname='" + this.Surname + '\'' +
                ", Email='" + this.Email + '\'' +
                ", City='" + this.City + '\'' +
                ", Country='" + this.Country + '\'' +
                '}';
    }
}