package ma.expleo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AppUserPasswordRequestDTO {
    private String newPassword;
    private String oldPassword;
    private String userNameLoging;
}
