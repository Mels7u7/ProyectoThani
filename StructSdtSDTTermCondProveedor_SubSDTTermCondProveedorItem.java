package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem( )
   {
      this( -1, new ModelContext( StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem.class ));
   }

   public StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem( int remoteHandle ,
                                                                     ModelContext context )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo = "" ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion = "" ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N = (byte)(1) ;
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

   public String getTitulo( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo ;
   }

   public void setTitulo( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> getSubsubsdttcproveedor( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor ;
   }

   public void setSubsubsdttcproveedor( java.util.Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor = value ;
   }

   protected byte gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor_N ;
   protected byte gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_N ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion ;
   protected java.util.Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem> gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor=null ;
}

