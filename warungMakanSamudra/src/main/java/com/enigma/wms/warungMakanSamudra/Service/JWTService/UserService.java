package com.enigma.wms.warungMakanSamudra.Service.JWTService;

import com.enigma.wms.warungMakanSamudra.Entity.JWT.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    AppUser loadUserByUserId(String id);
}
