package org.veggainternship.customers;

import java.util.ArrayList;

public interface CustomerDirectory {
    public Customer create(Customer customer);
    public void delete(Customer customer);
    public void update(Customer customer);
    public void findByNIF();
    public void findByEmail();
    public void findByName();
    public void findBySurname();
    public void findByCity();
    public void findByCountry();
    public String listAll();
    public boolean validateNifNoRepeated(String nif);

}
