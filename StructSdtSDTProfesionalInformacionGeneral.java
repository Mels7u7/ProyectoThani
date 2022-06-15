package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalInformacionGeneral implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalInformacionGeneral( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalInformacionGeneral.class ));
   }

   public StructSdtSDTProfesionalInformacionGeneral( int remoteHandle ,
                                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento = cal.getTime() ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita = (byte)(30) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro = cal.getTime() ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode = "" ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N = (byte)(1) ;
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
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid = value ;
   }

   public String getProfesionaltipodocumento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento ;
   }

   public void setProfesionaltipodocumento( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento = value ;
   }

   public String getProfesionalnrodocumento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento ;
   }

   public void setProfesionalnrodocumento( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento = value ;
   }

   public String getProfesionalapellidopaterno( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno ;
   }

   public void setProfesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno = value ;
   }

   public String getProfesionalapellidomaterno( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno ;
   }

   public void setProfesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno = value ;
   }

   public String getProfesionalnombres( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres ;
   }

   public void setProfesionalnombres( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres = value ;
   }

   public java.util.Date getProfesionalfechanacimiento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento ;
   }

   public void setProfesionalfechanacimiento( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento = value ;
   }

   public String getProfesionalsexo( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo ;
   }

   public void setProfesionalsexo( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo = value ;
   }

   public String getProfesionaldescripcion( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion ;
   }

   public void setProfesionaldescripcion( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion = value ;
   }

   public String getProfesionalcorreo( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo ;
   }

   public void setProfesionalcorreo( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo = value ;
   }

   public String getProfesionalcop( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop ;
   }

   public void setProfesionalcop( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop = value ;
   }

   public byte getProfesionaltiempocita( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita ;
   }

   public void setProfesionaltiempocita( byte value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita = value ;
   }

   public String getProfesionaldireccion( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion ;
   }

   public void setProfesionaldireccion( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion = value ;
   }

   public String getPaisdescripcion( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion ;
   }

   public void setPaisdescripcion( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion = value ;
   }

   public String getUbigeocode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode ;
   }

   public void setUbigeocode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode = value ;
   }

   public String getUbigeonombre( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre ;
   }

   public void setUbigeonombre( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre = value ;
   }

   public String getProfesionalfoto( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto ;
   }

   public void setProfesionalfoto( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto = value ;
   }

   public String getProfesionalfoto_gxi( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi ;
   }

   public void setProfesionalfoto_gxi( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi = value ;
   }

   public String getProfesionaltwitter( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter ;
   }

   public void setProfesionaltwitter( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter = value ;
   }

   public String getProfesionalfacebook( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook ;
   }

   public void setProfesionalfacebook( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook = value ;
   }

   public String getProfesionalinstagram( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram ;
   }

   public void setProfesionalinstagram( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram = value ;
   }

   public String getProfesionallinkedin( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin ;
   }

   public void setProfesionallinkedin( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin = value ;
   }

   public String getProfesionaltelefono( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono ;
   }

   public void setProfesionaltelefono( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono = value ;
   }

   public java.util.Date getProfesionalfecharegistro( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro ;
   }

   public void setProfesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro = value ;
   }

   public String getProfesionalestadocuenta( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta ;
   }

   public void setProfesionalestadocuenta( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta = value ;
   }

   public String getProfesionalestado( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado ;
   }

   public void setProfesionalestado( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado = value ;
   }

   public String getUbigeodepartamento( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento ;
   }

   public void setUbigeodepartamento( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento = value ;
   }

   public String getUbigeodepartamentocode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode ;
   }

   public void setUbigeodepartamentocode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode = value ;
   }

   public String getUbigeoprovincia( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia ;
   }

   public void setUbigeoprovincia( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia = value ;
   }

   public String getUbigeoprovinciacode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode ;
   }

   public void setUbigeoprovinciacode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode = value ;
   }

   public String getUbigeodistrito( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito ;
   }

   public void setUbigeodistrito( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito = value ;
   }

   public String getUbigeodistritocode( )
   {
      return gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode ;
   }

   public void setUbigeodistritocode( String value )
   {
      gxTv_SdtSDTProfesionalInformacionGeneral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode = value ;
   }

   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita ;
   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento_N ;
   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro_N ;
   protected byte gxTv_SdtSDTProfesionalInformacionGeneral_N ;
   protected int gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode ;
   protected String gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto ;
   protected java.util.Date gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento ;
   protected java.util.Date gxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro ;
}

