package org.veggainternship.customers;

//treure el menu i donar els parametres ja fets a la part de validacio, fer les classes com estan a la interficie customerDirectory, treure el deletedCustomerDirectory,
//les validacions de dades han d anar al create, fer que el listAll torni una llista, tambe pot imprimir els customers,
//arreglar els bugs de update i delete i millorar el sistema de validacio de repetits, fer que el NIF sigui unic i no es pugui cambiar,
//a les probes unitaries fer que cada test tingui totes les dades que necessita per a ser executat, es poden fer variors asserts i probar varios metodes al mateis  @test.

public class Main {
    public static void main(String[] args) throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, InvalidNifException, InvalidEmailException {

        Menu menu = new Menu();
        boolean entrar = false;
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
                        customerDirectory.create(new Customer());
                        break;
                    case 2:
                        customerDirectory.update(customer);
                        break;
                    case 3:
                        customerDirectory.delete(customer);
                        break;
                    case 4:
                        System.out.println(customerDirectory.findByNif("49535056w"));
                        break;
                    case 5:
                        System.out.println(customerDirectory.findByEmail("abel13ibarra@gmail.com"));
                        break;
                    case 6:
                        System.out.println(customerDirectory.findByName("Cosmin"));
                        break;
                    case 7:
                        System.out.println(customerDirectory.findBySurname("Mihai"));
                        break;
                    case 8:
                        System.out.println(customerDirectory.findByCity("Mondongo"));
                        break;
                    case 9:
                        System.out.println(customerDirectory.findByCountry("España"));
                        break;
                    case 10:
                        System.out.println("Active: ");
                        System.out.println();
                        customerDirectory.listAll();
                        System.out.println();
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
