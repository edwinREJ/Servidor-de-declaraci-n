package servicios;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import modelo.Compra;
import org.glassfish.jersey.jackson.JacksonFeature;



public class ClienteServices {
    
    private String endPoint;
    private Client objClientePeticiones; 
	
    public ClienteServices()
    {
	this.endPoint="http://localhost:4000/api/clientes";
	this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        listaClientes = objPeticion.get(new GenericType<List<Cliente>>() {});
        return listaClientes;
    }

    public Cliente add_buy(String tipo_id, Integer id, Compra prm_compra) {
        Cliente obj_cliente = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + tipo_id + "/" + id);
        Entity<Compra> data = Entity.entity(prm_compra, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        obj_cliente = objPeticion.post(data, Cliente.class);
        return obj_cliente;
    }
    
}
