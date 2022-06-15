package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTTerminosCondiciones.SubTerminosCondicionesItem", namespace ="ProjectThani")
public final  class StructSdtColSDTTerminosCondiciones_SubTerminosCondicionesItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTTerminosCondiciones_SubTerminosCondicionesItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTTerminosCondiciones_SubTerminosCondicionesItem.class ));
   }

   public StructSdtColSDTTerminosCondiciones_SubTerminosCondicionesItem( int remoteHandle ,
                                                                         ModelContext context )
   {
   }

   public  StructSdtColSDTTerminosCondiciones_SubTerminosCondicionesItem( java.util.Vector<StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTTerminosCondiciones.SubTerminosCondicionesItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> item = new java.util.Vector<>();
}

