package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalServiciosPerfil implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalServiciosPerfil( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalServiciosPerfil.class ));
   }

   public StructSdtSDTProfesionalServiciosPerfil( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtSDTProfesionalServiciosPerfil_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio = "" ;
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

   public java.util.UUID getId( )
   {
      return gxTv_SdtSDTProfesionalServiciosPerfil_Id ;
   }

   public void setId( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalServiciosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServiciosPerfil_Id = value ;
   }

   public String getNombreservicio( )
   {
      return gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio ;
   }

   public void setNombreservicio( String value )
   {
      gxTv_SdtSDTProfesionalServiciosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio = value ;
   }

   protected byte gxTv_SdtSDTProfesionalServiciosPerfil_N ;
   protected String gxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio ;
   protected java.util.UUID gxTv_SdtSDTProfesionalServiciosPerfil_Id ;
}

