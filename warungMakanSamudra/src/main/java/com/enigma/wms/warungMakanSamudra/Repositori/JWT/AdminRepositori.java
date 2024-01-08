package com.enigma.wms.warungMakanSamudra.Repositori.JWT;

import com.enigma.wms.warungMakanSamudra.Entity.JWT.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositori extends JpaRepository<Admin,String> {
}
