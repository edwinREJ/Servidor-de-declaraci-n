package co.edu.unicauca.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.core.models.Cliente;
import co.edu.unicauca.core.models.Compra;
import co.edu.unicauca.core.repositories.UsuarioRepository;
import co.edu.unicauca.core.sop_corba.GestionNotificaciones;



@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;
    private GestionNotificaciones ref;
    
    @Override
    public List<Cliente> findAll() {
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return this.servicioAccesoBaseDatos.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return this.servicioAccesoBaseDatos.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        return this.servicioAccesoBaseDatos.update(id, cliente);
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

   
    @Override
    public Cliente add_buy(String tipo_id, Integer id, Compra obj_compra) {
        
        return this.servicioAccesoBaseDatos.add_buy(tipo_id, id, obj_compra);
    }
    public void mandar_objremoto(GestionNotificaciones objNotificacion){
        this.servicioAccesoBaseDatos.pasar_referencia(objNotificacion);
    }
}
