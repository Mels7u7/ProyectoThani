package com.projectthani ;
import com.genexus.*;

public final  class StructSdtPago implements Cloneable, java.io.Serializable
{
   public StructSdtPago( )
   {
      this( -1, new ModelContext( StructSdtPago.class ));
   }

   public StructSdtPago( int remoteHandle ,
                         ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtPago_Citacode = "" ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha = cal.getTime() ;
      gxTv_SdtPago_Pagomonto = new java.math.BigDecimal(0) ;
      gxTv_SdtPago_Pagotoken = "" ;
      gxTv_SdtPago_Pagotipodocumentocliente = "" ;
      gxTv_SdtPago_Pagoclientenrodocumento = "" ;
      gxTv_SdtPago_Pagoclientedenominacion = "" ;
      gxTv_SdtPago_Pagoclientedireccion = "" ;
      gxTv_SdtPago_Pagoclienteemail = "" ;
      gxTv_SdtPago_Pagofechaemision = cal.getTime() ;
      gxTv_SdtPago_Pagonubefactrequest = "" ;
      gxTv_SdtPago_Pagonubefactresponse = "" ;
      gxTv_SdtPago_Pagorequest = "" ;
      gxTv_SdtPago_Pagoresponse = "" ;
      gxTv_SdtPago_Pagopasarelaid = "" ;
      gxTv_SdtPago_Pagoenlacepdf = "" ;
      gxTv_SdtPago_Pagoenlacexml = "" ;
      gxTv_SdtPago_Pagoestador = "" ;
      gxTv_SdtPago_Mode = "" ;
      gxTv_SdtPago_Citacode_Z = "" ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha_Z = cal.getTime() ;
      gxTv_SdtPago_Pagomonto_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPago_Pagotoken_Z = "" ;
      gxTv_SdtPago_Pagotipodocumentocliente_Z = "" ;
      gxTv_SdtPago_Pagoclientenrodocumento_Z = "" ;
      gxTv_SdtPago_Pagoclientedenominacion_Z = "" ;
      gxTv_SdtPago_Pagoclientedireccion_Z = "" ;
      gxTv_SdtPago_Pagoclienteemail_Z = "" ;
      gxTv_SdtPago_Pagofechaemision_Z = cal.getTime() ;
      gxTv_SdtPago_Pagopasarelaid_Z = "" ;
      gxTv_SdtPago_Pagoenlacepdf_Z = "" ;
      gxTv_SdtPago_Pagoenlacexml_Z = "" ;
      gxTv_SdtPago_Pagoestador_Z = "" ;
      gxTv_SdtPago_Citaid_N = (byte)(1) ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtPago_Disponibilidadid_N = (byte)(1) ;
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

   public int getPagoid( )
   {
      return gxTv_SdtPago_Pagoid ;
   }

   public void setPagoid( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoid = value ;
   }

   public int getCitaid( )
   {
      return gxTv_SdtPago_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtPago_Citaid_N = (byte)(0) ;
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Citaid = value ;
   }

   public String getCitacode( )
   {
      return gxTv_SdtPago_Citacode ;
   }

   public void setCitacode( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Citacode = value ;
   }

   public java.util.Date getSgcitadisponibilidadfecha( )
   {
      return gxTv_SdtPago_Sgcitadisponibilidadfecha ;
   }

   public void setSgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtPago_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha = value ;
   }

   public java.math.BigDecimal getPagomonto( )
   {
      return gxTv_SdtPago_Pagomonto ;
   }

   public void setPagomonto( java.math.BigDecimal value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagomonto = value ;
   }

   public String getPagotoken( )
   {
      return gxTv_SdtPago_Pagotoken ;
   }

   public void setPagotoken( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagotoken = value ;
   }

   public String getPagotipodocumentocliente( )
   {
      return gxTv_SdtPago_Pagotipodocumentocliente ;
   }

   public void setPagotipodocumentocliente( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagotipodocumentocliente = value ;
   }

   public String getPagoclientenrodocumento( )
   {
      return gxTv_SdtPago_Pagoclientenrodocumento ;
   }

