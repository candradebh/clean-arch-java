package dev.carlosandrade.cleanarch.infrastructure.service;

import dev.carlosandrade.cleanarch.domain.service.CustomerScoreService;
import dev.carlosandrade.cleanarch.infrastructure.service.client.CustomerScoreClient;
import dev.carlosandrade.cleanarch.infrastructure.service.client.request.CustomerScoreRequest;
import dev.carlosandrade.cleanarch.infrastructure.service.client.response.CustomerScoreResponse;
import dev.carlosandrade.cleanarch.infrastructure.service.client.response.CustomerScoreStatusEnum;

import javax.inject.Named;

@Named
public class CustomerScoreClientService implements CustomerScoreService {

    private CustomerScoreClient customerScoreClient;

    public CustomerScoreClientService(CustomerScoreClient customerScoreClient) {
        this.customerScoreClient = customerScoreClient;
    }

    @Override
    public Boolean isApproved(String cpf) {
        CustomerScoreResponse response = this.customerScoreClient.queryScore(new CustomerScoreRequest(cpf));
        if(response.getStatus() == CustomerScoreStatusEnum.APPROVED) {
            return true;
        } else {
            return false;
        }
    }

}
