package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago400", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago400 implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago400( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago400.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago400( int remoteHandle ,
                                                      ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago400( java.util.Vector<StructSdtSDTResponseAutorizacionPago400> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago400",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago400> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago400> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago400> item = new java.util.Vector<>();
}

