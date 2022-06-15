package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTDoctorReservarCita implements Cloneable, java.io.Serializable
{
   public StructSdtSDTDoctorReservarCita( )
   {
      this( -1, new ModelContext( StructSdtSDTDoctorReservarCita.class ));
   }

   public StructSdtSDTDoctorReservarCita( int remoteHandle ,
                                          ModelContext context )
   {
      gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto = "" ;
      gxTv_SdtSDTDoctorReservarCita_Especialidadnombre = "" ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto = "" ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTDoctorReservarCita_Calificacion = "" ;
      gxTv_SdtSDTDoctorReservarCita_Direccion = "" ;
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

   public String getProfesionalnombrecompleto( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto ;
   }

   public void setProfesionalnombrecompleto( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto = value ;
   }

   public String getEspecialidadnombre( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Especialidadnombre ;
   }

   public void setEspecialidadnombre( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Especialidadnombre = value ;
   }

   public String getProfesionalfoto( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalfoto ;
   }

   public void setProfesionalfoto( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto = value ;
   }

   public String getProfesionalfoto_gxi( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi ;
   }

   public void setProfesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi = value ;
   }

   public String getCalificacion( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Calificacion ;
   }

   public void setCalificacion( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Calificacion = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Profesionalid = value ;
   }

   public String getDireccion( )
   {
      return gxTv_SdtSDTDoctorReservarCita_Direccion ;
   }

   public void setDireccion( String value )
   {
      gxTv_SdtSDTDoctorReservarCita_N = (byte)(0) ;
      gxTv_SdtSDTDoctorReservarCita_Direccion = value ;
   }

   protected byte gxTv_SdtSDTDoctorReservarCita_N ;
   protected int gxTv_SdtSDTDoctorReservarCita_Profesionalid ;
   protected String gxTv_SdtSDTDoctorReservarCita_Calificacion ;
   protected String gxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto ;
   protected String gxTv_SdtSDTDoctorReservarCita_Especialidadnombre ;
   protected String gxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTDoctorReservarCita_Direccion ;
   protected String gxTv_SdtSDTDoctorReservarCita_Profesionalfoto ;
}

