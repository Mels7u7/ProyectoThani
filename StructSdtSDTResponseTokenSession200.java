package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseTokenSession200 implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseTokenSession200( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseTokenSession200.class ));
   }

   public StructSdtSDTResponseTokenSession200( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtSDTResponseTokenSession200_Sessionkey = "" ;
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

   public String getSessionkey( )
   {
      return gxTv_SdtSDTResponseTokenSession200_Sessionkey ;
   }

   public void setSessionkey( String value )
   {
      gxTv_SdtSDTResponseTokenSession200_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession200_Sessionkey = value ;
   }

   public long getExpirationtime( )
   {
      return gxTv_SdtSDTResponseTokenSession200_Expirationtime ;
   }

   public void setExpirationtime( long value )
   {
      gxTv_SdtSDTResponseTokenSession200_N = (byte)(0) ;
      gxTv_SdtSDTResponseTokenSession200_Expirationtime = value ;
   }

   protected byte gxTv_SdtSDTResponseTokenSession200_N ;
   protected long gxTv_SdtSDTResponseTokenSession200_Expirationtime ;
   protected String gxTv_SdtSDTResponseTokenSession200_Sessionkey ;
}

