package com.enigma.wms.warungMakanSamudra.Repositori;

import com.enigma.wms.warungMakanSamudra.Entity.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepositori extends JpaRepository<BillDetails,String> {
}
