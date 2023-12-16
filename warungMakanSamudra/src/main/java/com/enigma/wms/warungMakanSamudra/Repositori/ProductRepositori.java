package com.enigma.wms.warungMakanSamudra.Repositori;

import com.enigma.wms.warungMakanSamudra.Entity.Branch;
import com.enigma.wms.warungMakanSamudra.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositori extends JpaRepository<Product,String>, JpaSpecificationExecutor<Product> {
// Untuk search tambah params lagi

    //Todo -> tambahkan ini jika ingin mencari Produk berdasarkan Branch Id
List<Product> findAllByBranchId(Branch branch);


}
