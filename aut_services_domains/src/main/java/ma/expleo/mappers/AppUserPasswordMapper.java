package ma.expleo.mappers;

import ma.expleo.domain.AppUserPassword;
import ma.expleo.dto.AppUserPasswordRequestDTO;
import ma.expleo.dto.AppUserPasswordResponseDTO;

public interface AppUserPasswordMapper {
    AppUserPasswordResponseDTO appUserPasswordToAppUserPasswordResponseDTO(AppUserPassword appUserPassword);
    AppUserPassword appUserPasswordRequestDTOToAppUserPassword(AppUserPasswordRequestDTO appUserPasswordRequestDTO);

}
