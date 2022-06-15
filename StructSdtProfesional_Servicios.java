package com.projectthani ;
import com.genexus.*;

public final  class StructSdtProfesional_Servicios implements Cloneable, java.io.Serializable
{
   public StructSdtProfesional_Servicios( )
   {
      this( -1, new ModelContext( StructSdtProfesional_Servicios.class ));
   }

   public StructSdtProfesional_Servicios( int remoteHandle ,
                                          ModelContext context )
   {
      gxTv_SdtProfesional_Servicios_Serviciosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Servicios_Serviciosnombre = "" ;
      gxTv_SdtProfesional_Servicios_Mode = "" ;
      gxTv_SdtProfesional_Servicios_Serviciosid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Servicios_Serviciosnombre_Z = "" ;
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

   public java.util.UUID getServiciosid( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosid ;
   }

   public void setServiciosid( java.util.UUID value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Serviciosid = value ;
   }

   public String getServiciosnombre( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosnombre ;
   }

   public void setServiciosnombre( String value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Serviciosnombre = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProfesional_Servicios_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtProfesional_Servicios_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProfesional_Servicios_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Initialized = value ;
   }

   public java.util.UUID getServiciosid_Z( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosid_Z ;
   }

   public void setServiciosid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Serviciosid_Z = value ;
   }

   public String getServiciosnombre_Z( )
   {
      return gxTv_SdtProfesional_Servicios_Serviciosnombre_Z ;
   }

   public void setServiciosnombre_Z( String value )
   {
      gxTv_SdtProfesional_Servicios_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios_Serviciosnombre_Z = value ;
   }

   private byte gxTv_SdtProfesional_Servicios_N ;
   protected short gxTv_SdtProfesional_Servicios_Modified ;
   protected short gxTv_SdtProfesional_Servicios_Initialized ;
   protected String gxTv_SdtProfesional_Servicios_Mode ;
   protected String gxTv_SdtProfesional_Servicios_Serviciosnombre ;
   protected String gxTv_SdtProfesional_Servicios_Serviciosnombre_Z ;
   protected java.util.UUID gxTv_SdtProfesional_Servicios_Serviciosid ;
   protected java.util.UUID gxTv_SdtProfesional_Servicios_Serviciosid_Z ;
}

