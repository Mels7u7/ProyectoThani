package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTSede", namespace ="ProjectThani")
public final  class StructSdtColSDTSede implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTSede( )
   {
      this( -1, new ModelContext( StructSdtColSDTSede.class ));
   }

   public StructSdtColSDTSede( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtColSDTSede( java.util.Vector<StructSdtSDTSede> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTSede",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTSede> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTSede> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTSede> item = new java.util.Vector<>();
}

