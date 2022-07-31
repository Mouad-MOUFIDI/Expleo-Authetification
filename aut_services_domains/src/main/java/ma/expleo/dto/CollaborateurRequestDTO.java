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
public class CollaborateurRequestDTO {
    private String colName;
    private String colFirstName;
    private String registrationNumber;
    private Date colDateOfBirth;
    private Date dateOfEntryService;
    private Date dateOfReleaseService;
    private String motifReleaseService;

}
