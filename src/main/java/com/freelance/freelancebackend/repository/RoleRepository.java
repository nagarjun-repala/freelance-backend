package com.freelance.freelancebackend.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.freelance.freelancebackend.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String roleName);
}
