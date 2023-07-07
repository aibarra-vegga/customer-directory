package org.veggainternship.customers;

import java.util.ArrayList;

public interface CustomerDirectory {
    public Customer create(Customer customer);
    public void delete(ArrayList<CustomerDirectoryService> customerDirectories);
    public void update(ArrayList<CustomerDirectoryService> customerDirectories);
    public void findByNIF(ArrayList<CustomerDirectoryService> customerDirectories);
    public void findByEmail(ArrayList<CustomerDirectoryService> customerDirectories);
    public void findByName(ArrayList<CustomerDirectoryService> customerDirectories);
    public void findBySurname(ArrayList<CustomerDirectoryService> customerDirectories);
    public void findByCity(ArrayList<CustomerDirectoryService> customerDirectories);
    public void findByCountry(ArrayList<CustomerDirectoryService> customerDirectories);
    public void listAll(ArrayList<CustomerDirectoryService> customerDirectories);
    public boolean validateNoRepeated(ArrayList<CustomerDirectoryService> customerDirectories);

}
