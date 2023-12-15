package com.enigma.wms.warungMakanSamudra.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name ="m_product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "product_code" , nullable = false,length = 100,unique = true)
    private String productCode;

    @Column(name = "product_name" , nullable = false ,length = 100, unique = true)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branchId;


    // Untuk Halaman Page (Pagination) (productPrices)
    @OneToMany(mappedBy = "productId") // nama nya harus sama keproduk price
    private List<ProductPrice> productPrices;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", branchId=" + branchId +
                '}';
    }
}
