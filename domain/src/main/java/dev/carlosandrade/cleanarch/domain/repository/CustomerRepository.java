package dev.carlosandrade.cleanarch.domain.repository;

import dev.carlosandrade.cleanarch.domain.Customer;
import dev.carlosandrade.cleanarch.domain.Page;
import dev.carlosandrade.cleanarch.domain.PageRequest;

import java.util.Optional;

public interface CustomerRepository {

    Customer create(Customer customer);

    Customer update(Customer customer);

    Optional<Customer> find(String id);

    Page<Customer> find(PageRequest page);

    void delete(Customer customer);

}
