package es.neesis.mvcdemo.models;

import java.util.List;

public class Clientes {

	private Integer idCliente;
	private String DNI;
	private String nombreCliente;
	private String direccionPostal;
	private String email;
	private String telefono;
	private Sucursales sucursal;

	public Clientes(Integer idCliente, String DNI, String nombreCliente, String direccionPostal, String email, String telefono, Sucursales sucursal) {
		this.idCliente = idCliente;
		this.DNI = DNI;
		this.nombreCliente = nombreCliente;
		this.direccionPostal = direccionPostal;
		this.email = email;
		this.telefono = telefono;
		this.sucursal = sucursal;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Sucursales getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursales sucursal) {
		this.sucursal = sucursal;
	}
}
