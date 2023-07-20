package pe.edu.manrique.estudiantes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.manrique.estudiantes.entidad.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario.
}
