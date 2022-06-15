package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTCountPaciente", namespace ="ProjectThani")
public final  class StructSdtColSDTCountPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTCountPaciente( )
   {
      this( -1, new ModelContext( StructSdtColSDTCountPaciente.class ));
   }

   public StructSdtColSDTCountPaciente( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColSDTCountPaciente( java.util.Vector<StructSdtSDTCountPaciente> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTCountPaciente",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTCountPaciente> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTCountPaciente> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTCountPaciente> item = new java.util.Vector<>();
}

