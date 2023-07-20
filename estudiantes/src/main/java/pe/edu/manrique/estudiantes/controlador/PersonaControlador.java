package pe.edu.manrique.estudiantes.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.edu.manrique.estudiantes.entidad.Persona;
import pe.edu.manrique.estudiantes.servicio.PersonaServicio;
import java.util.List;

@Controller
public class PersonaControlador {
    @Autowired
    private PersonaServicio servicio;

    @GetMapping("/personas")
    public String inicio(Model modelo) {
        List<Persona> personas = servicio.listarTodasLasPersonas();
        modelo.addAttribute("personas", personas);
        return "personas";
    }

    @GetMapping("/personas/nuevo")
    public String nuevaPersonaForm(Model modelo) {
        Persona persona = new Persona();
        modelo.addAttribute("persona", persona);
        return "nuevo";
    }

    @PostMapping("/personas/guardar")
    public String guardarPersona(@ModelAttribute("persona") Persona persona) {
        servicio.guardarPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/personas/editar/{id}")
    public String editarPersonaForm(@PathVariable Long id, Model modelo) {
        Persona persona = servicio.obtenerPersonaPorId(id);
        modelo.addAttribute("persona", persona);
        return "editar";
    }

    @PostMapping("/personas/editar/{id}")
    public String actualizarPersona(@ModelAttribute("persona") Persona persona) {
        servicio.guardarPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/personas/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        servicio.eliminarPersona(id);
        return "redirect:/personas";
    }

}
