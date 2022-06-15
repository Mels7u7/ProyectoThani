package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem implements Cloneable, java.io.Serializable
{
   public StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( )
   {
      this( -1, new ModelContext( StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem.class ));
   }

   public StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( int remoteHandle ,
                                                                      ModelContext context )
   {
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey = "" ;
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc = "" ;
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

   public String getSecfunctionalitykey( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey ;
   }

   public void setSecfunctionalitykey( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey = value ;
   }

   public String getSecfunctionalitydsc( )
   {
      return gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc ;
   }

   public void setSecfunctionalitydsc( String value )
   {
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N = (byte)(0) ;
      gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc = value ;
   }

   protected byte gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_N ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey ;
   protected String gxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc ;
}

