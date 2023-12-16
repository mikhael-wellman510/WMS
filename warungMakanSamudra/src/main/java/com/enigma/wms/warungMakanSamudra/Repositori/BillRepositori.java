package com.enigma.wms.warungMakanSamudra.Repositori;


import com.enigma.wms.warungMakanSamudra.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepositori extends JpaRepository<Bill,String> {
}
