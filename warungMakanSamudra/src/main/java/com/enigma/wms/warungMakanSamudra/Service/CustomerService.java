package com.enigma.wms.warungMakanSamudra.Service;

import com.enigma.wms.warungMakanSamudra.DTO.Request.CustomerRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CustomerResponse;
import com.enigma.wms.warungMakanSamudra.Entity.Customer;

import java.util.List;

public interface CustomerService {

    public CustomerResponse createCustomer(Customer customer);

    public List<CustomerResponse> getAllCustomer(CustomerRequest customerRequest);
}
