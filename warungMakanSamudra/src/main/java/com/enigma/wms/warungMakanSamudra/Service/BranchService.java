package com.enigma.wms.warungMakanSamudra.Service;

import com.enigma.wms.warungMakanSamudra.DTO.Request.BranchRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.BranchResponse;

import java.util.List;

public interface BranchService {

    BranchResponse createBranch(BranchRequest branchRequest);

    BranchResponse getByIdBranch(String id);

    List<BranchResponse> getAllBranch();

    BranchResponse updateBranch(BranchRequest branchRequest);

    void deleteBranch(String id);
}
