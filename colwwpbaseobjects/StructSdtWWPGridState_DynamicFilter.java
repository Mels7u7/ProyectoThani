package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPGridState.DynamicFilter", namespace ="ProjectThani")
public final  class StructSdtWWPGridState_DynamicFilter implements Cloneable, java.io.Serializable
{
   public StructSdtWWPGridState_DynamicFilter( )
   {
      this( -1, new ModelContext( StructSdtWWPGridState_DynamicFilter.class ));
   }

   public StructSdtWWPGridState_DynamicFilter( int remoteHandle ,
                                               ModelContext context )
   {
   }

   public  StructSdtWWPGridState_DynamicFilter( java.util.Vector<StructSdtWWPGridState_DynamicFilter> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPGridState.DynamicFilter",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPGridState_DynamicFilter> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPGridState_DynamicFilter> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPGridState_DynamicFilter> item = new java.util.Vector<>();
}

