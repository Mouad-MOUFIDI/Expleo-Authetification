package ma.expleo.application;

/**
 * @author Merouane GUELLIL
 * Created on 02/06/2022
 */
public final class Constants {
    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";
    public static final String SYSTEM = "system";
    public static final String DEFAULT_LANGUAGE = "fr";

    private Constants() {}
}
