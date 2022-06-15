package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTHora_SDTHoraItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTHora_SDTHoraItem( )
   {
      this( -1, new ModelContext( StructSdtSDTHora_SDTHoraItem.class ));
   }

   public StructSdtSDTHora_SDTHoraItem( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_SdtSDTHora_SDTHoraItem_Horaid = "" ;
      gxTv_SdtSDTHora_SDTHoraItem_Horavalue = "" ;
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

   public String getHoraid( )
   {
      return gxTv_SdtSDTHora_SDTHoraItem_Horaid ;
   }

   public void setHoraid( String value )
   {
      gxTv_SdtSDTHora_SDTHoraItem_N = (byte)(0) ;
      gxTv_SdtSDTHora_SDTHoraItem_Horaid = value ;
   }

   public String getHoravalue( )
   {
      return gxTv_SdtSDTHora_SDTHoraItem_Horavalue ;
   }

   public void setHoravalue( String value )
   {
      gxTv_SdtSDTHora_SDTHoraItem_N = (byte)(0) ;
      gxTv_SdtSDTHora_SDTHoraItem_Horavalue = value ;
   }

   protected byte gxTv_SdtSDTHora_SDTHoraItem_N ;
   protected String gxTv_SdtSDTHora_SDTHoraItem_Horaid ;
   protected String gxTv_SdtSDTHora_SDTHoraItem_Horavalue ;
}

