package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalExperienciaLaboralProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalExperienciaLaboralProfesional( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalExperienciaLaboralProfesional.class ));
   }

   public StructSdtSDTProfesionalExperienciaLaboralProfesional( int remoteHandle ,
                                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa = "" ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde = cal.getTime() ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta = cal.getTime() ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N = (byte)(1) ;
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
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id ;
   }

   public void setId( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id = value ;
   }

   public String getNombreempresa( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa ;
   }

   public void setNombreempresa( String value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa = value ;
   }

   public java.util.Date getDesde( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde ;
   }

   public void setDesde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde = value ;
   }

   public java.util.Date getHasta( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta ;
   }

   public void setHasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta = value ;
   }

   protected byte gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_N ;
   protected String gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa ;
   protected java.util.UUID gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta ;
}

