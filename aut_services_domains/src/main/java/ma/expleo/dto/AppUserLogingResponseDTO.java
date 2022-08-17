package ma.expleo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.expleo.domain.ActivationStatus;
import ma.expleo.domain.AppUserPassword;
import ma.expleo.domain.AppUserRole;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AppUserLogingResponseDTO {
    private long ID;
    private String userNameLoging;
    private String userMail;
    private Date lastLogin;
    private Boolean admin = new Boolean(false);
    private Collection<AppUserRole> roles;
    private ActivationStatus status = ActivationStatus.INACTIVE;
}
