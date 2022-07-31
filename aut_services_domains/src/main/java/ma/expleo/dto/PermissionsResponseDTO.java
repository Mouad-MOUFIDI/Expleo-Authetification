package ma.expleo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PermissionsResponseDTO {
    private Long id;
    private String namePermission;
    private String descriptionPermission;
    private boolean isActive;
}
