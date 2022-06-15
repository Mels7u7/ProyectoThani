package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseAutorizacionPago200 implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseAutorizacionPago200( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseAutorizacionPago200.class ));
   }

   public StructSdtSDTResponseAutorizacionPago200( int remoteHandle ,
                                                   ModelContext context )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Header_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Order_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Token_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N = (byte)(1) ;
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

   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Header getHeader( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Header ;
   }

   public void setHeader( com.projectthani.StructSdtSDTResponseAutorizacionPago200Header value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Header = value;
   }

   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Fulfillment getFulfillment( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment ;
   }

   public void setFulfillment( com.projectthani.StructSdtSDTResponseAutorizacionPago200Fulfillment value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment = value;
   }

   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Order getOrder( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Order ;
   }

   public void setOrder( com.projectthani.StructSdtSDTResponseAutorizacionPago200Order value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Order = value;
   }

   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Token getToken( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Token ;
   }

   public void setToken( com.projectthani.StructSdtSDTResponseAutorizacionPago200Token value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Token = value;
   }

   public com.projectthani.StructSdtSDTResponseAutorizacionPago200DataMap getDatamap( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200_Datamap ;
   }

   public void setDatamap( com.projectthani.StructSdtSDTResponseAutorizacionPago200DataMap value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200_Datamap = value;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Header_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Order_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Token_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_Datamap_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago200_N ;
   protected com.projectthani.StructSdtSDTResponseAutorizacionPago200Header gxTv_SdtSDTResponseAutorizacionPago200_Header=null ;
   protected com.projectthani.StructSdtSDTResponseAutorizacionPago200Fulfillment gxTv_SdtSDTResponseAutorizacionPago200_Fulfillment=null ;
   protected com.projectthani.StructSdtSDTResponseAutorizacionPago200Order gxTv_SdtSDTResponseAutorizacionPago200_Order=null ;
   protected com.projectthani.StructSdtSDTResponseAutorizacionPago200Token gxTv_SdtSDTResponseAutorizacionPago200_Token=null ;
   protected com.projectthani.StructSdtSDTResponseAutorizacionPago200DataMap gxTv_SdtSDTResponseAutorizacionPago200_Datamap=null ;
}

