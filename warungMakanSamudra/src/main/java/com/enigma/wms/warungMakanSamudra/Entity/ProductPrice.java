package com.enigma.wms.warungMakanSamudra.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="m_product_price")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branchId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id")
    private Product productId ;


    @Override
    public String toString() {
        return "ProductPrice{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", branchId=" + branchId +
                ", productId=" + productId +
                '}';
    }
}
