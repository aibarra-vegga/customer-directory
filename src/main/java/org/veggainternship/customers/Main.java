package org.veggainternship.customers;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, InvalidNifException, InvalidEmailException, CustomerNotFoundException {

        Menu menu = new Menu();
        boolean entrar = true;
        Integer option;

        CustomerDirectoryService customerDirectory = new CustomerDirectoryService();

        do {
            //per a les probes unitaries cambiar els parametres dels metodes per a que demanin les dades dle teclat per alla
            // Customer customer = new Customer();

            option = menu.optionsMenu();
            System.out.println("\n");
            switch (option) {
                case 1:
                    customerDirectory.create((new Customer(menu.nif(), menu.email(), menu.name(), menu.surname(), menu.city(), menu.country())));
                    break;
                case 2:
                    customerDirectory.update(menu.nif(), menu.email(), menu.name(), menu.surname(), menu.city(), menu.country());
                    break;
                case 3:
                    customerDirectory.delete(menu.nif());
                    break;
                case 4:
                    System.out.println(customerDirectory.findByNif(menu.NIFtoFind()));
                    break;
                case 5:
                    System.out.println(customerDirectory.findByEmail(menu.emailToFind()));
                    break;
                case 6:
                    System.out.println(customerDirectory.findByName(menu.nameToFind()));
                    break;
                case 7:
                    System.out.println(customerDirectory.findBySurname(menu.surname()));
                    break;
                case 8:
                    System.out.println(customerDirectory.findByCity(menu.cityToFind()));
                    break;
                case 9:
                    System.out.println(customerDirectory.findByCountry(menu.countryToFind()));
                    break;
                case 10:
                    System.out.println("Active: ");
                    System.out.println();
                    customerDirectory.listAll();
                    System.out.println();
                    break;
                case 11:
                    customerDirectory.create(new Customer("59379830V", "a@adsasddsda", "askdhabdsjadbsa", "sklanndska", "sajdbsajdsadsa", "dsadk"));
                    customerDirectory.create(new Customer("49535056w", "aaa", "bfhsdfbsdfbsdf", "abel13ibarra@gmail.com", "bdsbfdsbfdsbf", "bsdfb"));
                    customerDirectory.create(new Customer("98765432B", "c@csdgsdgsd", "casdghasdghas", "csdasdgasdg", "casdgcasdgcas", "casdg"));
                    customerDirectory.create(new Customer("00000000t", "d@dfsdfsdfsd", "dsfsdfsdfsdfs", "a@a", "dsfsdfsdfsdf", "dsfsdf"));
                    customerDirectory.create(new Customer("23456789D", "e@edsdgsdgds", "edsgasdgasdg", "edasdasdgas", "edasdgasdgas", "edasdg"));
                    break;
                default:
                    entrar = false;
                    break;
            }

        } while (entrar);

        System.gc();
    }
}
