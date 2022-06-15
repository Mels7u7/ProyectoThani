package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTHorariosDoctor", namespace ="ProjectThani")
public final  class StructSdtColSDTHorariosDoctor implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTHorariosDoctor( )
   {
      this( -1, new ModelContext( StructSdtColSDTHorariosDoctor.class ));
   }

   public StructSdtColSDTHorariosDoctor( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtColSDTHorariosDoctor( java.util.Vector<StructSdtSDTHorariosDoctor> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTHorariosDoctor",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTHorariosDoctor> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTHorariosDoctor> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTHorariosDoctor> item = new java.util.Vector<>();
}

