package com.projectthani ;
import com.genexus.*;

public final  class StructSdtEncuesta implements Cloneable, java.io.Serializable
{
   public StructSdtEncuesta( )
   {
      this( -1, new ModelContext( StructSdtEncuesta.class ));
   }

   public StructSdtEncuesta( int remoteHandle ,
                             ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = cal.getTime() ;
      gxTv_SdtEncuesta_Pacienteapellidopaterno = "" ;
      gxTv_SdtEncuesta_Pacienteapellidomaterno = "" ;
      gxTv_SdtEncuesta_Pacientenombres = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre = "" ;
      gxTv_SdtEncuesta_Encuestaatencion = "" ;
      gxTv_SdtEncuesta_Encuestaatendido = "" ;
      gxTv_SdtEncuesta_Encuestahoraatencion = cal.getTime() ;
      gxTv_SdtEncuesta_Encuestacomentarios = "" ;
      gxTv_SdtEncuesta_Encuestaestado = "" ;
      gxTv_SdtEncuesta_Mode = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z = cal.getTime() ;
      gxTv_SdtEncuesta_Pacienteapellidopaterno_Z = "" ;
      gxTv_SdtEncuesta_Pacienteapellidomaterno_Z = "" ;
      gxTv_SdtEncuesta_Pacientenombres_Z = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z = "" ;
      gxTv_SdtEncuesta_Encuestaatencion_Z = "" ;
      gxTv_SdtEncuesta_Encuestaatendido_Z = "" ;
      gxTv_SdtEncuesta_Encuestahoraatencion_Z = cal.getTime() ;
      gxTv_SdtEncuesta_Encuestaestado_Z = "" ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestaatencion_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestaatendido_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestahoraatencion_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestacomentarios_N = (byte)(1) ;
      gxTv_SdtEncuesta_Encuestaestado_N = (byte)(1) ;
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

   public short getEncuestaid( )
   {
      return gxTv_SdtEncuesta_Encuestaid ;
   }

   public void setEncuestaid( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaid = value ;
   }

   public int getCitaid( )
   {
      return gxTv_SdtEncuesta_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Citaid = value ;
   }

   public int getSgcitadisponibilidadprofesionalid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid ;
   }

