package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColDisponibilidad", namespace ="ProjectThani")
public final  class StructSdtColDisponibilidad implements Cloneable, java.io.Serializable
{
   public StructSdtColDisponibilidad( )
   {
      this( -1, new ModelContext( StructSdtColDisponibilidad.class ));
   }

   public StructSdtColDisponibilidad( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtColDisponibilidad( java.util.Vector<StructSdtDisponibilidad> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Disponibilidad",namespace="ProjectThani")
   public java.util.Vector<StructSdtDisponibilidad> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDisponibilidad> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDisponibilidad> item = new java.util.Vector<>();
}

