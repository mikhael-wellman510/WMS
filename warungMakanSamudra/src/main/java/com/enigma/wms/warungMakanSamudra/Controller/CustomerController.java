package com.enigma.wms.warungMakanSamudra.Controller;


import com.enigma.wms.warungMakanSamudra.Constant.AppPath;
import com.enigma.wms.warungMakanSamudra.DTO.Request.CustomerRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CommonResponse.CommonResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CustomerResponse;
import com.enigma.wms.warungMakanSamudra.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.CUSTOMER)
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest){




//        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
//        System.out.println("Hasil" + customerResponse);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(CommonResponse.<CustomerResponse>builder()
//                        .statusCode(HttpStatus.CREATED.value())
//                        .message("Sukses Created Data")
//                        .data(customerResponse)
//                        .build().getData()
//                );

        return  null;
    }

}
