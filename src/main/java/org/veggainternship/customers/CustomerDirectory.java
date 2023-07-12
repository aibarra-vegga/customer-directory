package org.veggainternship.customers;

import java.util.ArrayList;

public interface CustomerDirectory {
    public Customer create(Customer customer);
    public void delete(Customer customer);
    public void update(Customer customer);
    public Customer findByNIF();
    public Customer findByEmail();
    public Customer findByName();
    public Customer findBySurname();
    public Customer findByCity();
    public Customer findByCountry();
    public String listAll();
    public String listAllDeleted();
    public boolean validateNifNoRepeated(String nif);
    public boolean validateEmailNoRepeated(String email);

}
