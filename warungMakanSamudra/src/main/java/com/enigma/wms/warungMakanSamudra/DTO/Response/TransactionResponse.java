package com.enigma.wms.warungMakanSamudra.DTO.Response;


import com.enigma.wms.warungMakanSamudra.Entity.BillDetails;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionResponse {


    private String billId;
    private String receiptNumber;
    private LocalDateTime transdate;
    private String transactionType;
    // Todo -> pisahkan , karena mau menghasil kan lebih dari 1 bill response
    private List <BillResponse> billResponses;

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "billId='" + billId + '\'' +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", transdate=" + transdate +
                ", transactionType='" + transactionType + '\'' +
                ", billResponses=" + billResponses +
                '}';
    }
}
