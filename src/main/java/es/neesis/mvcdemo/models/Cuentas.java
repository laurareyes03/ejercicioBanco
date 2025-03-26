package es.neesis.mvcdemo.models;

public class Cuentas {
    private String numeroCuenta;
    private String sucursal;
    private Integer idUsuario;
    private String balance;

    // Constructor
    public Cuentas(String numeroCuenta, String sucursal, Integer idUsuario, String balance) {
        this.numeroCuenta = numeroCuenta;
        this.sucursal = sucursal;
        this.idUsuario = idUsuario;
        this.balance = balance;
    }

    // Getters y Setters
    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
    public String getSucursal() { return sucursal; }
    public void setSucursal(String sucursal) { this.sucursal = sucursal; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public String getBalance() { return balance; }
    public void setBalance(String balance) { this.balance = balance; }

    public void add(Cuentas cuentas) {
    }
}
