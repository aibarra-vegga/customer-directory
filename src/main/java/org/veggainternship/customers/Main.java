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

        CustomerDirectoryService customerDirectory = new CustomerDirectoryService();

        do {

            Customer customer = new Customer();

            if (entrar) {
                option = menu.optionsMenu();
                System.out.println("\n");
                switch (option) {
                    case 1:
                        customerDirectory.create(new Customer(menu.nif(), menu.name(), menu.surname(), menu.email(), menu.city(), menu.country()));
                        break;
                    case 2:
                        customerDirectory.update(customer);
                        break;
                    case 3:
                        customerDirectory.delete(customer);
                        break;
                    case 4:
                        System.out.println(customerDirectory.findByNIF());
                        break;
                    case 5:
                        System.out.println(customerDirectory.findByEmail());
                        break;
                    case 6:
                        System.out.println(customerDirectory.findByName());
                        break;
                    case 7:
                        System.out.println(customerDirectory.findBySurname());
                        break;
                    case 8:
                        System.out.println(customerDirectory.findByCity());
                        break;
                    case 9:
                        System.out.println(customerDirectory.findByCountry());
                        break;
                    case 10:
                        System.out.println("Active: ");
                        System.out.println();
                        customerDirectory.listAll();
                        System.out.println();
                        break;
                    case 11:
                        System.out.println("Deleted: ");
                        System.out.println();
                        customerDirectory.listAllDeleted();
                        System.out.println();
                        break;
                    case 12:
                        customerDirectory.create(new Customer("00000000t", "abdel", "fatah", "abdel13fatah@gmail.com", "mondongo", "senegal"));
                        customerDirectory.create(new Customer("12345678z", "cosmin", "mihai", "drthvader99@gmail.com", "mondongo", "arabia saudi"));
                        break;
                    case 13:
                        customerDirectory.create(new Customer("49535056w", "a", "e", "s@w", "es", "marruecos"));
                        customerDirectory.create(new Customer("81816780F", "ae", "ae", "s@ww", "esw", "marruecos"));
                        break;
                    default:
                        entrar = false;
                        break;
                }
            }

        } while (entrar);

        System.gc();
    }
}
