package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSugerenciasMejorasPlataforma implements Cloneable, java.io.Serializable
{
   public StructSdtSugerenciasMejorasPlataforma( )
   {
      this( -1, new ModelContext( StructSdtSugerenciasMejorasPlataforma.class ));
   }

   public StructSdtSugerenciasMejorasPlataforma( int remoteHandle ,
                                                 ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop = "" ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej = "" ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro = cal.getTime() ;
      gxTv_SdtSugerenciasMejorasPlataforma_Mode = "" ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z = cal.getTime() ;
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

   public int getSugerenciasmejorasplataformaid( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid ;
   }

   public void setSugerenciasmejorasplataformaid( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid = value ;
   }

   public int getSgpacientepacienteid( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid ;
   }

   public void setSgpacientepacienteid( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid = value ;
   }

   public short getSugerenciasmejorasplataformacitaid( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid ;
   }

   public void setSugerenciasmejorasplataformacitaid( short value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid = value ;
   }

   public String getSugerenciasmejorasplataformaop( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop ;
   }

   public void setSugerenciasmejorasplataformaop( String value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop = value ;
   }

   public String getSugerenciasmejorasplataformamej( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej ;
   }

   public void setSugerenciasmejorasplataformamej( String value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej = value ;
   }

   public java.util.Date getSugerenciasmejorasplataformafecregistro( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro ;
   }

   public void setSugerenciasmejorasplataformafecregistro( java.util.Date value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Initialized = value ;
   }

   public int getSugerenciasmejorasplataformaid_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z ;
   }

   public void setSugerenciasmejorasplataformaid_Z( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z = value ;
   }

   public int getSgpacientepacienteid_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z ;
   }

   public void setSgpacientepacienteid_Z( int value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z = value ;
   }

   public short getSugerenciasmejorasplataformacitaid_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z ;
   }

   public void setSugerenciasmejorasplataformacitaid_Z( short value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z = value ;
   }

   public java.util.Date getSugerenciasmejorasplataformafecregistro_Z( )
   {
      return gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z ;
   }

   public void setSugerenciasmejorasplataformafecregistro_Z( java.util.Date value )
   {
      gxTv_SdtSugerenciasMejorasPlataforma_N = (byte)(0) ;
      gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z = value ;
   }

   private byte gxTv_SdtSugerenciasMejorasPlataforma_N ;
   protected short gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid ;
   protected short gxTv_SdtSugerenciasMejorasPlataforma_Initialized ;
   protected short gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z ;
   protected int gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid ;
   protected int gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid ;
   protected int gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z ;
   protected int gxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z ;
   protected String gxTv_SdtSugerenciasMejorasPlataforma_Mode ;
   protected String gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop ;
   protected String gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej ;
   protected java.util.Date gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro ;
   protected java.util.Date gxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z ;
}

