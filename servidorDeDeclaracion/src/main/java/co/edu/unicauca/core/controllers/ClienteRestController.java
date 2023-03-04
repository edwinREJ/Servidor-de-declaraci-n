package co.edu.unicauca.core.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.core.models.Cliente;
import co.edu.unicauca.core.models.Compra;
import co.edu.unicauca.core.services.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> mostar() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Integer id) {
        Cliente objCliente = null;
        objCliente = clienteService.findById(id);
        return objCliente;
    }

    @PostMapping("/clientes")
    public Cliente create(@RequestBody Cliente cliente) {
        Cliente objCliente = null;
        objCliente = clienteService.save(cliente);
        return objCliente;
    }

    @PutMapping("/clientes/{id}")
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Integer id) {
        Cliente objCliente = null;
        Cliente clienteActual = clienteService.findById(id);
        if (clienteActual != null) {
            objCliente = clienteService.update(id, cliente);
        }
        return objCliente;
    }

    @PostMapping("/clientes/{tipo_id}/{id}")
    public Cliente agregar_compra(@RequestBody Compra prm_compra, @PathVariable String tipo_id,
        @PathVariable Integer id) {
        Cliente obj_cliente = null;
        obj_cliente = clienteService.add_buy(tipo_id, id, prm_compra);
        return obj_cliente;
    }

    @DeleteMapping("/clientes/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        Cliente clienteActual = clienteService.findById(id);
        if (clienteActual != null) {
            bandera = clienteService.delete(id);
        }
        return bandera;

    }

    @GetMapping("/clientes/listarCabeceras")
    public void listarCabeceras(@RequestHeader Map<String, String> headers) {
        System.out.println("cabeceras");
        headers.forEach((key, value) -> {
            System.out.println(String.format("Cabecera '%s' = %s", key, value));
        });
    }

}
