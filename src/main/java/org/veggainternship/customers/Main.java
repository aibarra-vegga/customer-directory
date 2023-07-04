package org.veggainternship.customers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        boolean entrar = false;
        entrar = menu.menuPrincipal(entrar);
        Integer option;

        ArrayList<Customer> customers = new ArrayList<>();

        do {

            //el delete va be, el create funcione pero no anyadeix mes de 1 al arraylist i el update borra les dades del customer, en tot el do while nomes tracta 1 customer
            Customer customer = new Customer();

            if (entrar) {
                option = menu.optionsMenu();

                if (option == 1) {
                    System.out.println("Has entered create user");
                    customer.create(customer);
                    //System.out.println(customer.toString());
                    customers.add(customer);
                } else if (option == 2) {
                    customer.update(customer.getNIF());
                    System.out.println(customer.toString());

                } else if (option == 3) {
                    customer.delete(customer.getNIF());
                    System.out.println(customer.toString());
                    customers.remove(customer);
                } else if (option == 4) {
                    customer.findByNIF(customer.getNIF());
                    System.out.println(customer.toString());
                }else {
                    entrar = false;
                }
                customer.listAll(customers);
            }
        } while (entrar);
    }
}