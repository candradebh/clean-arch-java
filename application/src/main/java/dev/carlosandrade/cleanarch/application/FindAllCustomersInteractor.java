package dev.carlosandrade.cleanarch.application;

import dev.carlosandrade.cleanarch.application.response.CustomerResponse;
import dev.carlosandrade.cleanarch.application.response.PageResponse;
import dev.carlosandrade.cleanarch.domain.PageRequest;

public interface FindAllCustomersInteractor {

    PageResponse<CustomerResponse> execute(PageRequest pageRequest);

}
