package ma.expleo.mappers;

import ma.expleo.domain.AppUserRole;
import ma.expleo.dto.AppUserRoleRequestDTO;
import ma.expleo.dto.AppUserRoleResponseDTO;

public interface AppUserRoleMapper {
    AppUserRoleResponseDTO appUserRoleToAppUserResponseDTO(AppUserRole appUserRole);
    AppUserRole appUserRoleRequestDTOToAppUserRole(AppUserRoleRequestDTO appUserRoleRequestDTO);
}
