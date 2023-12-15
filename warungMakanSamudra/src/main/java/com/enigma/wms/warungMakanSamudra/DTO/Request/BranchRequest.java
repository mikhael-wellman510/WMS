package com.enigma.wms.warungMakanSamudra.DTO.Request;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BranchRequest {
    private String id;
    private String branchCode ;
    private String branchName ;
    private String address;
    private String phoneNumber;
}
