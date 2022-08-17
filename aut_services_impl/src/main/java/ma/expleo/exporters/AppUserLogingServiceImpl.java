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
import org.springframework.beans.factory.BeanFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppUserLogingServiceImpl implements AppUserLogingService {
    private final CollaborateurRepository collaborateurRepository;
    private final AppUserLogingRepository appUserLogingRepository;
    private final AppUserPasswordService appUserPasswordService;
    private final AppRoleService appRoleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserLogingMapper appUserLogingMapper;
    private final BeanFactory beanFactory;

    public AppUserLogingServiceImpl(CollaborateurRepository collaborateurRepository, AppUserLogingRepository appUserLogingRepository, AppUserPasswordService appUserPasswordService, AppRoleService appRoleService, BCryptPasswordEncoder bCryptPasswordEncoder, AppUserLogingMapper appUserLogingMapper, BeanFactory beanFactory){
        this.collaborateurRepository=collaborateurRepository;
        this.appUserLogingRepository=appUserLogingRepository;
        this.appUserPasswordService=appUserPasswordService;
        this.appRoleService=appRoleService;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.appUserLogingMapper=appUserLogingMapper;
        this.beanFactory = beanFactory;
    }

    /**
     * @author Mouad MOUFIDI
     * TODO Create AppUSerLoging and saveit
     * @param appUserLogingRequestDTO
     * @return AppUserLogingResponseDTO
     */
    @Override
    public AppUserLogingResponseDTO saveAppUserLoging(AppUserLogingRequestDTO appUserLogingRequestDTO) {
        Collaborateur collaborateur=passwordConfirmationIfAppUserLoggingExist(appUserLogingRequestDTO);
        AppUserLoging appUserLoging=appUserLogingMapper.AppUserLogingRequestDTOToAppUserLoging(appUserLogingRequestDTO);
        appUserLoging.setCollaborateur(collaborateur);
        appUserLoging.setUserNameLoging(appUserLogingRequestDTO.getUserNameLoging());
//        appUserLoging.setActive(true);
        appUserLoging.setStatus(ActivationStatus.ACTIVE);
        AppUserPassword appUserPassword=createAndPopulateAppUserPassword(appUserLogingRequestDTO);
        appUserLoging.setAppUserPassword(appUserPassword);
        appUserLogingRepository.save(appUserLoging);
        collaborateur.setAppUserLoging(appUserLoging);
        appRoleService.addRoleToCollaborateur(appUserLogingRequestDTO.getUserNameLoging(), "USER");
        return appUserLogingMapper.AppUserLogingToAppUserLogingResponseDTO(appUserLoging);
    }
    /**
     * @author Mouad MOUFIDI
     * TODO Loading AppUserLoging by userNameLging
     * @param userNameLoging
     * @return AppUserLoging
     * */
    @Override
    public AppUserLoging loadUserByUsername(String userNameLoging) {
        return appUserLogingRepository.findByUserNameLoging(userNameLoging);
    }

    /**
     * @author Mouad MOUFIDI
     * TODO Checking if collaborateur exist by registrationNumber - Checking if it has an appUserLoging - And confirm password
     * @param appUserLogingRequestDTO
     * @return Collaborateur
     * */
    private Collaborateur passwordConfirmationIfAppUserLoggingExist(AppUserLogingRequestDTO appUserLogingRequestDTO){
        Collaborateur collaborateur=collaborateurRepository.findByRegistrationNumber(appUserLogingRequestDTO.getRegistrationName());
        if(collaborateur==null) throw new RuntimeException("This collaborator doesn't exist");
        if(collaborateur.getAppUserLoging()!=null) throw new RuntimeException("Account already exists");
        if(!appUserLogingRequestDTO.getPassword().equals(appUserLogingRequestDTO.getComfirmedPassword())) throw new RuntimeException("Please confirm your password");
        return collaborateur;
    }

    /**
     * @author Mouad MOUFIFI
     * TODO Create AppUserPassword and save it
     * @param appUserLogingRequestDTO
     * @return AppUserPassword
     */
    private AppUserPassword createAndPopulateAppUserPassword(AppUserLogingRequestDTO appUserLogingRequestDTO){
        AppUserPassword appUserPassword=beanFactory.getBean(AppUserPassword.class);
        appUserPassword.setPassword(bCryptPasswordEncoder.encode(appUserLogingRequestDTO.getPassword()));
        appUserPassword.setDateCreatePassword(new Date());
        if(appUserPassword.getOldPassword()==null){appUserPassword.setOldPassword(bCryptPasswordEncoder.encode(appUserLogingRequestDTO.getPassword()));}
        appUserPasswordService.saveAppUserPassword(appUserPassword);
        return appUserPassword;
    }



}
