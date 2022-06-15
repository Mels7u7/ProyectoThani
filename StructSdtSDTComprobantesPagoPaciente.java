package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTComprobantesPagoPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtSDTComprobantesPagoPaciente( )
   {
      this( -1, new ModelContext( StructSdtSDTComprobantesPagoPaciente.class ));
   }

   public StructSdtSDTComprobantesPagoPaciente( int remoteHandle ,
                                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Citacode = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision = cal.getTime() ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml = "" ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N = (byte)(1) ;
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
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoid ;
   }

   public void setPagoid( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoid = value ;
   }

   public java.math.BigDecimal getPagomonto( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto ;
   }

   public void setPagomonto( java.math.BigDecimal value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto = value ;
   }

   public int getCitaid( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Citaid = value ;
   }

   public String getCitacode( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Citacode ;
   }

   public void setCitacode( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Citacode = value ;
   }

   public String getPagotipodocumentocliente( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente ;
   }

   public void setPagotipodocumentocliente( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente = value ;
   }

   public String getPagoclientenrodocumento( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento ;
   }

   public void setPagoclientenrodocumento( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento = value ;
   }

   public String getPagoclientedenominacion( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion ;
   }

   public void setPagoclientedenominacion( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion = value ;
   }

   public String getPagoclientedireccion( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion ;
   }

   public void setPagoclientedireccion( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion = value ;
   }

   public String getPagoclienteemail( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail ;
   }

   public void setPagoclienteemail( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail = value ;
   }

   public short getPagotipodocumento( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento ;
   }

   public void setPagotipodocumento( short value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento = value ;
   }

   public int getPagonumero( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero ;
   }

   public void setPagonumero( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero = value ;
   }

   public java.util.Date getPagofechaemision( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision ;
   }

   public void setPagofechaemision( java.util.Date value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision = value ;
   }

   public short getPagomoneda( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda ;
   }

   public void setPagomoneda( short value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda = value ;
   }

   public String getPagonubefactrequest( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest ;
   }

   public void setPagonubefactrequest( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest = value ;
   }

   public String getPagonubefactresponse( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse ;
   }

   public void setPagonubefactresponse( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse = value ;
   }

   public String getPagorequest( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest ;
   }

   public void setPagorequest( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest = value ;
   }

   public String getPagoresponse( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse ;
   }

   public void setPagoresponse( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse = value ;
   }

   public int getDisponibilidadid( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid ;
   }

   public void setDisponibilidadid( int value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid = value ;
   }

   public String getPagoestador( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador ;
   }

   public void setPagoestador( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador = value ;
   }

   public String getPagoenlacepdf( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf ;
   }

   public void setPagoenlacepdf( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf = value ;
   }

   public String getPagoenlacexml( )
   {
      return gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml ;
   }

   public void setPagoenlacexml( String value )
   {
      gxTv_SdtSDTComprobantesPagoPaciente_N = (byte)(0) ;
      gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml = value ;
   }

   protected byte gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision_N ;
   protected byte gxTv_SdtSDTComprobantesPagoPaciente_N ;
   protected short gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumento ;
   protected short gxTv_SdtSDTComprobantesPagoPaciente_Pagomoneda ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Pagoid ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Citaid ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Pagonumero ;
   protected int gxTv_SdtSDTComprobantesPagoPaciente_Disponibilidadid ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagotipodocumentocliente ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoestador ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactrequest ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagonubefactresponse ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagorequest ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoresponse ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Citacode ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientenrodocumento ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedenominacion ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclientedireccion ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoclienteemail ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacepdf ;
   protected String gxTv_SdtSDTComprobantesPagoPaciente_Pagoenlacexml ;
   protected java.math.BigDecimal gxTv_SdtSDTComprobantesPagoPaciente_Pagomonto ;
   protected java.util.Date gxTv_SdtSDTComprobantesPagoPaciente_Pagofechaemision ;
}

