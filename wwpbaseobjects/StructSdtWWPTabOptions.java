package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPTabOptions", namespace ="ProjectThani")
public final  class StructSdtWWPTabOptions implements Cloneable, java.io.Serializable
{
   public StructSdtWWPTabOptions( )
   {
      this( -1, new ModelContext( StructSdtWWPTabOptions.class ));
   }

   public StructSdtWWPTabOptions( int remoteHandle ,
                                  ModelContext context )
   {
   }

   public  StructSdtWWPTabOptions( java.util.Vector<StructSdtWWPTabOptions_TabOptionsItem> value )
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
   public java.util.Vector<StructSdtWWPTabOptions_TabOptionsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPTabOptions_TabOptionsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPTabOptions_TabOptionsItem> item = new java.util.Vector<>();
}

