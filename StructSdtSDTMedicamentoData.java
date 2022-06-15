package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTMedicamentoData implements Cloneable, java.io.Serializable
{
   public StructSdtSDTMedicamentoData( )
   {
      this( -1, new ModelContext( StructSdtSDTMedicamentoData.class ));
   }

   public StructSdtSDTMedicamentoData( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtSDTMedicamentoData_Medicamentocodigo = "" ;
      gxTv_SdtSDTMedicamentoData_Medicamentonombre = "" ;
      gxTv_SdtSDTMedicamentoData_Medicamentoformafarm = "" ;
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
      return gxTv_SdtSDTMedicamentoData_Medicamentoid ;
   }

   public void setMedicamentoid( short value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentoid = value ;
   }

   public String getMedicamentocodigo( )
   {
      return gxTv_SdtSDTMedicamentoData_Medicamentocodigo ;
   }

   public void setMedicamentocodigo( String value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentocodigo = value ;
   }

   public String getMedicamentonombre( )
   {
      return gxTv_SdtSDTMedicamentoData_Medicamentonombre ;
   }

   public void setMedicamentonombre( String value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentonombre = value ;
   }

   public String getMedicamentoformafarm( )
   {
      return gxTv_SdtSDTMedicamentoData_Medicamentoformafarm ;
   }

   public void setMedicamentoformafarm( String value )
   {
      gxTv_SdtSDTMedicamentoData_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoData_Medicamentoformafarm = value ;
   }

   protected byte gxTv_SdtSDTMedicamentoData_N ;
   protected short gxTv_SdtSDTMedicamentoData_Medicamentoid ;
   protected String gxTv_SdtSDTMedicamentoData_Medicamentocodigo ;
   protected String gxTv_SdtSDTMedicamentoData_Medicamentonombre ;
   protected String gxTv_SdtSDTMedicamentoData_Medicamentoformafarm ;
}

