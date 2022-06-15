package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTMedicamentoGridItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTMedicamentoGridItem( )
   {
      this( -1, new ModelContext( StructSdtSDTMedicamentoGridItem.class ));
   }

   public StructSdtSDTMedicamentoGridItem( int remoteHandle ,
                                           ModelContext context )
   {
      gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre = "" ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones = "" ;
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
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentoid ;
   }

   public void setMedicamentoid( short value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentoid = value ;
   }

   public String getMedicamentonombre( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre ;
   }

   public void setMedicamentonombre( String value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre = value ;
   }

   public short getMedicamentocantidad( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad ;
   }

   public void setMedicamentocantidad( short value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad = value ;
   }

   public String getMedicamentoindicaciones( )
   {
      return gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones ;
   }

   public void setMedicamentoindicaciones( String value )
   {
      gxTv_SdtSDTMedicamentoGridItem_N = (byte)(0) ;
      gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones = value ;
   }

   protected byte gxTv_SdtSDTMedicamentoGridItem_N ;
   protected short gxTv_SdtSDTMedicamentoGridItem_Medicamentoid ;
   protected short gxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad ;
   protected String gxTv_SdtSDTMedicamentoGridItem_Medicamentonombre ;
   protected String gxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones ;
}

