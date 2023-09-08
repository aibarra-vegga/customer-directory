package org.veggainternship.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    CustomerDirectoryService customerDirectory = new CustomerDirectoryService();
    ArrayList<Customer> activeList = new ArrayList<>();

    Customer customer = new Customer("49535056w","Abel","Ibarra","abel13ibarra@gmail.com","Lleida","Marruecos");
    Customer customerTest = customerDirectory.create(new Customer());
    Customer customerTest2 = customerDirectory.create(new Customer());

    MainTest() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {

    }

    @Test
    void createCustomer() {
        assertTrue(customerTest.equals(customer)); //per la validacio de que el nif i el gmail no estiguin repetits no passe els testos
    }

    @Test
    void deleteCustomer() {
        customerDirectory.delete(customerTest);
        activeList.remove(customerTest);
        assertFalse(activeList.contains(customerTest));
    }

    @Test
    void testUpdateCustomer() {
        //update(customerTest);
        Customer updatedCustomer = new Customer("49535056w", "wwswww", "rdrrrrr", "a@aaa", "dddsd", "Argentina");
        customerDirectory.update(customerTest);
        assertTrue(updatedCustomer.equals(customerTest));
    }

    @Test
    void findNIFTest() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer("40922497T","a","a","a@aqwww","a","España"));
        ArrayList<Customer> customers = customerDirectory.findByName("a");
        System.out.println(customers);
        System.out.println(customerToFind);
        assertTrue(customers.contains(customerToFind));
    }

    @Test
    void listAllTest() {
        String list = String.valueOf(customerDirectory.listAll());
        assertTrue(list.contains(customerTest.toString()) && list.contains(customerTest2.toString()));
    }

