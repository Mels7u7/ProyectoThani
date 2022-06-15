package com.projectthani ;
import com.genexus.*;

public final  class StructSdtEspecialidad implements Cloneable, java.io.Serializable
{
   public StructSdtEspecialidad( )
   {
      this( -1, new ModelContext( StructSdtEspecialidad.class ));
   }

   public StructSdtEspecialidad( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtEspecialidad_Especialidadnombre = "" ;
      gxTv_SdtEspecialidad_Especialidaddescripcion = "" ;
      gxTv_SdtEspecialidad_Especialidadcodigo = "" ;
      gxTv_SdtEspecialidad_Especialidadfoto = "" ;
      gxTv_SdtEspecialidad_Especialidadfoto_gxi = "" ;
      gxTv_SdtEspecialidad_Especialidadestado = "" ;
      gxTv_SdtEspecialidad_Mode = "" ;
      gxTv_SdtEspecialidad_Especialidadnombre_Z = "" ;
      gxTv_SdtEspecialidad_Especialidaddescripcion_Z = "" ;
      gxTv_SdtEspecialidad_Especialidadcodigo_Z = "" ;
      gxTv_SdtEspecialidad_Especialidadestado_Z = "" ;
      gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z = "" ;
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
      return gxTv_SdtEspecialidad_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadid = value ;
   }

   public String getEspecialidadnombre( )
   {
      return gxTv_SdtEspecialidad_Especialidadnombre ;
   }

   public void setEspecialidadnombre( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadnombre = value ;
   }

   public String getEspecialidaddescripcion( )
   {
      return gxTv_SdtEspecialidad_Especialidaddescripcion ;
   }

   public void setEspecialidaddescripcion( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidaddescripcion = value ;
   }

   public String getEspecialidadcodigo( )
   {
      return gxTv_SdtEspecialidad_Especialidadcodigo ;
   }

   public void setEspecialidadcodigo( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadcodigo = value ;
   }

   public String getEspecialidadfoto( )
   {
      return gxTv_SdtEspecialidad_Especialidadfoto ;
   }

   public void setEspecialidadfoto( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadfoto = value ;
   }

   public String getEspecialidadfoto_gxi( )
   {
      return gxTv_SdtEspecialidad_Especialidadfoto_gxi ;
   }

   public void setEspecialidadfoto_gxi( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadfoto_gxi = value ;
   }

   public String getEspecialidadestado( )
   {
      return gxTv_SdtEspecialidad_Especialidadestado ;
   }

   public void setEspecialidadestado( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadestado = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtEspecialidad_Sede> getSede( )
   {
      return gxTv_SdtEspecialidad_Sede ;
   }

   public void setSede( java.util.Vector<com.projectthani.StructSdtEspecialidad_Sede> value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEspecialidad_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEspecialidad_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Initialized = value ;
   }

   public short getEspecialidadid_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadid_Z ;
   }

   public void setEspecialidadid_Z( short value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadid_Z = value ;
   }

   public String getEspecialidadnombre_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadnombre_Z ;
   }

   public void setEspecialidadnombre_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadnombre_Z = value ;
   }

   public String getEspecialidaddescripcion_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidaddescripcion_Z ;
   }

   public void setEspecialidaddescripcion_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidaddescripcion_Z = value ;
   }

   public String getEspecialidadcodigo_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadcodigo_Z ;
   }

   public void setEspecialidadcodigo_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadcodigo_Z = value ;
   }

   public String getEspecialidadestado_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadestado_Z ;
   }

   public void setEspecialidadestado_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadestado_Z = value ;
   }

   public String getEspecialidadfoto_gxi_Z( )
   {
      return gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z ;
   }

   public void setEspecialidadfoto_gxi_Z( String value )
   {
      gxTv_SdtEspecialidad_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z = value ;
   }

   private byte gxTv_SdtEspecialidad_N ;
   protected short gxTv_SdtEspecialidad_Especialidadid ;
   protected short gxTv_SdtEspecialidad_Initialized ;
   protected short gxTv_SdtEspecialidad_Especialidadid_Z ;
   protected String gxTv_SdtEspecialidad_Especialidadestado ;
   protected String gxTv_SdtEspecialidad_Mode ;
   protected String gxTv_SdtEspecialidad_Especialidadestado_Z ;
   protected String gxTv_SdtEspecialidad_Especialidadnombre ;
   protected String gxTv_SdtEspecialidad_Especialidaddescripcion ;
   protected String gxTv_SdtEspecialidad_Especialidadcodigo ;
   protected String gxTv_SdtEspecialidad_Especialidadfoto_gxi ;
   protected String gxTv_SdtEspecialidad_Especialidadnombre_Z ;
   protected String gxTv_SdtEspecialidad_Especialidaddescripcion_Z ;
   protected String gxTv_SdtEspecialidad_Especialidadcodigo_Z ;
   protected String gxTv_SdtEspecialidad_Especialidadfoto_gxi_Z ;
   protected String gxTv_SdtEspecialidad_Especialidadfoto ;
   protected java.util.Vector<com.projectthani.StructSdtEspecialidad_Sede> gxTv_SdtEspecialidad_Sede=null ;
}

