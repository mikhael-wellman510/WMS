package com.enigma.wms.warungMakanSamudra.DTO.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerRequest {

    private String id;
    private String name ;
    private String address;
    private String mobilePhone;
    private String email;
}
