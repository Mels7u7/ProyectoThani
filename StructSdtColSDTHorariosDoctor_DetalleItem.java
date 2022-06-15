package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTHorariosDoctor.DetalleItem", namespace ="ProjectThani")
public final  class StructSdtColSDTHorariosDoctor_DetalleItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTHorariosDoctor_DetalleItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTHorariosDoctor_DetalleItem.class ));
   }

   public StructSdtColSDTHorariosDoctor_DetalleItem( int remoteHandle ,
                                                     ModelContext context )
   {
   }

   public  StructSdtColSDTHorariosDoctor_DetalleItem( java.util.Vector<StructSdtSDTHorariosDoctor_DetalleItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTHorariosDoctor.DetalleItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTHorariosDoctor_DetalleItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTHorariosDoctor_DetalleItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTHorariosDoctor_DetalleItem> item = new java.util.Vector<>();
}

