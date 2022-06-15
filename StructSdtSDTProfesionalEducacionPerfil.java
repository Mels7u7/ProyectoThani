package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalEducacionPerfil implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalEducacionPerfil( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalEducacionPerfil.class ));
   }

   public StructSdtSDTProfesionalEducacionPerfil( int remoteHandle ,
                                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesionalEducacionPerfil_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion = "" ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde = cal.getTime() ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta = cal.getTime() ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre = "" ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N = (byte)(1) ;
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
      return gxTv_SdtSDTProfesionalEducacionPerfil_Id ;
   }

   public void setId( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Id = value ;
   }

   public String getNombreinstitucion( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion ;
   }

   public void setNombreinstitucion( String value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion = value ;
   }

   public java.util.Date getDesde( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Desde ;
   }

   public void setDesde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Desde = value ;
   }

   public java.util.Date getHasta( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Hasta ;
   }

   public void setHasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Hasta = value ;
   }

   public String getPaisnombre( )
   {
      return gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre ;
   }

   public void setPaisnombre( String value )
   {
      gxTv_SdtSDTProfesionalEducacionPerfil_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre = value ;
   }

   protected byte gxTv_SdtSDTProfesionalEducacionPerfil_Desde_N ;
   protected byte gxTv_SdtSDTProfesionalEducacionPerfil_Hasta_N ;
   protected byte gxTv_SdtSDTProfesionalEducacionPerfil_N ;
   protected String gxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion ;
   protected String gxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalEducacionPerfil_Id ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacionPerfil_Desde ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacionPerfil_Hasta ;
}

