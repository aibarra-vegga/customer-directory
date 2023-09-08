package org.veggainternship.customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerDirectory {

    Customer create(Customer customer) throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, InvalidNifException, InvalidEmailException;

    Optional<Customer> findByNif(String nif);

    Optional<Customer> findByEmail(String email);

    List<Customer> findByName(String name);

    List<Customer> findBySurname(String surname);

    List<Customer> findByCity(String city);

    List<Customer> findByCountry(String country);

    void delete(Customer c);// throws CustomerNotFoundException;

    void update(Customer c);// throws CustomerNotFoundException, InvalidEmailException, MandatoryFieldNotProvidedException;

    public ArrayList<Customer> listAll();

    public boolean validateNifNoRepeated(String nif);

    public boolean validateEmailNoRepeated(String email);

}
