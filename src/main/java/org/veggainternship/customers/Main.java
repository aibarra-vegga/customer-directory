package org.veggainternship.customers;

//falta fer les probes unitaries
// i fer que quedi millor quan tornes a demanar un dni o un gmail si ja existeixen i arreglar la part de que el gmail siguin unics al update
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

        ArrayList<CustomerDirectoryService> customerDirectories = new ArrayList<>();

        do {

            CustomerDirectoryService customerDirectory = new CustomerDirectoryService();

            if (entrar) {
                option = menu.optionsMenu();
                System.out.println("\n");
                switch (option) {
                    case 1:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.create(customerDirectory,customerDirectories);
                        customerDirectories.add(customerDirectory);
                        break;
                    case 2:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.update(customerDirectories);
                        break;
                    case 3:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.delete(customerDirectories);
                        break;
                    case 4:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.findByNIF(customerDirectories);
                        break;
                    case 5:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.findByEmail(customerDirectories);
                        break;
                    case 6:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.findByName(customerDirectories);
                        break;
                    case 7:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.findBySurname(customerDirectories);
                        break;
                    case 8:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.findByCity(customerDirectories);
                        break;
                    case 9:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.findByCountry(customerDirectories);
                        break;
                    case 10:
                        customerDirectory = new CustomerDirectoryService();
                        customerDirectory.listAll(customerDirectories);
                        break;
                    default:
                        entrar = false;
                        break;
                }
            }

        } while (entrar);
    }
}