   public void setPagoclientenrodocumento( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclientenrodocumento = value ;
   }

   public String getPagoclientedenominacion( )
   {
      return gxTv_SdtPago_Pagoclientedenominacion ;
   }

   public void setPagoclientedenominacion( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclientedenominacion = value ;
   }

   public String getPagoclientedireccion( )
   {
      return gxTv_SdtPago_Pagoclientedireccion ;
   }

   public void setPagoclientedireccion( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclientedireccion = value ;
   }

   public String getPagoclienteemail( )
   {
      return gxTv_SdtPago_Pagoclienteemail ;
   }

   public void setPagoclienteemail( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclienteemail = value ;
   }

   public short getPagotipodocumento( )
   {
      return gxTv_SdtPago_Pagotipodocumento ;
   }

   public void setPagotipodocumento( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagotipodocumento = value ;
   }

   public int getPagonumero( )
   {
      return gxTv_SdtPago_Pagonumero ;
   }

   public void setPagonumero( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagonumero = value ;
   }

   public java.util.Date getPagofechaemision( )
   {
      return gxTv_SdtPago_Pagofechaemision ;
   }

   public void setPagofechaemision( java.util.Date value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagofechaemision = value ;
   }

   public short getPagomoneda( )
   {
      return gxTv_SdtPago_Pagomoneda ;
   }

   public void setPagomoneda( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagomoneda = value ;
   }

   public String getPagonubefactrequest( )
   {
      return gxTv_SdtPago_Pagonubefactrequest ;
   }

   public void setPagonubefactrequest( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagonubefactrequest = value ;
   }

   public String getPagonubefactresponse( )
   {
      return gxTv_SdtPago_Pagonubefactresponse ;
   }

   public void setPagonubefactresponse( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagonubefactresponse = value ;
   }

   public String getPagorequest( )
   {
      return gxTv_SdtPago_Pagorequest ;
   }

   public void setPagorequest( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagorequest = value ;
   }

   public String getPagoresponse( )
   {
      return gxTv_SdtPago_Pagoresponse ;
   }

   public void setPagoresponse( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoresponse = value ;
   }

   public String getPagopasarelaid( )
   {
      return gxTv_SdtPago_Pagopasarelaid ;
   }

   public void setPagopasarelaid( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagopasarelaid = value ;
   }

   public int getPagostatuscode( )
   {
      return gxTv_SdtPago_Pagostatuscode ;
   }

   public void setPagostatuscode( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagostatuscode = value ;
   }

   public int getDisponibilidadid( )
   {
      return gxTv_SdtPago_Disponibilidadid ;
   }

   public void setDisponibilidadid( int value )
   {
      gxTv_SdtPago_Disponibilidadid_N = (byte)(0) ;
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Disponibilidadid = value ;
   }

   public String getPagoenlacepdf( )
   {
      return gxTv_SdtPago_Pagoenlacepdf ;
   }

   public void setPagoenlacepdf( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoenlacepdf = value ;
   }

   public String getPagoenlacexml( )
   {
      return gxTv_SdtPago_Pagoenlacexml ;
   }

   public void setPagoenlacexml( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoenlacexml = value ;
   }

   public String getPagoestador( )
   {
      return gxTv_SdtPago_Pagoestador ;
   }

   public void setPagoestador( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoestador = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPago_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPago_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Initialized = value ;
   }

   public int getPagoid_Z( )
   {
      return gxTv_SdtPago_Pagoid_Z ;
   }

