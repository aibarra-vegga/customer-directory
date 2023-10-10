package org.veggainternship.customers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDirectoryService implements CustomerDirectory {

    ArrayList<Customer> customerDirectory = new ArrayList<>();
    Menu menu = new Menu();

    public Customer create(Customer customer) throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException{

        if ((customer.getNif() == null) || (customer.getNif().contains(" "))) {
            throw new MandatoryFieldNotProvidedException("The nif is missing");
        }

        if (validateNifNoRepeated(customer.getNif()) || (validateEmailNoRepeated(customer.getEmail()))) {
            throw new CustomerAlreadyExistsException("There is already a user with the nif: " + customer.getNif());
        }

        if (customer.getName().equalsIgnoreCase("") || (customer.getSurname().equalsIgnoreCase("")) || (customer.getCity().equalsIgnoreCase("")) || (customer.getCountry().equalsIgnoreCase(""))) { // mirar que els camps no estiguin malament
            throw new MandatoryFieldNotProvidedException("One of the fields is missing");
        }

        customerDirectory.add(customer);

        return customer;
    }

    public void delete(String nif) throws CustomerNotFoundException { // intentar fer sense el menu

        boolean customerFound = false;

        for (Customer c : customerDirectory) {
            if (!customerFound) {
                if (c.getNif().equalsIgnoreCase(nif)) {
                    customerDirectory.remove(c);
                    System.out.println("Customer with NIF " + nif + " has been successfully removed from the database.");
                    customerFound = true;
                    break;
                }
            }
        }
        if (!customerFound) {
            throw new CustomerNotFoundException("Customer with NIF " + nif + " was not found in the database.");
        }
    }

    public void update(String nif, String email, String name, String surname, String city, String country) throws CustomerNotFoundException, CustomerAlreadyExistsException { // intentar arreglar sense el menu

        boolean customerFound = false;

        for (Customer c : customerDirectory) {
            if(c.getNif().equalsIgnoreCase(nif)){
                if (c.getEmail().equalsIgnoreCase(email)) { // per si no vol cambiar el gmail
                    c.setEmail(email);
                    c.setName(name);
                    c.setSurname(surname);
                    c.setCity(city);
                    c.setCountry(country);
                    customerFound = true;
                    break;
                } else if (!validateEmailNoRepeated(email)) {
                    c.setEmail(email);
                    c.setName(name);
                    c.setSurname(surname);
                    c.setCity(city);
                    c.setCountry(country);
                    customerFound = true;
                    break;
                } else {
                    throw new CustomerAlreadyExistsException("An user with that email already exists");
                }
            }
        }

        if (!customerFound) { // si no s ha trobat cap customer amb el nif especificat // fer que peti abans aixo que el gmail si fiques dni que no existeixen
            throw new CustomerNotFoundException("Customer with NIF " + nif + " was not found in the database.");
        }
    }

    public ArrayList<Customer> listAll() {

        ArrayList<Customer> list = customerDirectory;
        for (Customer c : customerDirectory) {
            System.out.println(c.toString());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

        return list;

    }

    public boolean validateNifNoRepeated(String nif) { // invertir els true i els false

        boolean exists = false; // torne true si existeix i false si no ha trobat cap

        for (Customer customer : customerDirectory) {
            if (this.findByNif(nif).isPresent()) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public boolean validateEmailNoRepeated(String email) {

        boolean exists = false;

        for (Customer customer : customerDirectory) {
            if (this.findByEmail(email).isPresent()) {
                exists = true;
                break;
            }
        }

        return exists; // si es false signifique que no existeix
    }

    public Optional<Customer> findByNif(String nif) { // adaptar els altres com aquest

        for (Customer customer : customerDirectory) {
            if (nif.equalsIgnoreCase(customer.getNif())) {
                return Optional.of(customer);
            }
        }

        return Optional.empty();
    }

    public Optional<Customer> findByEmail(String email) {

        for (Customer customer : customerDirectory) {
            if (email.equalsIgnoreCase(customer.getEmail())) {
                return Optional.of(customer);
            }
        }

        return Optional.empty();
    }

    public ArrayList<Customer> findByName(String name) {

        ArrayList<Customer> list = new ArrayList<>();
        boolean customerFound = false;
        for (Customer customer : customerDirectory) { // s ha de mantenir aixi per que ha de poder tornar varios customers

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

}
