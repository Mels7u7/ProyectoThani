package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTImportMedico implements Cloneable, java.io.Serializable
{
   public StructSdtSDTImportMedico( )
   {
      this( -1, new ModelContext( StructSdtSDTImportMedico.class ));
   }

   public StructSdtSDTImportMedico( int remoteHandle ,
                                    ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTImportMedico_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTImportMedico_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTImportMedico_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTImportMedico_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTImportMedico_Profesionalnombres = "" ;
      gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento = cal.getTime() ;
      gxTv_SdtSDTImportMedico_Profesionalsexo = "" ;
      gxTv_SdtSDTImportMedico_Profesionaldescripcion = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcorreo = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcop = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcolordisponible = "" ;
      gxTv_SdtSDTImportMedico_Profesionalcolorcita = "" ;
      gxTv_SdtSDTImportMedico_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTImportMedico_Profesionaldireccion = "" ;
      gxTv_SdtSDTImportMedico_Paisdescripcion = "" ;
      gxTv_SdtSDTImportMedico_Ubigeocode = "" ;
      gxTv_SdtSDTImportMedico_Ubigeonombre = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfoto = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTImportMedico_Profesionaltelefono = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro = cal.getTime() ;
      gxTv_SdtSDTImportMedico_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTImportMedico_Profesionalestado = "" ;
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N = (byte)(1) ;
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
      return gxTv_SdtSDTImportMedico_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalid = value ;
   }

   public String getProfesionaltipodocumento( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaltipodocumento ;
   }

   public void setProfesionaltipodocumento( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaltipodocumento = value ;
   }

   public String getProfesionalnrodocumento( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalnrodocumento ;
   }

   public void setProfesionalnrodocumento( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalnrodocumento = value ;
   }

   public String getProfesionalapellidopaterno( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalapellidopaterno ;
   }

   public void setProfesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalapellidopaterno = value ;
   }

   public String getProfesionalapellidomaterno( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalapellidomaterno ;
   }

   public void setProfesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalapellidomaterno = value ;
   }

   public String getProfesionalnombres( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalnombres ;
   }

   public void setProfesionalnombres( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalnombres = value ;
   }

   public String getProfesionalnombrecompleto2( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 ;
   }

   public void setProfesionalnombrecompleto2( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 = value ;
   }

   public java.util.Date getProfesionalfechanacimiento( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfechanacimiento ;
   }

   public void setProfesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfechanacimiento = value ;
   }

   public String getProfesionalsexo( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalsexo ;
   }

   public void setProfesionalsexo( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalsexo = value ;
   }

   public String getProfesionaldescripcion( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaldescripcion ;
   }

   public void setProfesionaldescripcion( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaldescripcion = value ;
   }

   public String getProfesionalcorreo( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcorreo ;
   }

   public void setProfesionalcorreo( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcorreo = value ;
   }

   public String getProfesionalcop( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcop ;
   }

   public void setProfesionalcop( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcop = value ;
   }

   public String getProfesionalcolordisponible( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcolordisponible ;
   }

   public void setProfesionalcolordisponible( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcolordisponible = value ;
   }

   public String getProfesionalcolorcita( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalcolorcita ;
   }

   public void setProfesionalcolorcita( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalcolorcita = value ;
   }

   public byte getProfesionaltiempocita( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaltiempocita ;
   }

   public void setProfesionaltiempocita( byte value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaltiempocita = value ;
   }

   public String getProfesionaldireccion( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaldireccion ;
   }

   public void setProfesionaldireccion( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaldireccion = value ;
   }

   public short getPaisid( )
   {
      return gxTv_SdtSDTImportMedico_Paisid ;
   }

   public void setPaisid( short value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Paisid = value ;
   }

   public String getPaisdescripcion( )
   {
      return gxTv_SdtSDTImportMedico_Paisdescripcion ;
   }

   public void setPaisdescripcion( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Paisdescripcion = value ;
   }

   public String getUbigeocode( )
   {
      return gxTv_SdtSDTImportMedico_Ubigeocode ;
   }

   public void setUbigeocode( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Ubigeocode = value ;
   }

   public String getUbigeonombre( )
   {
      return gxTv_SdtSDTImportMedico_Ubigeonombre ;
   }

   public void setUbigeonombre( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Ubigeonombre = value ;
   }

   public String getProfesionalfoto( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfoto ;
   }

   public void setProfesionalfoto( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfoto = value ;
   }

   public String getProfesionalfoto_gxi( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfoto_gxi ;
   }

   public void setProfesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfoto_gxi = value ;
   }

   public String getProfesionaltelefono( )
   {
      return gxTv_SdtSDTImportMedico_Profesionaltelefono ;
   }

   public void setProfesionaltelefono( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionaltelefono = value ;
   }

   public short getSecuserid( )
   {
      return gxTv_SdtSDTImportMedico_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Secuserid = value ;
   }

   public java.util.Date getProfesionalfecharegistro( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalfecharegistro ;
   }

   public void setProfesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalfecharegistro = value ;
   }

   public boolean getProfesionalterminoscondiciones( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones ;
   }

   public void setProfesionalterminoscondiciones( boolean value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones = value ;
   }

   public String getProfesionalestadocuenta( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalestadocuenta ;
   }

   public void setProfesionalestadocuenta( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalestadocuenta = value ;
   }

   public String getProfesionalestado( )
   {
      return gxTv_SdtSDTImportMedico_Profesionalestado ;
   }

   public void setProfesionalestado( String value )
   {
      gxTv_SdtSDTImportMedico_N = (byte)(0) ;
      gxTv_SdtSDTImportMedico_Profesionalestado = value ;
   }

   protected byte gxTv_SdtSDTImportMedico_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTImportMedico_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTImportMedico_Profesionalfecharegistro_N ;
   protected byte gxTv_SdtSDTImportMedico_N ;
   protected short gxTv_SdtSDTImportMedico_Paisid ;
   protected short gxTv_SdtSDTImportMedico_Secuserid ;
   protected int gxTv_SdtSDTImportMedico_Profesionalid ;
   protected String gxTv_SdtSDTImportMedico_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTImportMedico_Profesionalsexo ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcolordisponible ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcolorcita ;
   protected String gxTv_SdtSDTImportMedico_Ubigeocode ;
   protected String gxTv_SdtSDTImportMedico_Profesionaltelefono ;
   protected String gxTv_SdtSDTImportMedico_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTImportMedico_Profesionalestado ;
   protected boolean gxTv_SdtSDTImportMedico_Profesionalterminoscondiciones ;
   protected String gxTv_SdtSDTImportMedico_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTImportMedico_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTImportMedico_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTImportMedico_Profesionalnombres ;
   protected String gxTv_SdtSDTImportMedico_Profesionalnombrecompleto2 ;
   protected String gxTv_SdtSDTImportMedico_Profesionaldescripcion ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcorreo ;
   protected String gxTv_SdtSDTImportMedico_Profesionalcop ;
   protected String gxTv_SdtSDTImportMedico_Profesionaldireccion ;
   protected String gxTv_SdtSDTImportMedico_Paisdescripcion ;
   protected String gxTv_SdtSDTImportMedico_Ubigeonombre ;
   protected String gxTv_SdtSDTImportMedico_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTImportMedico_Profesionalfoto ;
   protected java.util.Date gxTv_SdtSDTImportMedico_Profesionalfechanacimiento ;
   protected java.util.Date gxTv_SdtSDTImportMedico_Profesionalfecharegistro ;
}

