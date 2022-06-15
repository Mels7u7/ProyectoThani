package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRequestOrder", namespace ="ProjectThani")
public final  class StructSdtColSDTRequestOrder implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRequestOrder( )
   {
      this( -1, new ModelContext( StructSdtColSDTRequestOrder.class ));
   }

   public StructSdtColSDTRequestOrder( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColSDTRequestOrder( java.util.Vector<StructSdtSDTRequestOrder> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRequestOrder",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRequestOrder> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRequestOrder> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRequestOrder> item = new java.util.Vector<>();
}

