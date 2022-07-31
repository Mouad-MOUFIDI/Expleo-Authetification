package ma.expleo.repositories;

import ma.expleo.domain.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CollaborateurRepository extends JpaRepository<Collaborateur,Long> {
    Collaborateur findByRegistrationNumber(String registrationNumber);
}
