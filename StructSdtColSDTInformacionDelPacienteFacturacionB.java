package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTInformacionDelPacienteFacturacionB", namespace ="ProjectThani")
public final  class StructSdtColSDTInformacionDelPacienteFacturacionB implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTInformacionDelPacienteFacturacionB( )
   {
      this( -1, new ModelContext( StructSdtColSDTInformacionDelPacienteFacturacionB.class ));
   }

   public StructSdtColSDTInformacionDelPacienteFacturacionB( int remoteHandle ,
                                                             ModelContext context )
   {
   }

   public  StructSdtColSDTInformacionDelPacienteFacturacionB( java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionB> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTInformacionDelPacienteFacturacionB",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionB> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionB> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionB> item = new java.util.Vector<>();
}

