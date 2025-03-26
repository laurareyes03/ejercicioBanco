package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.models.Clientes;
import es.neesis.mvcdemo.models.Sucursales;
import es.neesis.mvcdemo.services.ServicioClientes;
import es.neesis.mvcdemo.services.ServicioSucursales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sucursales")
public class SucursalesController {

    /*@GetMapping("/alumnos")
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
    }*/

    @Autowired
    ServicioSucursales servicioSucursales;

    @GetMapping
    public List<Map<String,Object>> listarSucursales() {
        List<Sucursales> sucursales = servicioSucursales.listarSucursales();
        return sucursales.stream().map(sucursal -> {
            Map<String, Object> sucursalResponse = new HashMap<>();
            sucursalResponse.put("nombre", sucursal.getNombre());
            sucursalResponse.put("director", sucursal.getDirector());
            sucursalResponse.put("direccion", sucursal.getDireccion());
            return sucursalResponse;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Map<String, Object> obtenerSucursal(@PathVariable Long id) {
        Optional<Sucursales> sucursalOpt = servicioSucursales.obtenerSucursal(id);
        if (sucursalOpt.isPresent()) {
            Sucursales sucursal = sucursalOpt.get();
            Map<String, Object> sucursalResponse = new HashMap<>();
            sucursalResponse.put("nombre", sucursal.getNombre());
            sucursalResponse.put("director", sucursal.getDirector());
            sucursalResponse.put("direccion", sucursal.getDireccion());
            return sucursalResponse;
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Sucursal no encontrada");
            return errorResponse;
        }
    }

    @PostMapping
    public Sucursales crearSucursal(@RequestBody Sucursales sucursal) {
        return servicioSucursales.crearSucursal(sucursal);
    }

    @PutMapping("/{id}")
    public Sucursales actualizarSucursal(@PathVariable Long id, @RequestBody Sucursales sucursal) {
        return servicioSucursales.actualizarSucursal(id, sucursal);
    }

    @DeleteMapping("/{id}")
    public String eliminarSucursal(@PathVariable Long id) {
        boolean eliminado = servicioSucursales.eliminarSucursal(id);
        return eliminado ? "Sucursal eliminada exitosamente" : "Sucursal no encontrada";
    }
}
