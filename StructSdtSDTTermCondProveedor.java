package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTTermCondProveedor implements Cloneable, java.io.Serializable
{
   public StructSdtSDTTermCondProveedor( )
   {
      this( -1, new ModelContext( StructSdtSDTTermCondProveedor.class ));
   }

   public StructSdtSDTTermCondProveedor( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtSDTTermCondProveedor_Titulo = "" ;
      gxTv_SdtSDTTermCondProveedor_Descripcion = "" ;
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N = (byte)(1) ;
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
      return gxTv_SdtSDTTermCondProveedor_Titulo ;
   }

   public void setTitulo( String value )
   {
      gxTv_SdtSDTTermCondProveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_Titulo = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDTTermCondProveedor_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDTTermCondProveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_Descripcion = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> getSubsdttermcondproveedor( )
   {
      return gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor ;
   }

   public void setSubsdttermcondproveedor( java.util.Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> value )
   {
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_N = (byte)(0) ;
      gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor = value ;
   }

   protected byte gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor_N ;
   protected byte gxTv_SdtSDTTermCondProveedor_N ;
   protected String gxTv_SdtSDTTermCondProveedor_Titulo ;
   protected String gxTv_SdtSDTTermCondProveedor_Descripcion ;
   protected java.util.Vector<com.projectthani.StructSdtSDTTermCondProveedor_SubSDTTermCondProveedorItem> gxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor=null ;
}

