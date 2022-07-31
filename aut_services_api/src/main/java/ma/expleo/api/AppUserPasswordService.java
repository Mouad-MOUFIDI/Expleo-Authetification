package ma.expleo.api;

import ma.expleo.domain.AppUserPassword;
import ma.expleo.dto.AppUserPasswordRequestDTO;
import ma.expleo.dto.AppUserPasswordResponseDTO;

public interface AppUserPasswordService {
    AppUserPassword saveAppUserPassword(AppUserPassword appUserPassword);
    AppUserPasswordResponseDTO changePassword(AppUserPasswordRequestDTO appUserPasswordRequestDTO);
}
