package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseAutorizacionPago400 implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseAutorizacionPago400( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseAutorizacionPago400.class ));
   }

   public StructSdtSDTResponseAutorizacionPago400( int remoteHandle ,
                                                   ModelContext context )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_Errormessage = "" ;
      gxTv_SdtSDTResponseAutorizacionPago400_Header_N = (byte)(1) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Data_N = (byte)(1) ;
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

   public int getErrorcode( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Errorcode ;
   }

   public void setErrorcode( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Errorcode = value ;
   }

   public String getErrormessage( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Errormessage ;
   }

   public void setErrormessage( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Errormessage = value ;
   }

   public com.projectthani.StructSdtSDTResponseAutorizacionPago200Header getHeader( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Header ;
   }

   public void setHeader( com.projectthani.StructSdtSDTResponseAutorizacionPago200Header value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Header = value;
   }

   public com.projectthani.StructSdtSDTResponseAutorizacionPago400Data getData( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400_Data ;
   }

   public void setData( com.projectthani.StructSdtSDTResponseAutorizacionPago400Data value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400_Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400_Data = value;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago400_Header_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago400_Data_N ;
   protected byte gxTv_SdtSDTResponseAutorizacionPago400_N ;
   protected int gxTv_SdtSDTResponseAutorizacionPago400_Errorcode ;
   protected String gxTv_SdtSDTResponseAutorizacionPago400_Errormessage ;
   protected com.projectthani.StructSdtSDTResponseAutorizacionPago200Header gxTv_SdtSDTResponseAutorizacionPago400_Header=null ;
   protected com.projectthani.StructSdtSDTResponseAutorizacionPago400Data gxTv_SdtSDTResponseAutorizacionPago400_Data=null ;
}

