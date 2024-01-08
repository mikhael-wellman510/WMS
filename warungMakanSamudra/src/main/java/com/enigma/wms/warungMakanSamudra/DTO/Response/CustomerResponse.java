package com.enigma.wms.warungMakanSamudra.DTO.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerResponse {
    private String id;
    private String name ;
    private String address;
    private String mobilePhone;
    private String email;

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
