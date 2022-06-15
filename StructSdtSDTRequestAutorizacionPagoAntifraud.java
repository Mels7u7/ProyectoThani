package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRequestAutorizacionPagoAntifraud implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRequestAutorizacionPagoAntifraud( )
   {
      this( -1, new ModelContext( StructSdtSDTRequestAutorizacionPagoAntifraud.class ));
   }

   public StructSdtSDTRequestAutorizacionPagoAntifraud( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N = (byte)(1) ;
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

   public String getClientip( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip ;
   }

   public void setClientip( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip = value ;
   }

   public com.projectthani.StructSdtSDTRequestAutorizacionPagoMerchantData getMerchantdefinedata( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata ;
   }

   public void setMerchantdefinedata( com.projectthani.StructSdtSDTRequestAutorizacionPagoMerchantData value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata = value;
   }

   protected byte gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata_N ;
   protected byte gxTv_SdtSDTRequestAutorizacionPagoAntifraud_N ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Clientip ;
   protected com.projectthani.StructSdtSDTRequestAutorizacionPagoMerchantData gxTv_SdtSDTRequestAutorizacionPagoAntifraud_Merchantdefinedata=null ;
}

