package ma.expleo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class Collaborateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String colName;
    private String colFirstName;
    @Column(unique = true)
    private String registrationNumber;
    private Date colDateOfBirth;
    private Date dateOfEntryService;
    private Date dateOfReleaseService;
    private String motifReleaseService;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppUserRole> roles = new ArrayList<>();
    @JsonIgnore
    @OneToOne
    private AppUserLoging appUserLoging ;

}
