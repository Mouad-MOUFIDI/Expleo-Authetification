package ma.expleo;

import ma.expleo.api.*;
import ma.expleo.domain.AppUserRole;
import ma.expleo.dto.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @author Merouane GUELLIL
 * Created on 13/05/2022
 */
@SpringBootApplication
public class AutServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AppRoleService appRoleService,
                            AppUserLogingService appUserLogingService,
                            AppUserPasswordService appUserPasswordService,
                            CollaborateurService collaborateurService,
                            PermissionService permissionService){
        return args->{
            appRoleService.saveAppRole(AppUserRoleRequestDTO.builder()
                    .roleName("ADMIN")
                    .roleDescription("Description of the admin role")
                    .build());
            appRoleService.saveAppRole(AppUserRoleRequestDTO.builder()
                    .roleName("USER")
                    .roleDescription("Description of the user role")
                    .build());
//			Stream.of("user1","user2","user3","admin").forEach(un->{
//				accountService.saveAppUserLoging(un,"1234","1234","registration");
//			});
            permissionService.savePermissions(PermissionsRequestDTO.builder()
                    .namePermission("permission1")
                    .descriptionPermission("description1")
                    .isActive(true)
                    .build());
            permissionService.addPermissionToRole("ADMIN","permission1");

            collaborateurService.saveCollaborateur(CollaborateurRequestDTO.builder()
                    .colName("Mouad")
                    .colFirstName("Moufidi")
                    .registrationNumber("registration1")
                    .colDateOfBirth(new Date())
                    .build());
            collaborateurService.saveCollaborateur(CollaborateurRequestDTO.builder()
                    .colName("Ahmed")
                    .colFirstName("Derkaoui")
                    .registrationNumber("registration2")
                    .colDateOfBirth(new Date())
                    .build());

            appUserLogingService.saveAppUserLoging(AppUserLogingRequestDTO.builder()
                    .userNameLoging("user")
                    .password("1234")
                    .comfirmedPassword("1234")
                    .registrationName("registration1")
                    .build());

            appRoleService.addRoleToCollaborateur("registration1","ADMIN");


            appUserPasswordService.changePassword(AppUserPasswordRequestDTO.builder()
                    .newPassword("55555A")
                    .oldPassword("1234")
                    .userNameLoging("user1")
                    .build());

        };
    }
}
