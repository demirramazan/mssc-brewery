package guru.springframework.msscbrewery.web.mapper;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerToCustomerDto(CustomerDto customerDto);
}
