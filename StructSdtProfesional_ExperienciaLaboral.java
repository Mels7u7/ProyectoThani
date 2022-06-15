package com.projectthani ;
import com.genexus.*;

public final  class StructSdtProfesional_ExperienciaLaboral implements Cloneable, java.io.Serializable
{
   public StructSdtProfesional_ExperienciaLaboral( )
   {
      this( -1, new ModelContext( StructSdtProfesional_ExperienciaLaboral.class ));
   }

   public StructSdtProfesional_ExperienciaLaboral( int remoteHandle ,
                                                   ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre = "" ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde = cal.getTime() ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta = cal.getTime() ;
      gxTv_SdtProfesional_ExperienciaLaboral_Mode = "" ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z = "" ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z = cal.getTime() ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z = cal.getTime() ;
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
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid ;
   }

   public void setExperiencialaboralid( java.util.UUID value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid = value ;
   }

   public String getExperiencialaboralempresanombre( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre ;
   }

   public void setExperiencialaboralempresanombre( String value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre = value ;
   }

   public java.util.Date getExperiencialaboraldesde( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde ;
   }

   public void setExperiencialaboraldesde( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde = value ;
   }

   public java.util.Date getExperiencialaboralhasta( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta ;
   }

   public void setExperiencialaboralhasta( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Initialized = value ;
   }

   public java.util.UUID getExperiencialaboralid_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z ;
   }

   public void setExperiencialaboralid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z = value ;
   }

   public String getExperiencialaboralempresanombre_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z ;
   }

   public void setExperiencialaboralempresanombre_Z( String value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z = value ;
   }

   public java.util.Date getExperiencialaboraldesde_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z ;
   }

   public void setExperiencialaboraldesde_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z = value ;
   }

   public java.util.Date getExperiencialaboralhasta_Z( )
   {
      return gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z ;
   }

   public void setExperiencialaboralhasta_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_ExperienciaLaboral_N = (byte)(0) ;
      gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z = value ;
   }

   private byte gxTv_SdtProfesional_ExperienciaLaboral_N ;
   protected short gxTv_SdtProfesional_ExperienciaLaboral_Modified ;
   protected short gxTv_SdtProfesional_ExperienciaLaboral_Initialized ;
   protected String gxTv_SdtProfesional_ExperienciaLaboral_Mode ;
   protected String gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre ;
   protected String gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z ;
   protected java.util.UUID gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid ;
   protected java.util.UUID gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z ;
   protected java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde ;
   protected java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta ;
   protected java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z ;
   protected java.util.Date gxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z ;
}

