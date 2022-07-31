package ma.expleo.exporters;

import ma.expleo.api.AppRoleService;
import ma.expleo.api.PermissionService;
import ma.expleo.domain.AppUserRole;
import ma.expleo.domain.Permissions;
import ma.expleo.dto.PermissionsRequestDTO;
import ma.expleo.dto.PermissionsResponseDTO;
import ma.expleo.mappers.PermissionsMapper;
import ma.expleo.repositories.PermissionsRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    private PermissionsRepository permissionsRepository;
    private AppRoleService appRoleService;
    private PermissionsMapper permissionsMapper;

    public PermissionServiceImpl(PermissionsRepository permissionsRepository, AppRoleService appRoleService, PermissionsMapper permissionsMapper) {
        this.permissionsRepository = permissionsRepository;
        this.appRoleService = appRoleService;
        this.permissionsMapper = permissionsMapper;
    }

    @Override
    public PermissionsResponseDTO savePermissions(PermissionsRequestDTO permissionsRequestDTO) {
        Permissions permissions=permissionsMapper.permissionsRequestDTOToPermissions(permissionsRequestDTO);
        return permissionsMapper.permissionsToPermissionsResponseDTO(permissionsRepository.save(permissions));
    }

    @Override
    public Permissions loadPerissionsByPermissionName(String permissionName) {
        return permissionsRepository.findByNamePermission(permissionName);
    }

    @Override
    public void addPermissionToRole(String roleName, String permissionName) {
        AppUserRole appRole=appRoleService.loadRoleByRoleName(roleName);
        Permissions permission=permissionsRepository.findByNamePermission(permissionName);
        appRole.getPermissions().add(permission);
    }
}
