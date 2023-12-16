package com.enigma.wms.warungMakanSamudra.Entity;


import com.enigma.wms.warungMakanSamudra.Constant.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "m_bill")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @Column(name = "receipt_number" , nullable = false , length = 100 )
    private String receiptNumber ;

    @Column(name = "trans_date" , nullable = false)
    private LocalDateTime transDate ;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;


    @Column(name = "total_sales" , nullable = false)
    private Double totalSales;

}
