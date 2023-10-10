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

    MainTest() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {

    }
 // ficar tots al mateix metodes
    @Test
    void createCustomer() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);
        Optional<Customer> c = this.customerDirectory.findByNif(customer.getNif());
        assertTrue(c.isPresent());
        assertTrue(c.get().equals(customer));
    }

    @Test
    void deleteCustomer() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException, CustomerNotFoundException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);
        Optional<Customer> c = this.customerDirectory.findByNif(customer.getNif());
        assertTrue(c.isPresent());
        this.customerDirectory.delete("49535056w");
        assertFalse(this.customerDirectory.findByNif("49535056w").isPresent());
    }

    @Test
    void updateCustomer() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException, CustomerNotFoundException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);
        Optional<Customer> c = this.customerDirectory.findByNif(customer.getNif()); // al fer el update i que els 2 tinguin el mateix nif, els hi fique els mateixos valors

        this.customerDirectory.update("49535056w", "Abelr", "Ibarera", "abel13ibssarra@gmail.com", "Lledsida", "Marruecos");
        System.out.println(c.toString());
        System.out.println(customer.toString());
        assertNotEquals(c, customer);
    }

    @Test
    void findCustomerByNif() throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");


        this.customerDirectory.create(customer);

        assertTrue(this.customerDirectory.findByNif("49535056W").isPresent());
        assertTrue(customer.equals(this.customerDirectory.findByNif("49535056w").get()));

    }

    @Test
    void findCustomerByEmail() throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);

        assertTrue(this.customerDirectory.findByEmail("abel13ibarra@gmail.com").isPresent());
        assertTrue(customer.equals(this.customerDirectory.findByEmail("abel13ibarra@gmail.com").get()));

    }

    @Test
    void findCustomerByName() throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, CustomerNotFoundException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);

        activeList.add(customer);
        assertTrue(activeList.equals(customerDirectory.findByName("Abel")));
    }

    @Test
    void findCustomerBySurname() throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, CustomerNotFoundException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);

        activeList.add(customer);
        assertTrue(activeList.equals(customerDirectory.findBySurname("Ibarra")));
    }

    @Test
    void findCustomerByCity() throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, CustomerNotFoundException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);

        activeList.add(customer);
        assertTrue(activeList.equals(customerDirectory.findByCity("Lleida")));
    }

    @Test
    void findCustomerByCountry() throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, CustomerNotFoundException {
        Customer customer = new Customer("49535056w", "Abel", "Ibarra", "abel13ibarra@gmail.com", "Lleida", "Marruecos");

        this.customerDirectory.create(customer);

        activeList.add(customer);
        assertTrue(activeList.equals(customerDirectory.findByCountry("Marruecos")));
    }
}
