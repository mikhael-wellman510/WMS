package com.enigma.wms.warungMakanSamudra.Repositori;

import com.enigma.wms.warungMakanSamudra.Entity.Product;
import com.enigma.wms.warungMakanSamudra.Entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductPriceRepositori extends JpaRepository<ProductPrice,String> , JpaSpecificationExecutor<ProductPrice> {

}

