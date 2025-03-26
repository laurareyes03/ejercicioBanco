package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.models.Sucursales;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioSucursales {
    private List<Sucursales> sucursales;

    public ServicioSucursales() {
        sucursales = new ArrayList<>();
        sucursales.add(new Sucursales(1L, "Sucursal Centro", "Juan Pérez", "Calle Ficticia 123"));
        sucursales.add(new Sucursales(2L, "Sucursal Norte", "María López", "Avenida del Norte 456"));
        sucursales.add(new Sucursales(3L, "Sucursal Sur", "Carlos García", "Avenida del Sur 789"));
    }

    public List<Sucursales> listarSucursales() {
        return sucursales;
    }

    public Optional<Sucursales> obtenerSucursal(Long id) {
        return sucursales.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public Sucursales crearSucursal(Sucursales sucursal) {
        sucursal.setId((long) (sucursales.size() + 1));
        sucursales.add(sucursal);
        return sucursal;
    }

    public Sucursales actualizarSucursal(Long id, Sucursales sucursalActualizada) {
        Optional<Sucursales> sucursalOpt = obtenerSucursal(id);
        if (sucursalOpt.isPresent()) {
            Sucursales sucursal = sucursalOpt.get();
            sucursal.setNombre(sucursalActualizada.getNombre());
            sucursal.setDirector(sucursalActualizada.getDirector());
            sucursal.setDireccion(sucursalActualizada.getDireccion());
            return sucursal;
        }
        return null;
    }

    public boolean eliminarSucursal(Long id) {
        return sucursales.removeIf(sucursal -> sucursal.getId().equals(id));
    }

    public Optional<Sucursales> obtenerSucursalPorNombre(String nombre) {
        return sucursales.stream().filter(s -> s.getNombre().equals(nombre)).findFirst();
    }
}
