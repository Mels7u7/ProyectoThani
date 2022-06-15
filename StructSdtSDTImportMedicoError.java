package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTImportMedicoError implements Cloneable, java.io.Serializable
{
   public StructSdtSDTImportMedicoError( )
   {
      this( -1, new ModelContext( StructSdtSDTImportMedicoError.class ));
   }

   public StructSdtSDTImportMedicoError( int remoteHandle ,
                                         ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombres = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento = cal.getTime() ;
      gxTv_SdtSDTImportMedicoError_Profesionalsexo = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionaldescripcion = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcorreo = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcop = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolorcita = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTImportMedicoError_Profesionaldireccion = "" ;
      gxTv_SdtSDTImportMedicoError_Paisdescripcion = "" ;
      gxTv_SdtSDTImportMedicoError_Ubigeocode = "" ;
      gxTv_SdtSDTImportMedicoError_Ubigeonombre = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionaltelefono = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro = cal.getTime() ;
      gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalestado = "" ;
      gxTv_SdtSDTImportMedicoError_Estadoimport = "" ;
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N = (byte)(1) ;
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
      return gxTv_SdtSDTImportMedicoError_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalid = value ;
   }

   public String getProfesionaltipodocumento( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento ;
   }

   public void setProfesionaltipodocumento( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento = value ;
   }

   public String getProfesionalnrodocumento( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento ;
   }

   public void setProfesionalnrodocumento( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento = value ;
   }

   public String getProfesionalapellidopaterno( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno ;
   }

   public void setProfesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno = value ;
   }

   public String getProfesionalapellidomaterno( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno ;
   }

   public void setProfesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno = value ;
   }

   public String getProfesionalnombres( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalnombres ;
   }

   public void setProfesionalnombres( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombres = value ;
   }

   public String getProfesionalnombrecompleto2( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 ;
   }

   public void setProfesionalnombrecompleto2( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 = value ;
   }

   public java.util.Date getProfesionalfechanacimiento( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento ;
   }

   public void setProfesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento = value ;
   }

   public String getProfesionalsexo( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalsexo ;
   }

   public void setProfesionalsexo( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalsexo = value ;
   }

   public String getProfesionaldescripcion( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaldescripcion ;
   }

   public void setProfesionaldescripcion( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaldescripcion = value ;
   }

   public String getProfesionalcorreo( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcorreo ;
   }

   public void setProfesionalcorreo( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcorreo = value ;
   }

   public String getProfesionalcop( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcop ;
   }

   public void setProfesionalcop( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcop = value ;
   }

   public String getProfesionalcolordisponible( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible ;
   }

   public void setProfesionalcolordisponible( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible = value ;
   }

   public String getProfesionalcolorcita( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalcolorcita ;
   }

   public void setProfesionalcolorcita( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalcolorcita = value ;
   }

   public byte getProfesionaltiempocita( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaltiempocita ;
   }

   public void setProfesionaltiempocita( byte value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaltiempocita = value ;
   }

   public String getProfesionaldireccion( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaldireccion ;
   }

   public void setProfesionaldireccion( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaldireccion = value ;
   }

   public short getPaisid( )
   {
      return gxTv_SdtSDTImportMedicoError_Paisid ;
   }

   public void setPaisid( short value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Paisid = value ;
   }

   public String getPaisdescripcion( )
   {
      return gxTv_SdtSDTImportMedicoError_Paisdescripcion ;
   }

   public void setPaisdescripcion( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Paisdescripcion = value ;
   }

   public String getUbigeocode( )
   {
      return gxTv_SdtSDTImportMedicoError_Ubigeocode ;
   }

   public void setUbigeocode( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Ubigeocode = value ;
   }

   public String getUbigeonombre( )
   {
      return gxTv_SdtSDTImportMedicoError_Ubigeonombre ;
   }

   public void setUbigeonombre( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Ubigeonombre = value ;
   }

   public String getProfesionalfoto( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfoto ;
   }

   public void setProfesionalfoto( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto = value ;
   }

   public String getProfesionalfoto_gxi( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi ;
   }

   public void setProfesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi = value ;
   }

   public String getProfesionaltelefono( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionaltelefono ;
   }

   public void setProfesionaltelefono( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionaltelefono = value ;
   }

   public short getSecuserid( )
   {
      return gxTv_SdtSDTImportMedicoError_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Secuserid = value ;
   }

   public java.util.Date getProfesionalfecharegistro( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro ;
   }

   public void setProfesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro = value ;
   }

   public boolean getProfesionalterminoscondiciones( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones ;
   }

   public void setProfesionalterminoscondiciones( boolean value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones = value ;
   }

   public String getProfesionalestadocuenta( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta ;
   }

   public void setProfesionalestadocuenta( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta = value ;
   }

   public String getProfesionalestado( )
   {
      return gxTv_SdtSDTImportMedicoError_Profesionalestado ;
   }

   public void setProfesionalestado( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Profesionalestado = value ;
   }

   public String getEstadoimport( )
   {
      return gxTv_SdtSDTImportMedicoError_Estadoimport ;
   }

   public void setEstadoimport( String value )
   {
      gxTv_SdtSDTImportMedicoError_N = (byte)(0) ;
      gxTv_SdtSDTImportMedicoError_Estadoimport = value ;
   }

   protected byte gxTv_SdtSDTImportMedicoError_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro_N ;
   protected byte gxTv_SdtSDTImportMedicoError_N ;
   protected short gxTv_SdtSDTImportMedicoError_Paisid ;
   protected short gxTv_SdtSDTImportMedicoError_Secuserid ;
   protected int gxTv_SdtSDTImportMedicoError_Profesionalid ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalsexo ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcolordisponible ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcolorcita ;
   protected String gxTv_SdtSDTImportMedicoError_Ubigeocode ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaltelefono ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalestado ;
   protected boolean gxTv_SdtSDTImportMedicoError_Profesionalterminoscondiciones ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalnombres ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalnombrecompleto2 ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaldescripcion ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcorreo ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalcop ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionaldireccion ;
   protected String gxTv_SdtSDTImportMedicoError_Paisdescripcion ;
   protected String gxTv_SdtSDTImportMedicoError_Ubigeonombre ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTImportMedicoError_Estadoimport ;
   protected String gxTv_SdtSDTImportMedicoError_Profesionalfoto ;
   protected java.util.Date gxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento ;
   protected java.util.Date gxTv_SdtSDTImportMedicoError_Profesionalfecharegistro ;
}

