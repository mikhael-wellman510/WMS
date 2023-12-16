package com.enigma.wms.warungMakanSamudra.Service.Impl;


import com.enigma.wms.warungMakanSamudra.Constant.TransactionType;
import com.enigma.wms.warungMakanSamudra.DTO.Request.BillDetailsRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Request.TransactionRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.BillResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.BranchResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.TransactionResponse;
import com.enigma.wms.warungMakanSamudra.Entity.*;
import com.enigma.wms.warungMakanSamudra.Repositori.BillDetailRepositori;
import com.enigma.wms.warungMakanSamudra.Repositori.BillRepositori;
import com.enigma.wms.warungMakanSamudra.Repositori.BranchRepositori;
import com.enigma.wms.warungMakanSamudra.Repositori.ProductPriceRepositori;
import com.enigma.wms.warungMakanSamudra.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final ProductPriceRepositori productPriceRepositori;
    private final BranchRepositori branchRepositori;
    private final BillRepositori billRepositori;
    private final BillDetailRepositori billDetailRepositori;
    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {

        //Todo 1 : Isi Bill Id ;
        //1. quantity (Transaction request)
        //2.receiptNumber({branchCode}-{year}-{sequenceNumber})
        //3.TransDate
        //4.TransactionType(Transaction Request)

        //Todo Create Bill


        // Todo -> get Transaction types dari Transaction Request
        String transactionTypes = transactionRequest.getTransactionType().toString();
        // dapat String
        // Todo  -> menjumlahkan TotalSales
        List <Double> hasil = new ArrayList<>();
        for (BillDetailsRequest b : transactionRequest.getBillDetails()){
           String productPriceId = b.getProductPriceId();
            ProductPrice productPrices = productPriceRepositori.findById(productPriceId).orElse(null);
            hasil.add(productPrices.getPrice());
        }
        // todo -> Menjumlahkan hasil yang di array
        Double totalPrice = hasil.stream().mapToDouble(Double::doubleValue).sum();


        // Todo -> ReceiptNumber
           String receiptNumber =  getReceiptNumber(transactionRequest);
//             System.out.println(receiptNumber);


        Bill bill = Bill.builder()
                //Jadikan enum dan cek
                .transactionType(TransactionType.valueOf(transactionTypes))
                .totalSales(totalPrice)
                .receiptNumber(receiptNumber)
                .transDate(LocalDateTime.now())
                .build();

       billRepositori.save(bill);
        // todo ========================== Create billDetail ==========================================

        List<BillResponse> billDetailResponsesResult = new ArrayList<>();


        // Todo -> !!! Wajib melakukan perulangan jika ingin mendapatkan 2 id hasil
        for (BillDetailsRequest billDetailsRequest : transactionRequest.getBillDetails()){
            String productPrice = billDetailsRequest.getProductPriceId();

            ProductPrice productPrice1 = productPriceRepositori.findById(productPrice).orElse(null);

            Integer quantitys = billDetailsRequest.getQuantity();
            Product productid = productPrice1.getProductId();
            System.out.println(productid);

            //Todo -> create bill details (Karena ada 2 product prices , jdi d looping)
            BillDetails billDetails = BillDetails.builder()
                    .quantity(quantitys)
                    .billId(bill)
                    .productPriceId(productPrice1)
                    .productId(productid)
                    .build();
        billDetailRepositori.save(billDetails);
        // Todo -> Get BrancId
            Branch branch = branchRepositori.findById(productPrice1.getBranchId().getId()).orElse(null);

        // Todo -> mapping billDetails untuk d kirim ke transaction response
       BillResponse billResponse = BillResponse.builder()
               .billDetailId(billDetails.getId())
               .billId(bill.getId())
               .productId(productid.getId())
               .productPriceId(productPrice)
               .productName(productid.getProductName())
               .price(productPrice1.getPrice())
               //Todo -> maping branch
               .branch(BranchResponse.builder()
                       .branchId(branch.getId())
                       .branchCode(branch.getBranchCode())
                       .branchName(branch.getBranchName())
                       .address(branch.getAddress())
                       .phoneNumber(branch.getPhoneNumber())
                       .build())
               .quantity(billDetails.getQuantity())
               .totalSales(totalPrice)
               .build();

            billDetailResponsesResult.add(billResponse);
        }


        return TransactionResponse.builder()
                .billId(bill.getId())
                .receiptNumber(receiptNumber)
                .transdate(bill.getTransDate())
                .transactionType(transactionTypes)
                // todo -> Ini billresponse
                .billResponses(billDetailResponsesResult)

                .build();
    }



    // Untuk urutan transaksi
    private static int transactionCounter = 0;
    @Override
    public String getReceiptNumber(TransactionRequest transactionRequest) {

//         Todo -> Get Receipt Number
        // receiptNumber({branchCode}-{year}-{sequenceNumber})

        // Todo Get Receipt Number
        //Todo -> get Branch code
        List<String> branchCoderesult = new ArrayList<>();
        for (BillDetailsRequest c : transactionRequest.getBillDetails()){

            String pr_id = c.getProductPriceId();
            ProductPrice productPrices = productPriceRepositori.findById(pr_id).orElse(null);
            branchCoderesult.add(productPrices.getBranchId().getBranchCode());

        }
        //Todo -> menyambungkan Hasil BranchCode
        String branchCode = branchCoderesult.stream().collect(Collectors.joining(""));

        //todo -> get Tanggal
       Integer tahun=  LocalDate.now().getYear();

       // Todo -> Buat Sequence Number
        transactionCounter++;
        String sequenceNumber = String.format("%04d", transactionCounter); // Format sesuai kebutuhan

        String receiptNumber = branchCode + tahun + sequenceNumber;


        //
        return receiptNumber;
    }
}
