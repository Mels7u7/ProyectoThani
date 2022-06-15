package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTListadoCitasPorPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtSDTListadoCitasPorPaciente( )
   {
      this( -1, new ModelContext( StructSdtSDTListadoCitasPorPaciente.class ));
   }

   public StructSdtSDTListadoCitasPorPaciente( int remoteHandle ,
                                               ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTListadoCitasPorPaciente_Codcita = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita = cal.getTime() ;
      gxTv_SdtSDTListadoCitasPorPaciente_Horacita = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Especialidad = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Estadocita = "" ;
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N = (byte)(1) ;
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

   public int getCitaid( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Citaid = value ;
   }

   public String getCodcita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Codcita ;
   }

   public void setCodcita( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Codcita = value ;
   }

   public String getPacientenombresapellidos( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos ;
   }

   public void setPacientenombresapellidos( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos = value ;
   }

   public java.util.Date getFechacita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Fechacita ;
   }

   public void setFechacita( java.util.Date value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Fechacita = value ;
   }

   public String getHoracita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Horacita ;
   }

   public void setHoracita( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Horacita = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid = value ;
   }

   public String getDoctornombresapellidos( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos ;
   }

   public void setDoctornombresapellidos( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos = value ;
   }

   public String getEspecialidad( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Especialidad ;
   }

   public void setEspecialidad( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Especialidad = value ;
   }

   public String getEstadocita( )
   {
      return gxTv_SdtSDTListadoCitasPorPaciente_Estadocita ;
   }

   public void setEstadocita( String value )
   {
      gxTv_SdtSDTListadoCitasPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoCitasPorPaciente_Estadocita = value ;
   }

   protected byte gxTv_SdtSDTListadoCitasPorPaciente_Fechacita_N ;
   protected byte gxTv_SdtSDTListadoCitasPorPaciente_N ;
   protected int gxTv_SdtSDTListadoCitasPorPaciente_Citaid ;
   protected int gxTv_SdtSDTListadoCitasPorPaciente_Profesionalid ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Codcita ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Estadocita ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Horacita ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos ;
   protected String gxTv_SdtSDTListadoCitasPorPaciente_Especialidad ;
   protected java.util.Date gxTv_SdtSDTListadoCitasPorPaciente_Fechacita ;
}

