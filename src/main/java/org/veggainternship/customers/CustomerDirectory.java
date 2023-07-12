package org.veggainternship.customers;

import java.util.ArrayList;

public interface CustomerDirectory {
    public Customer create(Customer customer);
    public void delete(Customer customer);
    public void update(Customer customer);
    public ArrayList<Customer> findByNIF();
    public ArrayList<Customer> findByEmail();
    public ArrayList<Customer> findByName();
    public ArrayList<Customer> findBySurname();
    public ArrayList<Customer> findByCity();
    public ArrayList<Customer> findByCountry();
    public String listAll();
    public String listAllDeleted();
    public boolean validateNifNoRepeated(String nif);
    public boolean validateEmailNoRepeated(String email);

}