//    public String email() {
//
//        String email = "";
//        boolean valid = true;
//
//        do {
//
//            email = "a@###@@";
//            String patro = "^(.+)@(.+)$";
//            Pattern pattern = Pattern.compile(patro);
//            Matcher matcher = pattern.matcher(email);
//            if (!email.isBlank()) {
//                if (matcher.matches()) {
//                    email = email.replaceAll("\\s", "");
//                    valid = true;
//                } else {
//                    valid = false;
//                    System.out.println("You have not entered a valid email, please enter a valid one: ");
//                }
//            } else {
//                System.out.println("The email has a whitespace, please try again: ");
//                valid = false;
//            }
//
//        } while (!valid);
//
//        return email;
//    }
//
//    public String nif() {
//
//        String nif = "";
//        boolean valid = false;
//        outer:
//        do {
//
//            System.out.println("NIF: ");
//            nif = "23712496W";
//            String numnif = "";
//
//            if (nif.length() == 9) {
//
//                for (int i = 0; i <= 7; i++) {
//                    numnif += nif.charAt(i);
//                    if (!Character.isDigit(nif.charAt(i))) {
//
//                        valid = false;
//                        System.out.println("This nif is not correct, " + nif.charAt(i) + " is not a number");
//                        continue outer;
//
//                    }
//                }
//
//                if (Character.isAlphabetic(nif.charAt(8))) {
//                    valid = true;
//                } else {
//                    valid = false;
//                    System.out.println("Last character of the nif is not a letter");
//                }
//            } else {
//                System.out.println("This nif does not have 9 characters");
//            }
//
//            // Validación del DNI
//            if (valid) {
//
//                char lletraDNI = nif.charAt(8);
//
//                int numDNI = Integer.parseInt(numnif);
//                String DNI = "";
//                String[] lletresMaj = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
//                String[] lletresMin = {"t", "r", "w", "a", "g", "m", "y", "f", "p", "d", "x", "b", "n", "j", "z", "s", "q", "v", "h", "l", "c", "k", "e"};
//
//                int modDNI = numDNI % 23;
//                if (Character.isUpperCase(lletraDNI)) {
//                    DNI += lletresMaj[modDNI];
//                } else if (Character.isLowerCase(lletraDNI)) {
//                    DNI += lletresMin[modDNI];
//                }
//                if (lletraDNI == DNI.charAt(0)) {
//                    nif = numnif + DNI;
//                    valid = true;
//
//                } else {
//                    System.out.println("This nif is not well calculated, please try another nif: ");
//                    valid = false;
//                }
//
//            } else {
//                System.out.println("This nif is not valid, try again: ");
//            }
//        } while (!valid);
//
//        return nif;
//
//    }
//
//    public String name() {
//
//        String name = "", validatedName = "";
//        boolean valid = false;
//        int counter = 0;
//
//        do {
//            validatedName = "manolito";
//
//            for (char c : validatedName.toCharArray()) {
//
//                if (Character.isLetter(c) || c == ' ') {
//                    name += c;
//                    valid = true;
//                } else {
//                    System.out.println(c + " is not a valid character for a name ");
//                    valid = false;
//                }
//            }
//
//            if ((!valid) && (counter > 0) || name.isBlank()) {
//                System.out.println("That was an incorrect name, write a valid name: ");
//                validatedName = "";
//                name = "";
//                valid = false;
//            }
//            counter++;
//        } while (!valid);
//
//        return name;
//    }
//
//    public String surname() {
//
//        String validatedSurname = "";
//        String surname = "";
//        boolean valid = false;
//        int counter = 0;
//
//        do {
//            String input = "pies de plata";
//
//            for (char c : input.toCharArray()) {
//                if (Character.isLetter(c) || c == ' ') {
//                    surname += c;
//                    valid = true;
//                } else {
//                    System.out.println(c + " is not a valid character for a surname ");
//                    valid = false;
//                }
//            }
//            if ((!valid) && (counter > 0) || surname.isBlank()) {
//                System.out.println("That was an incorrect surname, write a valid surname: ");
//                validatedSurname = "";
//                surname = "";
//                valid = false;
//            }
//            counter++;
//        } while (!valid);
//
//        return surname;
//    }
//
//    public String city() {
//
//        boolean valid = false;
//        String city = "";
//        Locale[] locales = Locale.getAvailableLocales();
//
//        do {
//
//            boolean trobada = false;
//            city = "Lleida";
//            String validatedCity = "";
//
//            if (city.isBlank()) {
//                System.out.println("You have entered an empty name of a city, please try again: ");
//            } else {
//                for (char c : city.toCharArray()) {
//                    if (Character.isLetter(c)) {
//                        valid = true;
//                        validatedCity += c;
//                    } else {
//                        System.out.println(c + " is not a valid character for a city ");
//                        valid = false;
//                    }
//                    city = validatedCity;
//                }
//                for (Locale locale : locales) {
//
//                    if (!trobada) {
//                        if (city.equalsIgnoreCase(locale.getDisplayCountry())) {
//                            valid = false;
//                            trobada = true;
//                        } else {
//                            valid = true;
//                            trobada = false;
//                        }
//                    }
//                }
//                if (trobada) {
//                    System.out.println("That's a country ");
//                }
//                if (!valid) {
//                    System.out.println("Please try again: ");
//                }
//            }
//
//        } while (!valid);
//
//        return city;
//    }
//
//    public String country() {
//
//        String country = "";
//        boolean valid = false;
//        Locale[] locales = Locale.getAvailableLocales();
//        System.out.println("Country: ");
//
//        do {
//
//            country = "España";
//            for (Locale locale : locales) {
//                if (!valid) {
//                    if (country.equalsIgnoreCase(locale.getDisplayCountry()) && ((country != null) || (country != " "))) {
//                        valid = true;
//                        country = locale.getDisplayCountry();
//                    }
//                }
//            }
//
//            if (!valid) {
//                System.out.println("You have not entered a valid country, please try again.");
//            }
//
//        } while (!valid);
//
//        return country;
//    }

