package es.neesis.mvcdemo.models;

public class Clientes {

	private Integer idAlumno;
	private String nombreAlumno;

	public Clientes(Integer idAlumno, String nombreAlumno) {
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
}
