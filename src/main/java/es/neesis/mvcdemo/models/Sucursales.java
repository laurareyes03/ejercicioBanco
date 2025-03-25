package es.neesis.mvcdemo.models;

public class Sucursales {
    private Long id;
    private String nombre;
    private String director;
    private String direccion;

    public Sucursales(Long id, String nombre, String director, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
