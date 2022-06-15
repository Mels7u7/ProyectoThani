package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseDni implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseDni( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseDni.class ));
   }

   public StructSdtSDTResponseDni( int remoteHandle ,
                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTResponseDni_Dni = "" ;
      gxTv_SdtSDTResponseDni_Name = "" ;
      gxTv_SdtSDTResponseDni_First_name = "" ;
      gxTv_SdtSDTResponseDni_Last_name = "" ;
      gxTv_SdtSDTResponseDni_Nombres = "" ;
      gxTv_SdtSDTResponseDni_Apellido_paterno = "" ;
      gxTv_SdtSDTResponseDni_Apellido_materno = "" ;
      gxTv_SdtSDTResponseDni_Fecha_nacimiento = cal.getTime() ;
      gxTv_SdtSDTResponseDni_Sexo = "" ;
      gxTv_SdtSDTResponseDni_Cui = "" ;
      gxTv_SdtSDTResponseDni_Fecha_nacimiento_N = (byte)(1) ;
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

   public String getDni( )
   {
      return gxTv_SdtSDTResponseDni_Dni ;
   }

   public void setDni( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Dni = value ;
   }

   public String getName( )
   {
      return gxTv_SdtSDTResponseDni_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Name = value ;
   }

   public String getFirst_name( )
   {
      return gxTv_SdtSDTResponseDni_First_name ;
   }

   public void setFirst_name( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_First_name = value ;
   }

   public String getLast_name( )
   {
      return gxTv_SdtSDTResponseDni_Last_name ;
   }

   public void setLast_name( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Last_name = value ;
   }

   public String getNombres( )
   {
      return gxTv_SdtSDTResponseDni_Nombres ;
   }

   public void setNombres( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Nombres = value ;
   }

   public String getApellido_paterno( )
   {
      return gxTv_SdtSDTResponseDni_Apellido_paterno ;
   }

   public void setApellido_paterno( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Apellido_paterno = value ;
   }

   public String getApellido_materno( )
   {
      return gxTv_SdtSDTResponseDni_Apellido_materno ;
   }

   public void setApellido_materno( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Apellido_materno = value ;
   }

   public java.util.Date getFecha_nacimiento( )
   {
      return gxTv_SdtSDTResponseDni_Fecha_nacimiento ;
   }

   public void setFecha_nacimiento( java.util.Date value )
   {
      gxTv_SdtSDTResponseDni_Fecha_nacimiento_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Fecha_nacimiento = value ;
   }

   public String getSexo( )
   {
      return gxTv_SdtSDTResponseDni_Sexo ;
   }

   public void setSexo( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Sexo = value ;
   }

   public String getCui( )
   {
      return gxTv_SdtSDTResponseDni_Cui ;
   }

   public void setCui( String value )
   {
      gxTv_SdtSDTResponseDni_N = (byte)(0) ;
      gxTv_SdtSDTResponseDni_Cui = value ;
   }

   protected byte gxTv_SdtSDTResponseDni_Fecha_nacimiento_N ;
   protected byte gxTv_SdtSDTResponseDni_N ;
   protected String gxTv_SdtSDTResponseDni_Sexo ;
   protected String gxTv_SdtSDTResponseDni_Dni ;
   protected String gxTv_SdtSDTResponseDni_Name ;
   protected String gxTv_SdtSDTResponseDni_First_name ;
   protected String gxTv_SdtSDTResponseDni_Last_name ;
   protected String gxTv_SdtSDTResponseDni_Nombres ;
   protected String gxTv_SdtSDTResponseDni_Apellido_paterno ;
   protected String gxTv_SdtSDTResponseDni_Apellido_materno ;
   protected String gxTv_SdtSDTResponseDni_Cui ;
   protected java.util.Date gxTv_SdtSDTResponseDni_Fecha_nacimiento ;
}

