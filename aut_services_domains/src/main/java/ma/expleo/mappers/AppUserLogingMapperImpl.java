package ma.expleo.mappers;

import ma.expleo.domain.AppUserLoging;
import ma.expleo.dto.AppUserLogingRequestDTO;
import ma.expleo.dto.AppUserLogingResponseDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class AppUserLogingMapperImpl implements AppUserLogingMapper {
    private final BeanFactory beanFactory;

    public AppUserLogingMapperImpl(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public AppUserLogingResponseDTO AppUserLogingToAppUserLogingResponseDTO(AppUserLoging appUserLoging) {
        AppUserLogingResponseDTO appUserLogingResponseDTO= beanFactory.getBean(AppUserLogingResponseDTO.class);
        appUserLogingResponseDTO.setID(appUserLoging.getID());
        appUserLogingResponseDTO.setLastLogin(appUserLoging.getLastLogin());
        appUserLogingResponseDTO.setUserNameLoging(appUserLoging.getUserNameLoging());
        appUserLogingResponseDTO.setAdmin(appUserLoging.getAdmin());
        appUserLogingResponseDTO.setUserMail(appUserLoging.getUserMail());
        appUserLogingResponseDTO.setStatus(appUserLoging.getStatus());
        appUserLogingResponseDTO.setRoles(appUserLoging.getRoles());
        return appUserLogingResponseDTO;
    }

    @Override
    public AppUserLoging AppUserLogingRequestDTOToAppUserLoging(AppUserLogingRequestDTO appUserLogingRequestDTO) {
        AppUserLoging appUserLoging=beanFactory.getBean(AppUserLoging.class);
        appUserLoging.setUserNameLoging(appUserLogingRequestDTO.getUserNameLoging());
        return appUserLoging;
    }
}
