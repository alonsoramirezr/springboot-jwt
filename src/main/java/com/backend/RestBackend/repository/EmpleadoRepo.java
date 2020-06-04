package com.backend.RestBackend.repository;

import com.backend.RestBackend.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepo extends JpaRepository<Empleado,Long> {
}
