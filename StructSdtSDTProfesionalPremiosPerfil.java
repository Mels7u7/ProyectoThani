package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalPremiosPerfil implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalPremiosPerfil( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalPremiosPerfil.class ));
   }

   public StructSdtSDTProfesionalPremiosPerfil( int remoteHandle ,
                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesionalPremiosPerfil_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Nombre = "" ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion = "" ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha = cal.getTime() ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N = (byte)(1) ;
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
      return gxTv_SdtSDTProfesionalPremiosPerfil_Id ;
   }

   public void setId( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Id = value ;
   }

   public String getNombre( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Nombre = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion = value ;
   }

   public java.util.Date getFecha( )
   {
      return gxTv_SdtSDTProfesionalPremiosPerfil_Fecha ;
   }

   public void setFecha( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremiosPerfil_Fecha = value ;
   }

   protected byte gxTv_SdtSDTProfesionalPremiosPerfil_Fecha_N ;
   protected byte gxTv_SdtSDTProfesionalPremiosPerfil_N ;
   protected String gxTv_SdtSDTProfesionalPremiosPerfil_Descripcion ;
   protected String gxTv_SdtSDTProfesionalPremiosPerfil_Nombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalPremiosPerfil_Id ;
   protected java.util.Date gxTv_SdtSDTProfesionalPremiosPerfil_Fecha ;
}

