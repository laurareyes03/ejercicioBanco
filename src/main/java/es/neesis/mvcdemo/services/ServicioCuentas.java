package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.models.Cuentas;
import es.neesis.mvcdemo.models.Sucursales;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ServicioCuentas {
    private List<Cuentas> cuentas = new ArrayList<>();

    public List<Cuentas> listarCuentas() {
        return cuentas;
    }

    public Optional<Cuentas> obtenerCuenta(String numero) {
        return cuentas.stream().filter(c -> c.getNumeroCuenta().equals(numero)).findFirst();
    }

    public void agregarCuenta(Cuentas cuenta) {
        cuentas.add(cuenta);
    }

    public void eliminarCuenta(String numero) {
        cuentas.removeIf(c -> c.getNumeroCuenta().equals(numero));
    }

    public void actualizarCuenta(Cuentas cuentaActualizada) {
        obtenerCuenta(cuentaActualizada.getNumeroCuenta()).ifPresent(cuenta -> {
            cuenta.setSucursal (cuentaActualizada.getSucursal());
            cuenta.setIdUsuario(cuentaActualizada.getIdUsuario());
            cuenta.setBalance(cuentaActualizada.getBalance());
        });
    }



}
