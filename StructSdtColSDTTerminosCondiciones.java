package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTTerminosCondiciones", namespace ="ProjectThani")
public final  class StructSdtColSDTTerminosCondiciones implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTTerminosCondiciones( )
   {
      this( -1, new ModelContext( StructSdtColSDTTerminosCondiciones.class ));
   }

   public StructSdtColSDTTerminosCondiciones( int remoteHandle ,
                                              ModelContext context )
   {
   }

   public  StructSdtColSDTTerminosCondiciones( java.util.Vector<StructSdtSDTTerminosCondiciones> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTTerminosCondiciones",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTTerminosCondiciones> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTTerminosCondiciones> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTTerminosCondiciones> item = new java.util.Vector<>();
}

