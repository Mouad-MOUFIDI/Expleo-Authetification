package ma.expleo.applicaion;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Authentification Service.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link tech.jhipster.config.JHipsterProperties} for a good example.
 *
 * @author Merouane GUELLIL
 * Created on 14/06/2022
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
}
