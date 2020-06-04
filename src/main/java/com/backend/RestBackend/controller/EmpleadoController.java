package com.backend.RestBackend.controller;

import com.backend.RestBackend.exception.ResourceNotFoundException;
import com.backend.RestBackend.model.Empleado;
import com.backend.RestBackend.repository.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepo repo;

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        return repo.findAll();
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleadoPorId(@PathVariable(value = "id") Long empleadoId) throws ResourceNotFoundException {
        Empleado empleado = repo.findById(empleadoId).orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado para este id: " + empleadoId));
        return ResponseEntity.ok().body(empleado);
    }

    @PostMapping("/empleados")
    public Empleado crearEmpleado(@Valid @RequestBody Empleado empleado) {
        return repo.save(empleado);
    }

    @PutMapping("/empleados/{id}")
        public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable(value = "id") Long empleadoId, @Valid @RequestBody Empleado detalleEmpleado) throws ResourceNotFoundException {
        Empleado empleado = repo.findById(empleadoId).orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado para este id: " + empleadoId));

        empleado.setEmail(detalleEmpleado.getEmail());
        empleado.setNombre(detalleEmpleado.getNombre());
        empleado.setApellido(detalleEmpleado.getApellido());
        final Empleado empleadoActualizado = repo.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/empleados/{id}")
    public Map<String, Boolean> borrarEmpleado(@PathVariable(value = "id") Long empleadoId) throws ResourceNotFoundException {
        Empleado empleado = repo.findById(empleadoId).orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado para este id: " + empleadoId));

        repo.delete(empleado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        return response;
    }
}