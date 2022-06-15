package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago400Data", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago400Data implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago400Data( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago400Data.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago400Data( int remoteHandle ,
                                                          ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago400Data( java.util.Vector<StructSdtSDTResponseAutorizacionPago400Data> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago400Data",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago400Data> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago400Data> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago400Data> item = new java.util.Vector<>();
}

