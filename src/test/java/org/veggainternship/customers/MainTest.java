package org.veggainternship.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<CustomerDirectoryService> customerDirectories = new ArrayList<>();
    CustomerDirectoryService customerDirectory1 = new CustomerDirectoryService("00000000t", "Abdel&&&/", "Fa%&%tah", "a@gmail.com", "", "españa");
    CustomerDirectoryService customerDirectory2 = new CustomerDirectoryService("49535056w", "Alfredo", "Godofredo", "b@gmail.com", "", "marruecos");
//    @Test
//    void customerTest() {
//
//        //create
//
//        customerDirectories.add(customerDirectory1);
//
//        customerDirectory1.createTest(customerDirectory1, customerDirectories);
//
//        assertEquals(customerDirectory1, customerDirectory1);
//
//        //update
//        customerDirectory1.updateTest(customerDirectories);
//        assertEquals(customerDirectory1, customerDirectory1);
//
//        customerDirectory1.deleteTest(customerDirectories);
//        assertNull(customerDirectory1);
//
//    }

    @Test
    void findNIFTest() {



        customerDirectory1.findByNIFTest(customerDirectories);
        String resultadoNIF = customerDirectory1.getNIF();
        String resultadoEmail = customerDirectory1.getEmail();
        String resultadoName = customerDirectory1.getName();
        String resultadoSurname = customerDirectory1.getSurname();
        String resultadoCity = customerDirectory1.getCity();
        String resultadoCountry = customerDirectory1.getCountry();
        assertTrue(resultadoNIF.equalsIgnoreCase(customerDirectory1.findByNIFTest(customerDirectories)));
        assertTrue(resultadoEmail.equals(customerDirectory1.findByEmailTest(customerDirectories)));
        customerDirectory1.findByEmailTest(customerDirectories);
        customerDirectory1.findByNameTest(customerDirectories);
        customerDirectory1.findBySurnameTest(customerDirectories);
        customerDirectory1.findByCityTest(customerDirectories);
        customerDirectory1.findByCountryTest(customerDirectories);

    }
    @Test
    void findEmailTest(){
        customerDirectories.add(customerDirectory1);
    }

}