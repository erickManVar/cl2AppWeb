package pe.edu.manrique.estudiantes.servicio;

import pe.edu.manrique.estudiantes.entidad.Persona;

import java.util.List;

public interface PersonaServicio {
    List<Persona> listarTodasLasPersonas();
    Persona guardarPersona(Persona persona);
    Persona obtenerPersonaPorId(Long id);
    Persona actualizarPersona(Persona persona);
    void eliminarPersona(Long id);
}
