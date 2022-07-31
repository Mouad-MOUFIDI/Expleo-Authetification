package ma.expleo.exporters;

import ma.expleo.api.AppRoleService;
import ma.expleo.domain.AppUserRole;
import ma.expleo.domain.Collaborateur;
import ma.expleo.dto.AppUserRoleRequestDTO;
import ma.expleo.dto.AppUserRoleResponseDTO;
import ma.expleo.mappers.AppUserRoleMapper;
import ma.expleo.repositories.AppUserRoleRepository;
import ma.expleo.repositories.CollaborateurRepository;
import org.springframework.stereotype.Service;

@Service
public class AppRoleServiceImpl implements AppRoleService {
    AppUserRoleRepository appUserRoleRepository;
    CollaborateurRepository collaborateurRepository;
    AppUserRoleMapper appUserRoleMapper;


    public AppRoleServiceImpl(AppUserRoleRepository appUserRoleRepository,CollaborateurRepository collaborateurRepository,AppUserRoleMapper appUserRoleMapper){
        this.appUserRoleRepository=appUserRoleRepository;
        this.collaborateurRepository=collaborateurRepository;
        this.appUserRoleMapper=appUserRoleMapper;
    }

    @Override
    public AppUserRoleResponseDTO saveAppRole(AppUserRoleRequestDTO role) {
        AppUserRole appUserRole=appUserRoleMapper.appUserRoleRequestDTOToAppUserRole(role);
        return appUserRoleMapper.appUserRoleToAppUserResponseDTO(appUserRoleRepository.save(appUserRole));
    }

    @Override
    public void addRoleToCollaborateur(String registrationNumber, String roleName) {
        Collaborateur collaborateur=collaborateurRepository.findByRegistrationNumber(registrationNumber);
        AppUserRole appRole=appUserRoleRepository.findByRoleName(roleName);
        collaborateur.getRoles().add(appRole);
    }

    @Override
    public AppUserRole loadRoleByRoleName(String roleName) {
        return appUserRoleRepository.findByRoleName(roleName);
    }
}
