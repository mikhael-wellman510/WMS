package com.enigma.wms.warungMakanSamudra.Repositori;

import com.enigma.wms.warungMakanSamudra.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositori extends JpaRepository<Customer,String> {
}
