package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRequestAutorizacionPagoMerchantData implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRequestAutorizacionPagoMerchantData( )
   {
      this( -1, new ModelContext( StructSdtSDTRequestAutorizacionPagoMerchantData.class ));
   }

   public StructSdtSDTRequestAutorizacionPagoMerchantData( int remoteHandle ,
                                                           ModelContext context )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 = "" ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 = "" ;
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

   public String getMdd4( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 ;
   }

   public void setMdd4( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 = value ;
   }

   public String getMdd21( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 ;
   }

   public void setMdd21( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 = value ;
   }

   public String getMdd32( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 ;
   }

   public void setMdd32( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 = value ;
   }

   public String getMdd75( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 ;
   }

   public void setMdd75( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 = value ;
   }

   public String getMdd77( )
   {
      return gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 ;
   }

   public void setMdd77( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 = value ;
   }

   protected byte gxTv_SdtSDTRequestAutorizacionPagoMerchantData_N ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd4 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd21 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd32 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd75 ;
   protected String gxTv_SdtSDTRequestAutorizacionPagoMerchantData_Mdd77 ;
}

