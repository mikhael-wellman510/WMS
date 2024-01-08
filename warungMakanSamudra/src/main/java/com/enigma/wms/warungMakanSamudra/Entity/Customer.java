package com.enigma.wms.warungMakanSamudra.Entity;

import com.enigma.wms.warungMakanSamudra.Entity.JWT.UserCredential;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="m_customer")
@Data // ini untuk membuat perubahan (sebagai setter geter)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name" ,nullable = false, length = 100)
    private String name ;

    @Column(name = "address" ,nullable = false , length = 100)
    private String address;

    @Column(name = "mobile_phone" , unique = true , length = 30)
    private String mobilePhone ;

    @Column(name = "email" , unique = true , nullable = false, length = 30)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_credential_id")
    private UserCredential userCredential;

}
