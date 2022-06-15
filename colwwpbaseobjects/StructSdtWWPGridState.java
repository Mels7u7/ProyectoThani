package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPGridState", namespace ="ProjectThani")
public final  class StructSdtWWPGridState implements Cloneable, java.io.Serializable
{
   public StructSdtWWPGridState( )
   {
      this( -1, new ModelContext( StructSdtWWPGridState.class ));
   }

   public StructSdtWWPGridState( int remoteHandle ,
                                 ModelContext context )
   {
   }

   public  StructSdtWWPGridState( java.util.Vector<StructSdtWWPGridState> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPGridState",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPGridState> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPGridState> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPGridState> item = new java.util.Vector<>();
}

