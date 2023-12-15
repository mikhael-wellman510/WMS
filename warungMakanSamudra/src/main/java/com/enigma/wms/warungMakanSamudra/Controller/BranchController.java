package com.enigma.wms.warungMakanSamudra.Controller;

import com.enigma.wms.warungMakanSamudra.Constant.AppPath;
import com.enigma.wms.warungMakanSamudra.DTO.Request.BranchRequest;
import com.enigma.wms.warungMakanSamudra.DTO.Response.BranchResponse;
import com.enigma.wms.warungMakanSamudra.DTO.Response.CommonResponse.CommonResponse;
import com.enigma.wms.warungMakanSamudra.Service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.BRANCH)
public class BranchController {

    private final BranchService branchService;

    @PostMapping(value = "/branch")
    public ResponseEntity<?> createBranch(@RequestBody BranchRequest branchRequest){

       // pakai brancg response karena di service tipe data response
        BranchResponse branchResponse = branchService.createBranch(branchRequest);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<BranchResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Branch")
                        .data(branchResponse)
                        .build()) ;


    }

    @GetMapping(value = "/branch/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable String id){

        BranchResponse branchResponse = branchService.getByIdBranch(id);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<BranchResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully getByIdbranch")
                        .data(branchResponse)
                        .build()) ;

    }

    @GetMapping(value = "/branch/all")
    public ResponseEntity<?> getBranchAll(){

        List <BranchResponse> branchResponse = branchService.getAllBranch();

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<BranchResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully getAllBranch")
                        .data(branchResponse)
                        .build()) ;

    }

    @PutMapping(value = "/branch/update")
    public ResponseEntity<?> updateBranch(@RequestBody BranchRequest branchRequest){
        BranchResponse branchResponse = branchService.updateBranch(branchRequest);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<BranchResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully Update")
                        .data(branchResponse)
                        .build()) ;

    }

    @DeleteMapping(value = "/branch/delete/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable String id){
        branchService.deleteBranch(id);
        BranchResponse br = branchService.getByIdBranch(id);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<BranchResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully Delete")
                        .data(br)
                        .build()) ;
    }



}
