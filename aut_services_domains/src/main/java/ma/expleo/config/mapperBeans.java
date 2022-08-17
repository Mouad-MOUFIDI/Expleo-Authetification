package ma.expleo.config;

import ma.expleo.domain.*;
import ma.expleo.dto.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class mapperBeans {
    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public AppUserLoging appUserLogingBean(){
        return new AppUserLoging();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public AppUserLogingResponseDTO AppUserLogingResponseDTOBean(){
        return new AppUserLogingResponseDTO();    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public AppUserPassword appUserPasswordBean(){
        return new AppUserPassword();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public AppUserPasswordResponseDTO appUserPasswordResponseDTOBean(){
        return new AppUserPasswordResponseDTO();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public Collaborateur collaborateurBean(){
        return new Collaborateur();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public CollaborateurResponseDTO collaborateurResponseDTOBean() {
        return new CollaborateurResponseDTO();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public AppUserRole appUserRoleBean(){
        return new AppUserRole();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public AppUserRoleResponseDTO appUserRoleResponseDTOBean() {
        return new AppUserRoleResponseDTO();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public Permissions permissionsBean(){
        return new Permissions();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public PermissionsResponseDTO permissionsResponseDTOBean() {
        return new PermissionsResponseDTO();
    }

}
