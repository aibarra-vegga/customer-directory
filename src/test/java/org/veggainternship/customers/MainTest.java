package org.veggainternship.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    CustomerDirectoryService customerDirectory = new CustomerDirectoryService();
    ArrayList<Customer> activeList = new ArrayList<>();
    ArrayList<Customer> notActiveList = new ArrayList<>();
    Customer customer = new Customer("00000000t", "abdel", "fatah", "abdel13fatah@gmail.com", "mondongo", "senegal");
    Customer customerTest = customerDirectory.create(new Customer("00000000t", "abdel", "fatah", "abdel13fatah@gmail.com", "mondongo", "senegal"));
    Customer customerTest2 = customerDirectory.create(new Customer("000000sd00t", "abdssel", "fatadh", "abdel13fffatah@gmail.com", "mondonfsgo", "senegdsaal"));
    Customer customerTest3 = customerDirectory.create(new Customer("000000s00t", "abdddel", "faasdatah", "abdel13fasstah@gmail.com", "monddfdongo", "sendsegal"));

    public void update(Customer customer) {
        boolean valid = false;
        Customer oldCustomer = null;
        boolean customerFound = false;

        do {
            String NIFtoUpdate = "00000000t";
            Customer updatedCustomer = null;

            for (Customer c : activeList) {
                if (!customerFound) {
                    if (c.getNif().equalsIgnoreCase(NIFtoUpdate)) {
                        customerFound = true;
                        updatedCustomer = c;
                        customer = c;
                        notActiveList.add(c);
                    }
                }
            }

            if (!customerFound) {
                System.out.println("Customer with NIF " + NIFtoUpdate + " was not found in the database.");
            } else {
                String newNIF = "newNif";

                if (newNIF.equalsIgnoreCase(updatedCustomer.getNif())) {
                    updatedCustomer.setNif(newNIF);
                    String newEmail = "newEmail";

                    if (newEmail.equalsIgnoreCase(updatedCustomer.getEmail())) {
                        updatedCustomer.setEmail(newEmail);
                        updatedCustomer.setName("newName");
                        updatedCustomer.setSurname("newSurname");
                        updatedCustomer.setCity("newCity");
                        updatedCustomer.setCountry("newCountry");

                        activeList.add(updatedCustomer);
                        activeList.remove(customer);

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

    @Test
    void testCreateCustomer() {
        assertTrue(customer.equals(customerTest));
    }

    @Test
    void testDeleteCustomer() {
        customerDirectory.delete(customerTest);
        notActiveList.add(customerTest);
        activeList.remove(customerTest);
        assertTrue(notActiveList.contains(customerTest) && !activeList.contains(customerTest));
    }

    @Test
    void testUpdateCustomer() {
        update(customerTest);
        Customer updatedCustomer = new Customer("newNif", "newName", "newSurname", "newEmail", "newCity", "newCountry");
        assertEquals(updatedCustomer, customerTest);
    }

    @Test
    void findNIFTest() {
        ArrayList<Customer> list = customerDirectory.findByNIF();
        assertTrue(list.contains(customerTest));
    }

    @Test
    void listAllTest() {
        String list = customerDirectory.listAll();
        assertTrue(list.contains(customerTest.toString()) && list.contains(customerTest2.toString()) && (list.contains(customerTest3.toString())));
    }
}
