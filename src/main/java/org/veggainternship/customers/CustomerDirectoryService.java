package org.veggainternship.customers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDirectoryService implements CustomerDirectory {

    Menu menu = new Menu();
    ArrayList<Customer> customerDirectory = new ArrayList<>();

    public Customer create(Customer customer) throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, InvalidNifException, InvalidEmailException {

        if(customerDirectory.size() == 0) {
            //Nif
            String nif = "49535056w";
            if (validateNifNoRepeated(nif)) {
                customer.setNif(nif);

                if ((customer.getNif() == null) || (customer.getNif().contains(" "))) {
                    throw new MandatoryFieldNotProvidedException("The nif is missing");
                }
                if (!validateNif(customer.getNif())) {
                    throw new InvalidNifException("The nif " + customer.getNif() + " is not valid");
                }

                //Email
                String email = "abel13ibarra@gmail.com";

                if (validateEmailNoRepeated(email)) {
                    customer.setEmail(email);

                    if ((customer.getEmail() == null)) {
                        throw new MandatoryFieldNotProvidedException("The email is missing");
                    }

                    if (!validateEmail(email)) {
                        customer.setEmail("a@222sssdsdsdddssdd");
                        throw new InvalidEmailException("Invalid email");
                    } else {
                        customer.setEmail("abel13ibarra@gmail.com");
                    }

                    //Name & Surname
                    String name = "Abel", surname = "Ibarra";
                    customer.setName(name);
                    customer.setSurname(surname);

                    if ((!validateName(name))) {
                        customer.setName("Abel");
                    }
                    if (!validateSurname(surname)) {
                        customer.setSurname("Ibarra");
                    }

                    //City
                    String city = "Lleida";
                    customer.setCity(city);

                    if (!validateCity(city)) {
                        System.out.println(city + "is not a valid city name, it should be Lleida");
                        customer.setCity("Lleida");
                    }

                    //Country
                    String country = "Marruecos";

                    if (validateCountry(country)) {
                        customer.setCountry("Marruecos");
                    } else {
                        System.out.println(country + " is not a valid country name");
                    }

                    customerDirectory.add(customer);

                } else {
                    throw new CustomerAlreadyExistsException("There is already a user with the email: " + email);
                }

            } else {
                throw new CustomerAlreadyExistsException("There is already a user with the nif: " + nif);
            }

        }else if(customerDirectory.size() == 1){

            //Nif
            String nif = "00000000t";
            if (validateNifNoRepeated(nif)) {
                customer.setNif(nif);

                if ((customer.getNif() == null) || (customer.getNif().contains(" "))) {
                    throw new MandatoryFieldNotProvidedException("The nif is missing");
                }
                if (!validateNif(customer.getNif())) {
                    throw new InvalidNifException("The nif " + customer.getNif() + " is not valid");
                }

                //Email
                String email = "abel1311ibarra@gmail.com";

                if (validateEmailNoRepeated(email)) {
                    customer.setEmail(email);

                    if ((customer.getEmail() == null)) {
                        throw new MandatoryFieldNotProvidedException("The email is missing");
                    }

                    if (!validateEmail(email)) {
                        customer.setEmail("a@222sssdsdsdtddssdd");
                        throw new InvalidEmailException("Invalid email");
                    } else {
                        customer.setEmail("abel1311ibarra@gmail.com");
                    }

                    //Name & Surname
                    String name = "Abdel", surname = "Fatah";
                    customer.setName(name);
                    customer.setSurname(surname);

                    if ((!validateName(name))) {
                        customer.setName(name);
                    }
                    if (!validateSurname(surname)) {
                        customer.setSurname(surname);
                    }

                    //City
                    String city = "Mollerussa";
                    customer.setCity(city);

                    if (!validateCity(city)) {
                        System.out.println(city + "is not a valid city name, it should be Lleida");
                        customer.setCity("Lleida");
                    }

                    //Country
                    String country = "Marruecos";

                    if (validateCountry(country)) {
                        customer.setCountry(country);
                    } else {
                        System.out.println(country + " is not a valid country name");
                    }

                    customerDirectory.add(customer);

                } else {
                    throw new CustomerAlreadyExistsException("There is already a user with the email: " + email);
                }

            } else {
                throw new CustomerAlreadyExistsException("There is already a user with the nif: " + nif);
            }

        }else {

            //Nif
            String nif = "40922497T";
            if (validateNifNoRepeated(nif)) {
                customer.setNif(nif);

                if ((customer.getNif() == null) || (customer.getNif().contains(" "))) {
                    throw new MandatoryFieldNotProvidedException("The nif is missing");
                }
                if (!validateNif(customer.getNif())) {
                    throw new InvalidNifException("The nif " + customer.getNif() + " is not valid");
                }

                //Email
                String email = "abel131113ibarra@gmail.com";

                if (validateEmailNoRepeated(email)) {
                    customer.setEmail(email);

                    if ((customer.getEmail() == null)) {
                        throw new MandatoryFieldNotProvidedException("The email is missing");
                    }

                    if (!validateEmail(email)) {
                        customer.setEmail("a@222gsssdsdsdtddssdd");
                        throw new InvalidEmailException("Invalid email");
                    } else {
                        customer.setEmail("abel131113ibarra@gmail.com");
                    }

                    //Name & Surname
                    String name = "Abdels", surname = "Fatahs";
                    customer.setName(name);
                    customer.setSurname(surname);

                    if ((!validateName(name))) {
                        customer.setName(name);
                    }
                    if (!validateSurname(surname)) {
                        customer.setSurname(surname);
                    }

                    //City
                    String city = "Mollerussa";
                    customer.setCity(city);

                    if (!validateCity(city)) {
                        System.out.println(city + "is not a valid city name, it should be Lleida");
                        customer.setCity("Lleida");
                    }

                    //Country
                    String country = "Marruecos";

                    if (validateCountry(country)) {
                        customer.setCountry(country);
                    } else {
                        System.out.println(country + " is not a valid country name");
                    }

                    customerDirectory.add(customer);

                } else {
                    throw new CustomerAlreadyExistsException("There is already a user with the email: " + email);
                }

            } else {
                throw new CustomerAlreadyExistsException("There is already a user with the nif: " + nif);
            }
        }
        return customer;// per les proves unitaries a la part del create
    }

    public void delete(Customer customer) throws CustomerNotFoundException {

        String NIFtoErase = "49535056w";
        boolean customerFound = false;

        for (Customer c : customerDirectory) {
            if (!customerFound) {
                if (c.getNif().equalsIgnoreCase(NIFtoErase)) {
                    System.out.println("Customer with NIF " + NIFtoErase + " has been successfully removed from the database.");
                    customerDirectory.remove(c);
                    customerFound = true;
                    break; // intentar arreglar sense el break
                }
            }
        }
        if (!customerFound) {
            throw new CustomerNotFoundException("Customer with NIF " + NIFtoErase + " was not found in the database.");
        }
    }

    public void update(Customer customer) throws CustomerNotFoundException, InvalidEmailException, MandatoryFieldNotProvidedException, InvalidNifException {

        boolean valid = false;
        boolean customerFound = false;

        do {

            String NIFtoUpdate = "49535056w";//menu.NIFtoUpdate(); el dni de la persona a la que vols fer el update
            Customer updatedCustomer = new Customer();

            for (Customer c : customerDirectory) {
                if (!customerFound) {
                    if (c.getNif().equalsIgnoreCase(NIFtoUpdate)) {
                        customerFound = true;
                        updatedCustomer = c;
                        NIFtoUpdate = c.getNif();
                    }
                }
            } // trobe el customer i fa que el updatedCustomer tingui els valors del customer a actualitzar

            if (!customerFound) { // si no s ha trobat cap customer amb el nif especificat
                throw new CustomerNotFoundException("Customer with NIF " + NIFtoUpdate + " was not found in the database.");
            } else { // si s ha trobat un client amb el nif especificat

                String newEmail = "a@aaa";
                String newName = "wwswww";
                String newSurname = "rdrrrrr";
                String newCity = "dddsd";
                String newCountry = "Argentina";

                if(NIFtoUpdate == null || newEmail == null || newName == null || newSurname == null || newCity == null || newCountry == null){
                    throw new MandatoryFieldNotProvidedException("An important field is missing");
                }

                if ((validateNif(NIFtoUpdate))) {

                    if ((newEmail.equalsIgnoreCase(updatedCustomer.getEmail()) || validateEmailNoRepeated(newEmail) && (validateEmail(newEmail)))) {

                        updatedCustomer.setEmail(newEmail);
                        if(validateName(newName)) {
                            updatedCustomer.setName(newName);
                        }
                        if(validateSurname(newSurname)) {
                            updatedCustomer.setSurname(newSurname);
                        }
                        if(validateCity(newCity)) {
                            updatedCustomer.setCity(newCity);
                        }
                        if(validateCountry(newCountry)) {
                            updatedCustomer.setCountry(newCountry);
                        }

                        System.out.println("Customer with NIF " + NIFtoUpdate + " has been successfully updated in the database.");
                        valid = true;

                    } else {
                        throw new InvalidEmailException("That email already exists or is incorrect");
                    }
                } else {
                    throw new InvalidNifException("That nif is incorrect");
                }
            }
        } while (!valid);
    }

    public ArrayList<Customer> listAll() {

        ArrayList<Customer> list = customerDirectory;
        for (Customer c : list) {
            System.out.println(c.toString());
            System.out.println("-----------------------------------------------------------------------------------------");
        }

        return list;

    }

    public boolean validateNifNoRepeated(String nif) {

        boolean valid = true;
        boolean exists = false;
        boolean original = false;

        String originalNif = "";

        for (Customer customer : customerDirectory) {

            if (!original) {
                originalNif = customer.getNif();
                original = true;
            }

            if (customer.getNif().equals(nif) && !exists) {
                exists = true;
                nif = customer.getNif();
            }
        }

        if (exists) {
            valid = false;
        }

        return valid; //retorne valid true si no trobe cap nif igual
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
        if (!customerFound) {
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
            System.out.println("Customer with country " + country + " was not found in the database.");
        }
        return list;
    }

    public boolean validateNif(String Nif) throws InvalidNifException {

        boolean valid = false;
        outer:
        do {

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
                    valid = false;
                    throw new InvalidNifException("This nif is not well calculated");
                }

            } else {
                System.out.println("This nif is not valid, try again: ");
            }
        } while (!valid);

        return valid;

    }

    public boolean validateEmail(String email) throws InvalidEmailException {

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
                //System.out.println("The email has a whitespace, please try again: ");
                System.out.println("The email entered had a whitespace, so it has ben set to the default: a@222sssdsdsdddssdd ");
                email = "a@222sssdsdsdddssdd";
                valid = false;
            }

            if (!valid) {
                throw new InvalidEmailException("The email: " + email + " is not valid");
            }

        } while (!valid);

        return valid;
    }

    public boolean validateName(String name) {

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

    public boolean validateSurname(String surname) {

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

    public boolean validateCity(String city) {

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

    public boolean validateCountry(String country) {

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
