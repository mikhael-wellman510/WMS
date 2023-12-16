package com.enigma.wms.warungMakanSamudra.DTO.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BillResponse {

    private String billDetailId;
    private String billId;
    private String productId;
    private String productPriceId;
    private String productCode;
    private String productName;
    private Double price;
    private BranchResponse branch;
    private Integer quantity;
    private Double totalSales;


    @Override
    public String toString() {
        return "BillResponse{" +
                "billDetailId='" + billDetailId + '\'' +
                ", billId='" + billId + '\'' +
                ", productId='" + productId + '\'' +
                ", productPriceId='" + productPriceId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", branch=" + branch +
                ", quantity=" + quantity +
                ", totalSales=" + totalSales +
                '}';
    }
}
