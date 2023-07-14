package org.veggainternship.customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerDirectory {
    void create(Customer c);// throws MandatoryFieldNotProvidedException, CustomerAlreadyExistsException, InvalidNifException, InvalidEmailException;

    Optional<Customer> findById(String id);

    Optional<Customer> findByEmail(String email);

    List<Customer> findByName(String name);

    List<Customer> findBySurname(String surname);

    List<Customer> findByCity(String city);

    List<Customer> findByCountry(String country);

    void delete(Customer c);// throws CustomerNotFoundException;

    void update(Customer c);// throws CustomerNotFoundException, InvalidEmailException, MandatoryFieldNotProvidedException;

    public String listAll();

    public String listAllDeleted();

    public boolean validateNifNoRepeated(String nif);

    public boolean validateEmailNoRepeated(String email);

}
