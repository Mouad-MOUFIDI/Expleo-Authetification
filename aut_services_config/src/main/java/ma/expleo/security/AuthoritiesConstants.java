package ma.expleo.security;

/**
 * @author Merouane GUELLIL
 * Created on 02/06/2022
 *
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String ADMIN_RH = "ROLE_ADMIN_RH";
    public static final String ADMIN_FN = "ROLE_ADMIN_FN"; //FN: Finance
    public static final String USER = "ROLE_USER";
    public static final String ANONYMOUS = "ROLE_ANONYMOUS";
    private AuthoritiesConstants() {}
}
