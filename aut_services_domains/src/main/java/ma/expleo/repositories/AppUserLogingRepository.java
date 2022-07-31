package ma.expleo.repositories;

import ma.expleo.domain.AppUserLoging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserLogingRepository extends JpaRepository<AppUserLoging,Long> {
    AppUserLoging findByUserNameLoging(String userNameLoging);
}
