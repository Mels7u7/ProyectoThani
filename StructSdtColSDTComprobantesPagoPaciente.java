package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTComprobantesPagoPaciente", namespace ="ProjectThani")
public final  class StructSdtColSDTComprobantesPagoPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTComprobantesPagoPaciente( )
   {
      this( -1, new ModelContext( StructSdtColSDTComprobantesPagoPaciente.class ));
   }

   public StructSdtColSDTComprobantesPagoPaciente( int remoteHandle ,
                                                   ModelContext context )
   {
   }

   public  StructSdtColSDTComprobantesPagoPaciente( java.util.Vector<StructSdtSDTComprobantesPagoPaciente> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTComprobantesPagoPaciente",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTComprobantesPagoPaciente> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTComprobantesPagoPaciente> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTComprobantesPagoPaciente> item = new java.util.Vector<>();
}

