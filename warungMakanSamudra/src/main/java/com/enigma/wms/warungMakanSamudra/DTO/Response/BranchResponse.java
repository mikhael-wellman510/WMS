package com.enigma.wms.warungMakanSamudra.DTO.Response;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BranchResponse {

    private String branchId;
    private String branchCode;
    private String branchName;
    private String address;
    private String phoneNumber;

    @Override
    public String toString() {
        return "BranchResponse{" +
                "branchId='" + branchId + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", branchName='" + branchName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
