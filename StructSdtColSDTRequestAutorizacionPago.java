package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRequestAutorizacionPago", namespace ="ProjectThani")
public final  class StructSdtColSDTRequestAutorizacionPago implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRequestAutorizacionPago( )
   {
      this( -1, new ModelContext( StructSdtColSDTRequestAutorizacionPago.class ));
   }

   public StructSdtColSDTRequestAutorizacionPago( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColSDTRequestAutorizacionPago( java.util.Vector<StructSdtSDTRequestAutorizacionPago> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRequestAutorizacionPago",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRequestAutorizacionPago> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRequestAutorizacionPago> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRequestAutorizacionPago> item = new java.util.Vector<>();
}

