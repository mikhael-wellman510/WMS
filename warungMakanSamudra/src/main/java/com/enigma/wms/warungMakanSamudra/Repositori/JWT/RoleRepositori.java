package com.enigma.wms.warungMakanSamudra.Repositori.JWT;

import com.enigma.wms.warungMakanSamudra.Constant.JWT.ERole;
import com.enigma.wms.warungMakanSamudra.Entity.JWT.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositori extends JpaRepository<Role,String> {
    Optional <Role> findByName(ERole name);
}
