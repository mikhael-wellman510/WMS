package com.enigma.wms.warungMakanSamudra.Entity.JWT;

import com.enigma.wms.warungMakanSamudra.Constant.JWT.ERole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_role")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private ERole name ;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }
}
