package ma.expleo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AppUserLogingRequestDTO {
    String userNameLoging;
    String password;
    String comfirmedPassword;
    String registrationName;
}
