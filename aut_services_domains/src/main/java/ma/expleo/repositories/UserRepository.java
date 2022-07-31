package ma.expleo.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Merouane GUELLIL
 * Created on 17/05/2022
 */
public interface UserRepository extends JpaRepository<Long,User> {
}
