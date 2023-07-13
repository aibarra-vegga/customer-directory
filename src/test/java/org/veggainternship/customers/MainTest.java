package org.veggainternship.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<CustomerDirectoryService> customerDirectory = new ArrayList<>();
    Customer customer = new Customer();
    @Test
    void createCustomerTest() {

        customerDirectory(new Customer("00000000t", "abdel", "fatah", "abdel13fatah@gmail.com", "mondongo", "senegal"));
        assertEquals(customer);
    }

    @Test
    void findNIFTest() {



    }

}