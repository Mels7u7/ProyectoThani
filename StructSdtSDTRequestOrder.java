package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRequestOrder implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRequestOrder( )
   {
      this( -1, new ModelContext( StructSdtSDTRequestOrder.class ));
   }

   public StructSdtSDTRequestOrder( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtSDTRequestOrder_Tokenid = "" ;
      gxTv_SdtSDTRequestOrder_Purchasenumber = "" ;
      gxTv_SdtSDTRequestOrder_Amount = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestOrder_Currency = "" ;
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
      return gxTv_SdtSDTRequestOrder_Tokenid ;
   }

   public void setTokenid( String value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Tokenid = value ;
   }

   public String getPurchasenumber( )
   {
      return gxTv_SdtSDTRequestOrder_Purchasenumber ;
   }

   public void setPurchasenumber( String value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Purchasenumber = value ;
   }

   public java.math.BigDecimal getAmount( )
   {
      return gxTv_SdtSDTRequestOrder_Amount ;
   }

   public void setAmount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Amount = value ;
   }

   public String getCurrency( )
   {
      return gxTv_SdtSDTRequestOrder_Currency ;
   }

   public void setCurrency( String value )
   {
      gxTv_SdtSDTRequestOrder_N = (byte)(0) ;
      gxTv_SdtSDTRequestOrder_Currency = value ;
   }

   protected byte gxTv_SdtSDTRequestOrder_N ;
   protected String gxTv_SdtSDTRequestOrder_Tokenid ;
   protected String gxTv_SdtSDTRequestOrder_Purchasenumber ;
   protected String gxTv_SdtSDTRequestOrder_Currency ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestOrder_Amount ;
}

