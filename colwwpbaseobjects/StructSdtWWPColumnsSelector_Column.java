package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPColumnsSelector.Column", namespace ="ProjectThani")
public final  class StructSdtWWPColumnsSelector_Column implements Cloneable, java.io.Serializable
{
   public StructSdtWWPColumnsSelector_Column( )
   {
      this( -1, new ModelContext( StructSdtWWPColumnsSelector_Column.class ));
   }

   public StructSdtWWPColumnsSelector_Column( int remoteHandle ,
                                              ModelContext context )
   {
   }

   public  StructSdtWWPColumnsSelector_Column( java.util.Vector<StructSdtWWPColumnsSelector_Column> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPColumnsSelector.Column",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPColumnsSelector_Column> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPColumnsSelector_Column> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPColumnsSelector_Column> item = new java.util.Vector<>();
}

