package com.projectthani ;
import com.genexus.*;

public final  class StructSdtEducacionProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtEducacionProfesional( )
   {
      this( -1, new ModelContext( StructSdtEducacionProfesional.class ));
   }

   public StructSdtEducacionProfesional( int remoteHandle ,
                                         ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde = cal.getTime() ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta = cal.getTime() ;
      gxTv_SdtEducacionProfesional_Mode = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z = "" ;
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z = cal.getTime() ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z = cal.getTime() ;
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

   public int getEducacionprofesionalid( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalid ;
   }

   public void setEducacionprofesionalid( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalid = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtEducacionProfesional_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Profesionalid = value ;
   }

   public String getEducacionprofesionalnombreinstitucion( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion ;
   }

   public void setEducacionprofesionalnombreinstitucion( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion = value ;
   }

   public String getEducacionprofesionalpais( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalpais ;
   }

   public void setEducacionprofesionalpais( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais = value ;
   }

   public java.util.Date getEducacionprofesionaldesde( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionaldesde ;
   }

   public void setEducacionprofesionaldesde( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde = value ;
   }

   public java.util.Date getEducacionprofesionalhasta( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalhasta ;
   }

   public void setEducacionprofesionalhasta( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEducacionProfesional_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEducacionProfesional_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Initialized = value ;
   }

   public int getEducacionprofesionalid_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z ;
   }

   public void setEducacionprofesionalid_Z( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z = value ;
   }

   public int getProfesionalid_Z( )
   {
      return gxTv_SdtEducacionProfesional_Profesionalid_Z ;
   }

   public void setProfesionalid_Z( int value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Profesionalid_Z = value ;
   }

   public String getEducacionprofesionalnombreinstitucion_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z ;
   }

   public void setEducacionprofesionalnombreinstitucion_Z( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z = value ;
   }

   public String getEducacionprofesionalpais_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z ;
   }

   public void setEducacionprofesionalpais_Z( String value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z = value ;
   }

   public java.util.Date getEducacionprofesionaldesde_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z ;
   }

   public void setEducacionprofesionaldesde_Z( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z = value ;
   }

   public java.util.Date getEducacionprofesionalhasta_Z( )
   {
      return gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z ;
   }

   public void setEducacionprofesionalhasta_Z( java.util.Date value )
   {
      gxTv_SdtEducacionProfesional_N = (byte)(0) ;
      gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z = value ;
   }

   private byte gxTv_SdtEducacionProfesional_N ;
   protected short gxTv_SdtEducacionProfesional_Initialized ;
   protected int gxTv_SdtEducacionProfesional_Educacionprofesionalid ;
   protected int gxTv_SdtEducacionProfesional_Profesionalid ;
   protected int gxTv_SdtEducacionProfesional_Educacionprofesionalid_Z ;
   protected int gxTv_SdtEducacionProfesional_Profesionalid_Z ;
   protected String gxTv_SdtEducacionProfesional_Mode ;
   protected String gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion ;
   protected String gxTv_SdtEducacionProfesional_Educacionprofesionalpais ;
   protected String gxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z ;
   protected String gxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z ;
   protected java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionaldesde ;
   protected java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionalhasta ;
   protected java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z ;
   protected java.util.Date gxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z ;
}

