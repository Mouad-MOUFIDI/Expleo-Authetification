package ma.expleo.repositories;

import ma.expleo.domain.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRoleRepository extends JpaRepository<AppUserRole,Long> {
    AppUserRole findByRoleName(String rolename);
}
