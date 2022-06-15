package com.projectthani ;
import com.genexus.*;

public final  class StructSdtCitaServicio implements Cloneable, java.io.Serializable
{
   public StructSdtCitaServicio( )
   {
      this( -1, new ModelContext( StructSdtCitaServicio.class ));
   }

   public StructSdtCitaServicio( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtCitaServicio_Citaservicioestado = "" ;
      gxTv_SdtCitaServicio_Mode = "" ;
      gxTv_SdtCitaServicio_Citaservicioestado_Z = "" ;
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

   public int getCitaservicioid( )
   {
      return gxTv_SdtCitaServicio_Citaservicioid ;
   }

   public void setCitaservicioid( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaservicioid = value ;
   }

   public int getCitaid( )
   {
      return gxTv_SdtCitaServicio_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaid = value ;
   }

   public short getServicioid( )
   {
      return gxTv_SdtCitaServicio_Servicioid ;
   }

   public void setServicioid( short value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Servicioid = value ;
   }

   public byte getCitaservicioflag( )
   {
      return gxTv_SdtCitaServicio_Citaservicioflag ;
   }

   public void setCitaservicioflag( byte value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaservicioflag = value ;
   }

   public String getCitaservicioestado( )
   {
      return gxTv_SdtCitaServicio_Citaservicioestado ;
   }

   public void setCitaservicioestado( String value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaservicioestado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCitaServicio_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCitaServicio_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Initialized = value ;
   }

   public int getCitaservicioid_Z( )
   {
      return gxTv_SdtCitaServicio_Citaservicioid_Z ;
   }

   public void setCitaservicioid_Z( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaservicioid_Z = value ;
   }

   public int getCitaid_Z( )
   {
      return gxTv_SdtCitaServicio_Citaid_Z ;
   }

   public void setCitaid_Z( int value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaid_Z = value ;
   }

   public short getServicioid_Z( )
   {
      return gxTv_SdtCitaServicio_Servicioid_Z ;
   }

   public void setServicioid_Z( short value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Servicioid_Z = value ;
   }

   public byte getCitaservicioflag_Z( )
   {
      return gxTv_SdtCitaServicio_Citaservicioflag_Z ;
   }

   public void setCitaservicioflag_Z( byte value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaservicioflag_Z = value ;
   }

   public String getCitaservicioestado_Z( )
   {
      return gxTv_SdtCitaServicio_Citaservicioestado_Z ;
   }

   public void setCitaservicioestado_Z( String value )
   {
      gxTv_SdtCitaServicio_N = (byte)(0) ;
      gxTv_SdtCitaServicio_Citaservicioestado_Z = value ;
   }

   protected byte gxTv_SdtCitaServicio_Citaservicioflag ;
   protected byte gxTv_SdtCitaServicio_Citaservicioflag_Z ;
   private byte gxTv_SdtCitaServicio_N ;
   protected short gxTv_SdtCitaServicio_Servicioid ;
   protected short gxTv_SdtCitaServicio_Initialized ;
   protected short gxTv_SdtCitaServicio_Servicioid_Z ;
   protected int gxTv_SdtCitaServicio_Citaservicioid ;
   protected int gxTv_SdtCitaServicio_Citaid ;
   protected int gxTv_SdtCitaServicio_Citaservicioid_Z ;
   protected int gxTv_SdtCitaServicio_Citaid_Z ;
   protected String gxTv_SdtCitaServicio_Citaservicioestado ;
   protected String gxTv_SdtCitaServicio_Mode ;
   protected String gxTv_SdtCitaServicio_Citaservicioestado_Z ;
}

