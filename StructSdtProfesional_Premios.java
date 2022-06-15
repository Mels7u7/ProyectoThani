package com.projectthani ;
import com.genexus.*;

public final  class StructSdtProfesional_Premios implements Cloneable, java.io.Serializable
{
   public StructSdtProfesional_Premios( )
   {
      this( -1, new ModelContext( StructSdtProfesional_Premios.class ));
   }

   public StructSdtProfesional_Premios( int remoteHandle ,
                                        ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtProfesional_Premios_Premiosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Premios_Premiosnombre = "" ;
      gxTv_SdtProfesional_Premios_Premiosfecha = cal.getTime() ;
      gxTv_SdtProfesional_Premios_Premiosdescripcion = "" ;
      gxTv_SdtProfesional_Premios_Mode = "" ;
      gxTv_SdtProfesional_Premios_Premiosid_Z = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtProfesional_Premios_Premiosnombre_Z = "" ;
      gxTv_SdtProfesional_Premios_Premiosfecha_Z = cal.getTime() ;
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

   public java.util.UUID getPremiosid( )
   {
      return gxTv_SdtProfesional_Premios_Premiosid ;
   }

   public void setPremiosid( java.util.UUID value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Premiosid = value ;
   }

   public String getPremiosnombre( )
   {
      return gxTv_SdtProfesional_Premios_Premiosnombre ;
   }

   public void setPremiosnombre( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Premiosnombre = value ;
   }

   public java.util.Date getPremiosfecha( )
   {
      return gxTv_SdtProfesional_Premios_Premiosfecha ;
   }

   public void setPremiosfecha( java.util.Date value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Premiosfecha = value ;
   }

   public String getPremiosdescripcion( )
   {
      return gxTv_SdtProfesional_Premios_Premiosdescripcion ;
   }

   public void setPremiosdescripcion( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Premiosdescripcion = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtProfesional_Premios_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtProfesional_Premios_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtProfesional_Premios_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Initialized = value ;
   }

   public java.util.UUID getPremiosid_Z( )
   {
      return gxTv_SdtProfesional_Premios_Premiosid_Z ;
   }

   public void setPremiosid_Z( java.util.UUID value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Premiosid_Z = value ;
   }

   public String getPremiosnombre_Z( )
   {
      return gxTv_SdtProfesional_Premios_Premiosnombre_Z ;
   }

   public void setPremiosnombre_Z( String value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Premiosnombre_Z = value ;
   }

   public java.util.Date getPremiosfecha_Z( )
   {
      return gxTv_SdtProfesional_Premios_Premiosfecha_Z ;
   }

   public void setPremiosfecha_Z( java.util.Date value )
   {
      gxTv_SdtProfesional_Premios_N = (byte)(0) ;
      gxTv_SdtProfesional_Premios_Premiosfecha_Z = value ;
   }

   private byte gxTv_SdtProfesional_Premios_N ;
   protected short gxTv_SdtProfesional_Premios_Modified ;
   protected short gxTv_SdtProfesional_Premios_Initialized ;
   protected String gxTv_SdtProfesional_Premios_Mode ;
   protected String gxTv_SdtProfesional_Premios_Premiosdescripcion ;
   protected String gxTv_SdtProfesional_Premios_Premiosnombre ;
   protected String gxTv_SdtProfesional_Premios_Premiosnombre_Z ;
   protected java.util.UUID gxTv_SdtProfesional_Premios_Premiosid ;
   protected java.util.UUID gxTv_SdtProfesional_Premios_Premiosid_Z ;
   protected java.util.Date gxTv_SdtProfesional_Premios_Premiosfecha ;
   protected java.util.Date gxTv_SdtProfesional_Premios_Premiosfecha_Z ;
}

