package ma.expleo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Merouane GUELLIL
 * Created on 13/05/2022
 */
public class UserExpleoDetails implements UserDetails {

    private AppUserLoging appUserLoging;

    public UserExpleoDetails(AppUserLoging appUserLoging){
        this.appUserLoging = appUserLoging;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        if( this.appUserLoging.getStatus() != ActivationStatus.ACTIVE) {
            return false;
        }
        if( this.appUserLoging.getPassword() == null ){
            return false;
        }
        return true;
    }
}
