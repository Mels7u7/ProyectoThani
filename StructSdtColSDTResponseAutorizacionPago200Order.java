package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago200Order", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago200Order implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago200Order( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago200Order.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago200Order( int remoteHandle ,
                                                           ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago200Order( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Order> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago200Order",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago200Order> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Order> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago200Order> item = new java.util.Vector<>();
}

