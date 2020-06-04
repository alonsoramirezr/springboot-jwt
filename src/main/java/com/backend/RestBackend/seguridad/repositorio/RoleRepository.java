package com.backend.RestBackend.seguridad.repositorio;

import com.backend.RestBackend.seguridad.modelo.RoleName;
import com.backend.RestBackend.seguridad.modelo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByName(RoleName roleName);
}
