package ma.expleo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Merouane GUELLIL
 * Created on 13/05/2022
 */
public class UserExpleoDetails implements UserDetails {

    private AppUserLoging appUserLoging;

    public UserExpleoDetails(AppUserLoging appUserLoging){
        this.appUserLoging=appUserLoging;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        for (AppUserRole role : appUserLoging.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return appUserLoging.getAppUserPassword().getPassword();
    }

    @Override
    public String getUsername() {
        return appUserLoging.getUserNameLoging();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if( this.appUserLoging.getStatus() != ActivationStatus.ACTIVE) {
            return false;
        }
        if( this.appUserLoging.getAppUserPassword().getPassword() == null ){
            return false;
        }
        return true;
    }
}
