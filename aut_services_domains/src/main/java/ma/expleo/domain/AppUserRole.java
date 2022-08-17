package ma.expleo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Merouane GUELLIL
 * Created on 13/05/2022
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "ID")
@Table(name = "APP_ROLE", uniqueConstraints = {@UniqueConstraint(columnNames = {"ROLE_NAME"})})

public class AppUserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "ROLE_NAME", nullable = false, unique = true)
    private String roleName;

    @Column(name = "DATE_CREATED_ROLE",nullable = false)
    private Date dateCreatedRole;

    @Column(name = "ROLE_DESCRIPTION",nullable = false)
    private String roleDescription;

    @ManyToMany
    private Collection<AppUserLoging> users;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Permissions> permissions = new ArrayList<>();

    @Override
    public String getAuthority() {
        return this.getRoleName();
    }
}
