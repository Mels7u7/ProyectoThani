package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago200DataMap", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago200DataMap implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago200DataMap( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago200DataMap.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago200DataMap( int remoteHandle ,
                                                             ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago200DataMap( java.util.Vector<StructSdtSDTResponseAutorizacionPago200DataMap> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago200DataMap",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago200DataMap> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago200DataMap> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago200DataMap> item = new java.util.Vector<>();
}

