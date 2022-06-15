package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTComentariosProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtSDTComentariosProfesional( )
   {
      this( -1, new ModelContext( StructSdtSDTComentariosProfesional.class ));
   }

   public StructSdtSDTComentariosProfesional( int remoteHandle ,
                                              ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTComentariosProfesional_Comentario = "" ;
      gxTv_SdtSDTComentariosProfesional_Fecharegistro = cal.getTime() ;
      gxTv_SdtSDTComentariosProfesional_Fecharegistro_N = (byte)(1) ;
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

   public int getComentarioid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Comentarioid ;
   }

   public void setComentarioid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Comentarioid = value ;
   }

   public int getPacienteid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Pacienteid = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Profesionalid = value ;
   }

   public int getCitaid( )
   {
      return gxTv_SdtSDTComentariosProfesional_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Citaid = value ;
   }

   public String getComentario( )
   {
      return gxTv_SdtSDTComentariosProfesional_Comentario ;
   }

   public void setComentario( String value )
   {
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Comentario = value ;
   }

   public java.util.Date getFecharegistro( )
   {
      return gxTv_SdtSDTComentariosProfesional_Fecharegistro ;
   }

   public void setFecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTComentariosProfesional_Fecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_N = (byte)(0) ;
      gxTv_SdtSDTComentariosProfesional_Fecharegistro = value ;
   }

   protected byte gxTv_SdtSDTComentariosProfesional_Fecharegistro_N ;
   protected byte gxTv_SdtSDTComentariosProfesional_N ;
   protected int gxTv_SdtSDTComentariosProfesional_Comentarioid ;
   protected int gxTv_SdtSDTComentariosProfesional_Pacienteid ;
   protected int gxTv_SdtSDTComentariosProfesional_Profesionalid ;
   protected int gxTv_SdtSDTComentariosProfesional_Citaid ;
   protected String gxTv_SdtSDTComentariosProfesional_Comentario ;
   protected java.util.Date gxTv_SdtSDTComentariosProfesional_Fecharegistro ;
}

