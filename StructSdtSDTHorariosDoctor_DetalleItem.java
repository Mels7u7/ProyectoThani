package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTHorariosDoctor_DetalleItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTHorariosDoctor_DetalleItem( )
   {
      this( -1, new ModelContext( StructSdtSDTHorariosDoctor_DetalleItem.class ));
   }

   public StructSdtSDTHorariosDoctor_DetalleItem( int remoteHandle ,
                                                  ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio = cal.getTime() ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin = cal.getTime() ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor = "" ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N = (byte)(1) ;
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

   public int getSdthorariosdoctordetalledisponibilidadid( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid ;
   }

   public void setSdthorariosdoctordetalledisponibilidadid( int value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid = value ;
   }

   public String getSdthorariosdoctordetallehora( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora ;
   }

   public void setSdthorariosdoctordetallehora( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora = value ;
   }

   public java.util.Date getSdthorariosdoctordetallehorainicio( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio ;
   }

   public void setSdthorariosdoctordetallehorainicio( java.util.Date value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio = value ;
   }

   public java.util.Date getSdthorariosdoctordetallehorafin( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin ;
   }

   public void setSdthorariosdoctordetallehorafin( java.util.Date value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin = value ;
   }

   public String getSdthorariosdoctordetalletipocita( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita ;
   }

   public void setSdthorariosdoctordetalletipocita( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita = value ;
   }

   public java.math.BigDecimal getSdthorariosdoctordetallecostocita( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita ;
   }

   public void setSdthorariosdoctordetallecostocita( java.math.BigDecimal value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita = value ;
   }

   public String getSdthorariosdoctordetalleestado( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado ;
   }

   public void setSdthorariosdoctordetalleestado( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado = value ;
   }

   public String getSdthorariosdoctordetallelink( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink ;
   }

   public void setSdthorariosdoctordetallelink( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink = value ;
   }

   public String getSdthorariosdoctordetallecolor( )
   {
      return gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor ;
   }

   public void setSdthorariosdoctordetallecolor( String value )
   {
      gxTv_SdtSDTHorariosDoctor_DetalleItem_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor = value ;
   }

   protected byte gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_DetalleItem_N ;
   protected int gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink ;
   protected String gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor ;
   protected java.util.Date gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio ;
   protected java.util.Date gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin ;
   protected java.math.BigDecimal gxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita ;
}

