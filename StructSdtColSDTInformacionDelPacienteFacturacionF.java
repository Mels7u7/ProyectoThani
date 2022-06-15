package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTInformacionDelPacienteFacturacionF", namespace ="ProjectThani")
public final  class StructSdtColSDTInformacionDelPacienteFacturacionF implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTInformacionDelPacienteFacturacionF( )
   {
      this( -1, new ModelContext( StructSdtColSDTInformacionDelPacienteFacturacionF.class ));
   }

   public StructSdtColSDTInformacionDelPacienteFacturacionF( int remoteHandle ,
                                                             ModelContext context )
   {
   }

   public  StructSdtColSDTInformacionDelPacienteFacturacionF( java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionF> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTInformacionDelPacienteFacturacionF",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionF> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionF> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTInformacionDelPacienteFacturacionF> item = new java.util.Vector<>();
}

