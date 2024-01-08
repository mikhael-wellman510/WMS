package com.enigma.wms.warungMakanSamudra.exception;

import com.enigma.wms.warungMakanSamudra.DTO.Response.CommonResponse.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerCustom {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse<?>> internalServerError(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(

                CommonResponse.builder()
                        .statusCode(500)
                        .datas(null)
                        .message("Occourred error server")
                        .build()
        );
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CommonResponse<?>> notFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                CommonResponse.builder()
                        .statusCode(404)
                        .datas(null)
                        .message("Occourred error server")
                        .build()
        );
    }


}
