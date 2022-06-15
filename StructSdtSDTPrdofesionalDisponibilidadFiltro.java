package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTPrdofesionalDisponibilidadFiltro implements Cloneable, java.io.Serializable
{
   public StructSdtSDTPrdofesionalDisponibilidadFiltro( )
   {
      this( -1, new ModelContext( StructSdtSDTPrdofesionalDisponibilidadFiltro.class ));
   }

   public StructSdtSDTPrdofesionalDisponibilidadFiltro( int remoteHandle ,
                                                        ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad = "" ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita = "" ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita = cal.getTime() ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita = "" ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N = (byte)(1) ;
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

   public int getDisponibilidadid( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid ;
   }

   public void setDisponibilidadid( int value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid = value ;
   }

   public String getEspecialidad( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad ;
   }

   public void setEspecialidad( String value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad = value ;
   }

   public String getTipocita( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita ;
   }

   public void setTipocita( String value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita = value ;
   }

   public java.util.Date getFechacita( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita ;
   }

   public void setFechacita( java.util.Date value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita = value ;
   }

   public String getCostocita( )
   {
      return gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita ;
   }

   public void setCostocita( String value )
   {
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N = (byte)(0) ;
      gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita = value ;
   }

   protected byte gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita_N ;
   protected byte gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_N ;
   protected int gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Disponibilidadid ;
   protected int gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid ;
   protected String gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad ;
   protected String gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita ;
   protected String gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita ;
   protected java.util.Date gxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita ;
}

