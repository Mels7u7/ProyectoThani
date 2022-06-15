package com.projectthani ;
import com.genexus.*;

public final  class StructSdtClinica implements Cloneable, java.io.Serializable
{
   public StructSdtClinica( )
   {
      this( -1, new ModelContext( StructSdtClinica.class ));
   }

   public StructSdtClinica( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtClinica_Clinicanombrecomercial = "" ;
      gxTv_SdtClinica_Clinicanombreabreviado = "" ;
      gxTv_SdtClinica_Clinicadireccioncomercial = "" ;
      gxTv_SdtClinica_Clinicacorreo = "" ;
      gxTv_SdtClinica_Clinicalogo = "" ;
      gxTv_SdtClinica_Clinicalogo_gxi = "" ;
      gxTv_SdtClinica_Clinicalogoheader = "" ;
      gxTv_SdtClinica_Clinicalogoheader_gxi = "" ;
      gxTv_SdtClinica_Clinicalogofactura = "" ;
      gxTv_SdtClinica_Clinicalogofactura_gxi = "" ;
      gxTv_SdtClinica_Clinicalogoboleta = "" ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi = "" ;
      gxTv_SdtClinica_Clinicalogopago = "" ;
      gxTv_SdtClinica_Clinicalogopago_gxi = "" ;
      gxTv_SdtClinica_Clinicatelefono = "" ;
      gxTv_SdtClinica_Clinicawhatsapp = "" ;
      gxTv_SdtClinica_Clinicafacebook = "" ;
      gxTv_SdtClinica_Clinicatwiter = "" ;
      gxTv_SdtClinica_Clinicainstagram = "" ;
      gxTv_SdtClinica_Clinicalinkedin = "" ;
      gxTv_SdtClinica_Clinicaestado = "" ;
      gxTv_SdtClinica_Mode = "" ;
      gxTv_SdtClinica_Clinicanombrecomercial_Z = "" ;
      gxTv_SdtClinica_Clinicanombreabreviado_Z = "" ;
      gxTv_SdtClinica_Clinicadireccioncomercial_Z = "" ;
      gxTv_SdtClinica_Clinicacorreo_Z = "" ;
      gxTv_SdtClinica_Clinicatelefono_Z = "" ;
      gxTv_SdtClinica_Clinicawhatsapp_Z = "" ;
      gxTv_SdtClinica_Clinicafacebook_Z = "" ;
      gxTv_SdtClinica_Clinicatwiter_Z = "" ;
      gxTv_SdtClinica_Clinicainstagram_Z = "" ;
      gxTv_SdtClinica_Clinicalinkedin_Z = "" ;
      gxTv_SdtClinica_Clinicaestado_Z = "" ;
      gxTv_SdtClinica_Clinicalogo_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogoheader_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogofactura_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogopago_gxi_Z = "" ;
      gxTv_SdtClinica_Clinicalogoheader_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogoheader_gxi_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogofactura_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogofactura_gxi_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogoboleta_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogopago_N = (byte)(1) ;
      gxTv_SdtClinica_Clinicalogopago_gxi_N = (byte)(1) ;
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

   public short getClinicaid( )
   {
      return gxTv_SdtClinica_Clinicaid ;
   }

   public void setClinicaid( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicaid = value ;
   }

   public long getClinicaruc( )
   {
      return gxTv_SdtClinica_Clinicaruc ;
   }

   public void setClinicaruc( long value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicaruc = value ;
   }

   public String getClinicanombrecomercial( )
   {
      return gxTv_SdtClinica_Clinicanombrecomercial ;
   }

   public void setClinicanombrecomercial( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicanombrecomercial = value ;
   }

   public String getClinicanombreabreviado( )
   {
      return gxTv_SdtClinica_Clinicanombreabreviado ;
   }

   public void setClinicanombreabreviado( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicanombreabreviado = value ;
   }

   public String getClinicadireccioncomercial( )
   {
      return gxTv_SdtClinica_Clinicadireccioncomercial ;
   }

   public void setClinicadireccioncomercial( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicadireccioncomercial = value ;
   }

   public String getClinicacorreo( )
   {
      return gxTv_SdtClinica_Clinicacorreo ;
   }

   public void setClinicacorreo( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicacorreo = value ;
   }

   public short getClinicamoneda( )
   {
      return gxTv_SdtClinica_Clinicamoneda ;
   }

   public void setClinicamoneda( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicamoneda = value ;
   }

   public String getClinicalogo( )
   {
      return gxTv_SdtClinica_Clinicalogo ;
   }

   public void setClinicalogo( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogo = value ;
   }

   public String getClinicalogo_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogo_gxi ;
   }

