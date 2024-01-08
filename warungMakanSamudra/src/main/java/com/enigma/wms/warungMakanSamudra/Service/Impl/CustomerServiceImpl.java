package com.enigma.wms.warungMakanSamudra.Service.Impl;

import com.enigma.wms.warungMakanSamudra.DTO.Request.CustomerRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CustomerResponse;
import com.enigma.wms.warungMakanSamudra.Entity.Customer;
import com.enigma.wms.warungMakanSamudra.Repositori.CustomerRepositori;
import com.enigma.wms.warungMakanSamudra.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositori customerRepositori;

    @Override
    public CustomerResponse createCustomer(Customer request) {


      Customer customer =   customerRepositori.save(request);

        System.out.println("customer service : " + customer);
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .mobilePhone(customer.getMobilePhone())
                .build();
    }

    @Override
    public List<CustomerResponse> getAllCustomer(CustomerRequest customerRequest) {
        return null;
    }
}
