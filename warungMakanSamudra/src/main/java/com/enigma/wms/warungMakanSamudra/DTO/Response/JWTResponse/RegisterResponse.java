package com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse;


import com.enigma.wms.warungMakanSamudra.Entity.JWT.UserCredential;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegisterResponse {

    private String username;
    private String role;
    private UserCredential userCredential;
}
