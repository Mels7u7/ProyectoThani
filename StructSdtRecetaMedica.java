package com.projectthani ;
import com.genexus.*;

public final  class StructSdtRecetaMedica implements Cloneable, java.io.Serializable
{
   public StructSdtRecetaMedica( )
   {
      this( -1, new ModelContext( StructSdtRecetaMedica.class ));
   }

   public StructSdtRecetaMedica( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtRecetaMedica_Medicamentocodigo = "" ;
      gxTv_SdtRecetaMedica_Medicamentonombre = "" ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaarchivo = "" ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = "" ;
      gxTv_SdtRecetaMedica_Recetaindicaciones = "" ;
      gxTv_SdtRecetaMedica_Recetaarchivotipo = "" ;
      gxTv_SdtRecetaMedica_Mode = "" ;
      gxTv_SdtRecetaMedica_Medicamentocodigo_Z = "" ;
      gxTv_SdtRecetaMedica_Medicamentonombre_Z = "" ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm_Z = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z = "" ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion_Z = "" ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z = "" ;
      gxTv_SdtRecetaMedica_Recetaindicaciones_Z = "" ;
      gxTv_SdtRecetaMedica_Recetaarchivotipo_Z = "" ;
      gxTv_SdtRecetaMedica_Medicamentoid_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicacantidad_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = (byte)(1) ;
      gxTv_SdtRecetaMedica_Recetamedicaflag_N = (byte)(1) ;
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

   public short getRecetamedicaid( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaid ;
   }

   public void setRecetamedicaid( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaid = value ;
   }

   public int getCitaid( )
   {
      return gxTv_SdtRecetaMedica_Citaid ;
   }

   public void setCitaid( int value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Citaid = value ;
   }

   public short getMedicamentoid( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoid ;
   }

   public void setMedicamentoid( short value )
   {
      gxTv_SdtRecetaMedica_Medicamentoid_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentoid = value ;
   }

   public String getMedicamentocodigo( )
   {
      return gxTv_SdtRecetaMedica_Medicamentocodigo ;
   }

   public void setMedicamentocodigo( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentocodigo = value ;
   }

   public String getMedicamentonombre( )
   {
      return gxTv_SdtRecetaMedica_Medicamentonombre ;
   }

   public void setMedicamentonombre( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentonombre = value ;
   }

   public String getMedicamentoformafarm( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoformafarm ;
   }

   public void setMedicamentoformafarm( String value )
   {
      gxTv_SdtRecetaMedica_Medicamentoformafarm_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm = value ;
   }

   public String getRecetamedicaconcentracion( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaconcentracion ;
   }

   public void setRecetamedicaconcentracion( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion = value ;
   }

   public short getRecetamedicacantidad( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicacantidad ;
   }

   public void setRecetamedicacantidad( short value )
   {
      gxTv_SdtRecetaMedica_Recetamedicacantidad_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicacantidad = value ;
   }

   public String getRecetamedicaatencion( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaatencion ;
   }

   public void setRecetamedicaatencion( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaatencion_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion = value ;
   }

   public String getRecetamedicaarchivo( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaarchivo ;
   }

   public void setRecetamedicaarchivo( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaarchivo = value ;
   }

   public String getRecetamedicanombrearchivo( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicanombrearchivo ;
   }

   public void setRecetamedicanombrearchivo( String value )
   {
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo = value ;
   }

   public byte getRecetamedicaflag( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaflag ;
   }

   public void setRecetamedicaflag( byte value )
   {
      gxTv_SdtRecetaMedica_Recetamedicaflag_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaflag = value ;
   }

   public String getRecetaindicaciones( )
   {
      return gxTv_SdtRecetaMedica_Recetaindicaciones ;
   }

   public void setRecetaindicaciones( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetaindicaciones = value ;
   }

   public String getRecetaarchivotipo( )
   {
      return gxTv_SdtRecetaMedica_Recetaarchivotipo ;
   }

   public void setRecetaarchivotipo( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetaarchivotipo = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtRecetaMedica_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtRecetaMedica_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Initialized = value ;
   }

   public short getRecetamedicaid_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaid_Z ;
   }

   public void setRecetamedicaid_Z( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaid_Z = value ;
   }

   public int getCitaid_Z( )
   {
      return gxTv_SdtRecetaMedica_Citaid_Z ;
   }

   public void setCitaid_Z( int value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Citaid_Z = value ;
   }

