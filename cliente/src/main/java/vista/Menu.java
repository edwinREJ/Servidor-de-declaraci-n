package vista;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Compra;
import servicios.ClienteServices;

public class Menu {

    private static ClienteServices objClienteServices;

    public static void main(String[] args) {
        objClienteServices = new ClienteServices();
         menu_principal();
    }
    
    
    private static void menu_principal(){
        
       int opcion=0;
        
       Scanner entrada = new Scanner(System.in);
        
       do{
            System.out.println("===MENU PRINCIPAL===");
            System.out.println("1. Agregar compra.");
            System.out.println("2. Listar clientes.");
            System.out.println("3. Salir.");
            System.out.println("====================");
            opcion = entrada.nextInt();
            
            switch (opcion) {
               case 1:
                   agregar_compra();
               break;
               
               case 2:
                   listar_clientes();
               break;
               
               case 3:
                   System.out.println("Salio.");
               break;    
               
               default:
                   System.out.println("Opcion invalida.");
           }
           
       }while(opcion!=3);
        
    }
    
    private static void agregar_compra(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Agregar compra.");
        System.out.println("Ingrese tipo del id: ");
        String tipo_id = entrada.next();
        System.out.println("Ingrese el id: ");
        int id = entrada.nextInt();
        System.out.println("Ingrese valor:");
        long valor = entrada.nextLong();
        System.out.println("Lugar de la compra:");
        String lugar = entrada.next();
        System.out.println("Ingrese el medio de pago: ");
        String medio_pago = entrada.next();
        System.out.println("Ingrese el nit de la empresa: ");
        String nit = entrada.next();
        
        Compra obj_compra = new Compra(valor, lugar, new Date() , medio_pago, nit);
        
        Cliente obj_cliente = objClienteServices.add_buy(tipo_id, id, obj_compra);
        
        System.out.println("Tipo de identificacion del cliente: " + obj_cliente.getTipo_id());
        
        for (Compra objCompra : obj_cliente.getLis_compras()) {
            System.out.println("valor: "+ objCompra.getValor());
            System.out.println("fecha: "+ objCompra.getFecha());
        }
        
    }
    
    private static void listar_clientes(){
        int i=1,j=1;
        
        System.out.println("\n listando clientes");
        List<Cliente> listaDeClientes = objClienteServices.listarClientes();

        for (Cliente cliente : listaDeClientes) {
            System.out.println("===============================================");
            System.out.println("Cliente "+i);
            System.out.println("Tipo de identificacion: " + cliente.getTipo_id());
            System.out.println("Numero de identidicacion: "+cliente.getId());
            
            for (Compra objCompra : cliente.getLis_compras()) {
                System.out.println("***********************************************");
                System.out.println("Compra "+j);
                System.out.println("Valor: "+ objCompra.getValor());
                System.out.println("Fecha: "+ objCompra.getFecha());
                System.out.println("Lugar: "+objCompra.getLugar_compra());
                System.out.println("Medio de pago: "+objCompra.getMedio_pago());
                System.out.println("Nit de la empresa: "+objCompra.getNit());
                System.out.println("***********************************************");
                j++;
            }
            j=1;
            i++;
            System.out.println("===============================================");
        }
    }
            

}

