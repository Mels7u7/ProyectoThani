package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTDisponibilidad implements Cloneable, java.io.Serializable
{
   public StructSdtSDTDisponibilidad( )
   {
      this( -1, new ModelContext( StructSdtSDTDisponibilidad.class ));
   }

   public StructSdtSDTDisponibilidad( int remoteHandle ,
                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTDisponibilidad_Eventid = "" ;
      gxTv_SdtSDTDisponibilidad_Disponibilidaddescription = "" ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha = cal.getTime() ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio = cal.getTime() ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin = cal.getTime() ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre = "" ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado = "" ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadestado = "" ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N = (byte)(1) ;
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
      return gxTv_SdtSDTDisponibilidad_Disponibilidadid ;
   }

   public void setDisponibilidadid( int value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadid = value ;
   }

   public String getEventid( )
   {
      return gxTv_SdtSDTDisponibilidad_Eventid ;
   }

   public void setEventid( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Eventid = value ;
   }

   public String getDisponibilidaddescription( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidaddescription ;
   }

   public void setDisponibilidaddescription( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidaddescription = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtSDTDisponibilidad_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Profesionalid = value ;
   }

   public java.util.Date getDisponibilidadfecha( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadfecha ;
   }

   public void setDisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadfecha = value ;
   }

   public java.util.Date getDisponibilidadhorainicio( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio ;
   }

   public void setDisponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio = value ;
   }

   public java.util.Date getDisponibilidadhorafin( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin ;
   }

   public void setDisponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin = value ;
   }

   public short getEspecialidadid( )
   {
      return gxTv_SdtSDTDisponibilidad_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Especialidadid = value ;
   }

   public short getSgsededisponibilidadsedeid( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid ;
   }

   public void setSgsededisponibilidadsedeid( short value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid = value ;
   }

   public String getSgsededisponibilidadsedenombre( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre ;
   }

   public void setSgsededisponibilidadsedenombre( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre = value ;
   }

   public short getSgsededisponibilidadclinicaid( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid ;
   }

   public void setSgsededisponibilidadclinicaid( short value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid = value ;
   }

   public String getSgsededisponibilidadclinicaabreviado( )
   {
      return gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
   }

   public void setSgsededisponibilidadclinicaabreviado( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado = value ;
   }

   public String getDisponibilidadestado( )
   {
      return gxTv_SdtSDTDisponibilidad_Disponibilidadestado ;
   }

   public void setDisponibilidadestado( String value )
   {
      gxTv_SdtSDTDisponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidad_Disponibilidadestado = value ;
   }

   protected byte gxTv_SdtSDTDisponibilidad_Disponibilidadfecha_N ;
   protected byte gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio_N ;
   protected byte gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin_N ;
   protected byte gxTv_SdtSDTDisponibilidad_N ;
   protected short gxTv_SdtSDTDisponibilidad_Especialidadid ;
   protected short gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid ;
   protected short gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaid ;
   protected int gxTv_SdtSDTDisponibilidad_Disponibilidadid ;
   protected int gxTv_SdtSDTDisponibilidad_Profesionalid ;
   protected String gxTv_SdtSDTDisponibilidad_Eventid ;
   protected String gxTv_SdtSDTDisponibilidad_Disponibilidadestado ;
   protected String gxTv_SdtSDTDisponibilidad_Disponibilidaddescription ;
   protected String gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedenombre ;
   protected String gxTv_SdtSDTDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
   protected java.util.Date gxTv_SdtSDTDisponibilidad_Disponibilidadfecha ;
   protected java.util.Date gxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio ;
   protected java.util.Date gxTv_SdtSDTDisponibilidad_Disponibilidadhorafin ;
}

