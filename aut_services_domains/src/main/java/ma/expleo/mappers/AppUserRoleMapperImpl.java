package ma.expleo.mappers;

import ma.expleo.domain.AppUserRole;
import ma.expleo.dto.AppUserRoleRequestDTO;
import ma.expleo.dto.AppUserRoleResponseDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class AppUserRoleMapperImpl implements AppUserRoleMapper {
    private final BeanFactory beanFactory;

    public AppUserRoleMapperImpl(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public AppUserRoleResponseDTO appUserRoleToAppUserResponseDTO(AppUserRole appUserRole) {
        AppUserRoleResponseDTO appUserRoleResponseDTO=beanFactory.getBean(AppUserRoleResponseDTO.class);
        appUserRoleResponseDTO.setID(appUserRole.getID());
        appUserRoleResponseDTO.setRoleName(appUserRole.getRoleName());
        appUserRoleResponseDTO.setDateCreatedRole(appUserRole.getDateCreatedRole());
        appUserRoleResponseDTO.setRoleDescription(appUserRole.getRoleDescription());
        return appUserRoleResponseDTO;
    }

    @Override
    public AppUserRole appUserRoleRequestDTOToAppUserRole(AppUserRoleRequestDTO appUserRoleRequestDTO) {
        return null;
    }
}
