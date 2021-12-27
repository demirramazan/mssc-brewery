package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    private CustomerDto validCustomer;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final static String CUSTOMER_API_URI = "/api/v1/customer/";

    @BeforeEach
    public void setUp() {
        validCustomer = CustomerDto.builder().id(UUID.randomUUID())
                .name("")
                .build();
    }


    @Test
    public void getBeer() throws Exception {
        given(customerService.getById(any(UUID.class))).willReturn(validCustomer);

        mockMvc.perform(get(CUSTOMER_API_URI + validCustomer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validCustomer.getId().toString())))
                .andExpect(jsonPath("$.name", is("customer")));
    }

    @Test
    public void handlePost() throws Exception {
        CustomerDto dto = validCustomer;
        dto.setId(null);
        CustomerDto saveDto = CustomerDto.builder().id(UUID.randomUUID()).name("asd").build();
        String customerJson = objectMapper.writeValueAsString(dto);
        given(customerService.saveCustomer(any())).willReturn(saveDto);

        mockMvc.perform(post(CUSTOMER_API_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void handleUpdate() throws Exception {
        CustomerDto dto = validCustomer;
        dto.setId(null);
        String customerJson = objectMapper.writeValueAsString(dto);

        mockMvc.perform(put(CUSTOMER_API_URI + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isOk());

        then(customerService).should().updateCustomer(any(), any());
    }

}