   public short getMedicamentoid_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoid_Z ;
   }

   public void setMedicamentoid_Z( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentoid_Z = value ;
   }

   public String getMedicamentocodigo_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentocodigo_Z ;
   }

   public void setMedicamentocodigo_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentocodigo_Z = value ;
   }

   public String getMedicamentonombre_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentonombre_Z ;
   }

   public void setMedicamentonombre_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentonombre_Z = value ;
   }

   public String getMedicamentoformafarm_Z( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoformafarm_Z ;
   }

   public void setMedicamentoformafarm_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm_Z = value ;
   }

   public String getRecetamedicaconcentracion_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z ;
   }

   public void setRecetamedicaconcentracion_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z = value ;
   }

   public short getRecetamedicacantidad_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicacantidad_Z ;
   }

   public void setRecetamedicacantidad_Z( short value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicacantidad_Z = value ;
   }

   public String getRecetamedicaatencion_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaatencion_Z ;
   }

   public void setRecetamedicaatencion_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion_Z = value ;
   }

   public String getRecetamedicanombrearchivo_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z ;
   }

   public void setRecetamedicanombrearchivo_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z = value ;
   }

   public byte getRecetamedicaflag_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaflag_Z ;
   }

   public void setRecetamedicaflag_Z( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaflag_Z = value ;
   }

   public String getRecetaindicaciones_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetaindicaciones_Z ;
   }

   public void setRecetaindicaciones_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetaindicaciones_Z = value ;
   }

   public String getRecetaarchivotipo_Z( )
   {
      return gxTv_SdtRecetaMedica_Recetaarchivotipo_Z ;
   }

   public void setRecetaarchivotipo_Z( String value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetaarchivotipo_Z = value ;
   }

   public byte getMedicamentoid_N( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoid_N ;
   }

   public void setMedicamentoid_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentoid_N = value ;
   }

   public byte getMedicamentoformafarm_N( )
   {
      return gxTv_SdtRecetaMedica_Medicamentoformafarm_N ;
   }

   public void setMedicamentoformafarm_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Medicamentoformafarm_N = value ;
   }

   public byte getRecetamedicaconcentracion_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N ;
   }

   public void setRecetamedicaconcentracion_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N = value ;
   }

   public byte getRecetamedicacantidad_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicacantidad_N ;
   }

   public void setRecetamedicacantidad_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicacantidad_N = value ;
   }

   public byte getRecetamedicaatencion_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaatencion_N ;
   }

   public void setRecetamedicaatencion_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaatencion_N = value ;
   }

   public byte getRecetamedicaarchivo_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaarchivo_N ;
   }

   public void setRecetamedicaarchivo_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaarchivo_N = value ;
   }

   public byte getRecetamedicanombrearchivo_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N ;
   }

   public void setRecetamedicanombrearchivo_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N = value ;
   }

   public byte getRecetamedicaflag_N( )
   {
      return gxTv_SdtRecetaMedica_Recetamedicaflag_N ;
   }

   public void setRecetamedicaflag_N( byte value )
   {
      gxTv_SdtRecetaMedica_N = (byte)(0) ;
      gxTv_SdtRecetaMedica_Recetamedicaflag_N = value ;
   }

   protected byte gxTv_SdtRecetaMedica_Recetamedicaflag ;
   protected byte gxTv_SdtRecetaMedica_Recetamedicaflag_Z ;
   protected byte gxTv_SdtRecetaMedica_Medicamentoid_N ;
   protected byte gxTv_SdtRecetaMedica_Medicamentoformafarm_N ;
   protected byte gxTv_SdtRecetaMedica_Recetamedicaconcentracion_N ;
   protected byte gxTv_SdtRecetaMedica_Recetamedicacantidad_N ;
   protected byte gxTv_SdtRecetaMedica_Recetamedicaatencion_N ;
   protected byte gxTv_SdtRecetaMedica_Recetamedicaarchivo_N ;
   protected byte gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N ;
   protected byte gxTv_SdtRecetaMedica_Recetamedicaflag_N ;
   private byte gxTv_SdtRecetaMedica_N ;
   protected short gxTv_SdtRecetaMedica_Recetamedicaid ;
   protected short gxTv_SdtRecetaMedica_Medicamentoid ;
   protected short gxTv_SdtRecetaMedica_Recetamedicacantidad ;
   protected short gxTv_SdtRecetaMedica_Initialized ;
   protected short gxTv_SdtRecetaMedica_Recetamedicaid_Z ;
   protected short gxTv_SdtRecetaMedica_Medicamentoid_Z ;
   protected short gxTv_SdtRecetaMedica_Recetamedicacantidad_Z ;
   protected int gxTv_SdtRecetaMedica_Citaid ;
   protected int gxTv_SdtRecetaMedica_Citaid_Z ;
   protected String gxTv_SdtRecetaMedica_Mode ;
   protected String gxTv_SdtRecetaMedica_Recetamedicaarchivo ;
   protected String gxTv_SdtRecetaMedica_Medicamentocodigo ;
   protected String gxTv_SdtRecetaMedica_Medicamentonombre ;
   protected String gxTv_SdtRecetaMedica_Medicamentoformafarm ;
   protected String gxTv_SdtRecetaMedica_Recetamedicaconcentracion ;
   protected String gxTv_SdtRecetaMedica_Recetamedicaatencion ;
   protected String gxTv_SdtRecetaMedica_Recetamedicanombrearchivo ;
   protected String gxTv_SdtRecetaMedica_Recetaindicaciones ;
   protected String gxTv_SdtRecetaMedica_Recetaarchivotipo ;
   protected String gxTv_SdtRecetaMedica_Medicamentocodigo_Z ;
   protected String gxTv_SdtRecetaMedica_Medicamentonombre_Z ;
   protected String gxTv_SdtRecetaMedica_Medicamentoformafarm_Z ;
   protected String gxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z ;
   protected String gxTv_SdtRecetaMedica_Recetamedicaatencion_Z ;
   protected String gxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z ;
   protected String gxTv_SdtRecetaMedica_Recetaindicaciones_Z ;
   protected String gxTv_SdtRecetaMedica_Recetaarchivotipo_Z ;
}

