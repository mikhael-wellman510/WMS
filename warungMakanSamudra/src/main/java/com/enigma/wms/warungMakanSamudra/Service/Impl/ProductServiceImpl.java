package com.enigma.wms.warungMakanSamudra.Service.Impl;

import com.enigma.wms.warungMakanSamudra.DTO.Request.ProductRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.BranchResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.ProductResponse;
import com.enigma.wms.warungMakanSamudra.Entity.Branch;
import com.enigma.wms.warungMakanSamudra.Entity.Product;
import com.enigma.wms.warungMakanSamudra.Entity.ProductPrice;
import com.enigma.wms.warungMakanSamudra.Repositori.BranchRepositori;
import com.enigma.wms.warungMakanSamudra.Repositori.ProductPriceRepositori;
import com.enigma.wms.warungMakanSamudra.Repositori.ProductRepositori;
import com.enigma.wms.warungMakanSamudra.Service.BranchService;
import com.enigma.wms.warungMakanSamudra.Service.ProductService;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepositori productRepositori;

    private final BranchService branchService;

    private final BranchRepositori branchRepositori;

    private final ProductPriceRepositori productPriceRepositori;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {

        // todo 1 create product
        Product product = Product.builder()
                .productCode(productRequest.getProductCode())
                .productName(productRequest.getProductName())
                .branchId(Branch.builder()
                        .id(productRequest.getBranch_id())
                        .build())
                .build();

        productRepositori.save(product);

        System.out.println(productRequest);



        // todo 2 create product price

        ProductPrice productPrice = ProductPrice.builder()
                .price(productRequest.getPrice())
                .branchId(Branch.builder()
                        .id(productRequest.getBranch_id())
                        .build())
                .productId(Product.builder()
                        .id(product.getId())
                        .build())
                .build();
        productPriceRepositori.save(productPrice);
        System.out.println("Hasil product price  : " + productPrice);
        // todo 3 Buat Branch

       BranchResponse branchResponse = branchService.getByIdBranch(productRequest.getBranch_id());
        System.out.println("Hasil branch Response : " + branchResponse);
        System.out.println("hasil price : " + productRequest.getPrice());
       return  ProductResponse.builder()
               .productId(product.getId())
               .productPriceId(productPrice.getId())
               .productCode(productRequest.getProductCode())
               .productName(productRequest.getProductName())
               .price(productRequest.getPrice())
               .branchResponse(branchResponse)
               .build();
    }


    // Paginasi


    @Override
    public Page<ProductResponse> getAllByNameOrPrice(String name, Double maxPrice, Integer page, Integer size) {
        // Pakai JPA Spesification executor di Product Repositori
        Specification<Product> specification = (root, query, criteriaBuilder) -> {
           // Todo 1 = masukan join tabel nya , dan di ambil dari Entity Product (Mapped By)
            Join<Product , ProductPrice> productPrice = root.join("productPrices");

            // Ini untuk menampung pencarian dari query params
            List<Predicate> predicates = new ArrayList<>();



            if(name != null){
              // Kirim ke predicates ,,
                // Todo 2 = ini harus sesuai dengan nama di entity
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")),"%" + name.toLowerCase() + "%"));
            }

            if (maxPrice != null){
                // Mencari harga yang sama dan kurang dari dari entity Produk Price
                predicates.add(criteriaBuilder.lessThanOrEqualTo(productPrice.get("price") , maxPrice));
            }



            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();


        };

        //Todo 3 = ini untuk Number & size (5) ukuran halaman
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> products = productRepositori.findAll(specification,pageable);

        System.out.println("ini pageable : " + pageable);

        List<ProductResponse> productResponses = new ArrayList<>();

        // Kemn
        for (Product product : products.getContent()){
            Optional<ProductPrice> productPrice = product.getProductPrices()
                    .stream()
                    .findFirst();

            if (productPrice.isEmpty()) continue;

            Branch branch = productPrice.get().getBranchId();


            productResponses.add(toProductResponse(branch,product,productPrice.get()));
        }



        return new PageImpl<>(productResponses,pageable,products.getTotalElements());
    }

    private static  ProductResponse toProductResponse(Branch branch , Product product ,ProductPrice productPrice){
         return ProductResponse.builder()
                 .productId(product.getId())
                 .productPriceId(productPrice.getId())
                 .productCode(product.getProductCode())
                 .productName(product.getProductName())
                 .price(productPrice.getPrice())
                 .branchResponse(BranchResponse.builder()
                         .branchId(branch.getId())
                         .branchCode(branch.getBranchCode())
                         .branchName(branch.getBranchName())
                         .address(branch.getAddress())
                         .phoneNumber(branch.getPhoneNumber())
                         .build())
                 .build();

    }


    @Override
    public List<ProductResponse> getProductByBranchId(String branchId) {

        Branch branch = branchRepositori.findById(branchId).orElse(null);
        List<Product> produk= productRepositori.findAllByBranchId(branch);

       List<ProductPrice>  pp = productPriceRepositori.findAll();
        System.out.println("hasil" + pp);

        System.out.println(produk);
        return produk.stream()
                .map(product -> ProductResponse.builder()

                        .productId(product.getId())

                        .productCode(product.getProductCode())
                        .productName(product.getProductName())
//                        .price(ProductPrice.)


                        .build()).toList();

    }

    @Override
    public ProductResponse getByIdProduct(String id) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return null;
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        return null;
    }


    //Todo -> pakai boolean supaya di controller bisa hasilin true/false
    @Override
    public boolean deleteProduct(String id) {
        Product p = productRepositori.findById(id).orElse(null);
        System.out.println(p);
        if (p != null){
            System.out.println("Succes Delete");
            productRepositori.deleteById(id);
            return true;
        }

        return false;
    }
}
