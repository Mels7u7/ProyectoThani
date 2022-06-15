package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTInformacionDeLaCita implements Cloneable, java.io.Serializable
{
   public StructSdtSDTInformacionDeLaCita( )
   {
      this( -1, new ModelContext( StructSdtSDTInformacionDeLaCita.class ));
   }

   public StructSdtSDTInformacionDeLaCita( int remoteHandle ,
                                           ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha = cal.getTime() ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede = "" ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N = (byte)(1) ;
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

   public short getSdtinformaciondelacitaid( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid ;
   }

   public void setSdtinformaciondelacitaid( short value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid = value ;
   }

   public String getSdtinformaciondelacitanombresdoctor( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor ;
   }

   public void setSdtinformaciondelacitanombresdoctor( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor = value ;
   }

   public String getSdtinformaciondelacitafotografiadoctor( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor ;
   }

   public void setSdtinformaciondelacitafotografiadoctor( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor = value ;
   }

   public String getSdtinformaciondelacitafotografiadoctor_gxi( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi ;
   }

   public void setSdtinformaciondelacitafotografiadoctor_gxi( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi = value ;
   }

   public String getSdtinformaciondelacitaespecialidaddoctor( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor ;
   }

   public void setSdtinformaciondelacitaespecialidaddoctor( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor = value ;
   }

   public String getSdtinformaciondelacitatipoconsulta( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta ;
   }

   public void setSdtinformaciondelacitatipoconsulta( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta = value ;
   }

   public String getSdtinformaciondelacitahora( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora ;
   }

   public void setSdtinformaciondelacitahora( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora = value ;
   }

   public short getSdtinformaciondelacitacosto( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto ;
   }

   public void setSdtinformaciondelacitacosto( short value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto = value ;
   }

   public java.util.Date getSdtinformaciondelacitafecha( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha ;
   }

   public void setSdtinformaciondelacitafecha( java.util.Date value )
   {
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha = value ;
   }

   public String getSdtinformaciondelacitaclinica( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica ;
   }

   public void setSdtinformaciondelacitaclinica( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica = value ;
   }

   public String getSdtinformaciondelacitasede( )
   {
      return gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede ;
   }

   public void setSdtinformaciondelacitasede( String value )
   {
      gxTv_SdtSDTInformacionDeLaCita_N = (byte)(0) ;
      gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede = value ;
   }

   protected byte gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha_N ;
   protected byte gxTv_SdtSDTInformacionDeLaCita_N ;
   protected short gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid ;
   protected short gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede ;
   protected String gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor ;
   protected java.util.Date gxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha ;
}

