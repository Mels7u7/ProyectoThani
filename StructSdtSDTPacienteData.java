package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTPacienteData implements Cloneable, java.io.Serializable
{
   public StructSdtSDTPacienteData( )
   {
      this( -1, new ModelContext( StructSdtSDTPacienteData.class ));
   }

   public StructSdtSDTPacienteData( int remoteHandle ,
                                    ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTPacienteData_Pacienteapellidopaterno = "" ;
      gxTv_SdtSDTPacienteData_Pacienteapellidomaterno = "" ;
      gxTv_SdtSDTPacienteData_Pacientenombres = "" ;
      gxTv_SdtSDTPacienteData_Pacientecorreo = "" ;
      gxTv_SdtSDTPacienteData_Pacientetelefono = "" ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento = cal.getTime() ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion = "" ;
      gxTv_SdtSDTPacienteData_Pacientenrodocumento = "" ;
      gxTv_SdtSDTPacienteData_Pacientetipodocumento = "" ;
      gxTv_SdtSDTPacienteData_Pacientesexo = "" ;
      gxTv_SdtSDTPacienteData_Pacientedireccion = "" ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getPacienteapellidopaterno( )
   {
      return gxTv_SdtSDTPacienteData_Pacienteapellidopaterno ;
   }

   public void setPacienteapellidopaterno( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacienteapellidopaterno = value ;
   }

   public String getPacienteapellidomaterno( )
   {
      return gxTv_SdtSDTPacienteData_Pacienteapellidomaterno ;
   }

   public void setPacienteapellidomaterno( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacienteapellidomaterno = value ;
   }

   public String getPacientenombres( )
   {
      return gxTv_SdtSDTPacienteData_Pacientenombres ;
   }

   public void setPacientenombres( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientenombres = value ;
   }

   public String getPacientecorreo( )
   {
      return gxTv_SdtSDTPacienteData_Pacientecorreo ;
   }

   public void setPacientecorreo( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientecorreo = value ;
   }

   public String getPacientetelefono( )
   {
      return gxTv_SdtSDTPacienteData_Pacientetelefono ;
   }

   public void setPacientetelefono( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientetelefono = value ;
   }

   public java.util.Date getPacientefechanacimiento( )
   {
      return gxTv_SdtSDTPacienteData_Pacientefechanacimiento ;
   }

   public void setPacientefechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimiento = value ;
   }

   public String getPacientefechanacimientodescripcion( )
   {
      return gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion ;
   }

   public void setPacientefechanacimientodescripcion( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion = value ;
   }

   public String getPacientenrodocumento( )
   {
      return gxTv_SdtSDTPacienteData_Pacientenrodocumento ;
   }

   public void setPacientenrodocumento( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientenrodocumento = value ;
   }

   public String getPacientetipodocumento( )
   {
      return gxTv_SdtSDTPacienteData_Pacientetipodocumento ;
   }

   public void setPacientetipodocumento( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientetipodocumento = value ;
   }

   public String getPacientesexo( )
   {
      return gxTv_SdtSDTPacienteData_Pacientesexo ;
   }

   public void setPacientesexo( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientesexo = value ;
   }

   public String getPacientedireccion( )
   {
      return gxTv_SdtSDTPacienteData_Pacientedireccion ;
   }

   public void setPacientedireccion( String value )
   {
      gxTv_SdtSDTPacienteData_N = (byte)(0) ;
      gxTv_SdtSDTPacienteData_Pacientedireccion = value ;
   }

   protected byte gxTv_SdtSDTPacienteData_Pacientefechanacimiento_N ;
   protected byte gxTv_SdtSDTPacienteData_N ;
   protected String gxTv_SdtSDTPacienteData_Pacientetelefono ;
   protected String gxTv_SdtSDTPacienteData_Pacientetipodocumento ;
   protected String gxTv_SdtSDTPacienteData_Pacientesexo ;
   protected String gxTv_SdtSDTPacienteData_Pacienteapellidopaterno ;
   protected String gxTv_SdtSDTPacienteData_Pacienteapellidomaterno ;
   protected String gxTv_SdtSDTPacienteData_Pacientenombres ;
   protected String gxTv_SdtSDTPacienteData_Pacientecorreo ;
   protected String gxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion ;
   protected String gxTv_SdtSDTPacienteData_Pacientenrodocumento ;
   protected String gxTv_SdtSDTPacienteData_Pacientedireccion ;
   protected java.util.Date gxTv_SdtSDTPacienteData_Pacientefechanacimiento ;
}

