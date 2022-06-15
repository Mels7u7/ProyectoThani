package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( )
   {
      this( -1, new ModelContext( StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem.class ));
   }

   public StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem( int remoteHandle ,
                                                                                              ModelContext context )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo = "" ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion = "" ;
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
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo ;
   }

   public void setTitulo( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion = value ;
   }

   protected byte gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_N ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Titulo ;
   protected String gxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion ;
}

