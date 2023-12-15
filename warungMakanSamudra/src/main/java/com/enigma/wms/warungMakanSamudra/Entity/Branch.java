package com.enigma.wms.warungMakanSamudra.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="m_branch")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "branch_name" ,nullable = false ,length = 100 , unique = true)
    private String branchName;

    @Column(name = "branch_code" ,nullable = false ,length = 100 , unique = true)
    private String branchCode;

    @Column(name = "address" , nullable = false , length = 100)
    private String address;

    @Column(name = "phone_number" , nullable = false , unique = true)
    private String phoneNumber;

    @Override
    public String toString() {
        return "Branch{" +
                "id='" + id + '\'' +
                ", branchName='" + branchName + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
