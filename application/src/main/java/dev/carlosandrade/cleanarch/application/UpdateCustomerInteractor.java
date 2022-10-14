package dev.carlosandrade.cleanarch.application;

import dev.carlosandrade.cleanarch.application.request.UpdateCustomerRequest;
import dev.carlosandrade.cleanarch.application.response.CustomerResponse;

public interface UpdateCustomerInteractor {

    CustomerResponse execute(String id, UpdateCustomerRequest request);

}
