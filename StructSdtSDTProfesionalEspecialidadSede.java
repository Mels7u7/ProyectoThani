package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalEspecialidadSede implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalEspecialidadSede( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalEspecialidadSede.class ));
   }

   public StructSdtSDTProfesionalEspecialidadSede( int remoteHandle ,
                                                   ModelContext context )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta = DecimalUtil.stringToDec("0.00") ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre = "" ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado = "" ;
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

   public short getEspecialidadid( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid = value ;
   }

   public String getEspecialidadcodigo( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo ;
   }

   public void setEspecialidadcodigo( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo = value ;
   }

   public String getEspecialidadnombre( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre ;
   }

   public void setEspecialidadnombre( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre = value ;
   }

   public short getSedeid( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid ;
   }

   public void setSedeid( short value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid = value ;
   }

   public String getSedetipoconsulta( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta ;
   }

   public void setSedetipoconsulta( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta = value ;
   }

   public java.math.BigDecimal getCostoconsulta( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta ;
   }

   public void setCostoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta = value ;
   }

   public String getSedenombre( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre ;
   }

   public void setSedenombre( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre = value ;
   }

   public String getClinicanombreabreviado( )
   {
      return gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado ;
   }

   public void setClinicanombreabreviado( String value )
   {
      gxTv_SdtSDTProfesionalEspecialidadSede_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado = value ;
   }

   protected byte gxTv_SdtSDTProfesionalEspecialidadSede_N ;
   protected short gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid ;
   protected short gxTv_SdtSDTProfesionalEspecialidadSede_Sedeid ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre ;
   protected String gxTv_SdtSDTProfesionalEspecialidadSede_Clinicanombreabreviado ;
   protected java.math.BigDecimal gxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta ;
}

