package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTCostoConsulta", namespace ="ProjectThani")
public final  class StructSdtColSDTCostoConsulta implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTCostoConsulta( )
   {
      this( -1, new ModelContext( StructSdtColSDTCostoConsulta.class ));
   }

   public StructSdtColSDTCostoConsulta( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColSDTCostoConsulta( java.util.Vector<StructSdtSDTCostoConsulta> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTCostoConsulta",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTCostoConsulta> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTCostoConsulta> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTCostoConsulta> item = new java.util.Vector<>();
}

