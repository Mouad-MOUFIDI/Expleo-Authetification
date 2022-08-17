package ma.expleo.exporters;

import ma.expleo.api.AppUserLogingService;
import ma.expleo.domain.AppUserLoging;
import ma.expleo.domain.UserExpleoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Merouane GUELLIL
 * Created on 16/05/2022
 */
@Service
public class UserExpleoDetailsService implements UserDetailsService {
    @Autowired
    private AppUserLogingService appUserLogingService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUserLoging appUserLoging=appUserLogingService.loadUserByUsername(userName);
        if (appUserLoging == null) {
            throw new UsernameNotFoundException("Could not find user" + userName);
        }
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        appUserLoging.getRoles().forEach(r->{
//            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
//        });
//        return new UserExpleoDetails(appUserLoging.getUserNameLoging(),appUserLoging.getAppUserPassword().getPassword(),authorities);
        return new UserExpleoDetails(appUserLoging);
    }
}
