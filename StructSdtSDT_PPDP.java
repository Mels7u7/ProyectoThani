package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDT_PPDP implements Cloneable, java.io.Serializable
{
   public StructSdtSDT_PPDP( )
   {
      this( -1, new ModelContext( StructSdtSDT_PPDP.class ));
   }

   public StructSdtSDT_PPDP( int remoteHandle ,
                             ModelContext context )
   {
      gxTv_SdtSDT_PPDP_Titulo = "" ;
      gxTv_SdtSDT_PPDP_Descripcion = "" ;
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N = (byte)(1) ;
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
      return gxTv_SdtSDT_PPDP_Titulo ;
   }

   public void setTitulo( String value )
   {
      gxTv_SdtSDT_PPDP_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_Titulo = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDT_PPDP_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDT_PPDP_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_Descripcion = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem> getSdt_ppdp_sub( )
   {
      return gxTv_SdtSDT_PPDP_Sdt_ppdp_sub ;
   }

   public void setSdt_ppdp_sub( java.util.Vector<com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem> value )
   {
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_N = (byte)(0) ;
      gxTv_SdtSDT_PPDP_Sdt_ppdp_sub = value ;
   }

   protected byte gxTv_SdtSDT_PPDP_Sdt_ppdp_sub_N ;
   protected byte gxTv_SdtSDT_PPDP_N ;
   protected String gxTv_SdtSDT_PPDP_Titulo ;
   protected String gxTv_SdtSDT_PPDP_Descripcion ;
   protected java.util.Vector<com.projectthani.StructSdtSDT_PPDP_SDT_PPDP_SubItem> gxTv_SdtSDT_PPDP_Sdt_ppdp_sub=null ;
}

