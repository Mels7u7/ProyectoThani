package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRangoPrecios", namespace ="ProjectThani")
public final  class StructSdtColSDTRangoPrecios implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRangoPrecios( )
   {
      this( -1, new ModelContext( StructSdtColSDTRangoPrecios.class ));
   }

   public StructSdtColSDTRangoPrecios( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColSDTRangoPrecios( java.util.Vector<StructSdtSDTRangoPrecios> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRangoPrecios",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRangoPrecios> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRangoPrecios> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRangoPrecios> item = new java.util.Vector<>();
}

