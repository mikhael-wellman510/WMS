package com.enigma.wms.warungMakanSamudra.Service.Impl.JWTImpl;

import com.enigma.wms.warungMakanSamudra.Entity.JWT.Role;
import com.enigma.wms.warungMakanSamudra.Repositori.JWT.RoleRepositori;
import com.enigma.wms.warungMakanSamudra.Service.JWTService.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    public final RoleRepositori repositori;
    @Override
    public Role getOrSave(Role role) {

        Optional<Role> optionalRole = repositori.findByName(role.getName());
        System.out.println(optionalRole);
        // jika ada di db di get
        if (!optionalRole.isEmpty()){
            return optionalRole.get();
        }

        return  repositori.save(role);
    }
}
