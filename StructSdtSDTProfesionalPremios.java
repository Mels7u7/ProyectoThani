package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesionalPremios implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesionalPremios( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesionalPremios.class ));
   }

   public StructSdtSDTProfesionalPremios( int remoteHandle ,
                                          ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTProfesionalPremios_Premiosid = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      gxTv_SdtSDTProfesionalPremios_Premiosnombre = "" ;
      gxTv_SdtSDTProfesionalPremios_Premiosfecha = cal.getTime() ;
      gxTv_SdtSDTProfesionalPremios_Premiosdescripcion = "" ;
      gxTv_SdtSDTProfesionalPremios_Premiosfecha_N = (byte)(1) ;
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
      return gxTv_SdtSDTProfesionalPremios_Premiosid ;
   }

   public void setPremiosid( java.util.UUID value )
   {
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosid = value ;
   }

   public String getPremiosnombre( )
   {
      return gxTv_SdtSDTProfesionalPremios_Premiosnombre ;
   }

   public void setPremiosnombre( String value )
   {
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosnombre = value ;
   }

   public java.util.Date getPremiosfecha( )
   {
      return gxTv_SdtSDTProfesionalPremios_Premiosfecha ;
   }

   public void setPremiosfecha( java.util.Date value )
   {
      gxTv_SdtSDTProfesionalPremios_Premiosfecha_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosfecha = value ;
   }

   public String getPremiosdescripcion( )
   {
      return gxTv_SdtSDTProfesionalPremios_Premiosdescripcion ;
   }

   public void setPremiosdescripcion( String value )
   {
      gxTv_SdtSDTProfesionalPremios_N = (byte)(0) ;
      gxTv_SdtSDTProfesionalPremios_Premiosdescripcion = value ;
   }

   protected byte gxTv_SdtSDTProfesionalPremios_Premiosfecha_N ;
   protected byte gxTv_SdtSDTProfesionalPremios_N ;
   protected String gxTv_SdtSDTProfesionalPremios_Premiosdescripcion ;
   protected String gxTv_SdtSDTProfesionalPremios_Premiosnombre ;
   protected java.util.UUID gxTv_SdtSDTProfesionalPremios_Premiosid ;
   protected java.util.Date gxTv_SdtSDTProfesionalPremios_Premiosfecha ;
}

