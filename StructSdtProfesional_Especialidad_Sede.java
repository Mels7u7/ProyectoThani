package com.projectthani ;
import com.genexus.*;

public final  class StructSdtProfesional_Especialidad_Sede implements Cloneable, java.io.Serializable
{
   public StructSdtProfesional_Especialidad_Sede( )
   {
      this( -1, new ModelContext( StructSdtProfesional_Especialidad_Sede.class ));
   }

   public StructSdtProfesional_Especialidad_Sede( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta = DecimalUtil.stringToDec("0.00") ;
      gxTv_SdtProfesional_Especialidad_Sede_Mode = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z = "" ;
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z = new java.math.BigDecimal(0) ;
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

   public short getSedeid( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedeid ;
   }

   public void setSedeid( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedeid = value ;
   }

   public String getSedetipoconsulta( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta ;
   }

   public void setSedetipoconsulta( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta = value ;
   }

   public String getSedenombre( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedenombre ;
   }

   public void setSedenombre( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre = value ;
   }

   public String getClinicanombreabreviado( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado ;
   }

   public void setClinicanombreabreviado( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado = value ;
   }

   public java.math.BigDecimal getCostoconsulta( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta ;
   }

   public void setCostoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Initialized = value ;
   }

   public short getSedeid_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z ;
   }

   public void setSedeid_Z( short value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z = value ;
   }

   public String getSedetipoconsulta_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z ;
   }

   public void setSedetipoconsulta_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z = value ;
   }

   public String getSedenombre_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z ;
   }

   public void setSedenombre_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z = value ;
   }

   public String getClinicanombreabreviado_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z ;
   }

   public void setClinicanombreabreviado_Z( String value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z = value ;
   }

   public java.math.BigDecimal getCostoconsulta_Z( )
   {
      return gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z ;
   }

   public void setCostoconsulta_Z( java.math.BigDecimal value )
   {
      gxTv_SdtProfesional_Especialidad_Sede_N = (byte)(0) ;
      gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z = value ;
   }

   private byte gxTv_SdtProfesional_Especialidad_Sede_N ;
   protected short gxTv_SdtProfesional_Especialidad_Sede_Sedeid ;
   protected short gxTv_SdtProfesional_Especialidad_Sede_Modified ;
   protected short gxTv_SdtProfesional_Especialidad_Sede_Initialized ;
   protected short gxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z ;
   protected String gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta ;
   protected String gxTv_SdtProfesional_Especialidad_Sede_Mode ;
   protected String gxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z ;
   protected String gxTv_SdtProfesional_Especialidad_Sede_Sedenombre ;
   protected String gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado ;
   protected String gxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z ;
   protected String gxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z ;
   protected java.math.BigDecimal gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta ;
   protected java.math.BigDecimal gxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z ;
}

