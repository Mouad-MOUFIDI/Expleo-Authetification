package ma.expleo.mappers;

import ma.expleo.domain.Permissions;
import ma.expleo.dto.PermissionsRequestDTO;
import ma.expleo.dto.PermissionsResponseDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class PermissionsMapperImpl implements PermissionsMapper {
    private final BeanFactory beanFactory;

    public PermissionsMapperImpl(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public PermissionsResponseDTO permissionsToPermissionsResponseDTO(Permissions permissions) {
        PermissionsResponseDTO permissionsResponseDTO=beanFactory.getBean(PermissionsResponseDTO.class);
        permissionsResponseDTO.setId(permissions.getId());
        permissionsResponseDTO.setNamePermission(permissions.getNamePermission());
        permissionsResponseDTO.setDescriptionPermission(permissions.getDescriptionPermission());
        permissionsResponseDTO.setActive(permissions.isActive());
        return permissionsResponseDTO;
    }

    @Override
    public Permissions permissionsRequestDTOToPermissions(PermissionsRequestDTO permissionsRequestDTO) {
        Permissions permissions=beanFactory.getBean(Permissions.class);
        permissions.setNamePermission(permissionsRequestDTO.getNamePermission());
        permissions.setDescriptionPermission(permissionsRequestDTO.getDescriptionPermission());
        permissions.setActive(permissionsRequestDTO.isActive());
        return permissions;
    }
}
