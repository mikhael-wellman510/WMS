package com.enigma.wms.warungMakanSamudra.Service.JWTService;

import com.enigma.wms.warungMakanSamudra.DTO.Request.JWTRequest.AuthRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse.LoginResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse.RegisterResponse;

public interface AuthService {
        RegisterResponse registerCustomer(AuthRequest request);
        LoginResponse login(AuthRequest authRequest);

        RegisterResponse registerAdmin(AuthRequest authRequest);
}
