package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.models.Clientes;
import es.neesis.mvcdemo.services.ServicioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientesController {

    @Autowired
    ServicioClientes servicioAlumnos;

    @GetMapping("/alumnos")
    public String getAlumnos(Model model) {
        List<Clientes> alumnos = servicioAlumnos.listadoAlumnos();
        model.addAttribute("listadoALumnos", alumnos);
        return "alumnos";
    }

    @PostMapping("/alumnos")
    public String addAlumno(@RequestParam(name="name") String nameAlumno, Model model) {
        servicioAlumnos.addAlumno(nameAlumno);
        List<Clientes> alumnos = servicioAlumnos.listadoAlumnos();
        model.addAttribute("notificacion", "Se ha añadido un alumno" + nameAlumno);
        model.addAttribute("listadoAlumnos", alumnos);
        return "alumnos";
    }


}
