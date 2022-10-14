package dev.carlosandrade.cleanarch.application.impl;

import dev.carlosandrade.cleanarch.application.UpdateCustomerInteractor;
import dev.carlosandrade.cleanarch.application.request.UpdateCustomerRequest;
import dev.carlosandrade.cleanarch.application.response.CustomerResponse;
import dev.carlosandrade.cleanarch.domain.Customer;
import dev.carlosandrade.cleanarch.domain.exception.NotFoundException;
import dev.carlosandrade.cleanarch.domain.repository.CustomerRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UpdateCustomerInteractorImpl implements UpdateCustomerInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public UpdateCustomerInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse execute(String id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        Customer updatedCustomer = new Customer(
            customer.getId(),
            request.getName(),
            customer.getBirthDate(),
            request.getCity(),
            customer.getCpf()
        );
        customerRepository.update(updatedCustomer);
        return CustomerResponse.from(updatedCustomer);
    }

}
