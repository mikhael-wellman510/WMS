package com.enigma.wms.warungMakanSamudra.Entity.JWT;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "m_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name ;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "m_user_credential_id") // Nama Field Foreign key
    private UserCredential userCredential;




}
