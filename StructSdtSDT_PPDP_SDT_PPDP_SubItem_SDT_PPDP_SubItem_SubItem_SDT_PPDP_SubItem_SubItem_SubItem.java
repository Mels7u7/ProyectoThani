package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( )
   {
      this( -1, new ModelContext( StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem.class ));
   }

   public StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( int remoteHandle ,
                                                                                                        ModelContext context )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo = "" ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion = "" ;
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
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo ;
   }

   public void setTitulo( String value )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion = value ;
   }

   protected byte gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_N ;
   protected String gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Titulo ;
   protected String gxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem_Descripcion ;
}

