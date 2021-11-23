package com.codegym.service;

import com.codegym.model.Customer;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customers;
    private static Map<Integer, Customer> customers1;

    static {

        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));

        customers1 = new HashMap<>();
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

//    public List<Customer> findByName(String name) {
//        List<Customer> customers = findAll();
//        for (int i = 0; i < customers.size(); i++) {
//            String str = customers.get(i + 1).getName();
//            if (Objects.equals(str, name)){
//                customers1.add(customers.get(i + 1));
//            }
//        }
//        return customers1;
//    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
