package com.projectthani ;
import com.genexus.*;

public final  class StructSdtDisponibilidad implements Cloneable, java.io.Serializable
{
   public StructSdtDisponibilidad( )
   {
      this( -1, new ModelContext( StructSdtDisponibilidad.class ));
   }

   public StructSdtDisponibilidad( int remoteHandle ,
                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtDisponibilidad_Eventid = "" ;
      gxTv_SdtDisponibilidad_Disponibilidaddescription = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombres = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto = "" ;
      gxTv_SdtDisponibilidad_Profesionalcop = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha = cal.getTime() ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio = cal.getTime() ;
      gxTv_SdtDisponibilidad_Disponibilidadhorafin = cal.getTime() ;
      gxTv_SdtDisponibilidad_Especialidadcodigo = "" ;
      gxTv_SdtDisponibilidad_Especialidadnombre = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestado = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestadocita = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadtipocita = "" ;
      gxTv_SdtDisponibilidad_Mode = "" ;
      gxTv_SdtDisponibilidad_Eventid_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidaddescription_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombres_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z = "" ;
      gxTv_SdtDisponibilidad_Profesionalcop_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha_Z = cal.getTime() ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z = cal.getTime() ;
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z = cal.getTime() ;
      gxTv_SdtDisponibilidad_Especialidadcodigo_Z = "" ;
      gxTv_SdtDisponibilidad_Especialidadnombre_Z = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z = "" ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestado_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z = "" ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = (byte)(1) ;
      gxTv_SdtDisponibilidad_Dcitaid_N = (byte)(1) ;
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

   public int getDisponibilidadid( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadid ;
   }

   public void setDisponibilidadid( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadid = value ;
   }

   public String getEventid( )
   {
      return gxTv_SdtDisponibilidad_Eventid ;
   }

   public void setEventid( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Eventid = value ;
   }

   public String getDisponibilidaddescription( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaddescription ;
   }

   public void setDisponibilidaddescription( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidaddescription = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtDisponibilidad_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalid = value ;
   }

   public String getProfesionalapellidopaterno( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidopaterno ;
   }

   public void setProfesionalapellidopaterno( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno = value ;
   }

   public String getProfesionalapellidomaterno( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidomaterno ;
   }

   public void setProfesionalapellidomaterno( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno = value ;
   }

   public String getProfesionalnombres( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombres ;
   }

   public void setProfesionalnombres( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalnombres = value ;
   }

   public String getProfesionalnombrecompleto( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombrecompleto ;
   }

   public void setProfesionalnombrecompleto( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto = value ;
   }

   public String getProfesionalcop( )
   {
      return gxTv_SdtDisponibilidad_Profesionalcop ;
   }

   public void setProfesionalcop( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalcop = value ;
   }

   public java.util.Date getDisponibilidadfecha( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadfecha ;
   }

   public void setDisponibilidadfecha( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_Disponibilidadfecha_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha = value ;
   }

   public java.util.Date getDisponibilidadhorainicio( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorainicio ;
   }

   public void setDisponibilidadhorainicio( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio = value ;
   }

   public java.util.Date getDisponibilidadhorafin( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorafin ;
   }

   public void setDisponibilidadhorafin( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorafin = value ;
   }

   public short getEspecialidadid( )
   {
      return gxTv_SdtDisponibilidad_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Especialidadid = value ;
   }

   public String getEspecialidadcodigo( )
   {
      return gxTv_SdtDisponibilidad_Especialidadcodigo ;
   }

   public void setEspecialidadcodigo( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Especialidadcodigo = value ;
   }

   public String getEspecialidadnombre( )
   {
      return gxTv_SdtDisponibilidad_Especialidadnombre ;
   }

   public void setEspecialidadnombre( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Especialidadnombre = value ;
   }

   public short getSgsededisponibilidadsedeid( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid ;
   }

   public void setSgsededisponibilidadsedeid( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid = value ;
   }

   public String getSgsededisponibilidadsedenombre( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre ;
   }

   public void setSgsededisponibilidadsedenombre( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre = value ;
   }

   public short getSgsededisponibilidadclinicaid( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid ;
   }

   public void setSgsededisponibilidadclinicaid( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid = value ;
   }

   public String getSgsededisponibilidadclinicaabreviado( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
   }

   public void setSgsededisponibilidadclinicaabreviado( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado = value ;
   }

   public int getDisponibilidaduser( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaduser ;
   }

   public void setDisponibilidaduser( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidaduser = value ;
   }

   public String getDisponibilidadestado( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestado ;
   }

   public void setDisponibilidadestado( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadestado = value ;
   }

   public String getDisponibilidadestadocita( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestadocita ;
   }

   public void setDisponibilidadestadocita( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadestadocita = value ;
   }

   public int getDcitaid( )
   {
      return gxTv_SdtDisponibilidad_Dcitaid ;
   }

   public void setDcitaid( int value )
   {
      gxTv_SdtDisponibilidad_Dcitaid_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Dcitaid = value ;
   }

   public String getDisponibilidadtipocita( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadtipocita ;
   }

   public void setDisponibilidadtipocita( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadtipocita = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtDisponibilidad_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtDisponibilidad_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Initialized = value ;
   }

   public int getDisponibilidadid_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadid_Z ;
   }

