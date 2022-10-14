package dev.carlosandrade.cleanarch.application.impl;


import dev.carlosandrade.cleanarch.application.CreateCustomerInteractor;
import dev.carlosandrade.cleanarch.application.request.CreateCustomerRequest;
import dev.carlosandrade.cleanarch.application.response.CustomerResponse;
import dev.carlosandrade.cleanarch.domain.Customer;
import dev.carlosandrade.cleanarch.domain.exception.BusinessException;
import dev.carlosandrade.cleanarch.domain.repository.CustomerRepository;
import dev.carlosandrade.cleanarch.domain.service.CustomerScoreService;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreateCustomerInteractorImpl implements CreateCustomerInteractor {

    private CustomerRepository customerRepository;
    private CustomerScoreService customerScoreService;

    @Inject
    public CreateCustomerInteractorImpl(
        CustomerRepository customerRepository,
        CustomerScoreService customerScoreService
    ) {
        this.customerRepository = customerRepository;
        this.customerScoreService = customerScoreService;
    }

    @Override
    public CustomerResponse execute(CreateCustomerRequest request) {
        Customer customer = request.toDomain();
        if (this.customerScoreService.isApproved(customer.getCpf())) {
            return CustomerResponse.from(customerRepository.create(customer));
        } else {
            throw new BusinessException("Your cpf is not approved");
        }
    }

}
