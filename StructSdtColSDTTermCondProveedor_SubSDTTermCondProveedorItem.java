package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTTermCondProveedor.SubSDTTermCondProveedorItem", namespace ="ProjectThani")
public final  class StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem.class ));
   }

   public StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem( int remoteHandle ,
                                                                        ModelContext context )
   {
   }

   public  StructSdtColSDTTermCondProveedor_SubSDTTermCondProveedorItem( java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTTermCondProveedor.SubSDTTermCondProveedorItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> item = new java.util.Vector<>();
}

