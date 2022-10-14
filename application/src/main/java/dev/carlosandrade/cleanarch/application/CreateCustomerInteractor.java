package dev.carlosandrade.cleanarch.application;

import dev.carlosandrade.cleanarch.application.request.CreateCustomerRequest;
import dev.carlosandrade.cleanarch.application.response.CustomerResponse;

public interface CreateCustomerInteractor {

    CustomerResponse execute(CreateCustomerRequest request);

}
