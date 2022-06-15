package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTListadoCitasPorPaciente", namespace ="ProjectThani")
public final  class StructSdtColSDTListadoCitasPorPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTListadoCitasPorPaciente( )
   {
      this( -1, new ModelContext( StructSdtColSDTListadoCitasPorPaciente.class ));
   }

   public StructSdtColSDTListadoCitasPorPaciente( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColSDTListadoCitasPorPaciente( java.util.Vector<StructSdtSDTListadoCitasPorPaciente> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTListadoCitasPorPaciente",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTListadoCitasPorPaciente> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTListadoCitasPorPaciente> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTListadoCitasPorPaciente> item = new java.util.Vector<>();
}

