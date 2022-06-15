package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPContext", namespace ="ProjectThani")
public final  class StructSdtWWPContext implements Cloneable, java.io.Serializable
{
   public StructSdtWWPContext( )
   {
      this( -1, new ModelContext( StructSdtWWPContext.class ));
   }

   public StructSdtWWPContext( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtWWPContext( java.util.Vector<StructSdtWWPContext> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPContext",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPContext> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPContext> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPContext> item = new java.util.Vector<>();
}

