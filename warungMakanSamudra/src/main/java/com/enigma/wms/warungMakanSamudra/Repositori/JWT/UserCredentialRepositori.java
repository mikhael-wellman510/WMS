package com.enigma.wms.warungMakanSamudra.Repositori.JWT;

import com.enigma.wms.warungMakanSamudra.Entity.JWT.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepositori extends JpaRepository<UserCredential,String> {

    Optional<UserCredential> findByUsername(String username);

}
