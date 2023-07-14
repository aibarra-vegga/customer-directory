package org.veggainternship.customers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDirectoryService implements CustomerDirectory {

    Menu menu = new Menu();
    ArrayList<Customer> customerDirectory = new ArrayList<>();
    ArrayList<Customer> deletedCustomersDirectory = new ArrayList<>();

    public Customer create(Customer customer) {

        if ((validateNifNoRepeated(customer.getNif()) == true)) {
            customerDirectory.add(customer);
            System.out.println(customer.toString());
        }

        return customer;
    }

    public void delete(Customer customer) {

        String NIFtoErase = "00000000t";//menu.NIFtoErase();
        boolean customerFound = false;

        for (Customer c : customerDirectory) {
            if(!customerFound) {
                if (c.getNif().equalsIgnoreCase(NIFtoErase) || c.getNif().equalsIgnoreCase("00000000t")){
                    System.out.println("Customer with NIF " + NIFtoErase + " has been successfully removed from the database.");
                    deletedCustomersDirectory.add(c);
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
        Customer oldCustomer = null;
        boolean customerFound = false;
        Customer noBugCustomer = new Customer();
        deletedCustomersDirectory.add(noBugCustomer);
        do {

            String NIFtoUpdate = menu.NIFtoUpdate();
            Customer updatedCustomer = null;

            for (Customer c : customerDirectory) {
                if (!customerFound) {
                    if (c.getNif().equalsIgnoreCase(NIFtoUpdate)) {
                        customerFound = true;
                        updatedCustomer = c;
                        customer = c;
                        deletedCustomersDirectory.add(c);
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
            deletedCustomersDirectory.remove(noBugCustomer);
        } while (!valid);
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

            if (surname.equalsIgnoreCase(customer.getSurname())) {
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

}
