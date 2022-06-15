package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTListadoFamiliarPorPaciente", namespace ="ProjectThani")
public final  class StructSdtColSDTListadoFamiliarPorPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTListadoFamiliarPorPaciente( )
   {
      this( -1, new ModelContext( StructSdtColSDTListadoFamiliarPorPaciente.class ));
   }

   public StructSdtColSDTListadoFamiliarPorPaciente( int remoteHandle ,
                                                     ModelContext context )
   {
   }

   public  StructSdtColSDTListadoFamiliarPorPaciente( java.util.Vector<StructSdtSDTListadoFamiliarPorPaciente> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTListadoFamiliarPorPaciente",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTListadoFamiliarPorPaciente> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTListadoFamiliarPorPaciente> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTListadoFamiliarPorPaciente> item = new java.util.Vector<>();
}

