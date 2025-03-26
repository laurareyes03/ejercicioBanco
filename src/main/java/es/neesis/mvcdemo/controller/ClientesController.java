package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.models.Clientes;
import es.neesis.mvcdemo.services.ServicioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientesController {

    @Autowired
    ServicioClientes servicioClientes;

    @GetMapping("/clientes")
    public String getAlumnos(Model model) {
        List<Clientes> clientes = servicioClientes.listadoClientes();
        model.addAttribute("listadoClientes", clientes);
        return "clientes";
    }

    @PostMapping("/clientes")
    public String agregarCliente(@RequestParam("dni") String dni,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("direccionPostal") String direccionPostal,
                                 @RequestParam("email") String email,
                                 @RequestParam("telefono") String telefono,
                                 @RequestParam("sucursalPrincipal") String sucursalPrincipal,
                                 Model model) {
        servicioClientes.addCliente(dni, nombre, direccionPostal, email, telefono, sucursalPrincipal);
        model.addAttribute("notificacion", "Cliente " + nombre + " agregado correctamente");
        model.addAttribute("listadoClientes", servicioClientes.listadoClientes());

        return "clientes";
    }


    @GetMapping("clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id, Model model) {
        boolean eliminado = servicioClientes.eliminarCliente(id);

        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editarCliente(@PathVariable int id, Model model) {
        Clientes cliente = servicioClientes.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "editarCliente";
    }

    @PostMapping("/clientes/editar/{id}")
    public String actualizarCliente(@PathVariable int id, @RequestParam String dni,
                                    @RequestParam String nombre, @RequestParam String direccionPostal,
                                    @RequestParam String email, @RequestParam String telefono,
                                    @RequestParam String sucursalPrincipal, Model model) {
        boolean actualizado = servicioClientes.actualizarCliente(id, dni, nombre, direccionPostal, email, telefono, sucursalPrincipal);

        if (actualizado) {
            model.addAttribute("notificacion", "Cliente actualizado correctamente");
        } else {
            model.addAttribute("notificacion", "Error al actualizar el cliente");
        }
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String detalleCliente(@PathVariable Integer id, Model model) {
        // Obtener cliente por ID (y las cuentas asociadas)
        Clientes cliente = servicioClientes.buscarPorId(id);

        if (cliente != null) {
            // Añadir el cliente y sus cuentas al modelo
            model.addAttribute("cliente", cliente);
            model.addAttribute("cuentas", null);
        }

        return "detalleCliente";
    }


}
