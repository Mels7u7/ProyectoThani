package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseNubefact", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseNubefact implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseNubefact( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseNubefact.class ));
   }

   public StructSdtColSDTResponseNubefact( int remoteHandle ,
                                           ModelContext context )
   {
   }

   public  StructSdtColSDTResponseNubefact( java.util.Vector<StructSdtSDTResponseNubefact> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseNubefact",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseNubefact> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseNubefact> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseNubefact> item = new java.util.Vector<>();
}

