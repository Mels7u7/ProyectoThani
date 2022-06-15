package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTTermCondProveedor.SubSDTTermCondProveedorItem.SubSubSDTTCProveedorItem", namespace ="ProjectThani")
public final  class StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem.class ));
   }

   public StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( int remoteHandle ,
                                                                                                 ModelContext context )
   {
   }

   public  StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTTermCondProveedor.SubSDTTermCondProveedorItem.SubSubSDTTCProveedorItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> item = new java.util.Vector<>();
}

