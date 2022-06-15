package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTHorariosDoctor implements Cloneable, java.io.Serializable
{
   public StructSdtSDTHorariosDoctor( )
   {
      this( -1, new ModelContext( StructSdtSDTHorariosDoctor.class ));
   }

   public StructSdtSDTHorariosDoctor( int remoteHandle ,
                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes = "" ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha = cal.getTime() ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N = (byte)(1) ;
      gxTv_SdtSDTHorariosDoctor_Detalle_N = (byte)(1) ;
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

   public short getSdthorariosdoctorprofesionalid( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid ;
   }

   public void setSdthorariosdoctorprofesionalid( short value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid = value ;
   }

   public String getSdthorariosdoctornombresapellidos( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos ;
   }

   public void setSdthorariosdoctornombresapellidos( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos = value ;
   }

   public short getSdthorariosdoctorespecialidadid( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid ;
   }

   public void setSdthorariosdoctorespecialidadid( short value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid = value ;
   }

   public String getSdthorariosdoctorespecialidadnombre( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre ;
   }

   public void setSdthorariosdoctorespecialidadnombre( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre = value ;
   }

   public short getSdthorariosdoctornrodia( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia ;
   }

   public void setSdthorariosdoctornrodia( short value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia = value ;
   }

   public String getSdthorariosdoctornombredia( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia ;
   }

   public void setSdthorariosdoctornombredia( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia = value ;
   }

   public String getSdthorariosdoctornombremes( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes ;
   }

   public void setSdthorariosdoctornombremes( String value )
   {
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes = value ;
   }

   public java.util.Date getSdthorariosdoctorfecha( )
   {
      return gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha ;
   }

   public void setSdthorariosdoctorfecha( java.util.Date value )
   {
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem> getDetalle( )
   {
      return gxTv_SdtSDTHorariosDoctor_Detalle ;
   }

   public void setDetalle( java.util.Vector<com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem> value )
   {
      gxTv_SdtSDTHorariosDoctor_Detalle_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_N = (byte)(0) ;
      gxTv_SdtSDTHorariosDoctor_Detalle = value ;
   }

   protected byte gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_Detalle_N ;
   protected byte gxTv_SdtSDTHorariosDoctor_N ;
   protected short gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid ;
   protected short gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadid ;
   protected short gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorespecialidadnombre ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia ;
   protected String gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes ;
   protected java.util.Date gxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha ;
   protected java.util.Vector<com.projectthani.StructSdtSDTHorariosDoctor_DetalleItem> gxTv_SdtSDTHorariosDoctor_Detalle=null ;
}

