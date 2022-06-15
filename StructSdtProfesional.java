package com.projectthani ;
import com.genexus.*;

public final  class StructSdtProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtProfesional( )
   {
      this( -1, new ModelContext( StructSdtProfesional.class ));
   }

   public StructSdtProfesional( int remoteHandle ,
                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtProfesional_Profesionaltipodocumento = "" ;
      gxTv_SdtProfesional_Profesionalnrodocumento = "" ;
      gxTv_SdtProfesional_Profesionalapellidopaterno = "" ;
      gxTv_SdtProfesional_Profesionalapellidomaterno = "" ;
      gxTv_SdtProfesional_Profesionalnombres = "" ;
      gxTv_SdtProfesional_Profesionalnombrecompleto2 = "" ;
      gxTv_SdtProfesional_Profesionalfechanacimiento = cal.getTime() ;
      gxTv_SdtProfesional_Profesionalsexo = "" ;
      gxTv_SdtProfesional_Profesionaldescripcion = "" ;
      gxTv_SdtProfesional_Profesionalcorreo = "" ;
      gxTv_SdtProfesional_Profesionalcop = "" ;
      gxTv_SdtProfesional_Profesionalcolordisponible = "" ;
      gxTv_SdtProfesional_Profesionalcolorcita = "" ;
      gxTv_SdtProfesional_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtProfesional_Profesionaldireccion = "" ;
      gxTv_SdtProfesional_Paisdescripcion = "" ;
      gxTv_SdtProfesional_Ubigeocode = "" ;
      gxTv_SdtProfesional_Ubigeonombre = "" ;
      gxTv_SdtProfesional_Profesionalfoto = "" ;
      gxTv_SdtProfesional_Profesionalfoto_gxi = "" ;
      gxTv_SdtProfesional_Profesionaltwitter = "" ;
      gxTv_SdtProfesional_Profesionalfacebook = "" ;
      gxTv_SdtProfesional_Profesionalinstagram = "" ;
      gxTv_SdtProfesional_Profesionallinkedin = "" ;
      gxTv_SdtProfesional_Profesionaltelefono = "" ;
      gxTv_SdtProfesional_Profesionalfecharegistro = cal.getTime() ;
      gxTv_SdtProfesional_Profesionalestadocuenta = "" ;
      gxTv_SdtProfesional_Profesionalestado = "" ;
      gxTv_SdtProfesional_Mode = "" ;
      gxTv_SdtProfesional_Profesionaltipodocumento_Z = "" ;
      gxTv_SdtProfesional_Profesionalnrodocumento_Z = "" ;
      gxTv_SdtProfesional_Profesionalapellidopaterno_Z = "" ;
      gxTv_SdtProfesional_Profesionalapellidomaterno_Z = "" ;
      gxTv_SdtProfesional_Profesionalnombres_Z = "" ;
      gxTv_SdtProfesional_Profesionalnombrecompleto2_Z = "" ;
      gxTv_SdtProfesional_Profesionalfechanacimiento_Z = cal.getTime() ;
      gxTv_SdtProfesional_Profesionalsexo_Z = "" ;
      gxTv_SdtProfesional_Profesionaldescripcion_Z = "" ;
      gxTv_SdtProfesional_Profesionalcorreo_Z = "" ;
      gxTv_SdtProfesional_Profesionalcop_Z = "" ;
      gxTv_SdtProfesional_Profesionalcolordisponible_Z = "" ;
      gxTv_SdtProfesional_Profesionalcolorcita_Z = "" ;
      gxTv_SdtProfesional_Profesionaldireccion_Z = "" ;
      gxTv_SdtProfesional_Paisdescripcion_Z = "" ;
      gxTv_SdtProfesional_Ubigeocode_Z = "" ;
      gxTv_SdtProfesional_Ubigeonombre_Z = "" ;
      gxTv_SdtProfesional_Profesionaltwitter_Z = "" ;
      gxTv_SdtProfesional_Profesionalfacebook_Z = "" ;
      gxTv_SdtProfesional_Profesionalinstagram_Z = "" ;
      gxTv_SdtProfesional_Profesionallinkedin_Z = "" ;
      gxTv_SdtProfesional_Profesionaltelefono_Z = "" ;
      gxTv_SdtProfesional_Profesionalfecharegistro_Z = cal.getTime() ;
      gxTv_SdtProfesional_Profesionalestadocuenta_Z = "" ;
      gxTv_SdtProfesional_Profesionalestado_Z = "" ;
      gxTv_SdtProfesional_Profesionalfoto_gxi_Z = "" ;
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

   public int getProfesionalid( )
   {
      return gxTv_SdtProfesional_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalid = value ;
   }

   public String getProfesionaltipodocumento( )
   {
      return gxTv_SdtProfesional_Profesionaltipodocumento ;
   }

   public void setProfesionaltipodocumento( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltipodocumento = value ;
   }

   public String getProfesionalnrodocumento( )
   {
      return gxTv_SdtProfesional_Profesionalnrodocumento ;
   }

   public void setProfesionalnrodocumento( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalnrodocumento = value ;
   }

   public String getProfesionalapellidopaterno( )
   {
      return gxTv_SdtProfesional_Profesionalapellidopaterno ;
   }

   public void setProfesionalapellidopaterno( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalapellidopaterno = value ;
   }

   public String getProfesionalapellidomaterno( )
   {
      return gxTv_SdtProfesional_Profesionalapellidomaterno ;
   }

   public void setProfesionalapellidomaterno( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalapellidomaterno = value ;
   }

   public String getProfesionalnombres( )
   {
      return gxTv_SdtProfesional_Profesionalnombres ;
   }

   public void setProfesionalnombres( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalnombres = value ;
   }

   public String getProfesionalnombrecompleto2( )
   {
      return gxTv_SdtProfesional_Profesionalnombrecompleto2 ;
   }

   public void setProfesionalnombrecompleto2( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalnombrecompleto2 = value ;
   }

   public java.util.Date getProfesionalfechanacimiento( )
   {
      return gxTv_SdtProfesional_Profesionalfechanacimiento ;
   }

   public void setProfesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfechanacimiento = value ;
   }

   public String getProfesionalsexo( )
   {
      return gxTv_SdtProfesional_Profesionalsexo ;
   }

   public void setProfesionalsexo( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalsexo = value ;
   }

   public String getProfesionaldescripcion( )
   {
      return gxTv_SdtProfesional_Profesionaldescripcion ;
   }

   public void setProfesionaldescripcion( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaldescripcion = value ;
   }

   public String getProfesionalcorreo( )
   {
      return gxTv_SdtProfesional_Profesionalcorreo ;
   }

   public void setProfesionalcorreo( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcorreo = value ;
   }

   public String getProfesionalcop( )
   {
      return gxTv_SdtProfesional_Profesionalcop ;
   }

   public void setProfesionalcop( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcop = value ;
   }

   public String getProfesionalcolordisponible( )
   {
      return gxTv_SdtProfesional_Profesionalcolordisponible ;
   }

   public void setProfesionalcolordisponible( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcolordisponible = value ;
   }

   public String getProfesionalcolorcita( )
   {
      return gxTv_SdtProfesional_Profesionalcolorcita ;
   }

   public void setProfesionalcolorcita( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcolorcita = value ;
   }

   public byte getProfesionaltiempocita( )
   {
      return gxTv_SdtProfesional_Profesionaltiempocita ;
   }

   public void setProfesionaltiempocita( byte value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltiempocita = value ;
   }

   public String getProfesionaldireccion( )
   {
      return gxTv_SdtProfesional_Profesionaldireccion ;
   }

   public void setProfesionaldireccion( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaldireccion = value ;
   }

   public short getPaisid( )
   {
      return gxTv_SdtProfesional_Paisid ;
   }

   public void setPaisid( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Paisid = value ;
   }

   public String getPaisdescripcion( )
   {
      return gxTv_SdtProfesional_Paisdescripcion ;
   }

   public void setPaisdescripcion( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Paisdescripcion = value ;
   }

   public String getUbigeocode( )
   {
      return gxTv_SdtProfesional_Ubigeocode ;
   }

   public void setUbigeocode( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Ubigeocode = value ;
   }

   public String getUbigeonombre( )
   {
      return gxTv_SdtProfesional_Ubigeonombre ;
   }

   public void setUbigeonombre( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Ubigeonombre = value ;
   }

   public String getProfesionalfoto( )
   {
      return gxTv_SdtProfesional_Profesionalfoto ;
   }

   public void setProfesionalfoto( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfoto = value ;
   }

   public String getProfesionalfoto_gxi( )
   {
      return gxTv_SdtProfesional_Profesionalfoto_gxi ;
   }

   public void setProfesionalfoto_gxi( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfoto_gxi = value ;
   }

   public String getProfesionaltwitter( )
   {
      return gxTv_SdtProfesional_Profesionaltwitter ;
   }

   public void setProfesionaltwitter( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltwitter = value ;
   }

   public String getProfesionalfacebook( )
   {
      return gxTv_SdtProfesional_Profesionalfacebook ;
   }

   public void setProfesionalfacebook( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfacebook = value ;
   }

   public String getProfesionalinstagram( )
   {
      return gxTv_SdtProfesional_Profesionalinstagram ;
   }

   public void setProfesionalinstagram( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalinstagram = value ;
   }

   public String getProfesionallinkedin( )
   {
      return gxTv_SdtProfesional_Profesionallinkedin ;
   }

   public void setProfesionallinkedin( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionallinkedin = value ;
   }

   public String getProfesionaltelefono( )
   {
      return gxTv_SdtProfesional_Profesionaltelefono ;
   }

   public void setProfesionaltelefono( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltelefono = value ;
   }

   public short getSecuserid( )
   {
      return gxTv_SdtProfesional_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Secuserid = value ;
   }

   public java.util.Date getProfesionalfecharegistro( )
   {
      return gxTv_SdtProfesional_Profesionalfecharegistro ;
   }

   public void setProfesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfecharegistro = value ;
   }

   public boolean getProfesionalterminoscondiciones( )
   {
      return gxTv_SdtProfesional_Profesionalterminoscondiciones ;
   }

   public void setProfesionalterminoscondiciones( boolean value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalterminoscondiciones = value ;
   }

   public String getProfesionalestadocuenta( )
   {
      return gxTv_SdtProfesional_Profesionalestadocuenta ;
   }

   public void setProfesionalestadocuenta( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalestadocuenta = value ;
   }

   public String getProfesionalestado( )
   {
      return gxTv_SdtProfesional_Profesionalestado ;
   }

   public void setProfesionalestado( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalestado = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtProfesional_Especialidad> getEspecialidad( )
   {
      return gxTv_SdtProfesional_Especialidad ;
   }

   public void setEspecialidad( java.util.Vector<com.projectthani.StructSdtProfesional_Especialidad> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtProfesional_Educacion> getEducacion( )
   {
      return gxTv_SdtProfesional_Educacion ;
   }

   public void setEducacion( java.util.Vector<com.projectthani.StructSdtProfesional_Educacion> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Educacion = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtProfesional_ExperienciaLaboral> getExperiencialaboral( )
   {
      return gxTv_SdtProfesional_Experiencialaboral ;
   }

   public void setExperiencialaboral( java.util.Vector<com.projectthani.StructSdtProfesional_ExperienciaLaboral> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Experiencialaboral = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtProfesional_Premios> getPremios( )
   {
      return gxTv_SdtProfesional_Premios ;
   }

   public void setPremios( java.util.Vector<com.projectthani.StructSdtProfesional_Premios> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtProfesional_Servicios> getServicios( )
   {
      return gxTv_SdtProfesional_Servicios ;
   }

   public void setServicios( java.util.Vector<com.projectthani.StructSdtProfesional_Servicios> value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Servicios = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProfesional_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProfesional_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Initialized = value ;
   }

   public int getProfesionalid_Z( )
   {
      return gxTv_SdtProfesional_Profesionalid_Z ;
   }

   public void setProfesionalid_Z( int value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalid_Z = value ;
   }

   public String getProfesionaltipodocumento_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltipodocumento_Z ;
   }

   public void setProfesionaltipodocumento_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltipodocumento_Z = value ;
   }

   public String getProfesionalnrodocumento_Z( )
   {
      return gxTv_SdtProfesional_Profesionalnrodocumento_Z ;
   }

   public void setProfesionalnrodocumento_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalnrodocumento_Z = value ;
   }

   public String getProfesionalapellidopaterno_Z( )
   {
      return gxTv_SdtProfesional_Profesionalapellidopaterno_Z ;
   }

   public void setProfesionalapellidopaterno_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalapellidopaterno_Z = value ;
   }

   public String getProfesionalapellidomaterno_Z( )
   {
      return gxTv_SdtProfesional_Profesionalapellidomaterno_Z ;
   }

   public void setProfesionalapellidomaterno_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalapellidomaterno_Z = value ;
   }

   public String getProfesionalnombres_Z( )
   {
      return gxTv_SdtProfesional_Profesionalnombres_Z ;
   }

   public void setProfesionalnombres_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalnombres_Z = value ;
   }

   public String getProfesionalnombrecompleto2_Z( )
   {
      return gxTv_SdtProfesional_Profesionalnombrecompleto2_Z ;
   }

   public void setProfesionalnombrecompleto2_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalnombrecompleto2_Z = value ;
   }

   public java.util.Date getProfesionalfechanacimiento_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfechanacimiento_Z ;
   }

   public void setProfesionalfechanacimiento_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfechanacimiento_Z = value ;
   }

   public String getProfesionalsexo_Z( )
   {
      return gxTv_SdtProfesional_Profesionalsexo_Z ;
   }

   public void setProfesionalsexo_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalsexo_Z = value ;
   }

   public String getProfesionaldescripcion_Z( )
   {
      return gxTv_SdtProfesional_Profesionaldescripcion_Z ;
   }

   public void setProfesionaldescripcion_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaldescripcion_Z = value ;
   }

   public String getProfesionalcorreo_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcorreo_Z ;
   }

   public void setProfesionalcorreo_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcorreo_Z = value ;
   }

   public String getProfesionalcop_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcop_Z ;
   }

   public void setProfesionalcop_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcop_Z = value ;
   }

   public String getProfesionalcolordisponible_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcolordisponible_Z ;
   }

   public void setProfesionalcolordisponible_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcolordisponible_Z = value ;
   }

   public String getProfesionalcolorcita_Z( )
   {
      return gxTv_SdtProfesional_Profesionalcolorcita_Z ;
   }

   public void setProfesionalcolorcita_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalcolorcita_Z = value ;
   }

   public byte getProfesionaltiempocita_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltiempocita_Z ;
   }

   public void setProfesionaltiempocita_Z( byte value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltiempocita_Z = value ;
   }

   public String getProfesionaldireccion_Z( )
   {
      return gxTv_SdtProfesional_Profesionaldireccion_Z ;
   }

   public void setProfesionaldireccion_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaldireccion_Z = value ;
   }

   public short getPaisid_Z( )
   {
      return gxTv_SdtProfesional_Paisid_Z ;
   }

   public void setPaisid_Z( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Paisid_Z = value ;
   }

   public String getPaisdescripcion_Z( )
   {
      return gxTv_SdtProfesional_Paisdescripcion_Z ;
   }

   public void setPaisdescripcion_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Paisdescripcion_Z = value ;
   }

   public String getUbigeocode_Z( )
   {
      return gxTv_SdtProfesional_Ubigeocode_Z ;
   }

   public void setUbigeocode_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Ubigeocode_Z = value ;
   }

   public String getUbigeonombre_Z( )
   {
      return gxTv_SdtProfesional_Ubigeonombre_Z ;
   }

   public void setUbigeonombre_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Ubigeonombre_Z = value ;
   }

   public String getProfesionaltwitter_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltwitter_Z ;
   }

   public void setProfesionaltwitter_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltwitter_Z = value ;
   }

   public String getProfesionalfacebook_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfacebook_Z ;
   }

   public void setProfesionalfacebook_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfacebook_Z = value ;
   }

   public String getProfesionalinstagram_Z( )
   {
      return gxTv_SdtProfesional_Profesionalinstagram_Z ;
   }

   public void setProfesionalinstagram_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalinstagram_Z = value ;
   }

   public String getProfesionallinkedin_Z( )
   {
      return gxTv_SdtProfesional_Profesionallinkedin_Z ;
   }

   public void setProfesionallinkedin_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionallinkedin_Z = value ;
   }

   public String getProfesionaltelefono_Z( )
   {
      return gxTv_SdtProfesional_Profesionaltelefono_Z ;
   }

   public void setProfesionaltelefono_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionaltelefono_Z = value ;
   }

   public short getSecuserid_Z( )
   {
      return gxTv_SdtProfesional_Secuserid_Z ;
   }

   public void setSecuserid_Z( short value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Secuserid_Z = value ;
   }

   public java.util.Date getProfesionalfecharegistro_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfecharegistro_Z ;
   }

   public void setProfesionalfecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfecharegistro_Z = value ;
   }

   public boolean getProfesionalterminoscondiciones_Z( )
   {
      return gxTv_SdtProfesional_Profesionalterminoscondiciones_Z ;
   }

   public void setProfesionalterminoscondiciones_Z( boolean value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalterminoscondiciones_Z = value ;
   }

   public String getProfesionalestadocuenta_Z( )
   {
      return gxTv_SdtProfesional_Profesionalestadocuenta_Z ;
   }

   public void setProfesionalestadocuenta_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalestadocuenta_Z = value ;
   }

   public String getProfesionalestado_Z( )
   {
      return gxTv_SdtProfesional_Profesionalestado_Z ;
   }

   public void setProfesionalestado_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalestado_Z = value ;
   }

   public String getProfesionalfoto_gxi_Z( )
   {
      return gxTv_SdtProfesional_Profesionalfoto_gxi_Z ;
   }

   public void setProfesionalfoto_gxi_Z( String value )
   {
      gxTv_SdtProfesional_N = (byte)(0) ;
      gxTv_SdtProfesional_Profesionalfoto_gxi_Z = value ;
   }

   protected byte gxTv_SdtProfesional_Profesionaltiempocita ;
   protected byte gxTv_SdtProfesional_Profesionaltiempocita_Z ;
   private byte gxTv_SdtProfesional_N ;
   protected short gxTv_SdtProfesional_Paisid ;
   protected short gxTv_SdtProfesional_Secuserid ;
   protected short gxTv_SdtProfesional_Initialized ;
   protected short gxTv_SdtProfesional_Paisid_Z ;
   protected short gxTv_SdtProfesional_Secuserid_Z ;
   protected int gxTv_SdtProfesional_Profesionalid ;
   protected int gxTv_SdtProfesional_Profesionalid_Z ;
   protected String gxTv_SdtProfesional_Profesionaltipodocumento ;
   protected String gxTv_SdtProfesional_Profesionalsexo ;
   protected String gxTv_SdtProfesional_Profesionalcolordisponible ;
   protected String gxTv_SdtProfesional_Profesionalcolorcita ;
   protected String gxTv_SdtProfesional_Ubigeocode ;
   protected String gxTv_SdtProfesional_Profesionaltelefono ;
   protected String gxTv_SdtProfesional_Profesionalestadocuenta ;
   protected String gxTv_SdtProfesional_Profesionalestado ;
   protected String gxTv_SdtProfesional_Mode ;
   protected String gxTv_SdtProfesional_Profesionaltipodocumento_Z ;
   protected String gxTv_SdtProfesional_Profesionalsexo_Z ;
   protected String gxTv_SdtProfesional_Profesionalcolordisponible_Z ;
   protected String gxTv_SdtProfesional_Profesionalcolorcita_Z ;
   protected String gxTv_SdtProfesional_Ubigeocode_Z ;
   protected String gxTv_SdtProfesional_Profesionaltelefono_Z ;
   protected String gxTv_SdtProfesional_Profesionalestadocuenta_Z ;
   protected String gxTv_SdtProfesional_Profesionalestado_Z ;
   protected boolean gxTv_SdtProfesional_Profesionalterminoscondiciones ;
   protected boolean gxTv_SdtProfesional_Profesionalterminoscondiciones_Z ;
   protected String gxTv_SdtProfesional_Profesionalnrodocumento ;
   protected String gxTv_SdtProfesional_Profesionalapellidopaterno ;
   protected String gxTv_SdtProfesional_Profesionalapellidomaterno ;
   protected String gxTv_SdtProfesional_Profesionalnombres ;
   protected String gxTv_SdtProfesional_Profesionalnombrecompleto2 ;
   protected String gxTv_SdtProfesional_Profesionaldescripcion ;
   protected String gxTv_SdtProfesional_Profesionalcorreo ;
   protected String gxTv_SdtProfesional_Profesionalcop ;
   protected String gxTv_SdtProfesional_Profesionaldireccion ;
   protected String gxTv_SdtProfesional_Paisdescripcion ;
   protected String gxTv_SdtProfesional_Ubigeonombre ;
   protected String gxTv_SdtProfesional_Profesionalfoto_gxi ;
   protected String gxTv_SdtProfesional_Profesionaltwitter ;
   protected String gxTv_SdtProfesional_Profesionalfacebook ;
   protected String gxTv_SdtProfesional_Profesionalinstagram ;
   protected String gxTv_SdtProfesional_Profesionallinkedin ;
   protected String gxTv_SdtProfesional_Profesionalnrodocumento_Z ;
   protected String gxTv_SdtProfesional_Profesionalapellidopaterno_Z ;
   protected String gxTv_SdtProfesional_Profesionalapellidomaterno_Z ;
   protected String gxTv_SdtProfesional_Profesionalnombres_Z ;
   protected String gxTv_SdtProfesional_Profesionalnombrecompleto2_Z ;
   protected String gxTv_SdtProfesional_Profesionaldescripcion_Z ;
   protected String gxTv_SdtProfesional_Profesionalcorreo_Z ;
   protected String gxTv_SdtProfesional_Profesionalcop_Z ;
   protected String gxTv_SdtProfesional_Profesionaldireccion_Z ;
   protected String gxTv_SdtProfesional_Paisdescripcion_Z ;
   protected String gxTv_SdtProfesional_Ubigeonombre_Z ;
   protected String gxTv_SdtProfesional_Profesionaltwitter_Z ;
   protected String gxTv_SdtProfesional_Profesionalfacebook_Z ;
   protected String gxTv_SdtProfesional_Profesionalinstagram_Z ;
   protected String gxTv_SdtProfesional_Profesionallinkedin_Z ;
   protected String gxTv_SdtProfesional_Profesionalfoto_gxi_Z ;
   protected String gxTv_SdtProfesional_Profesionalfoto ;
   protected java.util.Date gxTv_SdtProfesional_Profesionalfechanacimiento ;
   protected java.util.Date gxTv_SdtProfesional_Profesionalfecharegistro ;
   protected java.util.Date gxTv_SdtProfesional_Profesionalfechanacimiento_Z ;
   protected java.util.Date gxTv_SdtProfesional_Profesionalfecharegistro_Z ;
   protected java.util.Vector<com.projectthani.StructSdtProfesional_Especialidad> gxTv_SdtProfesional_Especialidad=null ;
   protected java.util.Vector<com.projectthani.StructSdtProfesional_Educacion> gxTv_SdtProfesional_Educacion=null ;
   protected java.util.Vector<com.projectthani.StructSdtProfesional_ExperienciaLaboral> gxTv_SdtProfesional_Experiencialaboral=null ;
   protected java.util.Vector<com.projectthani.StructSdtProfesional_Premios> gxTv_SdtProfesional_Premios=null ;
   protected java.util.Vector<com.projectthani.StructSdtProfesional_Servicios> gxTv_SdtProfesional_Servicios=null ;
}

