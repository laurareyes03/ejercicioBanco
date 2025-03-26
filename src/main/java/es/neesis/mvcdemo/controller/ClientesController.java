package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.models.Clientes;
import es.neesis.mvcdemo.models.Cuentas;
import es.neesis.mvcdemo.services.ServicioClientes;
import es.neesis.mvcdemo.services.ServicioCuentas;
import es.neesis.mvcdemo.services.ServicioSucursales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ClientesController {

    @Autowired
    ServicioClientes servicioClientes;

    @Autowired
    ServicioSucursales servicioSucursales;

    @Autowired
    ServicioCuentas servicioCuentas;

    @GetMapping("/clientes")
    public String getAlumnos(Model model) {
        List<Clientes> clientes = servicioClientes.listadoClientes();
        model.addAttribute("listadoClientes", clientes);
        model.addAttribute("listadoSucursales", servicioSucursales.listarSucursales());
        return "clientes";
    }

    @PostMapping("/clientes")
    public String agregarCliente(@RequestParam("dni") String dni,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("direccionPostal") String direccionPostal,
                                 @RequestParam("email") String email,
                                 @RequestParam("telefono") String telefono,
                                 @RequestParam("sucursalPrincipal") String sucursalPrincipal, RedirectAttributes redirectAttributes,
                                 Model model) {
        servicioClientes.addCliente(dni, nombre, direccionPostal, email, telefono, sucursalPrincipal);
        redirectAttributes.addFlashAttribute("notificacion", "Cliente " + nombre + " agregado correctamente");
        model.addAttribute("listadoClientes", servicioClientes.listadoClientes());
        return "redirect:/clientes";
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
        model.addAttribute("listadoSucursales", servicioSucursales.listarSucursales());
        return "editarCliente";
    }

    @PostMapping("/clientes/editar/{id}")
    public String actualizarCliente(@PathVariable int id, @RequestParam String dni,
                                    @RequestParam String nombre, @RequestParam String direccionPostal,
                                    @RequestParam String email, @RequestParam String telefono,
                                    @RequestParam String sucursalPrincipal, RedirectAttributes redirectAttributes, Model model) {
        boolean actualizado = servicioClientes.actualizarCliente(id, dni, nombre, direccionPostal, email, telefono, sucursalPrincipal);

        if (actualizado) {
            redirectAttributes.addFlashAttribute("notificacion", "Cliente actualizado correctamente");
        } else {
            redirectAttributes.addFlashAttribute("notificacion", "Error al actualizar el cliente");
        }
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String detalleCliente(@PathVariable Integer id, Model model) {
        // Obtener cliente por ID (y las cuentas asociadas)
        Clientes cliente = servicioClientes.buscarPorId(id);
        List<Cuentas> cuentas = servicioCuentas.listarCuentas().stream().filter(c -> c.getIdUsuario().equals(cliente.getIdCliente())).collect(Collectors.toList());
        if (cliente != null) {
            // Añadir el cliente y sus cuentas al modelo
            model.addAttribute("cliente", cliente);
            model.addAttribute("cuentas", cuentas);
        }

        return "detalleCliente";
    }


}
