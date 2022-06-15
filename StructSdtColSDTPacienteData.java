package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTPacienteData", namespace ="ProjectThani")
public final  class StructSdtColSDTPacienteData implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTPacienteData( )
   {
      this( -1, new ModelContext( StructSdtColSDTPacienteData.class ));
   }

   public StructSdtColSDTPacienteData( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColSDTPacienteData( java.util.Vector<StructSdtSDTPacienteData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTPacienteData",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTPacienteData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTPacienteData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTPacienteData> item = new java.util.Vector<>();
}

