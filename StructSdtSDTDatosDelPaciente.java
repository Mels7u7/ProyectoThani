package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTDatosDelPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtSDTDatosDelPaciente( )
   {
      this( -1, new ModelContext( StructSdtSDTDatosDelPaciente.class ));
   }

   public StructSdtSDTDatosDelPaciente( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_SdtSDTDatosDelPaciente_Nombresapellidos = "" ;
      gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad = "" ;
      gxTv_SdtSDTDatosDelPaciente_Direccion = "" ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia = "" ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi = "" ;
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

   public short getIdpaciente( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Idpaciente ;
   }

   public void setIdpaciente( short value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Idpaciente = value ;
   }

   public String getNombresapellidos( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Nombresapellidos ;
   }

   public void setNombresapellidos( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Nombresapellidos = value ;
   }

   public String getFechanacimientoedad( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad ;
   }

   public void setFechanacimientoedad( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad = value ;
   }

   public String getDireccion( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Direccion ;
   }

   public void setDireccion( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Direccion = value ;
   }

   public String getFotografia( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Fotografia ;
   }

   public void setFotografia( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia = value ;
   }

   public String getFotografia_gxi( )
   {
      return gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi ;
   }

   public void setFotografia_gxi( String value )
   {
      gxTv_SdtSDTDatosDelPaciente_N = (byte)(0) ;
      gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi = value ;
   }

   protected byte gxTv_SdtSDTDatosDelPaciente_N ;
   protected short gxTv_SdtSDTDatosDelPaciente_Idpaciente ;
   protected String gxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad ;
   protected String gxTv_SdtSDTDatosDelPaciente_Direccion ;
   protected String gxTv_SdtSDTDatosDelPaciente_Nombresapellidos ;
   protected String gxTv_SdtSDTDatosDelPaciente_Fotografia_gxi ;
   protected String gxTv_SdtSDTDatosDelPaciente_Fotografia ;
}

