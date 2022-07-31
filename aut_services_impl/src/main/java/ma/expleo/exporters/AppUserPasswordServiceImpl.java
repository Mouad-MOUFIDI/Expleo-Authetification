package ma.expleo.exporters;

import ma.expleo.api.AppUserLogingService;
import ma.expleo.api.AppUserPasswordService;
import ma.expleo.domain.AppUserLoging;
import ma.expleo.domain.AppUserPassword;
import ma.expleo.dto.AppUserPasswordRequestDTO;
import ma.expleo.dto.AppUserPasswordResponseDTO;
import ma.expleo.mappers.AppUserPasswordMapper;
import ma.expleo.repositories.AppUserLogingRepository;
import ma.expleo.repositories.AppUserPasswordRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppUserPasswordServiceImpl implements AppUserPasswordService {
    private AppUserPasswordRepository appUserPasswordRepository;
    private AppUserLogingRepository appUserLogingRepository;
    private AppUserLogingService appUserLogingService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AppUserPasswordMapper appUserPasswordMapper;

    public AppUserPasswordServiceImpl(AppUserPasswordRepository appUserPasswordRepository, AppUserLogingRepository appUserLogingRepository,AppUserLogingService appUserLogingService, BCryptPasswordEncoder bCryptPasswordEncoder, AppUserPasswordMapper appUserPasswordMapper) {
        this.appUserPasswordRepository = appUserPasswordRepository;
        this.appUserLogingRepository = appUserLogingRepository;
        this.appUserLogingService=appUserLogingService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appUserPasswordMapper=appUserPasswordMapper;
    }

    @Override
    public AppUserPassword saveAppUserPassword(AppUserPassword appUserPassword) {
        return appUserPasswordRepository.save(appUserPassword);
    }

    @Override
    public AppUserPasswordResponseDTO changePassword(AppUserPasswordRequestDTO appUserPasswordRequestDTO) {
        AppUserLoging appUserLoging=appUserLogingService.loadUserByUsername(appUserPasswordRequestDTO.getUserNameLoging());
        if(appUserLoging==null) throw new RuntimeException("This account doesn't exist");
        AppUserPassword appUserPassword=appUserLoging.getAppUserPassword();
        if(!bCryptPasswordEncoder.matches(appUserPasswordRequestDTO.getOldPassword(),appUserPasswordRequestDTO.getNewPassword())) throw new RuntimeException("The old password and the new one doesn't match");
        appUserPassword.setOldPassword(bCryptPasswordEncoder.encode(appUserPasswordRequestDTO.getOldPassword()));
        appUserPassword.setPassword(bCryptPasswordEncoder.encode(appUserPasswordRequestDTO.getNewPassword()));
        appUserPassword.setDateChangePassword(new Date());
        appUserPasswordRepository.save(appUserPassword);
        appUserLogingRepository.save(appUserLoging);
        return appUserPasswordMapper.appUserPasswordToAppUserPasswordResponseDTO(appUserPassword);
    }
}
