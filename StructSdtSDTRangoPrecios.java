package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRangoPrecios implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRangoPrecios( )
   {
      this( -1, new ModelContext( StructSdtSDTRangoPrecios.class ));
   }

   public StructSdtSDTRangoPrecios( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtSDTRangoPrecios_Descripcion = "" ;
      gxTv_SdtSDTRangoPrecios_Valora = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRangoPrecios_Valorb = new java.math.BigDecimal(0) ;
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

   public short getIdprecio( )
   {
      return gxTv_SdtSDTRangoPrecios_Idprecio ;
   }

   public void setIdprecio( short value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Idprecio = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDTRangoPrecios_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Descripcion = value ;
   }

   public java.math.BigDecimal getValora( )
   {
      return gxTv_SdtSDTRangoPrecios_Valora ;
   }

   public void setValora( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Valora = value ;
   }

   public java.math.BigDecimal getValorb( )
   {
      return gxTv_SdtSDTRangoPrecios_Valorb ;
   }

   public void setValorb( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Valorb = value ;
   }

   public boolean getEstado( )
   {
      return gxTv_SdtSDTRangoPrecios_Estado ;
   }

   public void setEstado( boolean value )
   {
      gxTv_SdtSDTRangoPrecios_N = (byte)(0) ;
      gxTv_SdtSDTRangoPrecios_Estado = value ;
   }

   protected byte gxTv_SdtSDTRangoPrecios_N ;
   protected short gxTv_SdtSDTRangoPrecios_Idprecio ;
   protected boolean gxTv_SdtSDTRangoPrecios_Estado ;
   protected String gxTv_SdtSDTRangoPrecios_Descripcion ;
   protected java.math.BigDecimal gxTv_SdtSDTRangoPrecios_Valora ;
   protected java.math.BigDecimal gxTv_SdtSDTRangoPrecios_Valorb ;
}

