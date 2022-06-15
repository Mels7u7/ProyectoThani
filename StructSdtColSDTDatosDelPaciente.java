package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTDatosDelPaciente", namespace ="ProjectThani")
public final  class StructSdtColSDTDatosDelPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTDatosDelPaciente( )
   {
      this( -1, new ModelContext( StructSdtColSDTDatosDelPaciente.class ));
   }

   public StructSdtColSDTDatosDelPaciente( int remoteHandle ,
                                           ModelContext context )
   {
   }

   public  StructSdtColSDTDatosDelPaciente( java.util.Vector<StructSdtSDTDatosDelPaciente> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTDatosDelPaciente",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTDatosDelPaciente> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTDatosDelPaciente> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTDatosDelPaciente> item = new java.util.Vector<>();
}

