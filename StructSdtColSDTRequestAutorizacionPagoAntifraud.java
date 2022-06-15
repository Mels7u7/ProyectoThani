package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRequestAutorizacionPagoAntifraud", namespace ="ProjectThani")
public final  class StructSdtColSDTRequestAutorizacionPagoAntifraud implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRequestAutorizacionPagoAntifraud( )
   {
      this( -1, new ModelContext( StructSdtColSDTRequestAutorizacionPagoAntifraud.class ));
   }

   public StructSdtColSDTRequestAutorizacionPagoAntifraud( int remoteHandle ,
                                                           ModelContext context )
   {
   }

   public  StructSdtColSDTRequestAutorizacionPagoAntifraud( java.util.Vector<StructSdtSDTRequestAutorizacionPagoAntifraud> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRequestAutorizacionPagoAntifraud",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRequestAutorizacionPagoAntifraud> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRequestAutorizacionPagoAntifraud> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRequestAutorizacionPagoAntifraud> item = new java.util.Vector<>();
}

