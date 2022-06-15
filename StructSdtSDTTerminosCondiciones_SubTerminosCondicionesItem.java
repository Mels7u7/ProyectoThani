package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem( )
   {
      this( -1, new ModelContext( StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem.class ));
   }

   public StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem( int remoteHandle ,
                                                                      ModelContext context )
   {
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo = "" ;
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion = "" ;
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

   public String getSdtitemtitulo( )
   {
      return gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo ;
   }

   public void setSdtitemtitulo( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo = value ;
   }

   public String getStcitemdescripcion( )
   {
      return gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion ;
   }

   public void setStcitemdescripcion( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion = value ;
   }

   protected byte gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_N ;
   protected String gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo ;
   protected String gxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion ;
}

