package com.projectthani ;
import com.genexus.*;

public final  class StructSdtPais implements Cloneable, java.io.Serializable
{
   public StructSdtPais( )
   {
      this( -1, new ModelContext( StructSdtPais.class ));
   }

   public StructSdtPais( int remoteHandle ,
                         ModelContext context )
   {
      gxTv_SdtPais_Paisdescripcion = "" ;
      gxTv_SdtPais_Paisestado = "" ;
      gxTv_SdtPais_Mode = "" ;
      gxTv_SdtPais_Paisdescripcion_Z = "" ;
      gxTv_SdtPais_Paisestado_Z = "" ;
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

   public short getPaisid( )
   {
      return gxTv_SdtPais_Paisid ;
   }

   public void setPaisid( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paisid = value ;
   }

   public String getPaisdescripcion( )
   {
      return gxTv_SdtPais_Paisdescripcion ;
   }

   public void setPaisdescripcion( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paisdescripcion = value ;
   }

   public String getPaisestado( )
   {
      return gxTv_SdtPais_Paisestado ;
   }

   public void setPaisestado( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paisestado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPais_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPais_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Initialized = value ;
   }

   public short getPaisid_Z( )
   {
      return gxTv_SdtPais_Paisid_Z ;
   }

   public void setPaisid_Z( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paisid_Z = value ;
   }

   public String getPaisdescripcion_Z( )
   {
      return gxTv_SdtPais_Paisdescripcion_Z ;
   }

   public void setPaisdescripcion_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paisdescripcion_Z = value ;
   }

   public String getPaisestado_Z( )
   {
      return gxTv_SdtPais_Paisestado_Z ;
   }

   public void setPaisestado_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      gxTv_SdtPais_Paisestado_Z = value ;
   }

   private byte gxTv_SdtPais_N ;
   protected short gxTv_SdtPais_Paisid ;
   protected short gxTv_SdtPais_Initialized ;
   protected short gxTv_SdtPais_Paisid_Z ;
   protected String gxTv_SdtPais_Paisestado ;
   protected String gxTv_SdtPais_Mode ;
   protected String gxTv_SdtPais_Paisestado_Z ;
   protected String gxTv_SdtPais_Paisdescripcion ;
   protected String gxTv_SdtPais_Paisdescripcion_Z ;
}

