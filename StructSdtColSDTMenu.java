package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTMenu", namespace ="ProjectThani")
public final  class StructSdtColSDTMenu implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTMenu( )
   {
      this( -1, new ModelContext( StructSdtColSDTMenu.class ));
   }

   public StructSdtColSDTMenu( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtColSDTMenu( java.util.Vector<StructSdtSDTMenu> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTMenu",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTMenu> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTMenu> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTMenu> item = new java.util.Vector<>();
}

