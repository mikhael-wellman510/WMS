package com.enigma.wms.warungMakanSamudra.Repositori;

import com.enigma.wms.warungMakanSamudra.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepositori extends JpaRepository<Branch,String> {

}
