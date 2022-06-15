package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTInformacionDelPaciente", namespace ="ProjectThani")
public final  class StructSdtColSDTInformacionDelPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTInformacionDelPaciente( )
   {
      this( -1, new ModelContext( StructSdtColSDTInformacionDelPaciente.class ));
   }

   public StructSdtColSDTInformacionDelPaciente( int remoteHandle ,
                                                 ModelContext context )
   {
   }

   public  StructSdtColSDTInformacionDelPaciente( java.util.Vector<StructSdtSDTInformacionDelPaciente> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTInformacionDelPaciente",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTInformacionDelPaciente> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTInformacionDelPaciente> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTInformacionDelPaciente> item = new java.util.Vector<>();
}

