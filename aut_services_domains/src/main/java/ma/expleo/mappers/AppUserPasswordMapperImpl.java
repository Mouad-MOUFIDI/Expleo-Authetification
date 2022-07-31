package ma.expleo.mappers;

import ma.expleo.domain.AppUserPassword;
import ma.expleo.dto.AppUserPasswordRequestDTO;
import ma.expleo.dto.AppUserPasswordResponseDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class AppUserPasswordMapperImpl implements AppUserPasswordMapper {
    private final BeanFactory beanFactory;

    public AppUserPasswordMapperImpl(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public AppUserPasswordResponseDTO appUserPasswordToAppUserPasswordResponseDTO(AppUserPassword appUserPassword) {
        AppUserPasswordResponseDTO appUserPasswordResponseDTO=beanFactory.getBean(AppUserPasswordResponseDTO.class);
        appUserPasswordResponseDTO.setId(appUserPassword.getId());
        appUserPasswordResponseDTO.setPassword(appUserPassword.getPassword());
        appUserPasswordResponseDTO.setOldPassword(appUserPassword.getOldPassword());
        appUserPasswordResponseDTO.setDateChangePassword(appUserPassword.getDateChangePassword());
        return appUserPasswordResponseDTO;
    }

    @Override
    public AppUserPassword appUserPasswordRequestDTOToAppUserPassword(AppUserPasswordRequestDTO appUserPasswordRequestDTO) {
        AppUserPassword appUserPassword=beanFactory.getBean(AppUserPassword.class);
        appUserPassword.setPassword(appUserPasswordRequestDTO.getNewPassword());
        appUserPassword.setOldPassword(appUserPasswordRequestDTO.getOldPassword());
        return appUserPassword;
    }
}
