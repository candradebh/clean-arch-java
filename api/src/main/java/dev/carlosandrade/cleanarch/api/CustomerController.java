package dev.carlosandrade.cleanarch.api;

import dev.carlosandrade.cleanarch.application.*;
import dev.carlosandrade.cleanarch.application.request.CreateCustomerRequest;
import dev.carlosandrade.cleanarch.application.request.UpdateCustomerRequest;
import dev.carlosandrade.cleanarch.application.response.CustomerResponse;
import dev.carlosandrade.cleanarch.application.response.PageResponse;
import dev.carlosandrade.cleanarch.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CreateCustomerInteractor createCustomerInteractor;
    private DeleteCustomerInteractor deleteCustomerInteractor;
    private FindAllCustomersInteractor findAllCustomersInteractor;
    private FindCustomerInteractor findCustomerInteractor;
    private UpdateCustomerInteractor updateCustomerInteractor;

    public CustomerController(
        CreateCustomerInteractor createCustomerInteractor,
        DeleteCustomerInteractor deleteCustomerInteractor,
        FindAllCustomersInteractor findAllCustomersInteractor,
        FindCustomerInteractor findCustomerInteractor,
        UpdateCustomerInteractor updateCustomerInteractor
    ) {
        this.createCustomerInteractor = createCustomerInteractor;
        this.deleteCustomerInteractor = deleteCustomerInteractor;
        this.findAllCustomersInteractor = findAllCustomersInteractor;
        this.findCustomerInteractor = findCustomerInteractor;
        this.updateCustomerInteractor = updateCustomerInteractor;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CreateCustomerRequest request) {
        return this.createCustomerInteractor.execute(request);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        this.deleteCustomerInteractor.execute(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<CustomerResponse> find(PageRequest pageRequest) {
        return findAllCustomersInteractor.execute(pageRequest);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse find(@PathVariable("id") String id) {
        return this.findCustomerInteractor.execute(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable("id") String id, @RequestBody UpdateCustomerRequest request) {
        return this.updateCustomerInteractor.execute(id, request);
    }

}
