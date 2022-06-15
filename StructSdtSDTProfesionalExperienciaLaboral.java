package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalExperienciaLaboral implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalExperienciaLaboral( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalExperienciaLaboral.class ));
   }

   public StructSdtSDTProfesionalExperienciaLaboral( int remoteHandle ,
                                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre = "" ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde = cal.getTime() ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta = cal.getTime() ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N = (byte)(1) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N = (byte)(1) ;
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

   public java.util.UUID getExperiencialaboralid( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid ;
   }

   public void setExperiencialaboralid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid = value ;
   }

   public String getExperiencialaboralempresanombre( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre ;
   }

   public void setExperiencialaboralempresanombre( String value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre = value ;
   }

   public java.util.Date getExperiencialaboraldesde( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde ;
   }

   public void setExperiencialaboraldesde( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde = value ;
   }

   public java.util.Date getExperiencialaboralhasta( )
   {
      return gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta ;
   }

   public void setExperiencialaboralhasta( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta = value ;
   }

   protected byte gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta_N ;
   protected byte gxTv_SdtSDTProfesionalExperienciaLaboral_N ;
   protected String gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde ;
   protected java.util.Date gxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta ;
}

