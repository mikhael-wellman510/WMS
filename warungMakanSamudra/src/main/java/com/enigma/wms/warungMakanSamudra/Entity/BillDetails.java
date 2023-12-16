package com.enigma.wms.warungMakanSamudra.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="m_bill_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BillDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "quantity" , nullable = false)
    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "bill_id" ,nullable = false)
    private Bill billId;

    @ManyToOne
    @JoinColumn(name = "product_id" , nullable = false)
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "product_price_id" , nullable = false)
    private ProductPrice productPriceId;

    @Override
    public String toString() {
        return "BillDetails{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", billId=" + billId +
                ", productId=" + productId +
                ", productPriceId=" + productPriceId +
                '}';
    }
}
