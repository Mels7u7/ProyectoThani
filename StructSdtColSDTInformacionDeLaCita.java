package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTInformacionDeLaCita", namespace ="ProjectThani")
public final  class StructSdtColSDTInformacionDeLaCita implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTInformacionDeLaCita( )
   {
      this( -1, new ModelContext( StructSdtColSDTInformacionDeLaCita.class ));
   }

   public StructSdtColSDTInformacionDeLaCita( int remoteHandle ,
                                              ModelContext context )
   {
   }

   public  StructSdtColSDTInformacionDeLaCita( java.util.Vector<StructSdtSDTInformacionDeLaCita> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTInformacionDeLaCita",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTInformacionDeLaCita> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTInformacionDeLaCita> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTInformacionDeLaCita> item = new java.util.Vector<>();
}

