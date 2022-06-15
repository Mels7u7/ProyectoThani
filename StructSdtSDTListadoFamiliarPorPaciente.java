package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTListadoFamiliarPorPaciente implements Cloneable, java.io.Serializable
{
   public StructSdtSDTListadoFamiliarPorPaciente( )
   {
      this( -1, new ModelContext( StructSdtSDTListadoFamiliarPorPaciente.class ));
   }

   public StructSdtSDTListadoFamiliarPorPaciente( int remoteHandle ,
                                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento = cal.getTime() ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad = "" ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Peso = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N = (byte)(1) ;
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

   public String getNombres( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres ;
   }

   public void setNombres( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres = value ;
   }

   public String getApellidos( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos ;
   }

   public void setApellidos( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos = value ;
   }

   public String getNrodocumento( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento ;
   }

   public void setNrodocumento( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento = value ;
   }

   public java.util.Date getFechanacimento( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento ;
   }

   public void setFechanacimento( java.util.Date value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento = value ;
   }

   public String getParentesco( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco ;
   }

   public void setParentesco( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco = value ;
   }

   public String getSexo( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo ;
   }

   public void setSexo( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo = value ;
   }

   public String getNacionalidad( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad ;
   }

   public void setNacionalidad( String value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad = value ;
   }

   public java.math.BigDecimal getPeso( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Peso ;
   }

   public void setPeso( java.math.BigDecimal value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Peso = value ;
   }

   public java.math.BigDecimal getEstatura( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura ;
   }

   public void setEstatura( java.math.BigDecimal value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura = value ;
   }

   public int getPacientefamiliarid( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid ;
   }

   public void setPacientefamiliarid( int value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid = value ;
   }

   public int getSgpacientehijopacienteid( )
   {
      return gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid ;
   }

   public void setSgpacientehijopacienteid( int value )
   {
      gxTv_SdtSDTListadoFamiliarPorPaciente_N = (byte)(0) ;
      gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid = value ;
   }

   protected byte gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento_N ;
   protected byte gxTv_SdtSDTListadoFamiliarPorPaciente_N ;
   protected int gxTv_SdtSDTListadoFamiliarPorPaciente_Pacientefamiliarid ;
   protected int gxTv_SdtSDTListadoFamiliarPorPaciente_Sgpacientehijopacienteid ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Nrodocumento ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Sexo ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Nombres ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Apellidos ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Parentesco ;
   protected String gxTv_SdtSDTListadoFamiliarPorPaciente_Nacionalidad ;
   protected java.util.Date gxTv_SdtSDTListadoFamiliarPorPaciente_Fechanacimento ;
   protected java.math.BigDecimal gxTv_SdtSDTListadoFamiliarPorPaciente_Peso ;
   protected java.math.BigDecimal gxTv_SdtSDTListadoFamiliarPorPaciente_Estatura ;
}

