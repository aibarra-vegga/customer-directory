package org.veggainternship.customers;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDirectoryService implements CustomerDirectory {

    Menu menu = new Menu();
    ArrayList<Customer> customerDirectory = new ArrayList<>();

    public Customer create(Customer customer) {

        customerDirectory.add(customer);
        System.out.println(customer.toString());

        return customer;
    }

    @Override
    public void delete(Customer customer) {

        String NIFtoErase = menu.NIFtoErase();

        boolean customerFound = false;

        outer:
        for (customer : customerDirectory) {
            if (!customerFound) {
                if (customer.getNif().equalsIgnoreCase(NIFtoErase)) {
                    System.out.println("CustomerDirectoryService with NIF " + NIFtoErase + " has been successfully removed from the database.");
                    customerDirectory.remove(customer);
                    break outer;

                } else {
                    System.out.println("CustomerDirectoryService with NIF " + NIFtoErase + " was not found in the database.");
                }
            }
        }
    }

        @Override
        public void update (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public void findByNIF (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public void findByEmail (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public void findByName (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public void findBySurname (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public void findByCity (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public void findByCountry (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public void listAll (ArrayList < CustomerDirectoryService > customerDirectories) {

        }

        @Override
        public boolean validateNoRepeated (ArrayList < CustomerDirectoryService > customerDirectories) {
            return false;
        }
/*
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
                    //per si nomes es vol borrar un client
                    //customerFound = true;
                    //break outer; // per a que no peti si nomes hi ha un client a l arraylist
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

                    if ((customerDirectory.getNIF().equalsIgnoreCase(NIFtoUpdate) && (validateNoRepeated(customerDirectories)))) {

                        customerFound = true;

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

                            this.Email= customerDirectory.validateEmail(this.Email);

                            this.NIF = customerDirectory.validateNIF(this.NIF);

                            if (validateNoRepeated(customerDirectories)) {
                                valid = true;
                            }

                        } while (!valid);
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
    public boolean validateNoRepeated(ArrayList<CustomerDirectoryService> customerDirectories) {
        boolean valid = true;
        //nif
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

        //email
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

    //tests
    public void createTest(CustomerDirectoryService customerDirectory, ArrayList<CustomerDirectoryService> customerDirectories) {

        boolean valid = false;

        do {
            this.Name = "Abde/(//l";
            this.Surname = "Fata/(/h";
            customerDirectory.validateNames(this.Name, this.Surname);

            this.City = "y";

            this.Country = "España";
            customerDirectory.validateCountryTest(this.getCountry());

            this.Email = customerDirectory.validateEmailTest(this.Email);

            this.NIF = customerDirectory.validateNIFTest(this.NIF);

            if (validateNoRepeated(customerDirectories)) {
                valid = true;
            }

        } while (!valid);
    }
    public void updateTest(ArrayList<CustomerDirectoryService> customerDirectories) {

        String NIFtoUpdate = "00000000t";
        boolean customerFound = false;
        boolean valid = false;

        do {
            for (CustomerDirectoryService customerDirectory : customerDirectories) {

                if (!customerFound) { //per no actualitzar mes d un customer

                    if ((customerDirectory.getNIF().equalsIgnoreCase(NIFtoUpdate) && (validateNoRepeated(customerDirectories)))) {

                        customerFound = true;

                        do {

                            this.Name = "Manolo";

                            this.Surname = "Costache";
                            customerDirectory.validateNamesTest(this.Name, this.Surname);

                            this.City = "Mollerussa";

                            this.Country = "España";
                            customerDirectory.validateCountryTest(this.getCountry());

                            this.Email = customerDirectory.validateEmailTest(this.Email);

                            this.NIF = customerDirectory.validateNIFTest(this.NIF);

                            if (validateNoRepeated(customerDirectories)) {
                                valid = true;
                            }

                        } while (!valid);
                    }
                }
            }

            if (!customerFound) {
                System.out.println("CustomerDirectoryService with NIF " + NIFtoUpdate + " was not found in the database.");
                valid = true;
                customerFound = true;
            }

        } while (!valid);

    }
    public void deleteTest(ArrayList<CustomerDirectoryService> customerDirectories) {

        System.out.println("NIF of the customer you want to erase from the database: ");
        String NIFtoErase = "00000000t";
        boolean customerFound = false;

        outer:
        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (customerDirectory.getNIF().equalsIgnoreCase(NIFtoErase)) {
                    System.out.println("CustomerDirectoryService with NIF " + NIFtoErase + " has been successfully removed from the database.");
                    customerDirectories.remove(customerDirectory);
                    //per si nomes es vol borrar un client
                    //customerFound = true;
                    //break outer; // per a que no peti si nomes hi ha un client a l arraylist
                } else {
                    System.out.println("CustomerDirectoryService with NIF " + NIFtoErase + " was not found in the database.");
                }
            }
        }
    }
    public String validateEmailTest(String Email) {

        Email = "a@gmail.com";
        boolean valid = true;

        do {
            String patro = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(patro);
            Matcher matcher = pattern.matcher(Email);
            if (matcher.matches()) {
                this.setEmail(Email);
                valid = true;
            } else {
                valid = false;
                System.out.println("You have not entered a valid email, please enter a valid one: ");
                Email = "xd@xd";
            }

        } while (!valid);

        return Email;
    }
    public String validateNIFTest(String NIF) {

        boolean valid = false;
        do {

            NIF = "50289038K";
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
    public boolean validateCountryTest(String country) {
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
                country = "";
            }
        } while (!valid);
        return valid;
    }
    public boolean validateNamesTest(String name, String surname) {
        String validatedName = "";
        String validatedSurname = "";
        boolean valid = true;
        int counter = 0;

        do {

            if ((!valid) && (counter > 0)) {
                name = "Nombre";
                validatedName = "";
                surname = "Incorrecto";
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

        this.Name = validatedName;
        this.Surname = validatedSurname;
        return valid;
    }
    public String findByNIFTest(ArrayList<CustomerDirectoryService> customerDirectories) {
        NIF = "00000000";
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
        return  NIF;
    }
    public String findByEmailTest(ArrayList<CustomerDirectoryService> customerDirectories) {

        Email = "a@gmail.com";
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
        return Email;
    }
    public String findByNameTest(ArrayList<CustomerDirectoryService> customerDirectories) {

        Name = "Abde/(//l";
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (Name.equalsIgnoreCase(customerDirectory.getName())) {
                    System.out.println("The customerDirectory with the name " + customerDirectory.getName() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                    Name = customerDirectory.getName();
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with name " + Name + " was not found in the database.");
        }
        return Name;
    }
    public String findBySurnameTest(ArrayList<CustomerDirectoryService> customerDirectories) {

        Surname = "Fata/(/h";
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (Surname.equalsIgnoreCase(customerDirectory.getSurname())) {
                    System.out.println("The customerDirectory with the name " + customerDirectory.getSurname() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                    Surname = customerDirectory.getSurname();
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with surname " + Surname + " was not found in the database.");
        }
        return Surname;
    }
    public String findByCityTest(ArrayList<CustomerDirectoryService> customerDirectories) {

        City = "y";
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
        return City;
    }
    public String findByCountryTest(ArrayList<CustomerDirectoryService> customerDirectories) {

        Country = "España";
        boolean customerFound = false;

        for (CustomerDirectoryService customerDirectory : customerDirectories) {
            if (customerFound == false) {
                if (Country.equalsIgnoreCase(customerDirectory.getCity())) {
                    System.out.println("The customerDirectory with the NIF " + customerDirectory.getCountry() + " information is: ");
                    System.out.println(customerDirectory.toString());
                    customerFound = true;
                    Country = customerDirectory.getCountry();
                }
            }
        }

        if (!customerFound) {
            System.out.println("CustomerDirectoryService with country " + Country + " was not found in the database.");
        }
        return Country;
    }
 */
    }
