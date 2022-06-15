package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRequestNubefact.itemsItem", namespace ="ProjectThani")
public final  class StructSdtColSDTRequestNubefact_itemsItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRequestNubefact_itemsItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTRequestNubefact_itemsItem.class ));
   }

   public StructSdtColSDTRequestNubefact_itemsItem( int remoteHandle ,
                                                    ModelContext context )
   {
   }

   public  StructSdtColSDTRequestNubefact_itemsItem( java.util.Vector<StructSdtSDTRequestNubefact_itemsItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRequestNubefact.itemsItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRequestNubefact_itemsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRequestNubefact_itemsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRequestNubefact_itemsItem> item = new java.util.Vector<>();
}

