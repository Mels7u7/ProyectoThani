package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRequestNubefact", namespace ="ProjectThani")
public final  class StructSdtColSDTRequestNubefact implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRequestNubefact( )
   {
      this( -1, new ModelContext( StructSdtColSDTRequestNubefact.class ));
   }

   public StructSdtColSDTRequestNubefact( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtColSDTRequestNubefact( java.util.Vector<StructSdtSDTRequestNubefact> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRequestNubefact",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRequestNubefact> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRequestNubefact> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRequestNubefact> item = new java.util.Vector<>();
}

