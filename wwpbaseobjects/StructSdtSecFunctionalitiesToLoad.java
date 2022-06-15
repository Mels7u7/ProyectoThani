package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtSecFunctionalitiesToLoad implements Cloneable, java.io.Serializable
{
   public StructSdtSecFunctionalitiesToLoad( )
   {
      this( -1, new ModelContext( StructSdtSecFunctionalitiesToLoad.class ));
   }

   public StructSdtSecFunctionalitiesToLoad( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtSecFunctionalitiesToLoad_Secobjectname = "" ;
      gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey = "" ;
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N = (byte)(1) ;
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

   public String getSecobjectname( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secobjectname ;
   }

   public void setSecobjectname( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secobjectname = value ;
   }

   public byte getSecfunctionalitytype( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype ;
   }

   public void setSecfunctionalitytype( byte value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype = value ;
   }

   public String getSecparentfunctionalitykey( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey ;
   }

   public void setSecparentfunctionalitykey( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey = value ;
   }

   public java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> getSecfunctionalitykeys( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys ;
   }

   public void setSecfunctionalitykeys( java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys = value ;
   }

   protected byte gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype ;
   protected byte gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys_N ;
   protected byte gxTv_SdtSecFunctionalitiesToLoad_N ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_Secobjectname ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey ;
   protected java.util.Vector<com.projectthani.wwpbaseobjects.StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> gxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys=null ;
}

