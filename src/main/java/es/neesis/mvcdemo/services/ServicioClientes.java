package es.neesis.mvcdemo.services;

import es.neesis.mvcdemo.models.Clientes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioClientes {

	private static Integer contador = 0;
	private static List<Clientes> alumnos = new ArrayList<Clientes>();

	public List<Clientes> listadoAlumnos(){
		return alumnos;
	}

	public void addAlumno(String nombreAlumno){
		Clientes nuevoAlumno = new Clientes(contador++, nombreAlumno);
		alumnos.add(nuevoAlumno);
	}
}
