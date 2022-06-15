package com.projectthani ;
import com.genexus.*;

public final  class StructSdtComentarioProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtComentarioProfesional( )
   {
      this( -1, new ModelContext( StructSdtComentarioProfesional.class ));
   }

   public StructSdtComentarioProfesional( int remoteHandle ,
                                          ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario = "" ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro = cal.getTime() ;
      gxTv_SdtComentarioProfesional_Mode = "" ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z = cal.getTime() ;
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

   public int getComentarioprofesionalid( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalid ;
   }

   public void setComentarioprofesionalid( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalid = value ;
   }

   public int getSgpacientepacienteid( )
   {
      return gxTv_SdtComentarioProfesional_Sgpacientepacienteid ;
   }

   public void setSgpacientepacienteid( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Sgpacientepacienteid = value ;
   }

   public int getSgprofesionalprofesionalid( )
   {
      return gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid ;
   }

   public void setSgprofesionalprofesionalid( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid = value ;
   }

   public short getComentarioprofesionalcitaid( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid ;
   }

   public void setComentarioprofesionalcitaid( short value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid = value ;
   }

   public String getComentarioprofesionalcomentario( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario ;
   }

   public void setComentarioprofesionalcomentario( String value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario = value ;
   }

   public java.util.Date getComentarioprofesionalfecharegistro( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro ;
   }

   public void setComentarioprofesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtComentarioProfesional_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtComentarioProfesional_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Initialized = value ;
   }

   public int getComentarioprofesionalid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z ;
   }

   public void setComentarioprofesionalid_Z( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z = value ;
   }

   public int getSgpacientepacienteid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z ;
   }

   public void setSgpacientepacienteid_Z( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z = value ;
   }

   public int getSgprofesionalprofesionalid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z ;
   }

   public void setSgprofesionalprofesionalid_Z( int value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z = value ;
   }

   public short getComentarioprofesionalcitaid_Z( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z ;
   }

   public void setComentarioprofesionalcitaid_Z( short value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z = value ;
   }

   public java.util.Date getComentarioprofesionalfecharegistro_Z( )
   {
      return gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z ;
   }

   public void setComentarioprofesionalfecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtComentarioProfesional_N = (byte)(0) ;
      gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z = value ;
   }

   private byte gxTv_SdtComentarioProfesional_N ;
   protected short gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid ;
   protected short gxTv_SdtComentarioProfesional_Initialized ;
   protected short gxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z ;
   protected int gxTv_SdtComentarioProfesional_Comentarioprofesionalid ;
   protected int gxTv_SdtComentarioProfesional_Sgpacientepacienteid ;
   protected int gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid ;
   protected int gxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z ;
   protected int gxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z ;
   protected int gxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z ;
   protected String gxTv_SdtComentarioProfesional_Mode ;
   protected String gxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario ;
   protected java.util.Date gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro ;
   protected java.util.Date gxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z ;
}

