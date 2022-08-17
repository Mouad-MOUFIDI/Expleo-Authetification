package ma.expleo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author Merouane GUELLIL
 * Created on 13/05/2022
 */
@Entity
@Table(name = "APP_USER_LOGGING", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"USER_NAME_LOGGING"}),
        @UniqueConstraint(columnNames = "USER_MAIL")
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "ID")
@Builder(toBuilder = true)
public class AppUserLoging implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USER_LOGGING", nullable = false)
    private Long ID;

    @Column(name = "USER_NAME_LOGGING", unique = true, nullable = false)
    private String userNameLoging;

    @Column(name = "USER_MAIL", nullable = false)
    private String userMail;

    @Column(name = "LAST_LOGIN", nullable = false)
    private Date lastLogin;

    @Column(name = "IS_ADMIN", nullable = false)
    private Boolean admin = new Boolean(false);

    @Column(name = "ROLE", nullable = false)
    private String role;

    @ManyToMany
    private Collection<AppUserRole> roles;

    @OneToOne
    private AppUserPassword appUserPassword;

    @OneToOne
    private Collaborateur collaborateur;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private ActivationStatus status = ActivationStatus.INACTIVE;


/*
    @OneToMany(mappedBy = "ackUser", fetch = FetchType.LAZY)
    private Set<DaoPosition> positions ;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "luxtrust_user_authorities", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID"))
    private Set<DaoAuthority> authorities;


    public RestUser toRestUser() {
        RestUser restUser = RestUser.builder().
                id(ID).username(username).firstname(firstname).
                famillyname(famillyname).mail(mail).admin(admin).build();
        if( status !=null ) restUser.setStatus(status);
        return restUser;
    }*/
}
