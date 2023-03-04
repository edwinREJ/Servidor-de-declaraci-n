package co.edu.unicauca.core.services;

import java.util.List;

import co.edu.unicauca.core.models.Cliente;
import co.edu.unicauca.core.models.Compra;

public interface IClienteService {

	public List<Cliente> findAll();		
	public Cliente findById(Integer id);	
	public Cliente save(Cliente cliente);	
	public Cliente update(Integer id, Cliente cliente);	
	public boolean delete(Integer id);	
        public Cliente add_buy(String tipo_id, Integer id, Compra obj_compra);

}
