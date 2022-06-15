package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseNubefact.invoice", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseNubefact_invoice implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseNubefact_invoice( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseNubefact_invoice.class ));
   }

   public StructSdtColSDTResponseNubefact_invoice( int remoteHandle ,
                                                   ModelContext context )
   {
   }

   public  StructSdtColSDTResponseNubefact_invoice( java.util.Vector<StructSdtSDTResponseNubefact_invoice> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseNubefact.invoice",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseNubefact_invoice> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseNubefact_invoice> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseNubefact_invoice> item = new java.util.Vector<>();
}

