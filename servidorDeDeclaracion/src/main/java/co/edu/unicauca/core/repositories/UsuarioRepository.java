package co.edu.unicauca.core.repositories;

import co.edu.unicauca.core.models.Cliente;
import co.edu.unicauca.core.models.Compra;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.unicauca.core.sop_corba.GestionNotificaciones;
import co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO;
import co.edu.unicauca.core.utilidades.UtilidadesRegistroC;


@Service
public class UsuarioRepository {
    private static GestionNotificaciones objNotificaciones;
    private ArrayList<Cliente> lis_clientes;
    private GestionNotificaciones ref;
    
    public UsuarioRepository() {
        this.lis_clientes = new ArrayList<>();
        cargar_clientes();
    }

    public List<Cliente> findAll() {
        System.out.println("Invocando a listarclientes.");
        return this.lis_clientes;
    }
    
    public void pasar_referencia(GestionNotificaciones objNotificacion){
        ref = objNotificacion;
    }
    
    public Cliente add_buy(String tipo_id, Integer id, Compra obj_compra) {

        System.out.println("Invocando agregar compra.");
        Cliente obj_cliente = findById_tipoId(tipo_id, id);
        
        if(obj_cliente != null){
            obj_cliente.agregar_compra(obj_compra);
        }
        else{
             obj_cliente = new Cliente(tipo_id, id);
            obj_cliente.agregar_compra(obj_compra);
            this.lis_clientes.add(obj_cliente);
        } 
        
        evaluar_lista_compra(obj_cliente,obj_compra);  
        return obj_cliente;
    }
    
    private void evaluar_lista_compra(Cliente prmCliente,Compra obj_compra){
        Double acumulador = 0.0;
        for (Compra objCompra : prmCliente.getLis_compras()) {
            acumulador = acumulador + objCompra.getValor();
            if (acumulador > 45000000) {
                String medio_pago = obj_compra.getMedio_pago();
                long valor = obj_compra.getValor();
                String lugar = obj_compra.getLugar_compra();
                String fecha = obj_compra.getFecha().toString();
                String nit = obj_compra.getNit();
                obtener_referencia_objnotificaciones();
                ClsMensajeNotificacionDTO objNotificacion = new ClsMensajeNotificacionDTO(valor, lugar, fecha, medio_pago, nit);
                objNotificaciones.notificaarRegistro(objNotificacion);
            }
        }
    }
    
    private void obtener_referencia_objnotificaciones(){
        String[] varVectorDatosLocalizarNS = new String[4];
        varVectorDatosLocalizarNS[0] = "-ORBInitialHost";
        varVectorDatosLocalizarNS[1] = "localhost";
        varVectorDatosLocalizarNS[2] = "-ORBInitialPort";
        varVectorDatosLocalizarNS[3] = "2020";

        objNotificaciones = UtilidadesRegistroC.obtenerObjRemoto(varVectorDatosLocalizarNS, "objNotificaciones");

    }
    
    private Cliente findById_tipoId(String tipo_id, int id) {
        System.out.println("Invocando a consultar un cliente con id y tipo id.");
        Cliente objCliente = null;

        for (Cliente cliente : lis_clientes) {
            if (cliente.getId() == id && cliente.getTipo_id().equals(tipo_id)) {
                objCliente = cliente;
                break;
            }
        }
        return objCliente;
    }
    

    public Cliente findById(Integer id) {
        System.out.println("Invocando a consultar un cliente.");
        Cliente objCliente = null;

        for (Cliente cliente : lis_clientes) {
            if (cliente.getId() == id) {
                objCliente = cliente;
                break;
            }
        }
        return objCliente;
    }

    public Cliente save(Cliente cliente) {
        System.out.println("Invocando a almacenar cliente.");
        Cliente objCliente = null;
        if (this.lis_clientes.add(cliente)) {
            objCliente = cliente;
        }

        return objCliente;
    }

    public Cliente update(Integer id, Cliente cliente) {
        System.out.println("Invocando a actualizar un cliente.");
        Cliente objCliente = null;

        for (int i = 0; i < this.lis_clientes.size(); i++) {
            if (this.lis_clientes.get(i).getId() == id) {
                this.lis_clientes.set(i, cliente);
                objCliente = cliente;
                break;
            }
        }

        return objCliente;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un cliente.");
        boolean bandera = false;

        for (int i = 0; i < this.lis_clientes.size(); i++) {
            if (this.lis_clientes.get(i).getId() == id) {
                this.lis_clientes.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }
    
    private void cargar_clientes(){
        
        Cliente c1 = new Cliente("CC",1);
        Cliente c2 = new Cliente("CC",2);
        Compra obj_compra1 = new Compra(10000000,"Exito",new Date(),"Efectivo","12-r");
        Compra obj_compra2 = new Compra(20000000,"Olimpica",new Date(),"Devito","12-r");
        c1.agregar_compra(obj_compra1);
        c1.agregar_compra(obj_compra2);
        this.lis_clientes.add(c1);
        this.lis_clientes.add(c2);
        Compra obj_compra3 = new Compra(12000000,"De uno",new Date(),"Devito","145-r");
        c2.agregar_compra(obj_compra3);
    }

}
