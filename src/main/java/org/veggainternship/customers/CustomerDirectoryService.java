package org.veggainternship.customers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDirectoryService implements CustomerDirectory {

    Menu menu = new Menu();
    ArrayList<Customer> customerDirectory = new ArrayList<>();
    ArrayList<Customer> deletedCustomersDirectory = new ArrayList<>();

    public Customer create(Customer customer) {

        if ((validateNifNoRepeated(customer.getNif()) == true) && (validateEmailNoRepeated(customer.getEmail()) == true)) {
            customerDirectory.add(customer);
            System.out.println(customer.toString());
        }

        return customer;
    }

    public void delete(ArrayList<Customer> customerDirectory) {

        String NIFtoErase = menu.NIFtoErase();
        boolean customerFound = false;

        for (Customer customer : customerDirectory) {
            if (customer.getNif().equalsIgnoreCase(NIFtoErase)) {
                System.out.println("Customer with NIF " + NIFtoErase + " has been successfully removed from the database.");
                deletedCustomersDirectory.add(customer);
                customerDirectory.remove(customer);
                customerFound = true;
            }
        }
        if (!customerFound) {
            System.out.println("Customer with NIF " + NIFtoErase + " was not found in the database.");
        }
    }

    public void update(Customer customer) {

        boolean valid = false;
        do {
            String NIFtoUpdate = menu.NIFtoUpdate();
            Customer updatedCustomer = null;
            boolean customerFound = false;

            for (Customer c : customerDirectory) {
                if (!customerFound) {
                    if (c.getNif().equalsIgnoreCase(NIFtoUpdate)) {
                        customerFound = true;
                        updatedCustomer = c;
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

                        deletedCustomersDirectory.add(customer);
                        updatedCustomer.setEmail(newEmail);
                        updatedCustomer.setName(menu.name());
                        updatedCustomer.setSurname(menu.surname());
                        updatedCustomer.setCity(menu.city());
                        updatedCustomer.setCountry(menu.country());

                        customerDirectory.remove(customer);

                        customerDirectory.add(updatedCustomer);
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

    public ArrayList<Customer> findByNIF() {

        ArrayList<Customer> list = new ArrayList<>();
        String NIF = menu.NIFtoFind();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {
            if (NIF.equalsIgnoreCase(customer.getNif())) {
                customerFound = true;
                list.add(customer);
            }
        }
        return list;
    }

    public ArrayList<Customer> findByEmail() {

        ArrayList<Customer> list = new ArrayList<>();
        String email = menu.emailToFind();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (email.equalsIgnoreCase(customer.getEmail())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("CustomerDirectoryService with email " + email + " was not found in the database.");
        }
        return list;
    }

    public ArrayList<Customer> findByName() {

        ArrayList<Customer> list = new ArrayList<>();
        String name = menu.nameToFind();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (name.equalsIgnoreCase(customer.getName())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("CustomerDirectoryService with name " + name + " was not found in the database.");
        }
        return list;
    }

    public ArrayList<Customer> findBySurname() {

        ArrayList<Customer> list = new ArrayList<>();
        String surname = menu.surnameToFind();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (surname.equalsIgnoreCase(customer.getName())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("CustomerDirectoryService with surname " + surname + " was not found in the database.");
        }
        return list;
    }

    public ArrayList<Customer> findByCity() {

        ArrayList<Customer> list = new ArrayList<>();
        String city = menu.cityToFind();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) {

            if (city.equalsIgnoreCase(customer.getName())) {
                customerFound = true;
                list.add(customer);
            }

        }
        if (!customerFound) {
            System.out.println("CustomerDirectoryService with city " + city + " was not found in the database.");
        }
        return list;
    }

    public ArrayList<Customer> findByCountry() {

        ArrayList<Customer> list = new ArrayList<>();
        String country = menu.countryToFind();
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

    public String listAll() {

        String list = "";
        for (Customer customer : customerDirectory) {
            System.out.println(customer.toString());
            list += customer + "\n";
        }

        return list;
    }

    public String listAllDeleted() {

        String list = "";

        for (Customer customer : deletedCustomersDirectory) {
            System.out.println(customer.toString());
            list += customer + "\n";
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

//    public boolean validateEmailNoRepeated(){
//        boolean valid = false;
//        boolean isEmailRepeated = false;
//        for (Customer customer : customerDirectory) {
//            if (customerDirectory.getEmail().equals(customer.getEmail()) && isEmailRepeated == false) {
//                isEmailRepeated = true;
//            }
//        }
//        if (isEmailRepeated) {
//            valid = false;
//            isEmailRepeated = true;
//            System.out.println("Customer with email " + this.Email + " already exists ");
//        }
//        return valid;
//    }
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