   public void setClinicalogo_gxi( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogo_gxi = value ;
   }

   public String getClinicalogoheader( )
   {
      return gxTv_SdtClinica_Clinicalogoheader ;
   }

   public void setClinicalogoheader( String value )
   {
      gxTv_SdtClinica_Clinicalogoheader_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoheader = value ;
   }

   public String getClinicalogoheader_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_gxi ;
   }

   public void setClinicalogoheader_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogoheader_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoheader_gxi = value ;
   }

   public String getClinicalogofactura( )
   {
      return gxTv_SdtClinica_Clinicalogofactura ;
   }

   public void setClinicalogofactura( String value )
   {
      gxTv_SdtClinica_Clinicalogofactura_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogofactura = value ;
   }

   public String getClinicalogofactura_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_gxi ;
   }

   public void setClinicalogofactura_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogofactura_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogofactura_gxi = value ;
   }

   public String getClinicalogoboleta( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta ;
   }

   public void setClinicalogoboleta( String value )
   {
      gxTv_SdtClinica_Clinicalogoboleta_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoboleta = value ;
   }

   public String getClinicalogoboleta_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_gxi ;
   }

   public void setClinicalogoboleta_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogoboleta_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi = value ;
   }

   public String getClinicalogopago( )
   {
      return gxTv_SdtClinica_Clinicalogopago ;
   }

   public void setClinicalogopago( String value )
   {
      gxTv_SdtClinica_Clinicalogopago_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogopago = value ;
   }

   public String getClinicalogopago_gxi( )
   {
      return gxTv_SdtClinica_Clinicalogopago_gxi ;
   }

   public void setClinicalogopago_gxi( String value )
   {
      gxTv_SdtClinica_Clinicalogopago_gxi_N = (byte)(0) ;
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogopago_gxi = value ;
   }

   public String getClinicatelefono( )
   {
      return gxTv_SdtClinica_Clinicatelefono ;
   }

   public void setClinicatelefono( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicatelefono = value ;
   }

   public String getClinicawhatsapp( )
   {
      return gxTv_SdtClinica_Clinicawhatsapp ;
   }

   public void setClinicawhatsapp( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicawhatsapp = value ;
   }

   public String getClinicafacebook( )
   {
      return gxTv_SdtClinica_Clinicafacebook ;
   }

   public void setClinicafacebook( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicafacebook = value ;
   }

   public String getClinicatwiter( )
   {
      return gxTv_SdtClinica_Clinicatwiter ;
   }

   public void setClinicatwiter( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicatwiter = value ;
   }

   public String getClinicainstagram( )
   {
      return gxTv_SdtClinica_Clinicainstagram ;
   }

   public void setClinicainstagram( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicainstagram = value ;
   }

   public String getClinicalinkedin( )
   {
      return gxTv_SdtClinica_Clinicalinkedin ;
   }

   public void setClinicalinkedin( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalinkedin = value ;
   }

   public byte getClinicatiempodecita( )
   {
      return gxTv_SdtClinica_Clinicatiempodecita ;
   }

   public void setClinicatiempodecita( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicatiempodecita = value ;
   }

   public String getClinicaestado( )
   {
      return gxTv_SdtClinica_Clinicaestado ;
   }

   public void setClinicaestado( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicaestado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtClinica_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtClinica_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Initialized = value ;
   }

   public short getClinicaid_Z( )
   {
      return gxTv_SdtClinica_Clinicaid_Z ;
   }

   public void setClinicaid_Z( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicaid_Z = value ;
   }

   public long getClinicaruc_Z( )
   {
      return gxTv_SdtClinica_Clinicaruc_Z ;
   }

   public void setClinicaruc_Z( long value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicaruc_Z = value ;
   }

   public String getClinicanombrecomercial_Z( )
   {
      return gxTv_SdtClinica_Clinicanombrecomercial_Z ;
   }

   public void setClinicanombrecomercial_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicanombrecomercial_Z = value ;
   }

   public String getClinicanombreabreviado_Z( )
   {
      return gxTv_SdtClinica_Clinicanombreabreviado_Z ;
   }

   public void setClinicanombreabreviado_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicanombreabreviado_Z = value ;
   }

   public String getClinicadireccioncomercial_Z( )
   {
      return gxTv_SdtClinica_Clinicadireccioncomercial_Z ;
   }

   public void setClinicadireccioncomercial_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicadireccioncomercial_Z = value ;
   }

   public String getClinicacorreo_Z( )
   {
      return gxTv_SdtClinica_Clinicacorreo_Z ;
   }

   public void setClinicacorreo_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicacorreo_Z = value ;
   }

   public short getClinicamoneda_Z( )
   {
      return gxTv_SdtClinica_Clinicamoneda_Z ;
   }

   public void setClinicamoneda_Z( short value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicamoneda_Z = value ;
   }

   public String getClinicatelefono_Z( )
   {
      return gxTv_SdtClinica_Clinicatelefono_Z ;
   }

   public void setClinicatelefono_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicatelefono_Z = value ;
   }

   public String getClinicawhatsapp_Z( )
   {
      return gxTv_SdtClinica_Clinicawhatsapp_Z ;
   }

   public void setClinicawhatsapp_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicawhatsapp_Z = value ;
   }

   public String getClinicafacebook_Z( )
   {
      return gxTv_SdtClinica_Clinicafacebook_Z ;
   }

   public void setClinicafacebook_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicafacebook_Z = value ;
   }

   public String getClinicatwiter_Z( )
   {
      return gxTv_SdtClinica_Clinicatwiter_Z ;
   }

   public void setClinicatwiter_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicatwiter_Z = value ;
   }

   public String getClinicainstagram_Z( )
   {
      return gxTv_SdtClinica_Clinicainstagram_Z ;
   }

   public void setClinicainstagram_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicainstagram_Z = value ;
   }

   public String getClinicalinkedin_Z( )
   {
      return gxTv_SdtClinica_Clinicalinkedin_Z ;
   }

   public void setClinicalinkedin_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalinkedin_Z = value ;
   }

   public byte getClinicatiempodecita_Z( )
   {
      return gxTv_SdtClinica_Clinicatiempodecita_Z ;
   }

   public void setClinicatiempodecita_Z( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicatiempodecita_Z = value ;
   }

   public String getClinicaestado_Z( )
   {
      return gxTv_SdtClinica_Clinicaestado_Z ;
   }

   public void setClinicaestado_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicaestado_Z = value ;
   }

   public String getClinicalogo_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogo_gxi_Z ;
   }

   public void setClinicalogo_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogo_gxi_Z = value ;
   }

   public String getClinicalogoheader_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_gxi_Z ;
   }

   public void setClinicalogoheader_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoheader_gxi_Z = value ;
   }

   public String getClinicalogofactura_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_gxi_Z ;
   }

   public void setClinicalogofactura_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogofactura_gxi_Z = value ;
   }

   public String getClinicalogoboleta_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_gxi_Z ;
   }

   public void setClinicalogoboleta_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi_Z = value ;
   }

   public String getClinicalogopago_gxi_Z( )
   {
      return gxTv_SdtClinica_Clinicalogopago_gxi_Z ;
   }

   public void setClinicalogopago_gxi_Z( String value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogopago_gxi_Z = value ;
   }

   public byte getClinicalogoheader_N( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_N ;
   }

   public void setClinicalogoheader_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoheader_N = value ;
   }

   public byte getClinicalogofactura_N( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_N ;
   }

   public void setClinicalogofactura_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogofactura_N = value ;
   }

   public byte getClinicalogoboleta_N( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_N ;
   }

   public void setClinicalogoboleta_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoboleta_N = value ;
   }

   public byte getClinicalogopago_N( )
   {
      return gxTv_SdtClinica_Clinicalogopago_N ;
   }

   public void setClinicalogopago_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogopago_N = value ;
   }

   public byte getClinicalogoheader_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogoheader_gxi_N ;
   }

   public void setClinicalogoheader_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoheader_gxi_N = value ;
   }

   public byte getClinicalogofactura_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogofactura_gxi_N ;
   }

   public void setClinicalogofactura_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogofactura_gxi_N = value ;
   }

   public byte getClinicalogoboleta_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogoboleta_gxi_N ;
   }

   public void setClinicalogoboleta_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogoboleta_gxi_N = value ;
   }

   public byte getClinicalogopago_gxi_N( )
   {
      return gxTv_SdtClinica_Clinicalogopago_gxi_N ;
   }

   public void setClinicalogopago_gxi_N( byte value )
   {
      gxTv_SdtClinica_N = (byte)(0) ;
      gxTv_SdtClinica_Clinicalogopago_gxi_N = value ;
   }

   protected byte gxTv_SdtClinica_Clinicatiempodecita ;
   protected byte gxTv_SdtClinica_Clinicatiempodecita_Z ;
   protected byte gxTv_SdtClinica_Clinicalogoheader_N ;
   protected byte gxTv_SdtClinica_Clinicalogofactura_N ;
   protected byte gxTv_SdtClinica_Clinicalogoboleta_N ;
   protected byte gxTv_SdtClinica_Clinicalogopago_N ;
   protected byte gxTv_SdtClinica_Clinicalogoheader_gxi_N ;
   protected byte gxTv_SdtClinica_Clinicalogofactura_gxi_N ;
   protected byte gxTv_SdtClinica_Clinicalogoboleta_gxi_N ;
   protected byte gxTv_SdtClinica_Clinicalogopago_gxi_N ;
   private byte gxTv_SdtClinica_N ;
   protected short gxTv_SdtClinica_Clinicaid ;
   protected short gxTv_SdtClinica_Clinicamoneda ;
   protected short gxTv_SdtClinica_Initialized ;
   protected short gxTv_SdtClinica_Clinicaid_Z ;
   protected short gxTv_SdtClinica_Clinicamoneda_Z ;
   protected long gxTv_SdtClinica_Clinicaruc ;
   protected long gxTv_SdtClinica_Clinicaruc_Z ;
   protected String gxTv_SdtClinica_Clinicatelefono ;
   protected String gxTv_SdtClinica_Clinicawhatsapp ;
   protected String gxTv_SdtClinica_Clinicaestado ;
   protected String gxTv_SdtClinica_Mode ;
   protected String gxTv_SdtClinica_Clinicatelefono_Z ;
   protected String gxTv_SdtClinica_Clinicawhatsapp_Z ;
   protected String gxTv_SdtClinica_Clinicaestado_Z ;
   protected String gxTv_SdtClinica_Clinicanombrecomercial ;
   protected String gxTv_SdtClinica_Clinicanombreabreviado ;
   protected String gxTv_SdtClinica_Clinicadireccioncomercial ;
   protected String gxTv_SdtClinica_Clinicacorreo ;
   protected String gxTv_SdtClinica_Clinicalogo_gxi ;
   protected String gxTv_SdtClinica_Clinicalogoheader_gxi ;
   protected String gxTv_SdtClinica_Clinicalogofactura_gxi ;
   protected String gxTv_SdtClinica_Clinicalogoboleta_gxi ;
   protected String gxTv_SdtClinica_Clinicalogopago_gxi ;
   protected String gxTv_SdtClinica_Clinicafacebook ;
   protected String gxTv_SdtClinica_Clinicatwiter ;
   protected String gxTv_SdtClinica_Clinicainstagram ;
   protected String gxTv_SdtClinica_Clinicalinkedin ;
   protected String gxTv_SdtClinica_Clinicanombrecomercial_Z ;
   protected String gxTv_SdtClinica_Clinicanombreabreviado_Z ;
   protected String gxTv_SdtClinica_Clinicadireccioncomercial_Z ;
   protected String gxTv_SdtClinica_Clinicacorreo_Z ;
   protected String gxTv_SdtClinica_Clinicafacebook_Z ;
   protected String gxTv_SdtClinica_Clinicatwiter_Z ;
   protected String gxTv_SdtClinica_Clinicainstagram_Z ;
   protected String gxTv_SdtClinica_Clinicalinkedin_Z ;
   protected String gxTv_SdtClinica_Clinicalogo_gxi_Z ;
   protected String gxTv_SdtClinica_Clinicalogoheader_gxi_Z ;
   protected String gxTv_SdtClinica_Clinicalogofactura_gxi_Z ;
   protected String gxTv_SdtClinica_Clinicalogoboleta_gxi_Z ;
   protected String gxTv_SdtClinica_Clinicalogopago_gxi_Z ;
   protected String gxTv_SdtClinica_Clinicalogo ;
   protected String gxTv_SdtClinica_Clinicalogoheader ;
   protected String gxTv_SdtClinica_Clinicalogofactura ;
   protected String gxTv_SdtClinica_Clinicalogoboleta ;
   protected String gxTv_SdtClinica_Clinicalogopago ;
}

