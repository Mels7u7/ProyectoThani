package com.projectthani ;
import com.genexus.*;

public final  class StructSdtCita implements Cloneable, java.io.Serializable
{
   public StructSdtCita( )
   {
      this( -1, new ModelContext( StructSdtCita.class ));
   }

   public StructSdtCita( int remoteHandle ,
                         ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtCita_Citacode = "" ;
      gxTv_SdtCita_Pacienteapellidopaterno = "" ;
      gxTv_SdtCita_Pacienteapellidomaterno = "" ;
      gxTv_SdtCita_Pacientenombres = "" ;
      gxTv_SdtCita_Pacientenrodocumento = "" ;
      gxTv_SdtCita_Citatipodiagnostico = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha = cal.getTime() ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio = cal.getTime() ;
      gxTv_SdtCita_Sgcitadisponibilidadhorafin = cal.getTime() ;
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprofullname = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprocop = "" ;
      gxTv_SdtCita_Citaestadocita = "" ;
      gxTv_SdtCita_Citainforme = "" ;
      gxTv_SdtCita_Citaantecedentes = "" ;
      gxTv_SdtCita_Citalink = "" ;
      gxTv_SdtCita_Citafechareserva = cal.getTime() ;
      gxTv_SdtCita_Citalog = "" ;
      gxTv_SdtCita_Citaemailgenlink = "" ;
      gxTv_SdtCita_Citaestado = "" ;
      gxTv_SdtCita_Citamotivoconsulta = "" ;
      gxTv_SdtCita_Citaarchivonombre = "" ;
      gxTv_SdtCita_Citaarchivo = "" ;
      gxTv_SdtCita_Citaarchivoextencion = "" ;
      gxTv_SdtCita_Citaestadopago = "" ;
      gxTv_SdtCita_Citapeso = new java.math.BigDecimal(0) ;
      gxTv_SdtCita_Citaestatura = new java.math.BigDecimal(0) ;
      gxTv_SdtCita_Mode = "" ;
      gxTv_SdtCita_Citacode_Z = "" ;
      gxTv_SdtCita_Pacienteapellidopaterno_Z = "" ;
      gxTv_SdtCita_Pacienteapellidomaterno_Z = "" ;
      gxTv_SdtCita_Pacientenombres_Z = "" ;
      gxTv_SdtCita_Pacientenrodocumento_Z = "" ;
      gxTv_SdtCita_Citatipodiagnostico_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha_Z = cal.getTime() ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z = cal.getTime() ;
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z = cal.getTime() ;
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z = "" ;
      gxTv_SdtCita_Sgcitadisponibilidadprocop_Z = "" ;
      gxTv_SdtCita_Citaestadocita_Z = "" ;
      gxTv_SdtCita_Citalink_Z = "" ;
      gxTv_SdtCita_Citafechareserva_Z = cal.getTime() ;
      gxTv_SdtCita_Citalog_Z = "" ;
      gxTv_SdtCita_Citaemailgenlink_Z = "" ;
      gxTv_SdtCita_Citaestado_Z = "" ;
      gxTv_SdtCita_Citaarchivonombre_Z = "" ;
      gxTv_SdtCita_Citaarchivoextencion_Z = "" ;
      gxTv_SdtCita_Citaestadopago_Z = "" ;
      gxTv_SdtCita_Citapeso_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCita_Citaestatura_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtCita_Citatipodiagnostico_N = (byte)(1) ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = (byte)(1) ;
      gxTv_SdtCita_Citaestadocita_N = (byte)(1) ;
      gxTv_SdtCita_Citainforme_N = (byte)(1) ;
      gxTv_SdtCita_Citaantecedentes_N = (byte)(1) ;
      gxTv_SdtCita_Citalink_N = (byte)(1) ;
      gxTv_SdtCita_Citafechareserva_N = (byte)(1) ;
      gxTv_SdtCita_Citalog_N = (byte)(1) ;
      gxTv_SdtCita_Citaemailgenlink_N = (byte)(1) ;
      gxTv_SdtCita_Citaestado_N = (byte)(1) ;
      gxTv_SdtCita_Citamotivoconsulta_N = (byte)(1) ;
      gxTv_SdtCita_Citaarchivonombre_N = (byte)(1) ;
      gxTv_SdtCita_Citaarchivo_N = (byte)(1) ;
      gxTv_SdtCita_Citaarchivoextencion_N = (byte)(1) ;
      gxTv_SdtCita_Citaconsentimiento_N = (byte)(1) ;
      gxTv_SdtCita_Citagestante_N = (byte)(1) ;
      gxTv_SdtCita_Citaestadopago_N = (byte)(1) ;
      gxTv_SdtCita_Citapeso_N = (byte)(1) ;
      gxTv_SdtCita_Citaestatura_N = (byte)(1) ;
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

   public int getCitaid( )
   {
      return gxTv_SdtCita_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaid = value ;
   }

   public String getCitacode( )
   {
      return gxTv_SdtCita_Citacode ;
   }

   public void setCitacode( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citacode = value ;
   }

   public int getPacienteid( )
   {
      return gxTv_SdtCita_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacienteid = value ;
   }

   public String getPacienteapellidopaterno( )
   {
      return gxTv_SdtCita_Pacienteapellidopaterno ;
   }

   public void setPacienteapellidopaterno( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacienteapellidopaterno = value ;
   }

   public String getPacienteapellidomaterno( )
   {
      return gxTv_SdtCita_Pacienteapellidomaterno ;
   }

   public void setPacienteapellidomaterno( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacienteapellidomaterno = value ;
   }

   public String getPacientenombres( )
   {
      return gxTv_SdtCita_Pacientenombres ;
   }

   public void setPacientenombres( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacientenombres = value ;
   }

   public String getPacientenrodocumento( )
   {
      return gxTv_SdtCita_Pacientenrodocumento ;
   }

   public void setPacientenrodocumento( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacientenrodocumento = value ;
   }

   public String getCitatipodiagnostico( )
   {
      return gxTv_SdtCita_Citatipodiagnostico ;
   }

   public void setCitatipodiagnostico( String value )
   {
      gxTv_SdtCita_Citatipodiagnostico_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citatipodiagnostico = value ;
   }

   public int getSgcitadisponibilidadid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadid ;
   }

