package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTCitaData implements Cloneable, java.io.Serializable
{
   public StructSdtSDTCitaData( )
   {
      this( -1, new ModelContext( StructSdtSDTCitaData.class ));
   }

   public StructSdtSDTCitaData( int remoteHandle ,
                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTCitaData_Citacode = "" ;
      gxTv_SdtSDTCitaData_Pacienteapellidopaterno = "" ;
      gxTv_SdtSDTCitaData_Pacienteapellidomaterno = "" ;
      gxTv_SdtSDTCitaData_Pacientenombres = "" ;
      gxTv_SdtSDTCitaData_Pacientenrodocumento = "" ;
      gxTv_SdtSDTCitaData_Diagnosticocodigo = "" ;
      gxTv_SdtSDTCitaData_Diagnosticodescripcion = "" ;
      gxTv_SdtSDTCitaData_Citatipodiagnostico = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha = cal.getTime() ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio = cal.getTime() ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin = cal.getTime() ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop = "" ;
      gxTv_SdtSDTCitaData_Citaestadocita = "" ;
      gxTv_SdtSDTCitaData_Citainforme = "" ;
      gxTv_SdtSDTCitaData_Citaantecedentes = "" ;
      gxTv_SdtSDTCitaData_Citalink = "" ;
      gxTv_SdtSDTCitaData_Citafechareserva = cal.getTime() ;
      gxTv_SdtSDTCitaData_Citalog = "" ;
      gxTv_SdtSDTCitaData_Citaemailgenlink = "" ;
      gxTv_SdtSDTCitaData_Citaestado = "" ;
      gxTv_SdtSDTCitaData_Citamotivoconsulta = "" ;
      gxTv_SdtSDTCitaData_Citaarchivonombre = "" ;
      gxTv_SdtSDTCitaData_Citaarchivo = "" ;
      gxTv_SdtSDTCitaData_Citaestadopago = "" ;
      gxTv_SdtSDTCitaData_Citapeso = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTCitaData_Citaestatura = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTCitaData_Citapesodescripcion = "" ;
      gxTv_SdtSDTCitaData_Citaestaturadescripcion = "" ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N = (byte)(1) ;
      gxTv_SdtSDTCitaData_Citafechareserva_N = (byte)(1) ;
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
      return gxTv_SdtSDTCitaData_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaid = value ;
   }

   public String getCitacode( )
   {
      return gxTv_SdtSDTCitaData_Citacode ;
   }

   public void setCitacode( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citacode = value ;
   }

   public int getPacienteid( )
   {
      return gxTv_SdtSDTCitaData_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacienteid = value ;
   }

   public String getPacienteapellidopaterno( )
   {
      return gxTv_SdtSDTCitaData_Pacienteapellidopaterno ;
   }

   public void setPacienteapellidopaterno( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacienteapellidopaterno = value ;
   }

   public String getPacienteapellidomaterno( )
   {
      return gxTv_SdtSDTCitaData_Pacienteapellidomaterno ;
   }

   public void setPacienteapellidomaterno( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacienteapellidomaterno = value ;
   }

   public String getPacientenombres( )
   {
      return gxTv_SdtSDTCitaData_Pacientenombres ;
   }

   public void setPacientenombres( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacientenombres = value ;
   }

   public String getPacientenrodocumento( )
   {
      return gxTv_SdtSDTCitaData_Pacientenrodocumento ;
   }

   public void setPacientenrodocumento( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Pacientenrodocumento = value ;
   }

   public int getDiagnosticoid( )
   {
      return gxTv_SdtSDTCitaData_Diagnosticoid ;
   }

   public void setDiagnosticoid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Diagnosticoid = value ;
   }

   public String getDiagnosticocodigo( )
   {
      return gxTv_SdtSDTCitaData_Diagnosticocodigo ;
   }

   public void setDiagnosticocodigo( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Diagnosticocodigo = value ;
   }

   public String getDiagnosticodescripcion( )
   {
      return gxTv_SdtSDTCitaData_Diagnosticodescripcion ;
   }

   public void setDiagnosticodescripcion( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Diagnosticodescripcion = value ;
   }

   public String getCitatipodiagnostico( )
   {
      return gxTv_SdtSDTCitaData_Citatipodiagnostico ;
   }

   public void setCitatipodiagnostico( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citatipodiagnostico = value ;
   }

   public int getSgcitadisponibilidadid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadid ;
   }

   public void setSgcitadisponibilidadid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadid = value ;
   }

   public java.util.Date getSgcitadisponibilidadfecha( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha ;
   }

   public void setSgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha = value ;
   }

   public java.util.Date getSgcitadisponibilidadhorainicio( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio ;
   }

   public void setSgcitadisponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio = value ;
   }

   public java.util.Date getSgcitadisponibilidadhorafin( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin ;
   }

   public void setSgcitadisponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin = value ;
   }

   public short getSgcitadisponibilidadespecialidadid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid ;
   }

   public void setSgcitadisponibilidadespecialidadid( short value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid = value ;
   }

   public String getSgcitadisponibilidadespecialidadnombre( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre ;
   }

   public void setSgcitadisponibilidadespecialidadnombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre = value ;
   }

   public short getSgcitadisponibilidadsedeid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid ;
   }

   public void setSgcitadisponibilidadsedeid( short value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid = value ;
   }

   public String getSgcitadisponibilidadsedenombre( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre ;
   }

   public void setSgcitadisponibilidadsedenombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre = value ;
   }

   public short getSgcitadisponibilidadclinicaid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid ;
   }

   public void setSgcitadisponibilidadclinicaid( short value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid = value ;
   }

   public String getSgcitadisponibilidadclinicanombre( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre ;
   }

   public void setSgcitadisponibilidadclinicanombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre = value ;
   }

   public int getSgcitadisponibilidadprofesionalid( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid ;
   }

   public void setSgcitadisponibilidadprofesionalid( int value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid = value ;
   }

   public String getSgcitadisponibilidadprofullname( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname ;
   }

   public void setSgcitadisponibilidadprofullname( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname = value ;
   }

   public String getSgcitadisponibilidadprocop( )
   {
      return gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop ;
   }

   public void setSgcitadisponibilidadprocop( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop = value ;
   }

   public String getCitaestadocita( )
   {
      return gxTv_SdtSDTCitaData_Citaestadocita ;
   }

   public void setCitaestadocita( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestadocita = value ;
   }

   public String getCitainforme( )
   {
      return gxTv_SdtSDTCitaData_Citainforme ;
   }

   public void setCitainforme( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citainforme = value ;
   }

   public String getCitaantecedentes( )
   {
      return gxTv_SdtSDTCitaData_Citaantecedentes ;
   }

   public void setCitaantecedentes( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaantecedentes = value ;
   }

   public String getCitalink( )
   {
      return gxTv_SdtSDTCitaData_Citalink ;
   }

   public void setCitalink( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citalink = value ;
   }

   public java.util.Date getCitafechareserva( )
   {
      return gxTv_SdtSDTCitaData_Citafechareserva ;
   }

   public void setCitafechareserva( java.util.Date value )
   {
      gxTv_SdtSDTCitaData_Citafechareserva_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citafechareserva = value ;
   }

   public String getCitalog( )
   {
      return gxTv_SdtSDTCitaData_Citalog ;
   }

   public void setCitalog( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citalog = value ;
   }

   public String getCitaemailgenlink( )
   {
      return gxTv_SdtSDTCitaData_Citaemailgenlink ;
   }

   public void setCitaemailgenlink( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaemailgenlink = value ;
   }

   public String getCitaestado( )
   {
      return gxTv_SdtSDTCitaData_Citaestado ;
   }

   public void setCitaestado( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestado = value ;
   }

   public String getCitamotivoconsulta( )
   {
      return gxTv_SdtSDTCitaData_Citamotivoconsulta ;
   }

   public void setCitamotivoconsulta( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citamotivoconsulta = value ;
   }

   public String getCitaarchivonombre( )
   {
      return gxTv_SdtSDTCitaData_Citaarchivonombre ;
   }

   public void setCitaarchivonombre( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaarchivonombre = value ;
   }

   public String getCitaarchivo( )
   {
      return gxTv_SdtSDTCitaData_Citaarchivo ;
   }

   public void setCitaarchivo( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaarchivo = value ;
   }

   public boolean getCitaconsentimiento( )
   {
      return gxTv_SdtSDTCitaData_Citaconsentimiento ;
   }

   public void setCitaconsentimiento( boolean value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaconsentimiento = value ;
   }

   public boolean getCitagestante( )
   {
      return gxTv_SdtSDTCitaData_Citagestante ;
   }

   public void setCitagestante( boolean value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citagestante = value ;
   }

   public String getCitaestadopago( )
   {
      return gxTv_SdtSDTCitaData_Citaestadopago ;
   }

   public void setCitaestadopago( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestadopago = value ;
   }

   public java.math.BigDecimal getCitapeso( )
   {
      return gxTv_SdtSDTCitaData_Citapeso ;
   }

   public void setCitapeso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citapeso = value ;
   }

   public java.math.BigDecimal getCitaestatura( )
   {
      return gxTv_SdtSDTCitaData_Citaestatura ;
   }

   public void setCitaestatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestatura = value ;
   }

   public String getCitapesodescripcion( )
   {
      return gxTv_SdtSDTCitaData_Citapesodescripcion ;
   }

   public void setCitapesodescripcion( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citapesodescripcion = value ;
   }

   public String getCitaestaturadescripcion( )
   {
      return gxTv_SdtSDTCitaData_Citaestaturadescripcion ;
   }

   public void setCitaestaturadescripcion( String value )
   {
      gxTv_SdtSDTCitaData_N = (byte)(0) ;
      gxTv_SdtSDTCitaData_Citaestaturadescripcion = value ;
   }

   protected byte gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha_N ;
   protected byte gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio_N ;
   protected byte gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin_N ;
   protected byte gxTv_SdtSDTCitaData_Citafechareserva_N ;
   protected byte gxTv_SdtSDTCitaData_N ;
   protected short gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid ;
   protected short gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid ;
   protected short gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid ;
   protected int gxTv_SdtSDTCitaData_Citaid ;
   protected int gxTv_SdtSDTCitaData_Pacienteid ;
   protected int gxTv_SdtSDTCitaData_Diagnosticoid ;
   protected int gxTv_SdtSDTCitaData_Sgcitadisponibilidadid ;
   protected int gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid ;
   protected String gxTv_SdtSDTCitaData_Citaestadocita ;
   protected String gxTv_SdtSDTCitaData_Citaestado ;
   protected String gxTv_SdtSDTCitaData_Citaestadopago ;
   protected boolean gxTv_SdtSDTCitaData_Citaconsentimiento ;
   protected boolean gxTv_SdtSDTCitaData_Citagestante ;
   protected String gxTv_SdtSDTCitaData_Citainforme ;
   protected String gxTv_SdtSDTCitaData_Citaantecedentes ;
   protected String gxTv_SdtSDTCitaData_Citamotivoconsulta ;
   protected String gxTv_SdtSDTCitaData_Citaarchivo ;
   protected String gxTv_SdtSDTCitaData_Citacode ;
   protected String gxTv_SdtSDTCitaData_Pacienteapellidopaterno ;
   protected String gxTv_SdtSDTCitaData_Pacienteapellidomaterno ;
   protected String gxTv_SdtSDTCitaData_Pacientenombres ;
   protected String gxTv_SdtSDTCitaData_Pacientenrodocumento ;
   protected String gxTv_SdtSDTCitaData_Diagnosticocodigo ;
   protected String gxTv_SdtSDTCitaData_Diagnosticodescripcion ;
   protected String gxTv_SdtSDTCitaData_Citatipodiagnostico ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname ;
   protected String gxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop ;
   protected String gxTv_SdtSDTCitaData_Citalink ;
   protected String gxTv_SdtSDTCitaData_Citalog ;
   protected String gxTv_SdtSDTCitaData_Citaemailgenlink ;
   protected String gxTv_SdtSDTCitaData_Citaarchivonombre ;
   protected String gxTv_SdtSDTCitaData_Citapesodescripcion ;
   protected String gxTv_SdtSDTCitaData_Citaestaturadescripcion ;
   protected java.util.Date gxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha ;
   protected java.util.Date gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio ;
   protected java.util.Date gxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin ;
   protected java.util.Date gxTv_SdtSDTCitaData_Citafechareserva ;
   protected java.math.BigDecimal gxTv_SdtSDTCitaData_Citapeso ;
   protected java.math.BigDecimal gxTv_SdtSDTCitaData_Citaestatura ;
}

