package com.projectthani ;
import com.genexus.*;

public final  class StructSdtMedicamento implements Cloneable, java.io.Serializable
{
   public StructSdtMedicamento( )
   {
      this( -1, new ModelContext( StructSdtMedicamento.class ));
   }

   public StructSdtMedicamento( int remoteHandle ,
                                ModelContext context )
   {
      gxTv_SdtMedicamento_Medicamentocodigo = "" ;
      gxTv_SdtMedicamento_Medicamentonombre = "" ;
      gxTv_SdtMedicamento_Medicamentoformafarm = "" ;
      gxTv_SdtMedicamento_Mode = "" ;
      gxTv_SdtMedicamento_Medicamentocodigo_Z = "" ;
      gxTv_SdtMedicamento_Medicamentonombre_Z = "" ;
      gxTv_SdtMedicamento_Medicamentoformafarm_Z = "" ;
      gxTv_SdtMedicamento_Medicamentoformafarm_N = (byte)(1) ;
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

   public short getMedicamentoid( )
   {
      return gxTv_SdtMedicamento_Medicamentoid ;
   }

   public void setMedicamentoid( short value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentoid = value ;
   }

   public String getMedicamentocodigo( )
   {
      return gxTv_SdtMedicamento_Medicamentocodigo ;
   }

   public void setMedicamentocodigo( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentocodigo = value ;
   }

   public String getMedicamentonombre( )
   {
      return gxTv_SdtMedicamento_Medicamentonombre ;
   }

   public void setMedicamentonombre( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentonombre = value ;
   }

   public String getMedicamentoformafarm( )
   {
      return gxTv_SdtMedicamento_Medicamentoformafarm ;
   }

   public void setMedicamentoformafarm( String value )
   {
      gxTv_SdtMedicamento_Medicamentoformafarm_N = (byte)(0) ;
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentoformafarm = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtMedicamento_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtMedicamento_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Initialized = value ;
   }

   public short getMedicamentoid_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentoid_Z ;
   }

   public void setMedicamentoid_Z( short value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentoid_Z = value ;
   }

   public String getMedicamentocodigo_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentocodigo_Z ;
   }

   public void setMedicamentocodigo_Z( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentocodigo_Z = value ;
   }

   public String getMedicamentonombre_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentonombre_Z ;
   }

   public void setMedicamentonombre_Z( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentonombre_Z = value ;
   }

   public String getMedicamentoformafarm_Z( )
   {
      return gxTv_SdtMedicamento_Medicamentoformafarm_Z ;
   }

   public void setMedicamentoformafarm_Z( String value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentoformafarm_Z = value ;
   }

   public byte getMedicamentoid_N( )
   {
      return gxTv_SdtMedicamento_Medicamentoid_N ;
   }

   public void setMedicamentoid_N( byte value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentoid_N = value ;
   }

   public byte getMedicamentoformafarm_N( )
   {
      return gxTv_SdtMedicamento_Medicamentoformafarm_N ;
   }

   public void setMedicamentoformafarm_N( byte value )
   {
      gxTv_SdtMedicamento_N = (byte)(0) ;
      gxTv_SdtMedicamento_Medicamentoformafarm_N = value ;
   }

   protected byte gxTv_SdtMedicamento_Medicamentoid_N ;
   protected byte gxTv_SdtMedicamento_Medicamentoformafarm_N ;
   private byte gxTv_SdtMedicamento_N ;
   protected short gxTv_SdtMedicamento_Medicamentoid ;
   protected short gxTv_SdtMedicamento_Initialized ;
   protected short gxTv_SdtMedicamento_Medicamentoid_Z ;
   protected String gxTv_SdtMedicamento_Mode ;
   protected String gxTv_SdtMedicamento_Medicamentocodigo ;
   protected String gxTv_SdtMedicamento_Medicamentonombre ;
   protected String gxTv_SdtMedicamento_Medicamentoformafarm ;
   protected String gxTv_SdtMedicamento_Medicamentocodigo_Z ;
   protected String gxTv_SdtMedicamento_Medicamentonombre_Z ;
   protected String gxTv_SdtMedicamento_Medicamentoformafarm_Z ;
}

