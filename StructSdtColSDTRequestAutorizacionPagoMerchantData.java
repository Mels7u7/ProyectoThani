package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRequestAutorizacionPagoMerchantData", namespace ="ProjectThani")
public final  class StructSdtColSDTRequestAutorizacionPagoMerchantData implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRequestAutorizacionPagoMerchantData( )
   {
      this( -1, new ModelContext( StructSdtColSDTRequestAutorizacionPagoMerchantData.class ));
   }

   public StructSdtColSDTRequestAutorizacionPagoMerchantData( int remoteHandle ,
                                                              ModelContext context )
   {
   }

   public  StructSdtColSDTRequestAutorizacionPagoMerchantData( java.util.Vector<StructSdtSDTRequestAutorizacionPagoMerchantData> value )
   {
      item = value;
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRequestAutorizacionPagoMerchantData",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRequestAutorizacionPagoMerchantData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRequestAutorizacionPagoMerchantData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRequestAutorizacionPagoMerchantData> item = new java.util.Vector<>();
}

