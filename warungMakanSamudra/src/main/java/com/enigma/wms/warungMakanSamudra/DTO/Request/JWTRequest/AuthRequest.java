package com.enigma.wms.warungMakanSamudra.DTO.Request.JWTRequest;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AuthRequest {
    private String username;
    private String password;
    private String customerName;
    private String address;
    private String mobilePhone;
    private String email;
}
