package dev.carlosandrade.cleanarch.application.impl;

import dev.carlosandrade.cleanarch.application.FindAllCustomersInteractor;
import dev.carlosandrade.cleanarch.application.response.CustomerResponse;
import dev.carlosandrade.cleanarch.application.response.PageResponse;
import dev.carlosandrade.cleanarch.domain.Customer;
import dev.carlosandrade.cleanarch.domain.Page;
import dev.carlosandrade.cleanarch.domain.PageRequest;
import dev.carlosandrade.cleanarch.domain.repository.CustomerRepository;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Collectors;

@Named
public class FindAllCustomersInteractorImpl implements FindAllCustomersInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public FindAllCustomersInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PageResponse<CustomerResponse> execute(PageRequest pageRequest) {
        return convert(customerRepository.find(pageRequest));
    }

    private PageResponse<CustomerResponse> convert(Page<Customer> customers) {
        return new PageResponse<>(
            customers.getContent().stream().map(CustomerResponse::from).collect(Collectors.toList()),
            customers.getPageNumber(),
            customers.size(),
            customers.isLast(),
            customers.totalPages()
        );
    }

}
