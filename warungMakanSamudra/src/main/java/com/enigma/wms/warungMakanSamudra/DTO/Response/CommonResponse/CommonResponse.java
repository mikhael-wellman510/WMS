package com.enigma.wms.warungMakanSamudra.DTO.Response.CommonResponse;


import com.enigma.wms.warungMakanSamudra.DTO.Response.PagingResponse;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
// Nnti tambahkan untuk pagination
public class CommonResponse<T>{

    private Integer statusCode ;
    private String message;
    private T data;
    private PagingResponse paging;

}
