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

    Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");
    Customer customerTest = customerDirectory.create(new Customer());
    Customer customerTest2 = customerDirectory.create(new Customer());

    MainTest() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {

    }

    @Test
    void createCustomer() {
        assertTrue(customerTest.equals(customer));
    }

    @Test
    void deleteCustomer() throws CustomerNotFoundException {
        customerDirectory.delete(customerTest);
        activeList.remove(customerTest);
        assertFalse(activeList.contains(customerTest));
    }

    @Test
    void updateCustomer() throws MandatoryFieldNotProvidedException, InvalidNifException, CustomerNotFoundException, InvalidEmailException {
        Customer updatedCustomer = new Customer("49535056w", "wwswww", "rdrrrrr", "a@aaa", "dddsd", "Argentina");
        customerDirectory.update(customerTest);
        assertTrue(updatedCustomer.equals(customerTest));
    }

    @Test
    void findNif() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer());//Aqui al ja haber creat 2 usuaris adalt utilitze el tercer si no pete per la validacio dels usuaris no repetits
        Optional<Customer> customers = customerDirectory.findByNif("00000000T");
        assertTrue(customers.isPresent());
    }

    @Test
    void findEmail() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer());
        Optional<Customer> customers = customerDirectory.findByEmail("abel1311ibarra@gmail.com");
        assertTrue(customers.isPresent());
    }

    @Test
    void findName() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer());
        ArrayList<Customer> customers = customerDirectory.findByName("Abdels");
        assertTrue(customers.contains(customerToFind));
    }

    @Test
    void findSurame() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer());
        ArrayList<Customer> customers = customerDirectory.findBySurname("Fatahs");
        assertTrue(customers.contains(customerToFind));
    }

    @Test
    void findCity() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer());
        ArrayList<Customer> customers = customerDirectory.findByCity("Mollerussa");
        assertTrue(customers.contains(customerToFind));
    }

    @Test
    void findCountry() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer());
        ArrayList<Customer> customers = customerDirectory.findByCountry("Marruecos");
        assertTrue(customers.contains(customerToFind));
    }

    @Test
    void listAll() {
        String list = String.valueOf(customerDirectory.listAll());
        //System.out.println(String.valueOf(customerDirectory.listAll())); per mirar que sigui correcte
        assertTrue(list.contains(customerTest.toString()) && list.contains(customerTest2.toString()));
    }

    @Test
    void validateNif() throws InvalidNifException {
        assertTrue(customerDirectory.validateNif("49535056w"));
        assertFalse(customerDirectory.validateNif("49535056f"));
        //no es pot ficar assertFalse amb dades no valides ja que tots els metodes de validacio entren en bucle infinit
    }

    @Test
    void validateEmail() throws InvalidEmailException {
        assertTrue(customerDirectory.validateEmail("abel13ibarra@gmail.com"));
        assertFalse(customerDirectory.validateEmail("Manolito Pies de Plata"));
    }

    @Test
    void validateName() {
        assertTrue(customerDirectory.validateName("Abdel"));
        assertFalse(customerDirectory.validateName("44Ab44del44"));
    }

    @Test
    void validateSurname() {
        assertTrue(customerDirectory.validateSurname("Fatah"));
        assertFalse(customerDirectory.validateSurname("777Fata777h"));
    }

    @Test
    void validateCity(){
        assertTrue(customerDirectory.validateCity("Repampanos"));
        assertFalse(customerDirectory.validateCity("Cara44colas"));
    }

    @Test
    void validateCountry(){
        assertTrue(customerDirectory.validateCountry("Marruecos"));
        assertFalse(customerDirectory.validateCountry("Penelope22"));
    }

    @Test
    void validateNifNoRepeated() {
        customerDirectory.listAll();
        assertTrue(customerDirectory.validateNifNoRepeated("99920999Y"));
        assertFalse(customerDirectory.validateNifNoRepeated("49535056w"));
    }

    @Test
    void validateEmailNoRepeated() {
        customerDirectory.listAll();
        assertTrue(customerDirectory.validateEmailNoRepeated("a@kslslslslslsls"));
        assertFalse(customerDirectory.validateEmailNoRepeated("abel13ibarra@gmail.com"));
    }

}
