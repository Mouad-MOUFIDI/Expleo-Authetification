package ma.expleo.api;

import ma.expleo.domain.Permissions;
import ma.expleo.dto.PermissionsRequestDTO;
import ma.expleo.dto.PermissionsResponseDTO;

public interface PermissionService {
    PermissionsResponseDTO savePermissions(PermissionsRequestDTO permissionsRequestDTO);
    Permissions loadPerissionsByPermissionName(String permissionName);
    void addPermissionToRole(String roleName,String permissionName);
}
