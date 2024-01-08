package com.enigma.wms.warungMakanSamudra.Service.JWTService;

import com.enigma.wms.warungMakanSamudra.Entity.JWT.Role;

public interface RoleService {
    Role getOrSave(Role role);
}
