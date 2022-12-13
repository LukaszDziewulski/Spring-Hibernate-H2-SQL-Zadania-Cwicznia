package com.example.javastartspringdatarelacjaonetomanymanytoone;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastName;
    private String address;
    @OneToMany(mappedBy = "client")
    private List<ClientOrder> orders = new ArrayList<>();

    public Client() {
    }

    public Client(String firstname, String lastName, String address) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.address = address;
    }
    public void addOrder(ClientOrder order) {
        orders.add(order);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ClientOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ClientOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
