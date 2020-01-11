package pl.sda20.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda20.bootcamp.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByRole(String role);

}
