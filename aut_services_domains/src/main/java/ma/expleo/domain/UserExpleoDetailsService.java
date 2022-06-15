package ma.expleo.domain;

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
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUserLoging appUserLoging = userRepository.findByUsername(userName);
        if (appUserLoging == null) {
            throw new UsernameNotFoundException("Could not find user"+userName);
        }
        return new MyUserPrincipal(appUserLoging);
    }
}
