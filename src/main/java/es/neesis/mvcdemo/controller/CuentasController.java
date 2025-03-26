package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.models.Cuentas;
import es.neesis.mvcdemo.services.ServicioCuentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



    @RestController
    @RequestMapping("/cuentas")
    @CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen
    public class CuentasController {
        private final ServicioCuentas servicioCuentas;

        public CuentasController(ServicioCuentas servicioCuentas) {
            this.servicioCuentas = servicioCuentas;

        }

        @GetMapping
        public List<Cuentas> listarCuentas() {
            return servicioCuentas.listarCuentas();
        }

        @GetMapping("/{numero}")
        public Optional<Cuentas> obtenerCuenta(@PathVariable String numero) {
            return servicioCuentas.obtenerCuenta(numero);
        }

        @PostMapping
        public void agregarCuenta(@RequestBody Cuentas cuenta) {
            servicioCuentas.agregarCuenta(cuenta);
        }

        @DeleteMapping("/{numero}")
        public void eliminarCuenta(@PathVariable String numero) {
            servicioCuentas.eliminarCuenta(numero);
        }

        @PutMapping
        public void actualizarCuenta(@RequestBody Cuentas cuenta) {
            servicioCuentas.actualizarCuenta(cuenta);
        }
}
