package dev.carlosandrade.cleanarch.application;

import dev.carlosandrade.cleanarch.application.response.CustomerResponse;

public interface FindCustomerInteractor {

    CustomerResponse execute(String id);

}
