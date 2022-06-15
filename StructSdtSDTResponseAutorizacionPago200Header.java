package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseAutorizacionPago200Header implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseAutorizacionPago200Header( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseAutorizacionPago200Header.class ));
   }

   public StructSdtSDTResponseAutorizacionPago200Header( int remoteHandle ,
                                                         ModelContext context )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate = "" ;
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

   public String getEcoretransactionuuid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid ;
   }

   public void setEcoretransactionuuid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid = value ;
   }

   public String getEcoretransactiondate( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate ;
   }

   public void setEcoretransactiondate( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate = value ;
   }

   public int getMilllis( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis ;
   }

   public void setMilllis( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Header_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis = value ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Header_N ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200Header_Milllis ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactionuuid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Header_Ecoretransactiondate ;
}

