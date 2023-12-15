package com.enigma.wms.warungMakanSamudra.Service.Impl;

import com.enigma.wms.warungMakanSamudra.DTO.Request.BranchRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.BranchResponse;
import com.enigma.wms.warungMakanSamudra.Entity.Branch;
import com.enigma.wms.warungMakanSamudra.Repositori.BranchRepositori;
import com.enigma.wms.warungMakanSamudra.Service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepositori branchRepositori;

    @Override
    public BranchResponse createBranch(BranchRequest branchRequest) {
        Branch branch = Branch.builder()
                .branchName(branchRequest.getBranchName())
                .branchCode(branchRequest.getBranchCode())
                .address(branchRequest.getAddress())
                .phoneNumber(branchRequest.getPhoneNumber())
                .build();

        branchRepositori.save(branch);


        return BranchResponse.builder()
                .branchId(branch.getId())
                .branchCode(branchRequest.getBranchCode())
                .branchName(branchRequest.getBranchName())
                .address(branchRequest.getAddress())
                .phoneNumber(branchRequest.getPhoneNumber())
                .build();

    }

    @Override
    public BranchResponse getByIdBranch(String id) {
        Branch branch = branchRepositori.findById(id).orElse(null);

        System.out.println(branch);
        return BranchResponse.builder()
                .branchId(branch.getId())
                .branchCode(branch.getBranchCode())
                .branchName(branch.getBranchName())
                .address(branch.getAddress())
                .phoneNumber(branch.getPhoneNumber())
                .build();
    }

    @Override
    public List<BranchResponse> getAllBranch() {
        List<Branch> branch = branchRepositori.findAll();

        return branch.stream()
                .map(branchs -> BranchResponse.builder()
                        .branchId(branchs.getId())
                        .branchCode(branchs.getBranchCode())
                        .branchName(branchs.getBranchName())
                        .address(branchs.getAddress())
                        .phoneNumber(branchs.getPhoneNumber())
                        .build()).toList();
    }

    @Override
    public BranchResponse updateBranch(BranchRequest branchRequest) {
        BranchResponse branchResponse = getByIdBranch(branchRequest.getId());
        //Ambil entity
        Branch branch = Branch.builder()
                .id(branchRequest.getId())
                .branchName(branchRequest.getBranchName())
                .branchCode(branchRequest.getBranchCode())
                .address(branchRequest.getAddress())
                .phoneNumber(branchRequest.getPhoneNumber())
                .build();

        branchRepositori.save(branch);

        return BranchResponse.builder()
                .branchName(branch.getBranchName())
                .branchCode(branch.getBranchCode())
                .address(branch.getAddress())
                .phoneNumber(branch.getPhoneNumber())
                .build();
    }

    @Override
    public void deleteBranch(String id) {
        BranchResponse branchResponse = getByIdBranch(id);
        System.out.println(branchResponse);

        if (branchResponse.getBranchId() != null){
            System.out.println("Succes delete");
            branchRepositori.deleteById(id);
        }

    }
}
