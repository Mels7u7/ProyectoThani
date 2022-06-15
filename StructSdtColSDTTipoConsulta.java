package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTTipoConsulta", namespace ="ProjectThani")
public final  class StructSdtColSDTTipoConsulta implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTTipoConsulta( )
   {
      this( -1, new ModelContext( StructSdtColSDTTipoConsulta.class ));
   }

   public StructSdtColSDTTipoConsulta( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColSDTTipoConsulta( java.util.Vector<StructSdtSDTTipoConsulta> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTTipoConsulta",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTTipoConsulta> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTTipoConsulta> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTTipoConsulta> item = new java.util.Vector<>();
}

