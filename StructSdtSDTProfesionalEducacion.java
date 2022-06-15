package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalEducacion implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalEducacion( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalEducacion.class ));
   }

   public StructSdtSDTProfesionalEducacion( int remoteHandle ,
                                            ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesionalEducacion_Educacionid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion = "" ;
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde = cal.getTime() ;
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta = cal.getTime() ;
      gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion = "" ;
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N = (byte)(1) ;
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
      return gxTv_SdtSDTProfesionalEducacion_Educacionid ;
   }

   public void setEducacionid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionid = value ;
   }

   public String getEducacionnombreinstitucion( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion ;
   }

   public void setEducacionnombreinstitucion( String value )
   {
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion = value ;
   }

   public java.util.Date getEducaciondesde( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educaciondesde ;
   }

   public void setEducaciondesde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educaciondesde = value ;
   }

   public java.util.Date getEducacionhasta( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educacionhasta ;
   }

   public void setEducacionhasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionhasta = value ;
   }

   public String getEducacionpaisdescripcion( )
   {
      return gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion ;
   }

   public void setEducacionpaisdescripcion( String value )
   {
      gxTv_SdtSDTProfesionalEducacion_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion = value ;
   }

   protected byte gxTv_SdtSDTProfesionalEducacion_Educaciondesde_N ;
   protected byte gxTv_SdtSDTProfesionalEducacion_Educacionhasta_N ;
   protected byte gxTv_SdtSDTProfesionalEducacion_N ;
   protected String gxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion ;
   protected String gxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion ;
   protected java.util.UUID gxTv_SdtSDTProfesionalEducacion_Educacionid ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacion_Educaciondesde ;
   protected java.util.Date gxTv_SdtSDTProfesionalEducacion_Educacionhasta ;
}