   public void setSgcitadisponibilidadid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadid = value ;
   }

   public java.util.Date getSgcitadisponibilidadfecha( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadfecha ;
   }

   public void setSgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtCita_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha = value ;
   }

   public java.util.Date getSgcitadisponibilidadhorainicio( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorainicio ;
   }

   public void setSgcitadisponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio = value ;
   }

   public java.util.Date getSgcitadisponibilidadhorafin( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorafin ;
   }

   public void setSgcitadisponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorafin = value ;
   }

   public short getSgcitadisponibilidadespecialidadid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadid ;
   }

   public void setSgcitadisponibilidadespecialidadid( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadid = value ;
   }

   public String getSgcitadisponibilidadespecialidadnombre( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre ;
   }

   public void setSgcitadisponibilidadespecialidadnombre( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre = value ;
   }

   public short getSgcitadisponibilidadsedeid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedeid ;
   }

   public void setSgcitadisponibilidadsedeid( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadsedeid = value ;
   }

   public String getSgcitadisponibilidadsedenombre( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedenombre ;
   }

   public void setSgcitadisponibilidadsedenombre( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre = value ;
   }

   public short getSgcitadisponibilidadclinicaid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicaid ;
   }

   public void setSgcitadisponibilidadclinicaid( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicaid = value ;
   }

   public String getSgcitadisponibilidadclinicanombre( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicanombre ;
   }

   public void setSgcitadisponibilidadclinicanombre( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre = value ;
   }

   public int getSgcitadisponibilidadprofesionalid( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofesionalid ;
   }

   public void setSgcitadisponibilidadprofesionalid( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadprofesionalid = value ;
   }

   public String getSgcitadisponibilidadprofullname( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofullname ;
   }

   public void setSgcitadisponibilidadprofullname( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadprofullname = value ;
   }

   public String getSgcitadisponibilidadprocop( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprocop ;
   }

   public void setSgcitadisponibilidadprocop( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadprocop = value ;
   }

   public String getCitaestadocita( )
   {
      return gxTv_SdtCita_Citaestadocita ;
   }

   public void setCitaestadocita( String value )
   {
      gxTv_SdtCita_Citaestadocita_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestadocita = value ;
   }

   public String getCitainforme( )
   {
      return gxTv_SdtCita_Citainforme ;
   }

   public void setCitainforme( String value )
   {
      gxTv_SdtCita_Citainforme_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citainforme = value ;
   }

   public String getCitaantecedentes( )
   {
      return gxTv_SdtCita_Citaantecedentes ;
   }

   public void setCitaantecedentes( String value )
   {
      gxTv_SdtCita_Citaantecedentes_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaantecedentes = value ;
   }

   public String getCitalink( )
   {
      return gxTv_SdtCita_Citalink ;
   }

   public void setCitalink( String value )
   {
      gxTv_SdtCita_Citalink_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citalink = value ;
   }

   public java.util.Date getCitafechareserva( )
   {
      return gxTv_SdtCita_Citafechareserva ;
   }

   public void setCitafechareserva( java.util.Date value )
   {
      gxTv_SdtCita_Citafechareserva_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citafechareserva = value ;
   }

   public String getCitalog( )
   {
      return gxTv_SdtCita_Citalog ;
   }

   public void setCitalog( String value )
   {
      gxTv_SdtCita_Citalog_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citalog = value ;
   }

   public String getCitaemailgenlink( )
   {
      return gxTv_SdtCita_Citaemailgenlink ;
   }

   public void setCitaemailgenlink( String value )
   {
      gxTv_SdtCita_Citaemailgenlink_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaemailgenlink = value ;
   }

   public String getCitaestado( )
   {
      return gxTv_SdtCita_Citaestado ;
   }

   public void setCitaestado( String value )
   {
      gxTv_SdtCita_Citaestado_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestado = value ;
   }

   public String getCitamotivoconsulta( )
   {
      return gxTv_SdtCita_Citamotivoconsulta ;
   }

   public void setCitamotivoconsulta( String value )
   {
      gxTv_SdtCita_Citamotivoconsulta_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citamotivoconsulta = value ;
   }

   public String getCitaarchivonombre( )
   {
      return gxTv_SdtCita_Citaarchivonombre ;
   }

   public void setCitaarchivonombre( String value )
   {
      gxTv_SdtCita_Citaarchivonombre_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivonombre = value ;
   }

   public String getCitaarchivo( )
   {
      return gxTv_SdtCita_Citaarchivo ;
   }

   public void setCitaarchivo( String value )
   {
      gxTv_SdtCita_Citaarchivo_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivo = value ;
   }

   public String getCitaarchivoextencion( )
   {
      return gxTv_SdtCita_Citaarchivoextencion ;
   }

   public void setCitaarchivoextencion( String value )
   {
      gxTv_SdtCita_Citaarchivoextencion_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivoextencion = value ;
   }

   public boolean getCitaconsentimiento( )
   {
      return gxTv_SdtCita_Citaconsentimiento ;
   }

   public void setCitaconsentimiento( boolean value )
   {
      gxTv_SdtCita_Citaconsentimiento_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaconsentimiento = value ;
   }

   public boolean getCitagestante( )
   {
      return gxTv_SdtCita_Citagestante ;
   }

   public void setCitagestante( boolean value )
   {
      gxTv_SdtCita_Citagestante_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citagestante = value ;
   }

   public String getCitaestadopago( )
   {
      return gxTv_SdtCita_Citaestadopago ;
   }

   public void setCitaestadopago( String value )
   {
      gxTv_SdtCita_Citaestadopago_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestadopago = value ;
   }

   public java.math.BigDecimal getCitapeso( )
   {
      return gxTv_SdtCita_Citapeso ;
   }

   public void setCitapeso( java.math.BigDecimal value )
   {
      gxTv_SdtCita_Citapeso_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citapeso = value ;
   }

   public java.math.BigDecimal getCitaestatura( )
   {
      return gxTv_SdtCita_Citaestatura ;
   }

   public void setCitaestatura( java.math.BigDecimal value )
   {
      gxTv_SdtCita_Citaestatura_N = (byte)(0) ;
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestatura = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCita_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCita_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Initialized = value ;
   }

   public int getCitaid_Z( )
   {
      return gxTv_SdtCita_Citaid_Z ;
   }

   public void setCitaid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaid_Z = value ;
   }

   public String getCitacode_Z( )
   {
      return gxTv_SdtCita_Citacode_Z ;
   }

   public void setCitacode_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citacode_Z = value ;
   }

   public int getPacienteid_Z( )
   {
      return gxTv_SdtCita_Pacienteid_Z ;
   }

   public void setPacienteid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacienteid_Z = value ;
   }

   public String getPacienteapellidopaterno_Z( )
   {
      return gxTv_SdtCita_Pacienteapellidopaterno_Z ;
   }

   public void setPacienteapellidopaterno_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacienteapellidopaterno_Z = value ;
   }

   public String getPacienteapellidomaterno_Z( )
   {
      return gxTv_SdtCita_Pacienteapellidomaterno_Z ;
   }

   public void setPacienteapellidomaterno_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacienteapellidomaterno_Z = value ;
   }

   public String getPacientenombres_Z( )
   {
      return gxTv_SdtCita_Pacientenombres_Z ;
   }

   public void setPacientenombres_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacientenombres_Z = value ;
   }

   public String getPacientenrodocumento_Z( )
   {
      return gxTv_SdtCita_Pacientenrodocumento_Z ;
   }

   public void setPacientenrodocumento_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Pacientenrodocumento_Z = value ;
   }

   public String getCitatipodiagnostico_Z( )
   {
      return gxTv_SdtCita_Citatipodiagnostico_Z ;
   }

   public void setCitatipodiagnostico_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citatipodiagnostico_Z = value ;
   }

   public int getSgcitadisponibilidadid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadid_Z ;
   }

   public void setSgcitadisponibilidadid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadid_Z = value ;
   }

   public java.util.Date getSgcitadisponibilidadfecha_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadfecha_Z ;
   }

   public void setSgcitadisponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha_Z = value ;
   }

   public java.util.Date getSgcitadisponibilidadhorainicio_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z ;
   }

   public void setSgcitadisponibilidadhorainicio_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z = value ;
   }

   public java.util.Date getSgcitadisponibilidadhorafin_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z ;
   }

   public void setSgcitadisponibilidadhorafin_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z = value ;
   }

   public short getSgcitadisponibilidadespecialidadid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z ;
   }

   public void setSgcitadisponibilidadespecialidadid_Z( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z = value ;
   }

   public String getSgcitadisponibilidadespecialidadnombre_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z ;
   }

   public void setSgcitadisponibilidadespecialidadnombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z = value ;
   }

   public short getSgcitadisponibilidadsedeid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z ;
   }

   public void setSgcitadisponibilidadsedeid_Z( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z = value ;
   }

   public String getSgcitadisponibilidadsedenombre_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z ;
   }

   public void setSgcitadisponibilidadsedenombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z = value ;
   }

   public short getSgcitadisponibilidadclinicaid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z ;
   }

   public void setSgcitadisponibilidadclinicaid_Z( short value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z = value ;
   }

   public String getSgcitadisponibilidadclinicanombre_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z ;
   }

   public void setSgcitadisponibilidadclinicanombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z = value ;
   }

   public int getSgcitadisponibilidadprofesionalid_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z ;
   }

   public void setSgcitadisponibilidadprofesionalid_Z( int value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z = value ;
   }

   public String getSgcitadisponibilidadprofullname_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z ;
   }

   public void setSgcitadisponibilidadprofullname_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z = value ;
   }

   public String getSgcitadisponibilidadprocop_Z( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadprocop_Z ;
   }

   public void setSgcitadisponibilidadprocop_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadprocop_Z = value ;
   }

   public String getCitaestadocita_Z( )
   {
      return gxTv_SdtCita_Citaestadocita_Z ;
   }

   public void setCitaestadocita_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestadocita_Z = value ;
   }

   public String getCitalink_Z( )
   {
      return gxTv_SdtCita_Citalink_Z ;
   }

   public void setCitalink_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citalink_Z = value ;
   }

   public java.util.Date getCitafechareserva_Z( )
   {
      return gxTv_SdtCita_Citafechareserva_Z ;
   }

   public void setCitafechareserva_Z( java.util.Date value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citafechareserva_Z = value ;
   }

   public String getCitalog_Z( )
   {
      return gxTv_SdtCita_Citalog_Z ;
   }

   public void setCitalog_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citalog_Z = value ;
   }

   public String getCitaemailgenlink_Z( )
   {
      return gxTv_SdtCita_Citaemailgenlink_Z ;
   }

   public void setCitaemailgenlink_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaemailgenlink_Z = value ;
   }

   public String getCitaestado_Z( )
   {
      return gxTv_SdtCita_Citaestado_Z ;
   }

   public void setCitaestado_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestado_Z = value ;
   }

   public String getCitaarchivonombre_Z( )
   {
      return gxTv_SdtCita_Citaarchivonombre_Z ;
   }

   public void setCitaarchivonombre_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivonombre_Z = value ;
   }

   public String getCitaarchivoextencion_Z( )
   {
      return gxTv_SdtCita_Citaarchivoextencion_Z ;
   }

   public void setCitaarchivoextencion_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivoextencion_Z = value ;
   }

   public boolean getCitaconsentimiento_Z( )
   {
      return gxTv_SdtCita_Citaconsentimiento_Z ;
   }

   public void setCitaconsentimiento_Z( boolean value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaconsentimiento_Z = value ;
   }

   public boolean getCitagestante_Z( )
   {
      return gxTv_SdtCita_Citagestante_Z ;
   }

   public void setCitagestante_Z( boolean value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citagestante_Z = value ;
   }

   public String getCitaestadopago_Z( )
   {
      return gxTv_SdtCita_Citaestadopago_Z ;
   }

   public void setCitaestadopago_Z( String value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestadopago_Z = value ;
   }

   public java.math.BigDecimal getCitapeso_Z( )
   {
      return gxTv_SdtCita_Citapeso_Z ;
   }

   public void setCitapeso_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citapeso_Z = value ;
   }

   public java.math.BigDecimal getCitaestatura_Z( )
   {
      return gxTv_SdtCita_Citaestatura_Z ;
   }

   public void setCitaestatura_Z( java.math.BigDecimal value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestatura_Z = value ;
   }

   public byte getCitaid_N( )
   {
      return gxTv_SdtCita_Citaid_N ;
   }

   public void setCitaid_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaid_N = value ;
   }

   public byte getCitatipodiagnostico_N( )
   {
      return gxTv_SdtCita_Citatipodiagnostico_N ;
   }

   public void setCitatipodiagnostico_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citatipodiagnostico_N = value ;
   }

   public byte getSgcitadisponibilidadfecha_N( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadfecha_N ;
   }

   public void setSgcitadisponibilidadfecha_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadfecha_N = value ;
   }

   public byte getSgcitadisponibilidadhorainicio_N( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N ;
   }

   public void setSgcitadisponibilidadhorainicio_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N = value ;
   }

   public byte getSgcitadisponibilidadhorafin_N( )
   {
      return gxTv_SdtCita_Sgcitadisponibilidadhorafin_N ;
   }

   public void setSgcitadisponibilidadhorafin_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Sgcitadisponibilidadhorafin_N = value ;
   }

   public byte getCitaestadocita_N( )
   {
      return gxTv_SdtCita_Citaestadocita_N ;
   }

   public void setCitaestadocita_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestadocita_N = value ;
   }

   public byte getCitainforme_N( )
   {
      return gxTv_SdtCita_Citainforme_N ;
   }

   public void setCitainforme_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citainforme_N = value ;
   }

   public byte getCitaantecedentes_N( )
   {
      return gxTv_SdtCita_Citaantecedentes_N ;
   }

   public void setCitaantecedentes_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaantecedentes_N = value ;
   }

   public byte getCitalink_N( )
   {
      return gxTv_SdtCita_Citalink_N ;
   }

   public void setCitalink_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citalink_N = value ;
   }

   public byte getCitafechareserva_N( )
   {
      return gxTv_SdtCita_Citafechareserva_N ;
   }

   public void setCitafechareserva_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citafechareserva_N = value ;
   }

   public byte getCitalog_N( )
   {
      return gxTv_SdtCita_Citalog_N ;
   }

   public void setCitalog_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citalog_N = value ;
   }

   public byte getCitaemailgenlink_N( )
   {
      return gxTv_SdtCita_Citaemailgenlink_N ;
   }

   public void setCitaemailgenlink_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaemailgenlink_N = value ;
   }

   public byte getCitaestado_N( )
   {
      return gxTv_SdtCita_Citaestado_N ;
   }

   public void setCitaestado_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestado_N = value ;
   }

   public byte getCitamotivoconsulta_N( )
   {
      return gxTv_SdtCita_Citamotivoconsulta_N ;
   }

   public void setCitamotivoconsulta_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citamotivoconsulta_N = value ;
   }

   public byte getCitaarchivonombre_N( )
   {
      return gxTv_SdtCita_Citaarchivonombre_N ;
   }

   public void setCitaarchivonombre_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivonombre_N = value ;
   }

   public byte getCitaarchivo_N( )
   {
      return gxTv_SdtCita_Citaarchivo_N ;
   }

   public void setCitaarchivo_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivo_N = value ;
   }

   public byte getCitaarchivoextencion_N( )
   {
      return gxTv_SdtCita_Citaarchivoextencion_N ;
   }

   public void setCitaarchivoextencion_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaarchivoextencion_N = value ;
   }

   public byte getCitaconsentimiento_N( )
   {
      return gxTv_SdtCita_Citaconsentimiento_N ;
   }

   public void setCitaconsentimiento_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaconsentimiento_N = value ;
   }

   public byte getCitagestante_N( )
   {
      return gxTv_SdtCita_Citagestante_N ;
   }

   public void setCitagestante_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citagestante_N = value ;
   }

   public byte getCitaestadopago_N( )
   {
      return gxTv_SdtCita_Citaestadopago_N ;
   }

   public void setCitaestadopago_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestadopago_N = value ;
   }

   public byte getCitapeso_N( )
   {
      return gxTv_SdtCita_Citapeso_N ;
   }

   public void setCitapeso_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citapeso_N = value ;
   }

   public byte getCitaestatura_N( )
   {
      return gxTv_SdtCita_Citaestatura_N ;
   }

   public void setCitaestatura_N( byte value )
   {
      gxTv_SdtCita_N = (byte)(0) ;
      gxTv_SdtCita_Citaestatura_N = value ;
   }

   protected byte gxTv_SdtCita_Citaid_N ;
   protected byte gxTv_SdtCita_Citatipodiagnostico_N ;
   protected byte gxTv_SdtCita_Sgcitadisponibilidadfecha_N ;
   protected byte gxTv_SdtCita_Sgcitadisponibilidadhorainicio_N ;
   protected byte gxTv_SdtCita_Sgcitadisponibilidadhorafin_N ;
   protected byte gxTv_SdtCita_Citaestadocita_N ;
   protected byte gxTv_SdtCita_Citainforme_N ;
   protected byte gxTv_SdtCita_Citaantecedentes_N ;
   protected byte gxTv_SdtCita_Citalink_N ;
   protected byte gxTv_SdtCita_Citafechareserva_N ;
   protected byte gxTv_SdtCita_Citalog_N ;
   protected byte gxTv_SdtCita_Citaemailgenlink_N ;
   protected byte gxTv_SdtCita_Citaestado_N ;
   protected byte gxTv_SdtCita_Citamotivoconsulta_N ;
   protected byte gxTv_SdtCita_Citaarchivonombre_N ;
   protected byte gxTv_SdtCita_Citaarchivo_N ;
   protected byte gxTv_SdtCita_Citaarchivoextencion_N ;
   protected byte gxTv_SdtCita_Citaconsentimiento_N ;
   protected byte gxTv_SdtCita_Citagestante_N ;
   protected byte gxTv_SdtCita_Citaestadopago_N ;
   protected byte gxTv_SdtCita_Citapeso_N ;
   protected byte gxTv_SdtCita_Citaestatura_N ;
   private byte gxTv_SdtCita_N ;
   protected short gxTv_SdtCita_Sgcitadisponibilidadespecialidadid ;
   protected short gxTv_SdtCita_Sgcitadisponibilidadsedeid ;
   protected short gxTv_SdtCita_Sgcitadisponibilidadclinicaid ;
   protected short gxTv_SdtCita_Initialized ;
   protected short gxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z ;
   protected short gxTv_SdtCita_Sgcitadisponibilidadsedeid_Z ;
   protected short gxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z ;
   protected int gxTv_SdtCita_Citaid ;
   protected int gxTv_SdtCita_Pacienteid ;
   protected int gxTv_SdtCita_Sgcitadisponibilidadid ;
   protected int gxTv_SdtCita_Sgcitadisponibilidadprofesionalid ;
   protected int gxTv_SdtCita_Citaid_Z ;
   protected int gxTv_SdtCita_Pacienteid_Z ;
   protected int gxTv_SdtCita_Sgcitadisponibilidadid_Z ;
   protected int gxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z ;
   protected String gxTv_SdtCita_Citaestadocita ;
   protected String gxTv_SdtCita_Citaestado ;
   protected String gxTv_SdtCita_Citaestadopago ;
   protected String gxTv_SdtCita_Mode ;
   protected String gxTv_SdtCita_Citaestadocita_Z ;
   protected String gxTv_SdtCita_Citaestado_Z ;
   protected String gxTv_SdtCita_Citaestadopago_Z ;
   protected boolean gxTv_SdtCita_Citaconsentimiento ;
   protected boolean gxTv_SdtCita_Citagestante ;
   protected boolean gxTv_SdtCita_Citaconsentimiento_Z ;
   protected boolean gxTv_SdtCita_Citagestante_Z ;
   protected String gxTv_SdtCita_Citainforme ;
   protected String gxTv_SdtCita_Citaantecedentes ;
   protected String gxTv_SdtCita_Citamotivoconsulta ;
   protected String gxTv_SdtCita_Citaarchivo ;
   protected String gxTv_SdtCita_Citacode ;
   protected String gxTv_SdtCita_Pacienteapellidopaterno ;
   protected String gxTv_SdtCita_Pacienteapellidomaterno ;
   protected String gxTv_SdtCita_Pacientenombres ;
   protected String gxTv_SdtCita_Pacientenrodocumento ;
   protected String gxTv_SdtCita_Citatipodiagnostico ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadsedenombre ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadclinicanombre ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadprofullname ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadprocop ;
   protected String gxTv_SdtCita_Citalink ;
   protected String gxTv_SdtCita_Citalog ;
   protected String gxTv_SdtCita_Citaemailgenlink ;
   protected String gxTv_SdtCita_Citaarchivonombre ;
   protected String gxTv_SdtCita_Citaarchivoextencion ;
   protected String gxTv_SdtCita_Citacode_Z ;
   protected String gxTv_SdtCita_Pacienteapellidopaterno_Z ;
   protected String gxTv_SdtCita_Pacienteapellidomaterno_Z ;
   protected String gxTv_SdtCita_Pacientenombres_Z ;
   protected String gxTv_SdtCita_Pacientenrodocumento_Z ;
   protected String gxTv_SdtCita_Citatipodiagnostico_Z ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadprofullname_Z ;
   protected String gxTv_SdtCita_Sgcitadisponibilidadprocop_Z ;
   protected String gxTv_SdtCita_Citalink_Z ;
   protected String gxTv_SdtCita_Citalog_Z ;
   protected String gxTv_SdtCita_Citaemailgenlink_Z ;
   protected String gxTv_SdtCita_Citaarchivonombre_Z ;
   protected String gxTv_SdtCita_Citaarchivoextencion_Z ;
   protected java.util.Date gxTv_SdtCita_Sgcitadisponibilidadfecha ;
   protected java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorainicio ;
   protected java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorafin ;
   protected java.util.Date gxTv_SdtCita_Citafechareserva ;
   protected java.math.BigDecimal gxTv_SdtCita_Citapeso ;
   protected java.math.BigDecimal gxTv_SdtCita_Citaestatura ;
   protected java.util.Date gxTv_SdtCita_Sgcitadisponibilidadfecha_Z ;
   protected java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z ;
   protected java.util.Date gxTv_SdtCita_Sgcitadisponibilidadhorafin_Z ;
   protected java.util.Date gxTv_SdtCita_Citafechareserva_Z ;
   protected java.math.BigDecimal gxTv_SdtCita_Citapeso_Z ;
   protected java.math.BigDecimal gxTv_SdtCita_Citaestatura_Z ;
}

