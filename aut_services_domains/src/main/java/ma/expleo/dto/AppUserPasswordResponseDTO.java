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
public class AppUserPasswordResponseDTO {
    private Long id;
    private String password;
    private String oldPassword;
    private Date dateChangePassword;
    private Date dateCreatePassword;
}
