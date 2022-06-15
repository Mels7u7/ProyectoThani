package com.projectthani ;
import com.genexus.*;

public final  class StructSdtPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtPaciente( )
   {
      this( -1, new ModelContext( StructSdtPaciente.class ));
   }

   public StructSdtPaciente( int remoteHandle ,
                             ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtPaciente_Pacienteapellidopaterno = "" ;
      gxTv_SdtPaciente_Pacienteapellidomaterno = "" ;
      gxTv_SdtPaciente_Pacientenombres = "" ;
      gxTv_SdtPaciente_Pacientenombrecompleto = "" ;
      gxTv_SdtPaciente_Pacientefechanacimiento = cal.getTime() ;
      gxTv_SdtPaciente_Pacientetipodocumento = "" ;
      gxTv_SdtPaciente_Pacientenrodocumento = "" ;
      gxTv_SdtPaciente_Pacientedireccion = "" ;
      gxTv_SdtPaciente_Pacientesexo = "" ;
      gxTv_SdtPaciente_Pacientecorreo = "" ;
      gxTv_SdtPaciente_Pacientetelefono = "" ;
      gxTv_SdtPaciente_Paisdescripcion = "" ;
      gxTv_SdtPaciente_Pacienteestado = "" ;
      gxTv_SdtPaciente_Ubigeocode = "" ;
      gxTv_SdtPaciente_Ubigeonombre = "" ;
      gxTv_SdtPaciente_Pacienteestatura = new java.math.BigDecimal(0) ;
      gxTv_SdtPaciente_Pacientepeso = new java.math.BigDecimal(0) ;
      gxTv_SdtPaciente_Pacientenombreanexo = "" ;
      gxTv_SdtPaciente_Pacienteanexos = "" ;
      gxTv_SdtPaciente_Pacienteenterarse = "" ;
      gxTv_SdtPaciente_Pacienteespecifique = "" ;
      gxTv_SdtPaciente_Pacientefecharegistro = GXutil.now( ) ;
      gxTv_SdtPaciente_Mode = "" ;
      gxTv_SdtPaciente_Pacienteapellidopaterno_Z = "" ;
      gxTv_SdtPaciente_Pacienteapellidomaterno_Z = "" ;
      gxTv_SdtPaciente_Pacientenombres_Z = "" ;
      gxTv_SdtPaciente_Pacientenombrecompleto_Z = "" ;
      gxTv_SdtPaciente_Pacientefechanacimiento_Z = cal.getTime() ;
      gxTv_SdtPaciente_Pacientetipodocumento_Z = "" ;
      gxTv_SdtPaciente_Pacientenrodocumento_Z = "" ;
      gxTv_SdtPaciente_Pacientedireccion_Z = "" ;
      gxTv_SdtPaciente_Pacientesexo_Z = "" ;
      gxTv_SdtPaciente_Pacientecorreo_Z = "" ;
      gxTv_SdtPaciente_Pacientetelefono_Z = "" ;
      gxTv_SdtPaciente_Paisdescripcion_Z = "" ;
      gxTv_SdtPaciente_Pacienteestado_Z = "" ;
      gxTv_SdtPaciente_Ubigeocode_Z = "" ;
      gxTv_SdtPaciente_Ubigeonombre_Z = "" ;
      gxTv_SdtPaciente_Pacienteestatura_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPaciente_Pacientepeso_Z = new java.math.BigDecimal(0) ;
      gxTv_SdtPaciente_Pacientenombreanexo_Z = "" ;
      gxTv_SdtPaciente_Pacienteenterarse_Z = "" ;
      gxTv_SdtPaciente_Pacientefecharegistro_Z = cal.getTime() ;
      gxTv_SdtPaciente_Secuserid_N = (byte)(1) ;
      gxTv_SdtPaciente_Ubigeocode_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacientenombreanexo_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacienteanexos_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacienteenterarse_N = (byte)(1) ;
      gxTv_SdtPaciente_Pacienteespecifique_N = (byte)(1) ;
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

   public int getPacienteid( )
   {
      return gxTv_SdtPaciente_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteid = value ;
   }

   public String getPacienteapellidopaterno( )
   {
      return gxTv_SdtPaciente_Pacienteapellidopaterno ;
   }

   public void setPacienteapellidopaterno( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteapellidopaterno = value ;
   }

   public String getPacienteapellidomaterno( )
   {
      return gxTv_SdtPaciente_Pacienteapellidomaterno ;
   }

   public void setPacienteapellidomaterno( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteapellidomaterno = value ;
   }

   public String getPacientenombres( )
   {
      return gxTv_SdtPaciente_Pacientenombres ;
   }

   public void setPacientenombres( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenombres = value ;
   }

   public String getPacientenombrecompleto( )
   {
      return gxTv_SdtPaciente_Pacientenombrecompleto ;
   }

   public void setPacientenombrecompleto( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenombrecompleto = value ;
   }

   public java.util.Date getPacientefechanacimiento( )
   {
      return gxTv_SdtPaciente_Pacientefechanacimiento ;
   }

   public void setPacientefechanacimiento( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientefechanacimiento = value ;
   }

   public String getPacientetipodocumento( )
   {
      return gxTv_SdtPaciente_Pacientetipodocumento ;
   }

   public void setPacientetipodocumento( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientetipodocumento = value ;
   }

   public String getPacientenrodocumento( )
   {
      return gxTv_SdtPaciente_Pacientenrodocumento ;
   }

   public void setPacientenrodocumento( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenrodocumento = value ;
   }

   public String getPacientedireccion( )
   {
      return gxTv_SdtPaciente_Pacientedireccion ;
   }

   public void setPacientedireccion( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientedireccion = value ;
   }

   public String getPacientesexo( )
   {
      return gxTv_SdtPaciente_Pacientesexo ;
   }

   public void setPacientesexo( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientesexo = value ;
   }

   public String getPacientecorreo( )
   {
      return gxTv_SdtPaciente_Pacientecorreo ;
   }

   public void setPacientecorreo( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientecorreo = value ;
   }

   public String getPacientetelefono( )
   {
      return gxTv_SdtPaciente_Pacientetelefono ;
   }

   public void setPacientetelefono( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientetelefono = value ;
   }

   public short getPaisid( )
   {
      return gxTv_SdtPaciente_Paisid ;
   }

   public void setPaisid( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Paisid = value ;
   }

   public String getPaisdescripcion( )
   {
      return gxTv_SdtPaciente_Paisdescripcion ;
   }

   public void setPaisdescripcion( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Paisdescripcion = value ;
   }

   public String getPacienteestado( )
   {
      return gxTv_SdtPaciente_Pacienteestado ;
   }

   public void setPacienteestado( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteestado = value ;
   }

   public short getSecuserid( )
   {
      return gxTv_SdtPaciente_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtPaciente_Secuserid_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Secuserid = value ;
   }

   public String getUbigeocode( )
   {
      return gxTv_SdtPaciente_Ubigeocode ;
   }

   public void setUbigeocode( String value )
   {
      gxTv_SdtPaciente_Ubigeocode_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Ubigeocode = value ;
   }

   public String getUbigeonombre( )
   {
      return gxTv_SdtPaciente_Ubigeonombre ;
   }

   public void setUbigeonombre( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Ubigeonombre = value ;
   }

   public java.math.BigDecimal getPacienteestatura( )
   {
      return gxTv_SdtPaciente_Pacienteestatura ;
   }

   public void setPacienteestatura( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteestatura = value ;
   }

   public java.math.BigDecimal getPacientepeso( )
   {
      return gxTv_SdtPaciente_Pacientepeso ;
   }

   public void setPacientepeso( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientepeso = value ;
   }

   public String getPacientenombreanexo( )
   {
      return gxTv_SdtPaciente_Pacientenombreanexo ;
   }

   public void setPacientenombreanexo( String value )
   {
      gxTv_SdtPaciente_Pacientenombreanexo_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenombreanexo = value ;
   }

   public String getPacienteanexos( )
   {
      return gxTv_SdtPaciente_Pacienteanexos ;
   }

   public void setPacienteanexos( String value )
   {
      gxTv_SdtPaciente_Pacienteanexos_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteanexos = value ;
   }

   public String getPacienteenterarse( )
   {
      return gxTv_SdtPaciente_Pacienteenterarse ;
   }

   public void setPacienteenterarse( String value )
   {
      gxTv_SdtPaciente_Pacienteenterarse_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteenterarse = value ;
   }

   public String getPacienteespecifique( )
   {
      return gxTv_SdtPaciente_Pacienteespecifique ;
   }

   public void setPacienteespecifique( String value )
   {
      gxTv_SdtPaciente_Pacienteespecifique_N = (byte)(0) ;
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteespecifique = value ;
   }

   public java.util.Date getPacientefecharegistro( )
   {
      return gxTv_SdtPaciente_Pacientefecharegistro ;
   }

   public void setPacientefecharegistro( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientefecharegistro = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtPaciente_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtPaciente_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Initialized = value ;
   }

   public int getPacienteid_Z( )
   {
      return gxTv_SdtPaciente_Pacienteid_Z ;
   }

   public void setPacienteid_Z( int value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteid_Z = value ;
   }

   public String getPacienteapellidopaterno_Z( )
   {
      return gxTv_SdtPaciente_Pacienteapellidopaterno_Z ;
   }

   public void setPacienteapellidopaterno_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteapellidopaterno_Z = value ;
   }

   public String getPacienteapellidomaterno_Z( )
   {
      return gxTv_SdtPaciente_Pacienteapellidomaterno_Z ;
   }

   public void setPacienteapellidomaterno_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteapellidomaterno_Z = value ;
   }

   public String getPacientenombres_Z( )
   {
      return gxTv_SdtPaciente_Pacientenombres_Z ;
   }

   public void setPacientenombres_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenombres_Z = value ;
   }

   public String getPacientenombrecompleto_Z( )
   {
      return gxTv_SdtPaciente_Pacientenombrecompleto_Z ;
   }

   public void setPacientenombrecompleto_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenombrecompleto_Z = value ;
   }

   public java.util.Date getPacientefechanacimiento_Z( )
   {
      return gxTv_SdtPaciente_Pacientefechanacimiento_Z ;
   }

   public void setPacientefechanacimiento_Z( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientefechanacimiento_Z = value ;
   }

   public String getPacientetipodocumento_Z( )
   {
      return gxTv_SdtPaciente_Pacientetipodocumento_Z ;
   }

   public void setPacientetipodocumento_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientetipodocumento_Z = value ;
   }

   public String getPacientenrodocumento_Z( )
   {
      return gxTv_SdtPaciente_Pacientenrodocumento_Z ;
   }

   public void setPacientenrodocumento_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenrodocumento_Z = value ;
   }

   public String getPacientedireccion_Z( )
   {
      return gxTv_SdtPaciente_Pacientedireccion_Z ;
   }

   public void setPacientedireccion_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientedireccion_Z = value ;
   }

   public String getPacientesexo_Z( )
   {
      return gxTv_SdtPaciente_Pacientesexo_Z ;
   }

   public void setPacientesexo_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientesexo_Z = value ;
   }

   public String getPacientecorreo_Z( )
   {
      return gxTv_SdtPaciente_Pacientecorreo_Z ;
   }

   public void setPacientecorreo_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientecorreo_Z = value ;
   }

   public String getPacientetelefono_Z( )
   {
      return gxTv_SdtPaciente_Pacientetelefono_Z ;
   }

   public void setPacientetelefono_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientetelefono_Z = value ;
   }

   public short getPaisid_Z( )
   {
      return gxTv_SdtPaciente_Paisid_Z ;
   }

   public void setPaisid_Z( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Paisid_Z = value ;
   }

   public String getPaisdescripcion_Z( )
   {
      return gxTv_SdtPaciente_Paisdescripcion_Z ;
   }

   public void setPaisdescripcion_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Paisdescripcion_Z = value ;
   }

   public String getPacienteestado_Z( )
   {
      return gxTv_SdtPaciente_Pacienteestado_Z ;
   }

   public void setPacienteestado_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteestado_Z = value ;
   }

   public short getSecuserid_Z( )
   {
      return gxTv_SdtPaciente_Secuserid_Z ;
   }

   public void setSecuserid_Z( short value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Secuserid_Z = value ;
   }

   public String getUbigeocode_Z( )
   {
      return gxTv_SdtPaciente_Ubigeocode_Z ;
   }

   public void setUbigeocode_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Ubigeocode_Z = value ;
   }

   public String getUbigeonombre_Z( )
   {
      return gxTv_SdtPaciente_Ubigeonombre_Z ;
   }

   public void setUbigeonombre_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Ubigeonombre_Z = value ;
   }

   public java.math.BigDecimal getPacienteestatura_Z( )
   {
      return gxTv_SdtPaciente_Pacienteestatura_Z ;
   }

   public void setPacienteestatura_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteestatura_Z = value ;
   }

   public java.math.BigDecimal getPacientepeso_Z( )
   {
      return gxTv_SdtPaciente_Pacientepeso_Z ;
   }

   public void setPacientepeso_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientepeso_Z = value ;
   }

   public String getPacientenombreanexo_Z( )
   {
      return gxTv_SdtPaciente_Pacientenombreanexo_Z ;
   }

   public void setPacientenombreanexo_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenombreanexo_Z = value ;
   }

   public String getPacienteenterarse_Z( )
   {
      return gxTv_SdtPaciente_Pacienteenterarse_Z ;
   }

   public void setPacienteenterarse_Z( String value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteenterarse_Z = value ;
   }

   public java.util.Date getPacientefecharegistro_Z( )
   {
      return gxTv_SdtPaciente_Pacientefecharegistro_Z ;
   }

   public void setPacientefecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientefecharegistro_Z = value ;
   }

   public byte getSecuserid_N( )
   {
      return gxTv_SdtPaciente_Secuserid_N ;
   }

   public void setSecuserid_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Secuserid_N = value ;
   }

   public byte getUbigeocode_N( )
   {
      return gxTv_SdtPaciente_Ubigeocode_N ;
   }

   public void setUbigeocode_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Ubigeocode_N = value ;
   }

   public byte getPacientenombreanexo_N( )
   {
      return gxTv_SdtPaciente_Pacientenombreanexo_N ;
   }

   public void setPacientenombreanexo_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacientenombreanexo_N = value ;
   }

   public byte getPacienteanexos_N( )
   {
      return gxTv_SdtPaciente_Pacienteanexos_N ;
   }

   public void setPacienteanexos_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteanexos_N = value ;
   }

   public byte getPacienteenterarse_N( )
   {
      return gxTv_SdtPaciente_Pacienteenterarse_N ;
   }

   public void setPacienteenterarse_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteenterarse_N = value ;
   }

   public byte getPacienteespecifique_N( )
   {
      return gxTv_SdtPaciente_Pacienteespecifique_N ;
   }

   public void setPacienteespecifique_N( byte value )
   {
      gxTv_SdtPaciente_N = (byte)(0) ;
      gxTv_SdtPaciente_Pacienteespecifique_N = value ;
   }

   protected byte gxTv_SdtPaciente_Secuserid_N ;
   protected byte gxTv_SdtPaciente_Ubigeocode_N ;
   protected byte gxTv_SdtPaciente_Pacientenombreanexo_N ;
   protected byte gxTv_SdtPaciente_Pacienteanexos_N ;
   protected byte gxTv_SdtPaciente_Pacienteenterarse_N ;
   protected byte gxTv_SdtPaciente_Pacienteespecifique_N ;
   private byte gxTv_SdtPaciente_N ;
   protected short gxTv_SdtPaciente_Paisid ;
   protected short gxTv_SdtPaciente_Secuserid ;
   protected short gxTv_SdtPaciente_Initialized ;
   protected short gxTv_SdtPaciente_Paisid_Z ;
   protected short gxTv_SdtPaciente_Secuserid_Z ;
   protected int gxTv_SdtPaciente_Pacienteid ;
   protected int gxTv_SdtPaciente_Pacienteid_Z ;
   protected String gxTv_SdtPaciente_Pacientetipodocumento ;
   protected String gxTv_SdtPaciente_Pacientesexo ;
   protected String gxTv_SdtPaciente_Pacientetelefono ;
   protected String gxTv_SdtPaciente_Pacienteestado ;
   protected String gxTv_SdtPaciente_Ubigeocode ;
   protected String gxTv_SdtPaciente_Mode ;
   protected String gxTv_SdtPaciente_Pacientetipodocumento_Z ;
   protected String gxTv_SdtPaciente_Pacientesexo_Z ;
   protected String gxTv_SdtPaciente_Pacientetelefono_Z ;
   protected String gxTv_SdtPaciente_Pacienteestado_Z ;
   protected String gxTv_SdtPaciente_Ubigeocode_Z ;
   protected String gxTv_SdtPaciente_Pacienteespecifique ;
   protected String gxTv_SdtPaciente_Pacienteanexos ;
   protected String gxTv_SdtPaciente_Pacienteapellidopaterno ;
   protected String gxTv_SdtPaciente_Pacienteapellidomaterno ;
   protected String gxTv_SdtPaciente_Pacientenombres ;
   protected String gxTv_SdtPaciente_Pacientenombrecompleto ;
   protected String gxTv_SdtPaciente_Pacientenrodocumento ;
   protected String gxTv_SdtPaciente_Pacientedireccion ;
   protected String gxTv_SdtPaciente_Pacientecorreo ;
   protected String gxTv_SdtPaciente_Paisdescripcion ;
   protected String gxTv_SdtPaciente_Ubigeonombre ;
   protected String gxTv_SdtPaciente_Pacientenombreanexo ;
   protected String gxTv_SdtPaciente_Pacienteenterarse ;
   protected String gxTv_SdtPaciente_Pacienteapellidopaterno_Z ;
   protected String gxTv_SdtPaciente_Pacienteapellidomaterno_Z ;
   protected String gxTv_SdtPaciente_Pacientenombres_Z ;
   protected String gxTv_SdtPaciente_Pacientenombrecompleto_Z ;
   protected String gxTv_SdtPaciente_Pacientenrodocumento_Z ;
   protected String gxTv_SdtPaciente_Pacientedireccion_Z ;
   protected String gxTv_SdtPaciente_Pacientecorreo_Z ;
   protected String gxTv_SdtPaciente_Paisdescripcion_Z ;
   protected String gxTv_SdtPaciente_Ubigeonombre_Z ;
   protected String gxTv_SdtPaciente_Pacientenombreanexo_Z ;
   protected String gxTv_SdtPaciente_Pacienteenterarse_Z ;
   protected java.util.Date gxTv_SdtPaciente_Pacientefechanacimiento ;
   protected java.math.BigDecimal gxTv_SdtPaciente_Pacienteestatura ;
   protected java.math.BigDecimal gxTv_SdtPaciente_Pacientepeso ;
   protected java.util.Date gxTv_SdtPaciente_Pacientefecharegistro ;
   protected java.util.Date gxTv_SdtPaciente_Pacientefechanacimiento_Z ;
   protected java.math.BigDecimal gxTv_SdtPaciente_Pacienteestatura_Z ;
   protected java.math.BigDecimal gxTv_SdtPaciente_Pacientepeso_Z ;
   protected java.util.Date gxTv_SdtPaciente_Pacientefecharegistro_Z ;
}

