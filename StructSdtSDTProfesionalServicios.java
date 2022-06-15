package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalServicios implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalServicios( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalServicios.class ));
   }

   public StructSdtSDTProfesionalServicios( int remoteHandle ,
                                            ModelContext context )
   {
      gxTv_SdtSDTProfesionalServicios_Serviciosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalServicios_Serviciosnombre = "" ;
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
      return gxTv_SdtSDTProfesionalServicios_Serviciosid ;
   }

   public void setServiciosid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalServicios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServicios_Serviciosid = value ;
   }

   public String getServiciosnombre( )
   {
      return gxTv_SdtSDTProfesionalServicios_Serviciosnombre ;
   }

   public void setServiciosnombre( String value )
   {
      gxTv_SdtSDTProfesionalServicios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServicios_Serviciosnombre = value ;
   }

   protected byte gxTv_SdtSDTProfesionalServicios_N ;
   protected String gxTv_SdtSDTProfesionalServicios_Serviciosnombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalServicios_Serviciosid ;
}

