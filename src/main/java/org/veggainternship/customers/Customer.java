package org.veggainternship.customers;
public class Customer {
    private String nif;
    private String name;
    private String surname;
    private String email;
    private String city;
    private String country;

    Menu menu = new Menu();

    public Customer() {

        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.city = city;
        this.country = country;

    }
    public Customer(String nif, String name, String surname, String email, String city, String country) {

        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.city = city;
        this.country = country;

    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}