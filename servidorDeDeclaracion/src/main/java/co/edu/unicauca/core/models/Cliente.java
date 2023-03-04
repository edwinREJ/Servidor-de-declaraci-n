package co.edu.unicauca.core.models;

import java.util.ArrayList;

public class Cliente {
    
    private String tipo_id;
    private int id;
    private ArrayList<Compra> lis_compras;

    public Cliente() {
        this.lis_compras = new ArrayList<>();
    }
    
    public Cliente(String tipo_id, int id) {
        this.tipo_id = tipo_id;
        this.id = id;
        this.lis_compras = new ArrayList<>();
    }
    
    public boolean agregar_compra(Compra objCompra){
        if(objCompra != null){
            this.lis_compras.add(objCompra);
            return true;
        }
        return false;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Compra> getLis_compras() {
        return lis_compras;
    }

    public void setLis_compras(ArrayList<Compra> lis_compras) {
        this.lis_compras = lis_compras;
    }
 
}
