package ma.expleo.controlers;

import lombok.Data;
import ma.expleo.api.AppUserLogingService;

import ma.expleo.api.AppUserPasswordService;
import ma.expleo.api.CollaborateurService;
import ma.expleo.domain.AppUserLoging;
import ma.expleo.domain.AppUserPassword;
import ma.expleo.domain.Collaborateur;
import ma.expleo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")
public class Controller {
    @Autowired
    private AppUserLogingService appUserLogingService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private AppUserPasswordService appUserPasswordService;

    @PostMapping(path = "/register")
    public AppUserLogingResponseDTO register(@RequestBody AppUserLogingRequestDTO appUserLogingRequestDTO){
        return appUserLogingService.saveAppUserLoging(appUserLogingRequestDTO );
    }
    @GetMapping(path = "/collaborateur/{reg}")
    public CollaborateurResponseDTO getCollab(@PathVariable(name="reg") String registrationNumber){
        return collaborateurService.loadCollaborateurByRegistrationNumber(registrationNumber);
    }
    @PostMapping(path = "/changePassword")
    public AppUserPasswordResponseDTO changePassword(@RequestBody AppUserPasswordRequestDTO appUserPasswordRequestDTO){
        return appUserPasswordService.changePassword(appUserPasswordRequestDTO);
    }


}
