package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseNubefact implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseNubefact( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseNubefact.class ));
   }

   public StructSdtSDTResponseNubefact( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTResponseNubefact_Serie = "" ;
      gxTv_SdtSDTResponseNubefact_Numero = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTResponseNubefact_Enlace = "" ;
      gxTv_SdtSDTResponseNubefact_Sunat_soap_error = "" ;
      gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr = "" ;
      gxTv_SdtSDTResponseNubefact_Codigo_hash = "" ;
      gxTv_SdtSDTResponseNubefact_Codigo_de_barras = "" ;
      gxTv_SdtSDTResponseNubefact_Key = "" ;
      gxTv_SdtSDTResponseNubefact_Digest_value = "" ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_pdf = "" ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_xml = "" ;
      gxTv_SdtSDTResponseNubefact_Invoice_N = (byte)(1) ;
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

   public java.math.BigDecimal getTipo_de_comprobante( )
   {
      return gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante ;
   }

   public void setTipo_de_comprobante( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante = value ;
   }

   public String getSerie( )
   {
      return gxTv_SdtSDTResponseNubefact_Serie ;
   }

   public void setSerie( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Serie = value ;
   }

   public java.math.BigDecimal getNumero( )
   {
      return gxTv_SdtSDTResponseNubefact_Numero ;
   }

   public void setNumero( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Numero = value ;
   }

   public String getEnlace( )
   {
      return gxTv_SdtSDTResponseNubefact_Enlace ;
   }

   public void setEnlace( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Enlace = value ;
   }

   public boolean getAceptada_por_sunat( )
   {
      return gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat ;
   }

   public void setAceptada_por_sunat( boolean value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat = value ;
   }

   public String getSunat_soap_error( )
   {
      return gxTv_SdtSDTResponseNubefact_Sunat_soap_error ;
   }

   public void setSunat_soap_error( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Sunat_soap_error = value ;
   }

   public String getCadena_para_codigo_qr( )
   {
      return gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr ;
   }

   public void setCadena_para_codigo_qr( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr = value ;
   }

   public String getCodigo_hash( )
   {
      return gxTv_SdtSDTResponseNubefact_Codigo_hash ;
   }

   public void setCodigo_hash( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Codigo_hash = value ;
   }

   public String getCodigo_de_barras( )
   {
      return gxTv_SdtSDTResponseNubefact_Codigo_de_barras ;
   }

   public void setCodigo_de_barras( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Codigo_de_barras = value ;
   }

   public String getKey( )
   {
      return gxTv_SdtSDTResponseNubefact_Key ;
   }

   public void setKey( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Key = value ;
   }

   public String getDigest_value( )
   {
      return gxTv_SdtSDTResponseNubefact_Digest_value ;
   }

   public void setDigest_value( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Digest_value = value ;
   }

   public String getEnlace_del_pdf( )
   {
      return gxTv_SdtSDTResponseNubefact_Enlace_del_pdf ;
   }

   public void setEnlace_del_pdf( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_pdf = value ;
   }

   public String getEnlace_del_xml( )
   {
      return gxTv_SdtSDTResponseNubefact_Enlace_del_xml ;
   }

   public void setEnlace_del_xml( String value )
   {
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Enlace_del_xml = value ;
   }

   public com.projectthani.StructSdtSDTResponseNubefact_invoice getInvoice( )
   {
      return gxTv_SdtSDTResponseNubefact_Invoice ;
   }

   public void setInvoice( com.projectthani.StructSdtSDTResponseNubefact_invoice value )
   {
      gxTv_SdtSDTResponseNubefact_Invoice_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_N = (byte)(0) ;
      gxTv_SdtSDTResponseNubefact_Invoice = value;
   }

   protected byte gxTv_SdtSDTResponseNubefact_Invoice_N ;
   protected byte gxTv_SdtSDTResponseNubefact_N ;
   protected boolean gxTv_SdtSDTResponseNubefact_Aceptada_por_sunat ;
   protected String gxTv_SdtSDTResponseNubefact_Serie ;
   protected String gxTv_SdtSDTResponseNubefact_Enlace ;
   protected String gxTv_SdtSDTResponseNubefact_Sunat_soap_error ;
   protected String gxTv_SdtSDTResponseNubefact_Cadena_para_codigo_qr ;
   protected String gxTv_SdtSDTResponseNubefact_Codigo_hash ;
   protected String gxTv_SdtSDTResponseNubefact_Codigo_de_barras ;
   protected String gxTv_SdtSDTResponseNubefact_Key ;
   protected String gxTv_SdtSDTResponseNubefact_Digest_value ;
   protected String gxTv_SdtSDTResponseNubefact_Enlace_del_pdf ;
   protected String gxTv_SdtSDTResponseNubefact_Enlace_del_xml ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseNubefact_Tipo_de_comprobante ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseNubefact_Numero ;
   protected com.projectthani.StructSdtSDTResponseNubefact_invoice gxTv_SdtSDTResponseNubefact_Invoice=null ;
}

