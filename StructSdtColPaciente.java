package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColPaciente", namespace ="ProjectThani")
public final  class StructSdtColPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtColPaciente( )
   {
      this( -1, new ModelContext( StructSdtColPaciente.class ));
   }

   public StructSdtColPaciente( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColPaciente( java.util.Vector<StructSdtPaciente> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Paciente",namespace="ProjectThani")
   public java.util.Vector<StructSdtPaciente> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtPaciente> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtPaciente> item = new java.util.Vector<>();
}

