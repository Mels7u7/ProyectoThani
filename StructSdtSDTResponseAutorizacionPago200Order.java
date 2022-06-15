package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseAutorizacionPago200Order implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseAutorizacionPago200Order( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseAutorizacionPago200Order.class ));
   }

   public StructSdtSDTResponseAutorizacionPago200Order( int remoteHandle ,
                                                        ModelContext context )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Amount = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Currency = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid = "" ;
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
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid ;
   }

   public void setTokenid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid = value ;
   }

   public String getPurchasenumber( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber ;
   }

   public void setPurchasenumber( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber = value ;
   }

   public java.math.BigDecimal getAmount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Amount ;
   }

   public void setAmount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Amount = value ;
   }

   public int getInstallment( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Installment ;
   }

   public void setInstallment( int value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Installment = value ;
   }

   public String getCurrency( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Currency ;
   }

   public void setCurrency( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Currency = value ;
   }

   public java.math.BigDecimal getAuthorizedamount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount ;
   }

   public void setAuthorizedamount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount = value ;
   }

   public String getAuthorizationcode( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode ;
   }

   public void setAuthorizationcode( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode = value ;
   }

   public String getActioncode( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode ;
   }

   public void setActioncode( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode = value ;
   }

   public String getTracenumber( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber ;
   }

   public void setTracenumber( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber = value ;
   }

   public String getTransactiondate( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate ;
   }

   public void setTransactiondate( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate = value ;
   }

   public String getTransactionid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid ;
   }

   public void setTransactionid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Order_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid = value ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Order_N ;
   protected int gxTv_SdtSDTResponseAutorizacionPago200Order_Installment ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Tokenid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Purchasenumber ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Currency ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizationcode ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Actioncode ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Tracenumber ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Transactiondate ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Order_Transactionid ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200Order_Amount ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago200Order_Authorizedamount ;
}

