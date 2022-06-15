package com.projectthani ;
import com.genexus.*;

public final  class StructSdtDiagnostico implements Cloneable, java.io.Serializable
{
   public StructSdtDiagnostico( )
   {
      this( -1, new ModelContext( StructSdtDiagnostico.class ));
   }

   public StructSdtDiagnostico( int remoteHandle ,
                                ModelContext context )
   {
      gxTv_SdtDiagnostico_Diagnosticocodigo = "" ;
      gxTv_SdtDiagnostico_Diagnosticodescripcion = "" ;
      gxTv_SdtDiagnostico_Diagnosticotiposexo = "" ;
      gxTv_SdtDiagnostico_Diagnosticoestado = "" ;
      gxTv_SdtDiagnostico_Diagnosticolongdesc = "" ;
      gxTv_SdtDiagnostico_Mode = "" ;
      gxTv_SdtDiagnostico_Diagnosticocodigo_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticodescripcion_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticotiposexo_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticoestado_Z = "" ;
      gxTv_SdtDiagnostico_Diagnosticolongdesc_Z = "" ;
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

   public int getDiagnosticoid( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoid ;
   }

   public void setDiagnosticoid( int value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticoid = value ;
   }

   public String getDiagnosticocodigo( )
   {
      return gxTv_SdtDiagnostico_Diagnosticocodigo ;
   }

   public void setDiagnosticocodigo( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticocodigo = value ;
   }

   public String getDiagnosticodescripcion( )
   {
      return gxTv_SdtDiagnostico_Diagnosticodescripcion ;
   }

   public void setDiagnosticodescripcion( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticodescripcion = value ;
   }

   public String getDiagnosticotiposexo( )
   {
      return gxTv_SdtDiagnostico_Diagnosticotiposexo ;
   }

   public void setDiagnosticotiposexo( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticotiposexo = value ;
   }

   public String getDiagnosticoestado( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoestado ;
   }

   public void setDiagnosticoestado( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticoestado = value ;
   }

   public String getDiagnosticolongdesc( )
   {
      return gxTv_SdtDiagnostico_Diagnosticolongdesc ;
   }

   public void setDiagnosticolongdesc( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticolongdesc = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtDiagnostico_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtDiagnostico_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Initialized = value ;
   }

   public int getDiagnosticoid_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoid_Z ;
   }

   public void setDiagnosticoid_Z( int value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticoid_Z = value ;
   }

   public String getDiagnosticocodigo_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticocodigo_Z ;
   }

   public void setDiagnosticocodigo_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticocodigo_Z = value ;
   }

   public String getDiagnosticodescripcion_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticodescripcion_Z ;
   }

   public void setDiagnosticodescripcion_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticodescripcion_Z = value ;
   }

   public String getDiagnosticotiposexo_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticotiposexo_Z ;
   }

   public void setDiagnosticotiposexo_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticotiposexo_Z = value ;
   }

   public String getDiagnosticoestado_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticoestado_Z ;
   }

   public void setDiagnosticoestado_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticoestado_Z = value ;
   }

   public String getDiagnosticolongdesc_Z( )
   {
      return gxTv_SdtDiagnostico_Diagnosticolongdesc_Z ;
   }

   public void setDiagnosticolongdesc_Z( String value )
   {
      gxTv_SdtDiagnostico_N = (byte)(0) ;
      gxTv_SdtDiagnostico_Diagnosticolongdesc_Z = value ;
   }

   private byte gxTv_SdtDiagnostico_N ;
   protected short gxTv_SdtDiagnostico_Initialized ;
   protected int gxTv_SdtDiagnostico_Diagnosticoid ;
   protected int gxTv_SdtDiagnostico_Diagnosticoid_Z ;
   protected String gxTv_SdtDiagnostico_Diagnosticotiposexo ;
   protected String gxTv_SdtDiagnostico_Diagnosticoestado ;
   protected String gxTv_SdtDiagnostico_Mode ;
   protected String gxTv_SdtDiagnostico_Diagnosticotiposexo_Z ;
   protected String gxTv_SdtDiagnostico_Diagnosticoestado_Z ;
   protected String gxTv_SdtDiagnostico_Diagnosticocodigo ;
   protected String gxTv_SdtDiagnostico_Diagnosticodescripcion ;
   protected String gxTv_SdtDiagnostico_Diagnosticolongdesc ;
   protected String gxTv_SdtDiagnostico_Diagnosticocodigo_Z ;
   protected String gxTv_SdtDiagnostico_Diagnosticodescripcion_Z ;
   protected String gxTv_SdtDiagnostico_Diagnosticolongdesc_Z ;
}

