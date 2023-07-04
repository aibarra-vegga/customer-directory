package org.veggainternship.customers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        boolean entrar = false;
        //entrar = menu.menuPrincipal(entrar);
        entrar = true;
        Integer option;

        ArrayList<Customer> customers = new ArrayList<>();

        do {

            Customer customer = new Customer();

            if (entrar) {
                option = menu.optionsMenu();

                if (option == 1) {
                    customer.create(customer);
                    customers.add(customer);
                } else if (option == 2) {
                    customer.update(customers);
                } else if (option == 3) {
                    customer.delete(customers);
                } else if (option == 4) {
                    customer.findByNIF(customers);
                }else if (option == 5) {
                    customer.findByEmail(customers);
                }else if (option == 6) {
                    customer.findByName(customers);
                }else if (option == 7) {
                    customer.findBySurname(customers);
                }else if (option == 8) {
                    customer.findByCity(customers);
                }else if (option == 9) {
                    customer.findByCountry(customers);
                }else if (option == 10) {
                    customer.listAll(customers);
                }else {
                    entrar = false;
                }
            }
        } while (entrar);
    }
}