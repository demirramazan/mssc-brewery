package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerUid}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(value = "customerUid") UUID uuid) {
        return ResponseEntity.ok(customerService.getById(uuid));
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
        CustomerDto dto = customerService.saveCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + dto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{uuid}")
    public ResponseEntity handleUpdate(@PathVariable UUID uuid, @RequestBody CustomerDto customerDto) {
        CustomerDto updateCustomerDto = customerService.updateCustomer(uuid, customerDto);
        return ResponseEntity.ok().body(updateCustomerDto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByIdCustomer(@PathVariable UUID uuid) {
        customerService.deleteById(uuid);
    }
}