   public void setDisponibilidadid_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadid_Z = value ;
   }

   public String getEventid_Z( )
   {
      return gxTv_SdtDisponibilidad_Eventid_Z ;
   }

   public void setEventid_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Eventid_Z = value ;
   }

   public String getDisponibilidaddescription_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaddescription_Z ;
   }

   public void setDisponibilidaddescription_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidaddescription_Z = value ;
   }

   public int getProfesionalid_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalid_Z ;
   }

   public void setProfesionalid_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalid_Z = value ;
   }

   public String getProfesionalapellidopaterno_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z ;
   }

   public void setProfesionalapellidopaterno_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z = value ;
   }

   public String getProfesionalapellidomaterno_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z ;
   }

   public void setProfesionalapellidomaterno_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z = value ;
   }

   public String getProfesionalnombres_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombres_Z ;
   }

   public void setProfesionalnombres_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalnombres_Z = value ;
   }

   public String getProfesionalnombrecompleto_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z ;
   }

   public void setProfesionalnombrecompleto_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z = value ;
   }

   public String getProfesionalcop_Z( )
   {
      return gxTv_SdtDisponibilidad_Profesionalcop_Z ;
   }

   public void setProfesionalcop_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Profesionalcop_Z = value ;
   }

   public java.util.Date getDisponibilidadfecha_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadfecha_Z ;
   }

   public void setDisponibilidadfecha_Z( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha_Z = value ;
   }

   public java.util.Date getDisponibilidadhorainicio_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z ;
   }

   public void setDisponibilidadhorainicio_Z( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z = value ;
   }

   public java.util.Date getDisponibilidadhorafin_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z ;
   }

   public void setDisponibilidadhorafin_Z( java.util.Date value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z = value ;
   }

   public short getEspecialidadid_Z( )
   {
      return gxTv_SdtDisponibilidad_Especialidadid_Z ;
   }

   public void setEspecialidadid_Z( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Especialidadid_Z = value ;
   }

   public String getEspecialidadcodigo_Z( )
   {
      return gxTv_SdtDisponibilidad_Especialidadcodigo_Z ;
   }

   public void setEspecialidadcodigo_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Especialidadcodigo_Z = value ;
   }

   public String getEspecialidadnombre_Z( )
   {
      return gxTv_SdtDisponibilidad_Especialidadnombre_Z ;
   }

   public void setEspecialidadnombre_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Especialidadnombre_Z = value ;
   }

   public short getSgsededisponibilidadsedeid_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z ;
   }

   public void setSgsededisponibilidadsedeid_Z( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z = value ;
   }

   public String getSgsededisponibilidadsedenombre_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z ;
   }

   public void setSgsededisponibilidadsedenombre_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z = value ;
   }

   public short getSgsededisponibilidadclinicaid_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z ;
   }

   public void setSgsededisponibilidadclinicaid_Z( short value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z = value ;
   }

   public String getSgsededisponibilidadclinicaabreviado_Z( )
   {
      return gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z ;
   }

   public void setSgsededisponibilidadclinicaabreviado_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z = value ;
   }

   public int getDisponibilidaduser_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidaduser_Z ;
   }

   public void setDisponibilidaduser_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidaduser_Z = value ;
   }

   public String getDisponibilidadestado_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestado_Z ;
   }

   public void setDisponibilidadestado_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadestado_Z = value ;
   }

   public String getDisponibilidadestadocita_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z ;
   }

   public void setDisponibilidadestadocita_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z = value ;
   }

   public int getDcitaid_Z( )
   {
      return gxTv_SdtDisponibilidad_Dcitaid_Z ;
   }

   public void setDcitaid_Z( int value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Dcitaid_Z = value ;
   }

   public String getDisponibilidadtipocita_Z( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z ;
   }

   public void setDisponibilidadtipocita_Z( String value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z = value ;
   }

   public byte getDisponibilidadid_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadid_N ;
   }

   public void setDisponibilidadid_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadid_N = value ;
   }

   public byte getDisponibilidadfecha_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadfecha_N ;
   }

   public void setDisponibilidadfecha_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadfecha_N = value ;
   }

   public byte getDisponibilidadhorainicio_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N ;
   }

   public void setDisponibilidadhorainicio_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N = value ;
   }

   public byte getDisponibilidadhorafin_N( )
   {
      return gxTv_SdtDisponibilidad_Disponibilidadhorafin_N ;
   }

   public void setDisponibilidadhorafin_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Disponibilidadhorafin_N = value ;
   }

   public byte getDcitaid_N( )
   {
      return gxTv_SdtDisponibilidad_Dcitaid_N ;
   }

   public void setDcitaid_N( byte value )
   {
      gxTv_SdtDisponibilidad_N = (byte)(0) ;
      gxTv_SdtDisponibilidad_Dcitaid_N = value ;
   }

   protected byte gxTv_SdtDisponibilidad_Disponibilidadid_N ;
   protected byte gxTv_SdtDisponibilidad_Disponibilidadfecha_N ;
   protected byte gxTv_SdtDisponibilidad_Disponibilidadhorainicio_N ;
   protected byte gxTv_SdtDisponibilidad_Disponibilidadhorafin_N ;
   protected byte gxTv_SdtDisponibilidad_Dcitaid_N ;
   private byte gxTv_SdtDisponibilidad_N ;
   protected short gxTv_SdtDisponibilidad_Especialidadid ;
   protected short gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid ;
   protected short gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid ;
   protected short gxTv_SdtDisponibilidad_Initialized ;
   protected short gxTv_SdtDisponibilidad_Especialidadid_Z ;
   protected short gxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z ;
   protected short gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z ;
   protected int gxTv_SdtDisponibilidad_Disponibilidadid ;
   protected int gxTv_SdtDisponibilidad_Profesionalid ;
   protected int gxTv_SdtDisponibilidad_Disponibilidaduser ;
   protected int gxTv_SdtDisponibilidad_Dcitaid ;
   protected int gxTv_SdtDisponibilidad_Disponibilidadid_Z ;
   protected int gxTv_SdtDisponibilidad_Profesionalid_Z ;
   protected int gxTv_SdtDisponibilidad_Disponibilidaduser_Z ;
   protected int gxTv_SdtDisponibilidad_Dcitaid_Z ;
   protected String gxTv_SdtDisponibilidad_Eventid ;
   protected String gxTv_SdtDisponibilidad_Disponibilidadestado ;
   protected String gxTv_SdtDisponibilidad_Disponibilidadtipocita ;
   protected String gxTv_SdtDisponibilidad_Mode ;
   protected String gxTv_SdtDisponibilidad_Eventid_Z ;
   protected String gxTv_SdtDisponibilidad_Disponibilidadestado_Z ;
   protected String gxTv_SdtDisponibilidad_Disponibilidadtipocita_Z ;
   protected String gxTv_SdtDisponibilidad_Disponibilidaddescription ;
   protected String gxTv_SdtDisponibilidad_Profesionalapellidopaterno ;
   protected String gxTv_SdtDisponibilidad_Profesionalapellidomaterno ;
   protected String gxTv_SdtDisponibilidad_Profesionalnombres ;
   protected String gxTv_SdtDisponibilidad_Profesionalnombrecompleto ;
   protected String gxTv_SdtDisponibilidad_Profesionalcop ;
   protected String gxTv_SdtDisponibilidad_Especialidadcodigo ;
   protected String gxTv_SdtDisponibilidad_Especialidadnombre ;
   protected String gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre ;
   protected String gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado ;
   protected String gxTv_SdtDisponibilidad_Disponibilidadestadocita ;
   protected String gxTv_SdtDisponibilidad_Disponibilidaddescription_Z ;
   protected String gxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z ;
   protected String gxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z ;
   protected String gxTv_SdtDisponibilidad_Profesionalnombres_Z ;
   protected String gxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z ;
   protected String gxTv_SdtDisponibilidad_Profesionalcop_Z ;
   protected String gxTv_SdtDisponibilidad_Especialidadcodigo_Z ;
   protected String gxTv_SdtDisponibilidad_Especialidadnombre_Z ;
   protected String gxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z ;
   protected String gxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z ;
   protected String gxTv_SdtDisponibilidad_Disponibilidadestadocita_Z ;
   protected java.util.Date gxTv_SdtDisponibilidad_Disponibilidadfecha ;
   protected java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorainicio ;
   protected java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorafin ;
   protected java.util.Date gxTv_SdtDisponibilidad_Disponibilidadfecha_Z ;
   protected java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z ;
   protected java.util.Date gxTv_SdtDisponibilidad_Disponibilidadhorafin_Z ;
}

