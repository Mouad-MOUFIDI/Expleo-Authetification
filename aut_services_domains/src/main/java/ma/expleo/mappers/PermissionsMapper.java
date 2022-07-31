package ma.expleo.mappers;

import ma.expleo.domain.Permissions;
import ma.expleo.dto.PermissionsRequestDTO;
import ma.expleo.dto.PermissionsResponseDTO;


public interface PermissionsMapper {
    PermissionsResponseDTO permissionsToPermissionsResponseDTO(Permissions permissions);
    Permissions permissionsRequestDTOToPermissions(PermissionsRequestDTO permissionsRequestDTO);
}
