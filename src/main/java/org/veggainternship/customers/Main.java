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
                        customerDirectory.delete(customerDirectory.findByNIF());
                        break;
                    case 4:
                        customerDirectory.findByNIF();
                        break;
                    case 5:
                        customerDirectory.findByEmail();
                        break;
                    case 6:
                        customerDirectory.findByName();
                        break;
                    case 7:
                        customerDirectory.findBySurname();
                        break;
                    case 8:
                        customerDirectory.findByCity();
                        break;
                    case 9:
                        customerDirectory.findByCountry();
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
                        break;
                    case 13:
                        customerDirectory.create(new Customer("49535056w", "a", "e", "s@w", "es", "marruecos"));
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
