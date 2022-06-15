package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTPrdofesionalDisponibilidadFiltro", namespace ="ProjectThani")
public final  class StructSdtColSDTPrdofesionalDisponibilidadFiltro implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTPrdofesionalDisponibilidadFiltro( )
   {
      this( -1, new ModelContext( StructSdtColSDTPrdofesionalDisponibilidadFiltro.class ));
   }

   public StructSdtColSDTPrdofesionalDisponibilidadFiltro( int remoteHandle ,
                                                           ModelContext context )
   {
   }

   public  StructSdtColSDTPrdofesionalDisponibilidadFiltro( java.util.Vector<StructSdtSDTPrdofesionalDisponibilidadFiltro> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTPrdofesionalDisponibilidadFiltro",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTPrdofesionalDisponibilidadFiltro> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTPrdofesionalDisponibilidadFiltro> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTPrdofesionalDisponibilidadFiltro> item = new java.util.Vector<>();
}

