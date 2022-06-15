package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago200Header", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago200Header implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago200Header( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago200Header.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago200Header( int remoteHandle ,
                                                            ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago200Header( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Header> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago200Header",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago200Header> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Header> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago200Header> item = new java.util.Vector<>();
}

