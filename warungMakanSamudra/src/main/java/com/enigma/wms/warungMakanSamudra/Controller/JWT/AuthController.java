package com.enigma.wms.warungMakanSamudra.Controller.JWT;

import com.enigma.wms.warungMakanSamudra.Constant.AppPath;
import com.enigma.wms.warungMakanSamudra.DTO.Request.JWTRequest.AuthRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CommonResponse.CommonResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse.LoginResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse.RegisterResponse;
import com.enigma.wms.warungMakanSamudra.Service.JWTService.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.AUTH)
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/createRegisters")
    public ResponseEntity<?> registerCustomer(@RequestBody AuthRequest authRequest){
        RegisterResponse registerResponse = authService.registerCustomer(authRequest);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<RegisterResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Account")
                        .data(registerResponse)
                        .build()) ;

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> Login(@RequestBody AuthRequest authRequest){
        LoginResponse loginResponse = authService.login(authRequest);
        System.out.println(loginResponse);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<LoginResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully Login")
                        .data(loginResponse)
                        .build()) ;
    }
}
