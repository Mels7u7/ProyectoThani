package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago200", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago200 implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago200( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago200.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago200( int remoteHandle ,
                                                      ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago200( java.util.Vector<StructSdtSDTResponseAutorizacionPago200> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago200",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago200> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago200> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago200> item = new java.util.Vector<>();
}

