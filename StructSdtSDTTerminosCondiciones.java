package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTTerminosCondiciones implements Cloneable, java.io.Serializable
{
   public StructSdtSDTTerminosCondiciones( )
   {
      this( -1, new ModelContext( StructSdtSDTTerminosCondiciones.class ));
   }

   public StructSdtSDTTerminosCondiciones( int remoteHandle ,
                                           ModelContext context )
   {
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo = "" ;
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion = "" ;
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N = (byte)(1) ;
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

   public String getTerminoscondicionestitulo( )
   {
      return gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo ;
   }

   public void setTerminoscondicionestitulo( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo = value ;
   }

   public String getTerminoscondicionesdescripcion( )
   {
      return gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion ;
   }

   public void setTerminoscondicionesdescripcion( String value )
   {
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> getSubterminoscondiciones( )
   {
      return gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones ;
   }

   public void setSubterminoscondiciones( java.util.Vector<com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> value )
   {
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_N = (byte)(0) ;
      gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones = value ;
   }

   protected byte gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones_N ;
   protected byte gxTv_SdtSDTTerminosCondiciones_N ;
   protected String gxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo ;
   protected String gxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion ;
   protected java.util.Vector<com.projectthani.StructSdtSDTTerminosCondiciones_SubTerminosCondicionesItem> gxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones=null ;
}

