package com.projectthani ;
import com.genexus.*;

public final  class StructSdtConfig implements Cloneable, java.io.Serializable
{
   public StructSdtConfig( )
   {
      this( -1, new ModelContext( StructSdtConfig.class ));
   }

   public StructSdtConfig( int remoteHandle ,
                           ModelContext context )
   {
      gxTv_SdtConfig_Configkey = "" ;
      gxTv_SdtConfig_Configvalue = "" ;
      gxTv_SdtConfig_Configestador = "" ;
      gxTv_SdtConfig_Mode = "" ;
      gxTv_SdtConfig_Configkey_Z = "" ;
      gxTv_SdtConfig_Configvalue_Z = "" ;
      gxTv_SdtConfig_Configestador_Z = "" ;
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

   public short getConfigid( )
   {
      return gxTv_SdtConfig_Configid ;
   }

   public void setConfigid( short value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configid = value ;
   }

   public String getConfigkey( )
   {
      return gxTv_SdtConfig_Configkey ;
   }

   public void setConfigkey( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configkey = value ;
   }

   public String getConfigvalue( )
   {
      return gxTv_SdtConfig_Configvalue ;
   }

   public void setConfigvalue( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configvalue = value ;
   }

   public String getConfigestador( )
   {
      return gxTv_SdtConfig_Configestador ;
   }

   public void setConfigestador( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configestador = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtConfig_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtConfig_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Initialized = value ;
   }

   public short getConfigid_Z( )
   {
      return gxTv_SdtConfig_Configid_Z ;
   }

   public void setConfigid_Z( short value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configid_Z = value ;
   }

   public String getConfigkey_Z( )
   {
      return gxTv_SdtConfig_Configkey_Z ;
   }

   public void setConfigkey_Z( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configkey_Z = value ;
   }

   public String getConfigvalue_Z( )
   {
      return gxTv_SdtConfig_Configvalue_Z ;
   }

   public void setConfigvalue_Z( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configvalue_Z = value ;
   }

   public String getConfigestador_Z( )
   {
      return gxTv_SdtConfig_Configestador_Z ;
   }

   public void setConfigestador_Z( String value )
   {
      gxTv_SdtConfig_N = (byte)(0) ;
      gxTv_SdtConfig_Configestador_Z = value ;
   }

   private byte gxTv_SdtConfig_N ;
   protected short gxTv_SdtConfig_Configid ;
   protected short gxTv_SdtConfig_Initialized ;
   protected short gxTv_SdtConfig_Configid_Z ;
   protected String gxTv_SdtConfig_Configestador ;
   protected String gxTv_SdtConfig_Mode ;
   protected String gxTv_SdtConfig_Configestador_Z ;
   protected String gxTv_SdtConfig_Configkey ;
   protected String gxTv_SdtConfig_Configvalue ;
   protected String gxTv_SdtConfig_Configkey_Z ;
   protected String gxTv_SdtConfig_Configvalue_Z ;
}

