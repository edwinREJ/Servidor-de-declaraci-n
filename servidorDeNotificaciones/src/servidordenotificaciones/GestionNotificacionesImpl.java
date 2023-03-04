package servidordenotificaciones;

import sop_corba.GestionNotificacionesPOA;
import sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO;

    public class GestionNotificacionesImpl extends GestionNotificacionesPOA{

    @Override
    public void notificaarRegistro(ClsMensajeNotificacionDTO objNotificacion) {

        System.out.println("Notificacion de declaracion de renta.");
        System.out.println("Fecha de compra: "+objNotificacion.fecha);
        System.out.println("Valor de la compra: "+(long)objNotificacion.valor);
        System.out.println("Lugar de la compra: "+objNotificacion.lugar_compra);
        System.out.println("Nit de la empresa: "+objNotificacion.nit);
        System.out.println("Medio de pago: "+ objNotificacion.medio_pago);
    }
}
