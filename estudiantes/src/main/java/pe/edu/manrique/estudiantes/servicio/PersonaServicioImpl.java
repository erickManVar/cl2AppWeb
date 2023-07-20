package pe.edu.manrique.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.manrique.estudiantes.entidad.Persona;
import pe.edu.manrique.estudiantes.repositorio.PersonaRepository;

import java.util.List;

@Service
public class PersonaServicioImpl implements PersonaServicio {

    @Autowired
    private PersonaRepository repositorio;

    @Override
    public List<Persona> listarTodasLasPersonas() {
        return repositorio.findAll();
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return repositorio.save(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return repositorio.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        repositorio.deleteById(id);
    }
}
