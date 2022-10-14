package dev.carlosandrade.cleanarch.application.impl;

import dev.carlosandrade.cleanarch.application.FindCustomerInteractor;
import dev.carlosandrade.cleanarch.application.response.CustomerResponse;
import dev.carlosandrade.cleanarch.domain.Customer;
import dev.carlosandrade.cleanarch.domain.exception.NotFoundException;
import dev.carlosandrade.cleanarch.domain.repository.CustomerRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FindCustomerInteractorImpl implements FindCustomerInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public FindCustomerInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse execute(String id) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        return CustomerResponse.from(customer);
    }

}
