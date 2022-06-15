package ma.expleo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Merouane GUELLIL
 * Created on 13/05/2022
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "ID")
@Table(name = "APP_ROLE", uniqueConstraints = {@UniqueConstraint(columnNames = {"AUTHORITY_NAME"})})

public class AppUserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "ROLE_NAME", nullable = false, unique = true)
    private String roleName;
    @Override
    public String getAuthority() {
        return this.getRoleName();
    }
}