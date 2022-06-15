package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTCuentaPorVerificarProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtSDTCuentaPorVerificarProfesional( )
   {
      this( -1, new ModelContext( StructSdtSDTCuentaPorVerificarProfesional.class ));
   }

   public StructSdtSDTCuentaPorVerificarProfesional( int remoteHandle ,
                                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro = cal.getTime() ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado = "" ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N = (byte)(1) ;
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
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid = value ;
   }

   public String getProfesionaltipodocumento( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento ;
   }

   public void setProfesionaltipodocumento( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento = value ;
   }

   public String getProfesionalnrodocumento( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento ;
   }

   public void setProfesionalnrodocumento( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento = value ;
   }

   public String getProfesionalapellidopaterno( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno ;
   }

   public void setProfesionalapellidopaterno( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno = value ;
   }

   public String getProfesionalapellidomaterno( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno ;
   }

   public void setProfesionalapellidomaterno( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno = value ;
   }

   public String getProfesionalnombres( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres ;
   }

   public void setProfesionalnombres( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres = value ;
   }

   public String getProfesionalsexo( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo ;
   }

   public void setProfesionalsexo( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo = value ;
   }

   public String getProfesionalcop( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop ;
   }

   public void setProfesionalcop( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop = value ;
   }

   public String getProfesionaltelefono( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono ;
   }

   public void setProfesionaltelefono( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono = value ;
   }

   public String getProfesionalcorreo( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo ;
   }

   public void setProfesionalcorreo( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo = value ;
   }

   public java.util.Date getProfesionalfecharegistro( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro ;
   }

   public void setProfesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro = value ;
   }

   public String getProfesionalestadocuenta( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta ;
   }

   public void setProfesionalestadocuenta( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta = value ;
   }

   public String getProfesionalestado( )
   {
      return gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado ;
   }

   public void setProfesionalestado( String value )
   {
      gxTv_SdtSDTCuentaPorVerificarProfesional_N = (byte)(0) ;
      gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado = value ;
   }

   protected byte gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro_N ;
   protected byte gxTv_SdtSDTCuentaPorVerificarProfesional_N ;
   protected int gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop ;
   protected String gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo ;
   protected java.util.Date gxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro ;
}

