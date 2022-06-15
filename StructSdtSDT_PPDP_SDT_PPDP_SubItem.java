package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDT_PPDP_SDT_PPDP_SubItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDT_PPDP_SDT_PPDP_SubItem( )
   {
      this( -1, new ModelContext( StructSdtSDT_PPDP_SDT_PPDP_SubItem.class ));
   }

   public StructSdtSDT_PPDP_SDT_PPDP_SubItem( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo = "" ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion = "" ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub_N = (byte)(1) ;
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
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo ;
   }

   public void setTitulo( String value )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem> getSdt_ppdp_subitem_sub( )
   {
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub ;
   }

   public void setSdt_ppdp_subitem_sub( java.util.Vector<com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem> value )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub = value ;
   }

   protected byte gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub_N ;
   protected byte gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_N ;
   protected String gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo ;
   protected String gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion ;
   protected java.util.Vector<com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem> gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub=null ;
}

