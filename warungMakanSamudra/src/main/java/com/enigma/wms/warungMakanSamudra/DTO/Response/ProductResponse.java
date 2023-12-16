package com.enigma.wms.warungMakanSamudra.DTO.Response;

import com.enigma.wms.warungMakanSamudra.Entity.Branch;
import com.enigma.wms.warungMakanSamudra.Entity.ProductPrice;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {

    private String productId; // aman
    private String productPriceId; // aman
    private String productCode;
    private String productName;
    private Double price;
    private BranchResponse branchResponse;


}
