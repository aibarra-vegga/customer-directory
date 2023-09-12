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
        assertTrue(customerTest.equals(customer));
    }

    @Test
    void deleteCustomer() throws CustomerNotFoundException {
        customerDirectory.delete(customerTest);
        activeList.remove(customerTest);
        assertFalse(activeList.contains(customerTest));
    }

    @Test
    void testUpdateCustomer() throws MandatoryFieldNotProvidedException, InvalidNifException, CustomerNotFoundException, InvalidEmailException {
        Customer updatedCustomer = new Customer("49535056w", "wwswww", "rdrrrrr", "a@aaa", "dddsd", "Argentina");
        customerDirectory.update(customerTest);
        assertTrue(updatedCustomer.equals(customerTest));
    }

    @Test
    void findNameTest() throws MandatoryFieldNotProvidedException, InvalidNifException, InvalidEmailException, CustomerAlreadyExistsException {
        Customer customerToFind = customerDirectory.create(new Customer());//Aqui al ja haber creat 2 usuaris adalt utilitze el tercer si no pete per la validacio dels usuaris no repetits
        ArrayList<Customer> customers = customerDirectory.findByName("Abdels");
        assertTrue(customers.contains(customerToFind));
    }

    @Test
    void listAllTest() {
        String list = String.valueOf(customerDirectory.listAll());
        //System.out.println(String.valueOf(customerDirectory.listAll())); per mirar que sigui correcte
        assertTrue(list.contains(customerTest.toString()) && list.contains(customerTest2.toString()));
    }

}
