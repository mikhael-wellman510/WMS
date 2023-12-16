package com.enigma.wms.warungMakanSamudra.DTO.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BillDetailsRequest {

    private String productPriceId;
    private Integer quantity;

    @Override
    public String toString() {
        return "BillDetailsRequest{" +
                "productPriceId='" + productPriceId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
