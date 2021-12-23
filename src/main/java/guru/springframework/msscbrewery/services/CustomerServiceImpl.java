package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getById(UUID uuid) {
        return CustomerDto.builder()
                .id(uuid)
                .name("johnthomson")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public CustomerDto updateCustomer(UUID uuid, CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).name(customerDto.getName())
                .build();

    }

    @Override
    public void deleteById(UUID uuid) {
        log.info("Delete customer id=" + uuid.toString());
    }
}
