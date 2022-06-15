package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTCostoConsulta implements Cloneable, java.io.Serializable
{
   public StructSdtSDTCostoConsulta( )
   {
      this( -1, new ModelContext( StructSdtSDTCostoConsulta.class ));
   }

   public StructSdtSDTCostoConsulta( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtSDTCostoConsulta_Costoconsulta = DecimalUtil.stringToDec("0.00") ;
      gxTv_SdtSDTCostoConsulta_Sedetipoconsulta = "" ;
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
      return gxTv_SdtSDTCostoConsulta_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Profesionalid = value ;
   }

   public java.math.BigDecimal getCostoconsulta( )
   {
      return gxTv_SdtSDTCostoConsulta_Costoconsulta ;
   }

   public void setCostoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Costoconsulta = value ;
   }

   public short getSedeid( )
   {
      return gxTv_SdtSDTCostoConsulta_Sedeid ;
   }

   public void setSedeid( short value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Sedeid = value ;
   }

   public short getEspecialidadid( )
   {
      return gxTv_SdtSDTCostoConsulta_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Especialidadid = value ;
   }

   public String getSedetipoconsulta( )
   {
      return gxTv_SdtSDTCostoConsulta_Sedetipoconsulta ;
   }

   public void setSedetipoconsulta( String value )
   {
      gxTv_SdtSDTCostoConsulta_N = (byte)(0) ;
      gxTv_SdtSDTCostoConsulta_Sedetipoconsulta = value ;
   }

   protected byte gxTv_SdtSDTCostoConsulta_N ;
   protected short gxTv_SdtSDTCostoConsulta_Sedeid ;
   protected short gxTv_SdtSDTCostoConsulta_Especialidadid ;
   protected int gxTv_SdtSDTCostoConsulta_Profesionalid ;
   protected String gxTv_SdtSDTCostoConsulta_Sedetipoconsulta ;
   protected java.math.BigDecimal gxTv_SdtSDTCostoConsulta_Costoconsulta ;
}

