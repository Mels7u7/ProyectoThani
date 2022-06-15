package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTDisponibilidadIds", namespace ="ProjectThani")
public final  class StructSdtColSDTDisponibilidadIds implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTDisponibilidadIds( )
   {
      this( -1, new ModelContext( StructSdtColSDTDisponibilidadIds.class ));
   }

   public StructSdtColSDTDisponibilidadIds( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColSDTDisponibilidadIds( java.util.Vector<StructSdtSDTDisponibilidadIds> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTDisponibilidadIds",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTDisponibilidadIds> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTDisponibilidadIds> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTDisponibilidadIds> item = new java.util.Vector<>();
}

