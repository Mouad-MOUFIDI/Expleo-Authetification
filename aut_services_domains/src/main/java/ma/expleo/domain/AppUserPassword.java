package ma.expleo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Merouane GUELLIL
 * Created on 18/05/2022
 */
@Entity
@Table(name = "APP_USER_PASSWORD", uniqueConstraints = {@UniqueConstraint(columnNames = {"PASSWORD"})})
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "ID")
@Builder(toBuilder = true)

public class AppUserPassword implements Serializable {
    @Id
    @Column(name = "ID_PASSWORD", nullable = true)
    private Long id;

    @Column(name = "PASSWORD", nullable = true)
    private String password;

    @Column(name = "OLD_PASSWORD", nullable = false)
    private String oldPassword;

    @Column(name = "DATE_CHANGE_PASSWORD", nullable = false)
    private Date dateChangePassword;

    @Column(name = "DATE_CREATE_PASSWORD", nullable = true)
    private Date dateCreatePassword;

}
