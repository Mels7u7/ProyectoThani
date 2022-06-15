package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPGridState.FilterValue", namespace ="ProjectThani")
public final  class StructSdtWWPGridState_FilterValue implements Cloneable, java.io.Serializable
{
   public StructSdtWWPGridState_FilterValue( )
   {
      this( -1, new ModelContext( StructSdtWWPGridState_FilterValue.class ));
   }

   public StructSdtWWPGridState_FilterValue( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtWWPGridState_FilterValue( java.util.Vector<StructSdtWWPGridState_FilterValue> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPGridState.FilterValue",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPGridState_FilterValue> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPGridState_FilterValue> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPGridState_FilterValue> item = new java.util.Vector<>();
}

