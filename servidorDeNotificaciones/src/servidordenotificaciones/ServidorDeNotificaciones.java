package servidordenotificaciones;

import utilidades.UtilidadesRegistroS;

public class ServidorDeNotificaciones {

  
    public static void main(String[] args) {
       
         try 
        {
            /*String[] vectorDatosLocalizarNS = new String[4];//almacena la información para localizar el ns
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vectorDatosLocalizarNS[1] = UtilidadesConsola.leerCadena();
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vectorDatosLocalizarNS[3] = UtilidadesConsola.leerCadena();*/
            
            String[] varVectorDatosLocalizarNS = new String[4];
            varVectorDatosLocalizarNS[0] = "-ORBInitialHost";
            varVectorDatosLocalizarNS[1] = "localhost";
            varVectorDatosLocalizarNS[2] = "-ORBInitialPort";
            varVectorDatosLocalizarNS[3] = "2020";
            
            GestionNotificacionesImpl objRemotoNotificaciones = new GestionNotificacionesImpl();
      
            UtilidadesRegistroS.registrarObjetoRemoto(varVectorDatosLocalizarNS, objRemotoNotificaciones,"objNotificaciones");
      
            
        }    
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
        
    }
    
}
