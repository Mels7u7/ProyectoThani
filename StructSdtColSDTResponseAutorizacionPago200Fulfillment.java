package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago200Fulfillment", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago200Fulfillment implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago200Fulfillment( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago200Fulfillment.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago200Fulfillment( int remoteHandle ,
                                                                 ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago200Fulfillment( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Fulfillment> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago200Fulfillment",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago200Fulfillment> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Fulfillment> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago200Fulfillment> item = new java.util.Vector<>();
}

