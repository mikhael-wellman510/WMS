package com.enigma.wms.warungMakanSamudra.Service;

import com.enigma.wms.warungMakanSamudra.DTO.Request.ProductRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getByIdProduct(String id);

    List<ProductResponse> getAllProduct();

    ProductResponse updateProduct(ProductRequest productRequest);

    Page<ProductResponse> getAllByNameOrPrice(String name , Double maxPrice ,Integer page , Integer size );

    List<ProductResponse> getProductByBranchId(String branchId);
    boolean deleteProduct(String id);
}