   public void setSgcitadisponibilidadprofesionalid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid = value ;
   }

   public String getSgcitadisponibilidadprofullname( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname ;
   }

   public void setSgcitadisponibilidadprofullname( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname = value ;
   }

   public short getSgcitadisponibilidadespecialidadid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid ;
   }

   public void setSgcitadisponibilidadespecialidadid( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid = value ;
   }

   public String getSgcitadisponibilidadespecialidadnombre( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre ;
   }

   public void setSgcitadisponibilidadespecialidadnombre( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre = value ;
   }

   public int getSgcitadisponibilidadid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadid ;
   }

   public void setSgcitadisponibilidadid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadid = value ;
   }

   public java.util.Date getSgcitadisponibilidadfecha( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadfecha ;
   }

   public void setSgcitadisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha = value ;
   }

   public int getPacienteid( )
   {
      return gxTv_SdtEncuesta_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacienteid = value ;
   }

   public String getPacienteapellidopaterno( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidopaterno ;
   }

   public void setPacienteapellidopaterno( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacienteapellidopaterno = value ;
   }

   public String getPacienteapellidomaterno( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidomaterno ;
   }

   public void setPacienteapellidomaterno( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacienteapellidomaterno = value ;
   }

   public String getPacientenombres( )
   {
      return gxTv_SdtEncuesta_Pacientenombres ;
   }

   public void setPacientenombres( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacientenombres = value ;
   }

   public short getSgcitadisponibilidadclinicaid( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid ;
   }

   public void setSgcitadisponibilidadclinicaid( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid = value ;
   }

   public String getSgcitadisponibilidadclinicanombre( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre ;
   }

   public void setSgcitadisponibilidadclinicanombre( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre = value ;
   }

   public String getEncuestaatencion( )
   {
      return gxTv_SdtEncuesta_Encuestaatencion ;
   }

   public void setEncuestaatencion( String value )
   {
      gxTv_SdtEncuesta_Encuestaatencion_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaatencion = value ;
   }

   public String getEncuestaatendido( )
   {
      return gxTv_SdtEncuesta_Encuestaatendido ;
   }

   public void setEncuestaatendido( String value )
   {
      gxTv_SdtEncuesta_Encuestaatendido_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaatendido = value ;
   }

   public java.util.Date getEncuestahoraatencion( )
   {
      return gxTv_SdtEncuesta_Encuestahoraatencion ;
   }

   public void setEncuestahoraatencion( java.util.Date value )
   {
      gxTv_SdtEncuesta_Encuestahoraatencion_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestahoraatencion = value ;
   }

   public String getEncuestacomentarios( )
   {
      return gxTv_SdtEncuesta_Encuestacomentarios ;
   }

   public void setEncuestacomentarios( String value )
   {
      gxTv_SdtEncuesta_Encuestacomentarios_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestacomentarios = value ;
   }

   public byte getEncuestarecomendacion( )
   {
      return gxTv_SdtEncuesta_Encuestarecomendacion ;
   }

   public void setEncuestarecomendacion( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestarecomendacion = value ;
   }

   public String getEncuestaestado( )
   {
      return gxTv_SdtEncuesta_Encuestaestado ;
   }

   public void setEncuestaestado( String value )
   {
      gxTv_SdtEncuesta_Encuestaestado_N = (byte)(0) ;
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaestado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEncuesta_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEncuesta_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Initialized = value ;
   }

   public short getEncuestaid_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaid_Z ;
   }

   public void setEncuestaid_Z( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaid_Z = value ;
   }

   public int getCitaid_Z( )
   {
      return gxTv_SdtEncuesta_Citaid_Z ;
   }

   public void setCitaid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Citaid_Z = value ;
   }

   public int getSgcitadisponibilidadprofesionalid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z ;
   }

   public void setSgcitadisponibilidadprofesionalid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z = value ;
   }

   public String getSgcitadisponibilidadprofullname_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z ;
   }

   public void setSgcitadisponibilidadprofullname_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z = value ;
   }

   public short getSgcitadisponibilidadespecialidadid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z ;
   }

   public void setSgcitadisponibilidadespecialidadid_Z( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z = value ;
   }

   public String getSgcitadisponibilidadespecialidadnombre_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z ;
   }

   public void setSgcitadisponibilidadespecialidadnombre_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z = value ;
   }

   public int getSgcitadisponibilidadid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z ;
   }

   public void setSgcitadisponibilidadid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z = value ;
   }

   public java.util.Date getSgcitadisponibilidadfecha_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z ;
   }

   public void setSgcitadisponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z = value ;
   }

   public int getPacienteid_Z( )
   {
      return gxTv_SdtEncuesta_Pacienteid_Z ;
   }

   public void setPacienteid_Z( int value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacienteid_Z = value ;
   }

   public String getPacienteapellidopaterno_Z( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidopaterno_Z ;
   }

   public void setPacienteapellidopaterno_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacienteapellidopaterno_Z = value ;
   }

   public String getPacienteapellidomaterno_Z( )
   {
      return gxTv_SdtEncuesta_Pacienteapellidomaterno_Z ;
   }

   public void setPacienteapellidomaterno_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacienteapellidomaterno_Z = value ;
   }

   public String getPacientenombres_Z( )
   {
      return gxTv_SdtEncuesta_Pacientenombres_Z ;
   }

   public void setPacientenombres_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Pacientenombres_Z = value ;
   }

   public short getSgcitadisponibilidadclinicaid_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z ;
   }

   public void setSgcitadisponibilidadclinicaid_Z( short value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z = value ;
   }

   public String getSgcitadisponibilidadclinicanombre_Z( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z ;
   }

   public void setSgcitadisponibilidadclinicanombre_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z = value ;
   }

   public String getEncuestaatencion_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaatencion_Z ;
   }

   public void setEncuestaatencion_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaatencion_Z = value ;
   }

   public String getEncuestaatendido_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaatendido_Z ;
   }

   public void setEncuestaatendido_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaatendido_Z = value ;
   }

   public java.util.Date getEncuestahoraatencion_Z( )
   {
      return gxTv_SdtEncuesta_Encuestahoraatencion_Z ;
   }

   public void setEncuestahoraatencion_Z( java.util.Date value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestahoraatencion_Z = value ;
   }

   public byte getEncuestarecomendacion_Z( )
   {
      return gxTv_SdtEncuesta_Encuestarecomendacion_Z ;
   }

   public void setEncuestarecomendacion_Z( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestarecomendacion_Z = value ;
   }

   public String getEncuestaestado_Z( )
   {
      return gxTv_SdtEncuesta_Encuestaestado_Z ;
   }

   public void setEncuestaestado_Z( String value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaestado_Z = value ;
   }

   public byte getSgcitadisponibilidadfecha_N( )
   {
      return gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N ;
   }

   public void setSgcitadisponibilidadfecha_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N = value ;
   }

   public byte getEncuestaatencion_N( )
   {
      return gxTv_SdtEncuesta_Encuestaatencion_N ;
   }

   public void setEncuestaatencion_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaatencion_N = value ;
   }

   public byte getEncuestaatendido_N( )
   {
      return gxTv_SdtEncuesta_Encuestaatendido_N ;
   }

   public void setEncuestaatendido_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaatendido_N = value ;
   }

   public byte getEncuestahoraatencion_N( )
   {
      return gxTv_SdtEncuesta_Encuestahoraatencion_N ;
   }

   public void setEncuestahoraatencion_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestahoraatencion_N = value ;
   }

   public byte getEncuestacomentarios_N( )
   {
      return gxTv_SdtEncuesta_Encuestacomentarios_N ;
   }

   public void setEncuestacomentarios_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestacomentarios_N = value ;
   }

   public byte getEncuestaestado_N( )
   {
      return gxTv_SdtEncuesta_Encuestaestado_N ;
   }

   public void setEncuestaestado_N( byte value )
   {
      gxTv_SdtEncuesta_N = (byte)(0) ;
      gxTv_SdtEncuesta_Encuestaestado_N = value ;
   }

   protected byte gxTv_SdtEncuesta_Encuestarecomendacion ;
   protected byte gxTv_SdtEncuesta_Encuestarecomendacion_Z ;
   protected byte gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N ;
   protected byte gxTv_SdtEncuesta_Encuestaatencion_N ;
   protected byte gxTv_SdtEncuesta_Encuestaatendido_N ;
   protected byte gxTv_SdtEncuesta_Encuestahoraatencion_N ;
   protected byte gxTv_SdtEncuesta_Encuestacomentarios_N ;
   protected byte gxTv_SdtEncuesta_Encuestaestado_N ;
   private byte gxTv_SdtEncuesta_N ;
   protected short gxTv_SdtEncuesta_Encuestaid ;
   protected short gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid ;
   protected short gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid ;
   protected short gxTv_SdtEncuesta_Initialized ;
   protected short gxTv_SdtEncuesta_Encuestaid_Z ;
   protected short gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z ;
   protected short gxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z ;
   protected int gxTv_SdtEncuesta_Citaid ;
   protected int gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid ;
   protected int gxTv_SdtEncuesta_Sgcitadisponibilidadid ;
   protected int gxTv_SdtEncuesta_Pacienteid ;
   protected int gxTv_SdtEncuesta_Citaid_Z ;
   protected int gxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z ;
   protected int gxTv_SdtEncuesta_Sgcitadisponibilidadid_Z ;
   protected int gxTv_SdtEncuesta_Pacienteid_Z ;
   protected String gxTv_SdtEncuesta_Encuestaatencion ;
   protected String gxTv_SdtEncuesta_Encuestaatendido ;
   protected String gxTv_SdtEncuesta_Encuestaestado ;
   protected String gxTv_SdtEncuesta_Mode ;
   protected String gxTv_SdtEncuesta_Encuestaatencion_Z ;
   protected String gxTv_SdtEncuesta_Encuestaatendido_Z ;
   protected String gxTv_SdtEncuesta_Encuestaestado_Z ;
   protected String gxTv_SdtEncuesta_Encuestacomentarios ;
   protected String gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname ;
   protected String gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre ;
   protected String gxTv_SdtEncuesta_Pacienteapellidopaterno ;
   protected String gxTv_SdtEncuesta_Pacienteapellidomaterno ;
   protected String gxTv_SdtEncuesta_Pacientenombres ;
   protected String gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre ;
   protected String gxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z ;
   protected String gxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z ;
   protected String gxTv_SdtEncuesta_Pacienteapellidopaterno_Z ;
   protected String gxTv_SdtEncuesta_Pacienteapellidomaterno_Z ;
   protected String gxTv_SdtEncuesta_Pacientenombres_Z ;
   protected String gxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z ;
   protected java.util.Date gxTv_SdtEncuesta_Sgcitadisponibilidadfecha ;
   protected java.util.Date gxTv_SdtEncuesta_Encuestahoraatencion ;
   protected java.util.Date gxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z ;
   protected java.util.Date gxTv_SdtEncuesta_Encuestahoraatencion_Z ;
}

