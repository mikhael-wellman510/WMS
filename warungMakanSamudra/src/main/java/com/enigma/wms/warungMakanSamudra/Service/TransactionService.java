package com.enigma.wms.warungMakanSamudra.Service;

import com.enigma.wms.warungMakanSamudra.DTO.Request.TransactionRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.TransactionResponse;

public interface TransactionService {

    TransactionResponse createTransaction(TransactionRequest transactionRequest);
    String getReceiptNumber(TransactionRequest transactionRequest);
}
