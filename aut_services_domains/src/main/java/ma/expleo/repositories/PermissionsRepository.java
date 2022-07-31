package ma.expleo.repositories;

import ma.expleo.domain.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PermissionsRepository extends JpaRepository<Permissions,Long> {
    Permissions findByNamePermission(String namePermission);
}
