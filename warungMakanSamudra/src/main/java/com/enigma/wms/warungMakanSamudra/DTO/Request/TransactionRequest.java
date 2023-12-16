package com.enigma.wms.warungMakanSamudra.DTO.Request;

import com.enigma.wms.warungMakanSamudra.Entity.BillDetails;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionRequest {

    private String transactionType;
    private List<BillDetailsRequest> billDetails;

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "transactionType='" + transactionType + '\'' +
                ", billDetails=" + billDetails +
                '}';
    }
}
