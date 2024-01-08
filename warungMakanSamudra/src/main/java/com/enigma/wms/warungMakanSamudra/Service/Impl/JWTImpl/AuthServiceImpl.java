package com.enigma.wms.warungMakanSamudra.Service.Impl.JWTImpl;

import com.auth0.jwt.JWT;
import com.enigma.wms.warungMakanSamudra.Constant.JWT.ERole;
import com.enigma.wms.warungMakanSamudra.DTO.Request.JWTRequest.AuthRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse.LoginResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.JWTResponse.RegisterResponse;
import com.enigma.wms.warungMakanSamudra.Entity.Customer;
import com.enigma.wms.warungMakanSamudra.Entity.JWT.AppUser;
import com.enigma.wms.warungMakanSamudra.Entity.JWT.Role;
import com.enigma.wms.warungMakanSamudra.Entity.JWT.UserCredential;
import com.enigma.wms.warungMakanSamudra.Repositori.JWT.UserCredentialRepositori;
import com.enigma.wms.warungMakanSamudra.SecurityJWT.JwtUtil;
import com.enigma.wms.warungMakanSamudra.Service.CustomerService;
import com.enigma.wms.warungMakanSamudra.Service.JWTService.AuthService;
import com.enigma.wms.warungMakanSamudra.Service.JWTService.RoleService;
import com.enigma.wms.warungMakanSamudra.Util.ValidationUtil;
import com.enigma.wms.warungMakanSamudra.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    // Bawaan Spring
    private final PasswordEncoder passwordEncoder;
    // Belum bikin Entity Customer
    private final RoleService roleService;
    private final UserCredentialRepositori userCredentialRepositori;
    private final ValidationUtil validationUtil;
    private final AuthenticationManager authenticationManager; // Dari FrameWork
    private final JwtUtil jwtUtil;

    private final CustomerService customerService;
    @Transactional(rollbackOn = Exception.class)
    @Override
    public RegisterResponse registerCustomer(AuthRequest authRequest) {

        try {

            // Todo -> Validation Util semua AuthRequest
            validationUtil.validate(authRequest);

            //Todo -> Buat Role
            Role role = Role.builder()
                    .name(ERole.ROLE_CUSTOMER)
                    .build();
            // Todo -> Create jika Belum ada , dan di olah di role Service
            role= roleService.getOrSave(role);

            System.out.println(role);
            // Todo -> Set Credential
            UserCredential userCredential = UserCredential.builder()
                    .username(authRequest.getUsername().toLowerCase())
                    // todo -> pasword di bcrypt pakai bawaan java
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .role(role)
                    .build();
            // Todo -> Menggunakan save&Flush untuk langsung memasukan data ke entity tanpa menunggu yg lain
            userCredentialRepositori.saveAndFlush(userCredential);

////            UserCredential userCredential1 =
//            UserCredential userCredential1 = userCredentialRepositori.findByUsername("mikhaelsssdwd1").orElseThrow(NotFoundException::new);
////            System.out.println("percobaan : " + UserCredential.);
            // Todo -> Set Customer

            Customer customer = Customer.builder()
                    .name(authRequest.getCustomerName())
                    .address(authRequest.getAddress())
                    .mobilePhone(authRequest.getMobilePhone())
                    .email(authRequest.getEmail())
                    .userCredential(userCredential)
                    .build();

            customerService.createCustomer(customer);

            return RegisterResponse.builder()
                    .username(userCredential.getUsername())
                    .role(userCredential.getRole().getName().toString())
                    .userCredential(userCredential)
                    .build();
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"UserAlreadyExist");
        }

    }

    @Override
    public LoginResponse login(AuthRequest authRequest) {

        // Todo -> Validasi Auth Request
        validationUtil.validate(authRequest);

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getUsername().toLowerCase(),
                authRequest.getPassword()
        ));

        // Todo -> supaya tidak Bad Credential
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AppUser appUser =(AppUser) authentication.getPrincipal();
        String token =jwtUtil.generateToken(appUser);

        return LoginResponse.builder()
                .token(token)
                .role(appUser.getRole().name())
                .build();
    }

    @Override
    public RegisterResponse registerAdmin(AuthRequest authRequest) {
        return null;
    }
}
