package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "TabOptions", namespace ="ProjectThani")
public final  class StructSdtTabOptions implements Cloneable, java.io.Serializable
{
   public StructSdtTabOptions( )
   {
      this( -1, new ModelContext( StructSdtTabOptions.class ));
   }

   public StructSdtTabOptions( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtTabOptions( java.util.Vector<StructSdtTabOptions_TabOptionsItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="TabOptionsItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtTabOptions_TabOptionsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTabOptions_TabOptionsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTabOptions_TabOptionsItem> item = new java.util.Vector<>();
}

