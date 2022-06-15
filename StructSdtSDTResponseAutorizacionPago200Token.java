package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseAutorizacionPago200Token implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseAutorizacionPago200Token( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseAutorizacionPago200Token.class ));
   }

   public StructSdtSDTResponseAutorizacionPago200Token( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon = "" ;
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

   public String getTokenid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid ;
   }

   public void setTokenid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid = value ;
   }

   public String getOwnerid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid ;
   }

   public void setOwnerid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid = value ;
   }

   public String getExpireon( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon ;
   }

   public void setExpireon( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Token_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon = value ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Token_N ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Token_Tokenid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Token_Ownerid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Token_Expireon ;
}

