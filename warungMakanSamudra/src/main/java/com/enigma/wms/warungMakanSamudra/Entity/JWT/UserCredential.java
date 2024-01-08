package com.enigma.wms.warungMakanSamudra.Entity.JWT;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_user_credential")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)

// Todo -> Password dan UserName
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id ") // nama field
    private Role role;

    @Override
    public String toString() {
        return "UserCredential{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
