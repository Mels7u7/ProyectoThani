package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTDisponibilidad", namespace ="ProjectThani")
public final  class StructSdtColSDTDisponibilidad implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTDisponibilidad( )
   {
      this( -1, new ModelContext( StructSdtColSDTDisponibilidad.class ));
   }

   public StructSdtColSDTDisponibilidad( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtColSDTDisponibilidad( java.util.Vector<StructSdtSDTDisponibilidad> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTDisponibilidad",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTDisponibilidad> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTDisponibilidad> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTDisponibilidad> item = new java.util.Vector<>();
}

