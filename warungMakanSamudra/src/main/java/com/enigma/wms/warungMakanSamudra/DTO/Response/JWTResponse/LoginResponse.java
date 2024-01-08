package com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoginResponse {
    private String token;
    private String role;
}