//    public String NIFtoErase() {
//
//        System.out.println("NIF of the customer you want to erase: ");
//        String NIF = "00000000t";
//
//        return NIF;
//    }
//
//    public String NIFtoUpdate() {
//
//        System.out.println("NIF of the customer you want to update: ");
//        String NIF = nif();
//
//        return NIF;
//    }
//
////    public void update(Customer customer) {
//
//        boolean valid = false;
//        boolean customerFound = false;
//
//        String NIFtoUpdate = "49535056w";
//        Customer updatedCustomer = null;
//
//        for (Customer c : activeList) {
//            if (!customerFound) {
//                if (c.getNif().equalsIgnoreCase(NIFtoUpdate)) {
//                    customerFound = true;
//                    updatedCustomer = c;
//                    customer = c;
//                }
//            }
//        }
//
//        if (!customerFound) {
//            System.out.println("Customer with NIF " + NIFtoUpdate + " was not found in the database.");
//        } else {
//            String newNIF = "newNif";
//
//            if (newNIF.equalsIgnoreCase(updatedCustomer.getNif())) {
//                updatedCustomer.setNif(newNIF);
//                String newEmail = "newEmail";
//
//                if (newEmail.equalsIgnoreCase(updatedCustomer.getEmail())) {
//                    updatedCustomer.setEmail(newEmail);
//                    updatedCustomer.setName("newName");
//                    updatedCustomer.setSurname("newSurname");
//                    updatedCustomer.setCity("newCity");
//                    updatedCustomer.setCountry("newCountry");
//
//                    activeList.add(updatedCustomer);
//                    activeList.remove(customer);
//
//                    System.out.println("Customer with NIF " + NIFtoUpdate + " has been successfully updated in the database.");
//                    valid = true;
//                } else {
//                    System.out.println("That email already exists.");
//                }
//            } else {
//                System.out.println("That NIF already exists.");
//            }
//        }
//    }
//
//    public ArrayList<Customer> findByNIF() {
//
//        ArrayList<Customer> list = new ArrayList<>();
//        String NIF = nif();
//        boolean customerFound = false;
//
//        for (Customer customer : activeList) {
//            if (NIF.equalsIgnoreCase(customer.getNif())) {
//                customerFound = true;
//                list.add(customer);
//            }
//        }
//        return list;
//    }
//
//    public ArrayList<Customer> findByEmail() {
//
//        ArrayList<Customer> list = new ArrayList<>();
//        String email = email();
//        boolean customerFound = false;
//        for (Customer customer : activeList) {
//
//            if (email.equalsIgnoreCase(customer.getEmail())) {
//                customerFound = true;
//                list.add(customer);
//            }
//
//        }
//        if (!customerFound) {
//            System.out.println("CustomerDirectoryService with email " + email + " was not found in the database.");
//        }
//        return list;
//    }
//
//    public ArrayList<Customer> findByName() {
//
//        ArrayList<Customer> list = new ArrayList<>();
//        String name = name();
//        boolean customerFound = false;
//        for (Customer customer : activeList) {
//
//            if (name.equalsIgnoreCase(customer.getName())) {
//                customerFound = true;
//                list.add(customer);
//            }
//
//        }
//        if (!customerFound) {
//            System.out.println("CustomerDirectoryService with name " + name + " was not found in the database.");
//        }
//        return list;
//    }
//
//    public ArrayList<Customer> findBySurname() {
//
//        ArrayList<Customer> list = new ArrayList<>();
//        String surname = surname();
//        boolean customerFound = false;
//        for (Customer customer : activeList) {
//
//            if (surname.equalsIgnoreCase(customer.getSurname())) {
//                customerFound = true;
//                list.add(customer);
//            }
//
//        }
//        if (!customerFound) {
//            System.out.println("CustomerDirectoryService with surname " + surname + " was not found in the database.");
//        }
//        return list;
//    }
//
//    public ArrayList<Customer> findByCity() {
//
//        ArrayList<Customer> list = new ArrayList<>();
//        String city = city();
//        boolean customerFound = false;
//        for (Customer customer : activeList) {
//            if (city.equalsIgnoreCase(customer.getName())) {
//                customerFound = true;
//                list.add(customer);
//            }
//        }
//        if (!customerFound) {
//            System.out.println("CustomerDirectoryService with city " + city + " was not found in the database.");
//        }
//        return list;
//    }
//
//    public ArrayList<Customer> findByCountry() {
//
//        ArrayList<Customer> list = new ArrayList<>();
//        String country = country();
//        boolean customerFound = false;
//        for (Customer customer : activeList) {
//
//            if (country.equalsIgnoreCase(customer.getCountry())) {
//                customerFound = true;
//                list.add(customer);
//            }
//
//        }
//        if (!customerFound) {
//            System.out.println("CustomerDirectoryService with country " + country + " was not found in the database.");
//        }
//        return list;
//    }
}
