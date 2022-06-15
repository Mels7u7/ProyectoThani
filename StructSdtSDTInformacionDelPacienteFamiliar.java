package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTInformacionDelPacienteFamiliar implements Cloneable, java.io.Serializable
{
   public StructSdtSDTInformacionDelPacienteFamiliar( )
   {
      this( -1, new ModelContext( StructSdtSDTInformacionDelPacienteFamiliar.class ));
   }

   public StructSdtSDTInformacionDelPacienteFamiliar( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Email = "" ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta = "" ;
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

   public int getId( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Id ;
   }

   public void setId( int value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Id = value ;
   }

   public String getNombres( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres ;
   }

   public void setNombres( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres = value ;
   }

   public String getApellidopaterno( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno ;
   }

   public void setApellidopaterno( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno = value ;
   }

   public String getApellidomaterno( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno ;
   }

   public void setApellidomaterno( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno = value ;
   }

   public String getTipodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento ;
   }

   public void setTipodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento = value ;
   }

   public String getNrodocumento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento ;
   }

   public void setNrodocumento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento = value ;
   }

   public String getFechanacimiento( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento ;
   }

   public void setFechanacimiento( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento = value ;
   }

   public String getSexo( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo ;
   }

   public void setSexo( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo = value ;
   }

   public java.math.BigDecimal getPeso( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso ;
   }

   public void setPeso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso = value ;
   }

   public java.math.BigDecimal getEstatura( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura ;
   }

   public void setEstatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura = value ;
   }

   public String getEmail( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Email ;
   }

   public void setEmail( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Email = value ;
   }

   public String getMotivoconsulta( )
   {
      return gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta ;
   }

   public void setMotivoconsulta( String value )
   {
      gxTv_SdtSDTInformacionDelPacienteFamiliar_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta = value ;
   }

   protected byte gxTv_SdtSDTInformacionDelPacienteFamiliar_N ;
   protected int gxTv_SdtSDTInformacionDelPacienteFamiliar_Id ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Email ;
   protected String gxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPacienteFamiliar_Peso ;
   protected java.math.BigDecimal gxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura ;
}