   public void setPagoid_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoid_Z = value ;
   }

   public int getCitaid_Z( )
   {
      return gxTv_SdtPago_Citaid_Z ;
   }

   public void setCitaid_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Citaid_Z = value ;
   }

   public String getCitacode_Z( )
   {
      return gxTv_SdtPago_Citacode_Z ;
   }

   public void setCitacode_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Citacode_Z = value ;
   }

   public java.util.Date getSgcitadisponibilidadfecha_Z( )
   {
      return gxTv_SdtPago_Sgcitadisponibilidadfecha_Z ;
   }

   public void setSgcitadisponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha_Z = value ;
   }

   public java.math.BigDecimal getPagomonto_Z( )
   {
      return gxTv_SdtPago_Pagomonto_Z ;
   }

   public void setPagomonto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagomonto_Z = value ;
   }

   public String getPagotoken_Z( )
   {
      return gxTv_SdtPago_Pagotoken_Z ;
   }

   public void setPagotoken_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagotoken_Z = value ;
   }

   public String getPagotipodocumentocliente_Z( )
   {
      return gxTv_SdtPago_Pagotipodocumentocliente_Z ;
   }

   public void setPagotipodocumentocliente_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagotipodocumentocliente_Z = value ;
   }

   public String getPagoclientenrodocumento_Z( )
   {
      return gxTv_SdtPago_Pagoclientenrodocumento_Z ;
   }

   public void setPagoclientenrodocumento_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclientenrodocumento_Z = value ;
   }

   public String getPagoclientedenominacion_Z( )
   {
      return gxTv_SdtPago_Pagoclientedenominacion_Z ;
   }

   public void setPagoclientedenominacion_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclientedenominacion_Z = value ;
   }

   public String getPagoclientedireccion_Z( )
   {
      return gxTv_SdtPago_Pagoclientedireccion_Z ;
   }

   public void setPagoclientedireccion_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclientedireccion_Z = value ;
   }

   public String getPagoclienteemail_Z( )
   {
      return gxTv_SdtPago_Pagoclienteemail_Z ;
   }

   public void setPagoclienteemail_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoclienteemail_Z = value ;
   }

   public short getPagotipodocumento_Z( )
   {
      return gxTv_SdtPago_Pagotipodocumento_Z ;
   }

   public void setPagotipodocumento_Z( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagotipodocumento_Z = value ;
   }

   public int getPagonumero_Z( )
   {
      return gxTv_SdtPago_Pagonumero_Z ;
   }

   public void setPagonumero_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagonumero_Z = value ;
   }

   public java.util.Date getPagofechaemision_Z( )
   {
      return gxTv_SdtPago_Pagofechaemision_Z ;
   }

   public void setPagofechaemision_Z( java.util.Date value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagofechaemision_Z = value ;
   }

   public short getPagomoneda_Z( )
   {
      return gxTv_SdtPago_Pagomoneda_Z ;
   }

   public void setPagomoneda_Z( short value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagomoneda_Z = value ;
   }

   public String getPagopasarelaid_Z( )
   {
      return gxTv_SdtPago_Pagopasarelaid_Z ;
   }

   public void setPagopasarelaid_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagopasarelaid_Z = value ;
   }

   public int getPagostatuscode_Z( )
   {
      return gxTv_SdtPago_Pagostatuscode_Z ;
   }

   public void setPagostatuscode_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagostatuscode_Z = value ;
   }

   public int getDisponibilidadid_Z( )
   {
      return gxTv_SdtPago_Disponibilidadid_Z ;
   }

   public void setDisponibilidadid_Z( int value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Disponibilidadid_Z = value ;
   }

   public String getPagoenlacepdf_Z( )
   {
      return gxTv_SdtPago_Pagoenlacepdf_Z ;
   }

   public void setPagoenlacepdf_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoenlacepdf_Z = value ;
   }

   public String getPagoenlacexml_Z( )
   {
      return gxTv_SdtPago_Pagoenlacexml_Z ;
   }

   public void setPagoenlacexml_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoenlacexml_Z = value ;
   }

   public String getPagoestador_Z( )
   {
      return gxTv_SdtPago_Pagoestador_Z ;
   }

   public void setPagoestador_Z( String value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Pagoestador_Z = value ;
   }

   public byte getCitaid_N( )
   {
      return gxTv_SdtPago_Citaid_N ;
   }

   public void setCitaid_N( byte value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Citaid_N = value ;
   }

   public byte getSgcitadisponibilidadfecha_N( )
   {
      return gxTv_SdtPago_Sgcitadisponibilidadfecha_N ;
   }

   public void setSgcitadisponibilidadfecha_N( byte value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Sgcitadisponibilidadfecha_N = value ;
   }

   public byte getDisponibilidadid_N( )
   {
      return gxTv_SdtPago_Disponibilidadid_N ;
   }

   public void setDisponibilidadid_N( byte value )
   {
      gxTv_SdtPago_N = (byte)(0) ;
      gxTv_SdtPago_Disponibilidadid_N = value ;
   }

   protected byte gxTv_SdtPago_Citaid_N ;
   protected byte gxTv_SdtPago_Sgcitadisponibilidadfecha_N ;
   protected byte gxTv_SdtPago_Disponibilidadid_N ;
   private byte gxTv_SdtPago_N ;
   protected short gxTv_SdtPago_Pagotipodocumento ;
   protected short gxTv_SdtPago_Pagomoneda ;
   protected short gxTv_SdtPago_Initialized ;
   protected short gxTv_SdtPago_Pagotipodocumento_Z ;
   protected short gxTv_SdtPago_Pagomoneda_Z ;
   protected int gxTv_SdtPago_Pagoid ;
   protected int gxTv_SdtPago_Citaid ;
   protected int gxTv_SdtPago_Pagonumero ;
   protected int gxTv_SdtPago_Pagostatuscode ;
   protected int gxTv_SdtPago_Disponibilidadid ;
   protected int gxTv_SdtPago_Pagoid_Z ;
   protected int gxTv_SdtPago_Citaid_Z ;
   protected int gxTv_SdtPago_Pagonumero_Z ;
   protected int gxTv_SdtPago_Pagostatuscode_Z ;
   protected int gxTv_SdtPago_Disponibilidadid_Z ;
   protected String gxTv_SdtPago_Pagotipodocumentocliente ;
   protected String gxTv_SdtPago_Pagoestador ;
   protected String gxTv_SdtPago_Mode ;
   protected String gxTv_SdtPago_Pagotipodocumentocliente_Z ;
   protected String gxTv_SdtPago_Pagoestador_Z ;
   protected String gxTv_SdtPago_Pagonubefactrequest ;
   protected String gxTv_SdtPago_Pagonubefactresponse ;
   protected String gxTv_SdtPago_Pagorequest ;
   protected String gxTv_SdtPago_Pagoresponse ;
   protected String gxTv_SdtPago_Citacode ;
   protected String gxTv_SdtPago_Pagotoken ;
   protected String gxTv_SdtPago_Pagoclientenrodocumento ;
   protected String gxTv_SdtPago_Pagoclientedenominacion ;
   protected String gxTv_SdtPago_Pagoclientedireccion ;
   protected String gxTv_SdtPago_Pagoclienteemail ;
   protected String gxTv_SdtPago_Pagopasarelaid ;
   protected String gxTv_SdtPago_Pagoenlacepdf ;
   protected String gxTv_SdtPago_Pagoenlacexml ;
   protected String gxTv_SdtPago_Citacode_Z ;
   protected String gxTv_SdtPago_Pagotoken_Z ;
   protected String gxTv_SdtPago_Pagoclientenrodocumento_Z ;
   protected String gxTv_SdtPago_Pagoclientedenominacion_Z ;
   protected String gxTv_SdtPago_Pagoclientedireccion_Z ;
   protected String gxTv_SdtPago_Pagoclienteemail_Z ;
   protected String gxTv_SdtPago_Pagopasarelaid_Z ;
   protected String gxTv_SdtPago_Pagoenlacepdf_Z ;
   protected String gxTv_SdtPago_Pagoenlacexml_Z ;
   protected java.util.Date gxTv_SdtPago_Sgcitadisponibilidadfecha ;
   protected java.math.BigDecimal gxTv_SdtPago_Pagomonto ;
   protected java.util.Date gxTv_SdtPago_Pagofechaemision ;
   protected java.util.Date gxTv_SdtPago_Sgcitadisponibilidadfecha_Z ;
   protected java.math.BigDecimal gxTv_SdtPago_Pagomonto_Z ;
   protected java.util.Date gxTv_SdtPago_Pagofechaemision_Z ;
}

