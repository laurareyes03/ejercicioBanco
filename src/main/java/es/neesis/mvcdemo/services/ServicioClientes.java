package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.models.Clientes;
import es.neesis.mvcdemo.models.Sucursales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioClientes {

	private static Integer contador = 0;
	private static List<Clientes> clientes = new ArrayList<Clientes>();

	@Autowired
	private ServicioSucursales servicioSucursales;

	public List<Clientes> listadoClientes(){
		return clientes;
	}

	public void addCliente(String DNI, String nombreCliente, String direccionPostal, String email, String telefono, String nombreSucursal){
		Sucursales sucursal = servicioSucursales.obtenerSucursalPorNombre(nombreSucursal).orElse(null);
		Clientes nuevoCliente = new Clientes(contador++, DNI, nombreCliente, direccionPostal, email, telefono, sucursal);
		clientes.add(nuevoCliente);
	}

	public Clientes buscarPorId(int id) {
		for (Clientes cliente : clientes) {
			if (cliente.getIdCliente() == id) {
				return cliente;
			}
		}
		return null; // Si no lo encuentra, retorna null
	}

	public Clientes buscarPorDNI(String dni) {
		for (Clientes cliente : clientes) {
			if (cliente.getDNI().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}

	public Clientes buscarPorEmail(String email) {
		for (Clientes cliente : clientes) {
			if (cliente.getEmail().equals(email)) {
				return cliente;
			}
		}
		return null;
	}

	public boolean eliminarCliente(int id) {
		return clientes.removeIf(c -> c.getIdCliente() == id);
	}

	public boolean actualizarCliente(int id, String dni, String nombre, String direccionPostal, String email, String telefono, String sucursalPrincipal) {
		Clientes cliente = buscarPorId(id);
		Sucursales sucursal = servicioSucursales.obtenerSucursalPorNombre(sucursalPrincipal).orElse(null);
		if (cliente != null) {
			cliente.setDNI(dni);
			cliente.setNombreCliente(nombre);
			cliente.setDireccionPostal(direccionPostal);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setSucursal(sucursal);

			return true;
		}
		return false;
	}
}
