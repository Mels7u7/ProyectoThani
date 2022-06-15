package com.projectthani ;
import com.genexus.*;

public final  class StructSdtCitaDiagnostico implements Cloneable, java.io.Serializable
{
   public StructSdtCitaDiagnostico( )
   {
      this( -1, new ModelContext( StructSdtCitaDiagnostico.class ));
   }

   public StructSdtCitaDiagnostico( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado = "" ;
      gxTv_SdtCitaDiagnostico_Mode = "" ;
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z = "" ;
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

   public int getCitadiagnosticoid( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoid ;
   }

   public void setCitadiagnosticoid( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Citadiagnosticoid = value ;
   }

   public int getCitaid( )
   {
      return gxTv_SdtCitaDiagnostico_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Citaid = value ;
   }

   public int getDiagnosticoid( )
   {
      return gxTv_SdtCitaDiagnostico_Diagnosticoid ;
   }

   public void setDiagnosticoid( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Diagnosticoid = value ;
   }

   public String getCitadiagnosticoestado( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoestado ;
   }

   public void setCitadiagnosticoestado( String value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCitaDiagnostico_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCitaDiagnostico_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Initialized = value ;
   }

   public int getCitadiagnosticoid_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z ;
   }

   public void setCitadiagnosticoid_Z( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z = value ;
   }

   public int getCitaid_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Citaid_Z ;
   }

   public void setCitaid_Z( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Citaid_Z = value ;
   }

   public int getDiagnosticoid_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Diagnosticoid_Z ;
   }

   public void setDiagnosticoid_Z( int value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Diagnosticoid_Z = value ;
   }

   public String getCitadiagnosticoestado_Z( )
   {
      return gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z ;
   }

   public void setCitadiagnosticoestado_Z( String value )
   {
      gxTv_SdtCitaDiagnostico_N = (byte)(0) ;
      gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z = value ;
   }

   private byte gxTv_SdtCitaDiagnostico_N ;
   protected short gxTv_SdtCitaDiagnostico_Initialized ;
   protected int gxTv_SdtCitaDiagnostico_Citadiagnosticoid ;
   protected int gxTv_SdtCitaDiagnostico_Citaid ;
   protected int gxTv_SdtCitaDiagnostico_Diagnosticoid ;
   protected int gxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z ;
   protected int gxTv_SdtCitaDiagnostico_Citaid_Z ;
   protected int gxTv_SdtCitaDiagnostico_Diagnosticoid_Z ;
   protected String gxTv_SdtCitaDiagnostico_Mode ;
   protected String gxTv_SdtCitaDiagnostico_Citadiagnosticoestado ;
   protected String gxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z ;
}

