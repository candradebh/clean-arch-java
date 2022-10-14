package dev.carlosandrade.cleanarch.application.impl;

import dev.carlosandrade.cleanarch.application.DeleteCustomerInteractor;
import dev.carlosandrade.cleanarch.domain.Customer;
import dev.carlosandrade.cleanarch.domain.exception.NotFoundException;
import dev.carlosandrade.cleanarch.domain.repository.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DeleteCustomerInteractorImpl implements DeleteCustomerInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public DeleteCustomerInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void execute(String id) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        customerRepository.delete(customer);
    }

}
