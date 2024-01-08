package com.enigma.wms.warungMakanSamudra.Service.Impl.JWTImpl;

import com.enigma.wms.warungMakanSamudra.Entity.JWT.AppUser;
import com.enigma.wms.warungMakanSamudra.Entity.JWT.UserCredential;
import com.enigma.wms.warungMakanSamudra.Repositori.JWT.UserCredentialRepositori;
import com.enigma.wms.warungMakanSamudra.Service.JWTService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserCredentialRepositori userCredentialRepositori;
    @Override
    public AppUser loadUserByUserId(String id) {
        UserCredential userCredential = userCredentialRepositori.findById(id).orElseThrow(() -> new UsernameNotFoundException("Invalid Credential"));


        return AppUser.builder()
                .id(userCredential.getId())
                .username(userCredential.getUsername())
                .password(userCredential.getPassword())
                .role(userCredential.getRole().getName())
                .build();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredential userCredential = userCredentialRepositori.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Invalid Credential"));

        return AppUser.builder()
                .id(userCredential.getId())
                .username(userCredential.getUsername())
                .password(userCredential.getPassword())
                .role(userCredential.getRole().getName())
                .build();
    }
}

