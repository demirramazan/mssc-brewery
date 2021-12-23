package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID uuid);

    CustomerDto saveCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(UUID uuid, CustomerDto customerDto);

    void deleteById(UUID uuid);
}
