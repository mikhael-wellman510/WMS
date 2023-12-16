package com.enigma.wms.warungMakanSamudra.Controller;


import com.enigma.wms.warungMakanSamudra.Constant.AppPath;
import com.enigma.wms.warungMakanSamudra.DTO.Request.BranchRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Request.ProductRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.BranchResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CommonResponse.CommonResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.PagingResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.ProductResponse;
import com.enigma.wms.warungMakanSamudra.Entity.Product;
import com.enigma.wms.warungMakanSamudra.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.PRODUCT)
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/product/create")
    public ResponseEntity<?> createBranch(@RequestBody ProductRequest productRequest){

        // pakai brancg response karena di service tipe data response
        ProductResponse productResponse = productService.createProduct(productRequest);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Branch")
                        .data(productResponse)
                        .build()) ;


    }

    @GetMapping(value = "/page")
    public ResponseEntity<?> getAllProduct(
            //Todo -> ini untk mengatur Query Params nya
            @RequestParam(name = "name" , required = false)String name,
            @RequestParam(name = "price" , required = false)Double maxPrice,
            //Todo -> ini untuk mengatur pagging
            @RequestParam(name = "page" , required = false , defaultValue = "0")Integer page,
            @RequestParam(name = "size" , required = false , defaultValue = "5")Integer size

    ){
        Page<ProductResponse> productResponses = productService.getAllByNameOrPrice(name,maxPrice,page,size);


        //Todo -> ini yg mau di tampilkan di halaman
        PagingResponse pagingResponse = PagingResponse.builder()
                .currentPage(page)
                .totalPage(productResponses.getTotalPages())
                .size(size)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sucsses get data")
                        .data(productResponses.getContent())
                        .paging(pagingResponse)
                        .build()
                );

    }


    @GetMapping(value = "/produkByBranchId/{branchId}")
    public ResponseEntity<?> getProdukByBranchId(@PathVariable String branchId){

        List<ProductResponse> pr =  productService.getProductByBranchId(branchId);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<ProductResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully getAllBranch")
                        .data(pr)
                        .build()) ;


    }

    @GetMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduk(@PathVariable String id) {
        boolean isDeleted = productService.deleteProduct(id);
        System.out.println(isDeleted);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CommonResponse.<ProductResponse>builder()
                            .statusCode(HttpStatus.CREATED.value())
                            .message("Successfully deleted Data")
                            .datas("ok")
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(CommonResponse.builder()
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .message("Failed to delete Data. Product not found or deletion unsuccessful.")
                            .build());
        }
    }

}
