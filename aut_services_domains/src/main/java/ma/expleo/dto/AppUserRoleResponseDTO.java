package ma.expleo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AppUserRoleResponseDTO {
    private long ID;
    private String roleName;
    private Date dateCreatedRole;
    private String roleDescription;
}
