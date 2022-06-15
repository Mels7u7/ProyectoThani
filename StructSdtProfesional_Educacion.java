package com.projectthani ;
import com.genexus.*;

public final  class StructSdtProfesional_Educacion implements Cloneable, java.io.Serializable
{
   public StructSdtProfesional_Educacion( )
   {
      this( -1, new ModelContext( StructSdtProfesional_Educacion.class ));
   }

   public StructSdtProfesional_Educacion( int remoteHandle ,
                                          ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtProfesional_Educacion_Educacionid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion = "" ;
      gxTv_SdtProfesional_Educacion_Educaciondesde = cal.getTime() ;
      gxTv_SdtProfesional_Educacion_Educacionhasta = cal.getTime() ;
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion = "" ;
      gxTv_SdtProfesional_Educacion_Mode = "" ;
      gxTv_SdtProfesional_Educacion_Educacionid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z = "" ;
      gxTv_SdtProfesional_Educacion_Educaciondesde_Z = cal.getTime() ;
      gxTv_SdtProfesional_Educacion_Educacionhasta_Z = cal.getTime() ;
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z = "" ;
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

   public java.util.UUID getEducacionid( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionid ;
   }

   public void setEducacionid( java.util.UUID value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionid = value ;
   }

   public String getEducacionnombreinstitucion( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion ;
   }

   public void setEducacionnombreinstitucion( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion = value ;
   }

   public java.util.Date getEducaciondesde( )
   {
      return gxTv_SdtProfesional_Educacion_Educaciondesde ;
   }

   public void setEducaciondesde( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educaciondesde = value ;
   }

   public java.util.Date getEducacionhasta( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionhasta ;
   }

   public void setEducacionhasta( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionhasta = value ;
   }

   public String getEducacionpaisdescripcion( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion ;
   }

   public void setEducacionpaisdescripcion( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProfesional_Educacion_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtProfesional_Educacion_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProfesional_Educacion_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Initialized = value ;
   }

   public java.util.UUID getEducacionid_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionid_Z ;
   }

   public void setEducacionid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionid_Z = value ;
   }

   public String getEducacionnombreinstitucion_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z ;
   }

   public void setEducacionnombreinstitucion_Z( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z = value ;
   }

   public java.util.Date getEducaciondesde_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educaciondesde_Z ;
   }

   public void setEducaciondesde_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educaciondesde_Z = value ;
   }

   public java.util.Date getEducacionhasta_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionhasta_Z ;
   }

   public void setEducacionhasta_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionhasta_Z = value ;
   }

   public String getEducacionpaisdescripcion_Z( )
   {
      return gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z ;
   }

   public void setEducacionpaisdescripcion_Z( String value )
   {
      gxTv_SdtProfesional_Educacion_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z = value ;
   }

   private byte gxTv_SdtProfesional_Educacion_N ;
   protected short gxTv_SdtProfesional_Educacion_Modified ;
   protected short gxTv_SdtProfesional_Educacion_Initialized ;
   protected String gxTv_SdtProfesional_Educacion_Mode ;
   protected String gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion ;
   protected String gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion ;
   protected String gxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z ;
   protected String gxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z ;
   protected java.util.UUID gxTv_SdtProfesional_Educacion_Educacionid ;
   protected java.util.UUID gxTv_SdtProfesional_Educacion_Educacionid_Z ;
   protected java.util.Date gxTv_SdtProfesional_Educacion_Educaciondesde ;
   protected java.util.Date gxTv_SdtProfesional_Educacion_Educacionhasta ;
   protected java.util.Date gxTv_SdtProfesional_Educacion_Educaciondesde_Z ;
   protected java.util.Date gxTv_SdtProfesional_Educacion_Educacionhasta_Z ;
}

