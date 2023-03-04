package co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage;


/**
* sop_corba/GestionNotificacionesPackage/ClsMensajeNotificacionDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from notificaciones.idl
* viernes 5 de agosto de 2022 06:27:32 PM CEST
*/

abstract public class ClsMensajeNotificacionDTOHelper
{
  private static String  _id = "IDL:sop_corba/GestionNotificaciones/ClsMensajeNotificacionDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [5];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_double);
          _members0[0] = new org.omg.CORBA.StructMember (
            "valor",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "lugar_compra",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "fecha",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "medio_pago",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "nit",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTOHelper.id (), "ClsMensajeNotificacionDTO", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO read (org.omg.CORBA.portable.InputStream istream)
  {
        co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO value = new co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO ();
    value.valor = istream.read_double ();
    value.lugar_compra = istream.read_string ();
    value.fecha = istream.read_string ();
    value.medio_pago = istream.read_string ();
    value.nit = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, co.edu.unicauca.core.sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO value)
  {
    ostream.write_double (value.valor);
    ostream.write_string (value.lugar_compra);
    ostream.write_string (value.fecha);
    ostream.write_string (value.medio_pago);
    ostream.write_string (value.nit);
  }

}
