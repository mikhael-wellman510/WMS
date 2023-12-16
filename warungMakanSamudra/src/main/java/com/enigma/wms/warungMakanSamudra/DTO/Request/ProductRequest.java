package com.enigma.wms.warungMakanSamudra.DTO.Request;


import com.enigma.wms.warungMakanSamudra.DTO.Response.BranchResponse;
import com.enigma.wms.warungMakanSamudra.Entity.Branch;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductRequest {

    private String productCode;
    private String productName;
    private Double price;
    // masukan branch id
    private String branch_id;

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
