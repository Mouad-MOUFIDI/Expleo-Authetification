package ma.expleo.api;

import ma.expleo.domain.AppUserLoging;
import ma.expleo.dto.AppUserLogingRequestDTO;
import ma.expleo.dto.AppUserLogingResponseDTO;

public interface AppUserLogingService {
//    AppUserLoging saveAppUserLoging(String userNameLoging, String password, String comfirmedPassword, String registrationName );
    AppUserLogingResponseDTO saveAppUserLoging(AppUserLogingRequestDTO appUserLogingRequestDTO);
    AppUserLoging loadUserByUsername(String userNameLoging);
}
