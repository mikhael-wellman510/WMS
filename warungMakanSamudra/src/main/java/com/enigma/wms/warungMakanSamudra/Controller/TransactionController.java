package com.enigma.wms.warungMakanSamudra.Controller;

import com.enigma.wms.warungMakanSamudra.Constant.AppPath;
import com.enigma.wms.warungMakanSamudra.DTO.Request.TransactionRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CommonResponse.CommonResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.ProductResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.TransactionResponse;
import com.enigma.wms.warungMakanSamudra.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.TRANSACTION)
public class TransactionController {
        private final TransactionService transactionService;

        @PostMapping(value = "/transaction")
        public ResponseEntity<?> createTransaction(@RequestBody TransactionRequest transactionRequest){
            TransactionResponse transactionResponse= transactionService.createTransaction(transactionRequest);

            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body(CommonResponse.<TransactionResponse>builder()
                            .statusCode(HttpStatus.CREATED.value())
                            .message("Successfully crated new Branch")
                            .data(transactionResponse)
                            .build()) ;


        }

}
