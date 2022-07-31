package ma.expleo.mappers;

import ma.expleo.domain.AppUserLoging;
import ma.expleo.dto.AppUserLogingRequestDTO;
import ma.expleo.dto.AppUserLogingResponseDTO;

public interface AppUserLogingMapper {
    AppUserLogingResponseDTO AppUserLogingToAppUserLogingResponseDTO(AppUserLoging appUserLoging);
    AppUserLoging AppUserLogingRequestDTOToAppUserLoging(AppUserLogingRequestDTO appUserLogingRequestDTO);
}
