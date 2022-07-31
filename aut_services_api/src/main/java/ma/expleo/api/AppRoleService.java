package ma.expleo.api;

import ma.expleo.domain.AppUserRole;
import ma.expleo.dto.AppUserRoleRequestDTO;
import ma.expleo.dto.AppUserRoleResponseDTO;

public interface AppRoleService {
    AppUserRoleResponseDTO saveAppRole(AppUserRoleRequestDTO appUserRoleRequestDTO);
    void addRoleToCollaborateur(String registrationNumber, String roleName);
    AppUserRole loadRoleByRoleName(String roleName);
}
