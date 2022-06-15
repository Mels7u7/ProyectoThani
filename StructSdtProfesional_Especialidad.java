package com.projectthani ;
import com.genexus.*;

public final  class StructSdtProfesional_Especialidad implements Cloneable, java.io.Serializable
{
   public StructSdtProfesional_Especialidad( )
   {
      this( -1, new ModelContext( StructSdtProfesional_Especialidad.class ));
   }

   public StructSdtProfesional_Especialidad( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo = "" ;
      gxTv_SdtProfesional_Especialidad_Especialidadnombre = "" ;
      gxTv_SdtProfesional_Especialidad_Mode = "" ;
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z = "" ;
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

   public short getEspecialidadid( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Especialidadid = value ;
   }

   public String getEspecialidadcodigo( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadcodigo ;
   }

   public void setEspecialidadcodigo( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo = value ;
   }

   public String getEspecialidadnombre( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadnombre ;
   }

   public void setEspecialidadnombre( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Especialidadnombre = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtProfesional_Especialidad_Sede> getSede( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede ;
   }

   public void setSede( java.util.Vector<com.projectthani.StructSdtProfesional_Especialidad_Sede> value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProfesional_Especialidad_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtProfesional_Especialidad_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProfesional_Especialidad_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Initialized = value ;
   }

   public short getEspecialidadid_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadid_Z ;
   }

   public void setEspecialidadid_Z( short value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Especialidadid_Z = value ;
   }

   public String getEspecialidadcodigo_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z ;
   }

   public void setEspecialidadcodigo_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z = value ;
   }

   public String getEspecialidadnombre_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z ;
   }

   public void setEspecialidadnombre_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z = value ;
   }

   private byte gxTv_SdtProfesional_Especialidad_N ;
   protected short gxTv_SdtProfesional_Especialidad_Especialidadid ;
   protected short gxTv_SdtProfesional_Especialidad_Modified ;
   protected short gxTv_SdtProfesional_Especialidad_Initialized ;
   protected short gxTv_SdtProfesional_Especialidad_Especialidadid_Z ;
   protected String gxTv_SdtProfesional_Especialidad_Mode ;
   protected String gxTv_SdtProfesional_Especialidad_Especialidadcodigo ;
   protected String gxTv_SdtProfesional_Especialidad_Especialidadnombre ;
   protected String gxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z ;
   protected String gxTv_SdtProfesional_Especialidad_Especialidadnombre_Z ;
   protected java.util.Vector<com.projectthani.StructSdtProfesional_Especialidad_Sede> gxTv_SdtProfesional_Especialidad_Sede=null ;
}

