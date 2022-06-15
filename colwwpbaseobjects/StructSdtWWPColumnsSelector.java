package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPColumnsSelector", namespace ="ProjectThani")
public final  class StructSdtWWPColumnsSelector implements Cloneable, java.io.Serializable
{
   public StructSdtWWPColumnsSelector( )
   {
      this( -1, new ModelContext( StructSdtWWPColumnsSelector.class ));
   }

   public StructSdtWWPColumnsSelector( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtWWPColumnsSelector( java.util.Vector<StructSdtWWPColumnsSelector> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPColumnsSelector",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPColumnsSelector> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPColumnsSelector> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPColumnsSelector> item = new java.util.Vector<>();
}

