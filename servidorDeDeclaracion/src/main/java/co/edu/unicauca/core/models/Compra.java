package co.edu.unicauca.core.models;


import java.util.Date;

public class Compra {
    
    private long valor;
    private String lugar_compra;
    private Date fecha;
    private String medio_pago;
    private String nit;

    public Compra() {
    }

    public Compra(long valor, String lugar_compra, Date fecha, String medio_pago, String nit) {
        this.valor = valor;
        this.lugar_compra = lugar_compra;
        this.fecha = fecha;
        this.medio_pago = medio_pago;
        this.nit = nit;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getLugar_compra() {
        return lugar_compra;
    }

    public void setLugar_compra(String lugar_compra) {
        this.lugar_compra = lugar_compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    
    
    
}
