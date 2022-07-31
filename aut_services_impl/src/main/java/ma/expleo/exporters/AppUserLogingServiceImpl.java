package ma.expleo.exporters;

import ma.expleo.api.AppRoleService;
import ma.expleo.api.AppUserLogingService;
import ma.expleo.api.AppUserPasswordService;
import ma.expleo.domain.ActivationStatus;
import ma.expleo.domain.AppUserLoging;
import ma.expleo.domain.AppUserPassword;
import ma.expleo.domain.Collaborateur;
import ma.expleo.dto.AppUserLogingRequestDTO;
import ma.expleo.dto.AppUserLogingResponseDTO;
import ma.expleo.mappers.AppUserLogingMapper;
import ma.expleo.repositories.AppUserLogingRepository;
import ma.expleo.repositories.CollaborateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserLogingServiceImpl implements AppUserLogingService {
    private CollaborateurRepository collaborateurRepository;
    private AppUserLogingRepository appUserLogingRepository;
    private AppUserPasswordService appUserPasswordService;
    private AppRoleService appRoleService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AppUserLogingMapper appUserLogingMapper;

    public AppUserLogingServiceImpl(CollaborateurRepository collaborateurRepository,AppUserLogingRepository appUserLogingRepository, AppUserPasswordService appUserPasswordService,AppRoleService appRoleService, BCryptPasswordEncoder bCryptPasswordEncoder,AppUserLogingMapper appUserLogingMapper){
        this.collaborateurRepository=collaborateurRepository;
        this.appUserLogingRepository=appUserLogingRepository;
        this.appUserPasswordService=appUserPasswordService;
        this.appRoleService=appRoleService;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.appUserLogingMapper=appUserLogingMapper;
    }

    @Override
    public AppUserLogingResponseDTO saveAppUserLoging(AppUserLogingRequestDTO appUserLogingRequestDTO) {
        //        AppUserLoging user=appUserLogingRepository.findByUserNameLoging(userNameLoging);
        Collaborateur collaborateur=collaborateurRepository.findByRegistrationNumber(appUserLogingRequestDTO.getRegistrationName());
//        AppUserLoging account = collaborateur.getAppUserLoging();
        if(collaborateur==null) throw new RuntimeException("This collaborator doesn't exist");
        if(collaborateur.getAppUserLoging()!=null) throw new RuntimeException("Account already exists");
        if(!appUserLogingRequestDTO.getPassword().equals(appUserLogingRequestDTO.getComfirmedPassword())) throw new RuntimeException("Please confirm your password");
        AppUserLoging appUserLoging=appUserLogingMapper.AppUserLogingRequestDTOToAppUserLoging(appUserLogingRequestDTO);
        appUserLoging.setCollaborateur(collaborateur);
        appUserLoging.setUserNameLogging(appUserLogingRequestDTO.getUserNameLoging());
//        appUserLoging.setActive(true);
        appUserLoging.setStatus(ActivationStatus.ACTIVE);
        AppUserPassword appUserPassword=new AppUserPassword(bCryptPasswordEncoder.encode(appUserLogingRequestDTO.getPassword()));
        if(appUserPassword.getOldPassword()==null){appUserPassword.setOldPassword(bCryptPasswordEncoder.encode(appUserLogingRequestDTO.getPassword()));}
        appUserPasswordService.saveAppUserPassword(appUserPassword);
        appUserLoging.setAppUserPassword(appUserPassword);
//        appUserLoging.getAppUserPassword().setPassword(bCryptPasswordEncoder.encode(password));
//        appUserPasswordRepository.save(appUserLoging.getAppUserPassword());
        appUserLogingRepository.save(appUserLoging);
        collaborateur.setAppUserLoging(appUserLoging);
        appRoleService.addRoleToCollaborateur(appUserLogingRequestDTO.getUserNameLoging(), "USER");
        return appUserLogingMapper.AppUserLogingToAppUserLogingResponseDTO(appUserLoging);
    }

    @Override
    public AppUserLoging loadUserByUsername(String userNameLoging) {
        return appUserLogingRepository.findByUserNameLoging(userNameLoging);
    }
}
