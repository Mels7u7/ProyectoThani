package com.projectthani ;
import com.genexus.*;

public final  class StructSdtRatingProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtRatingProfesional( )
   {
      this( -1, new ModelContext( StructSdtRatingProfesional.class ));
   }

   public StructSdtRatingProfesional( int remoteHandle ,
                                      ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro = cal.getTime() ;
      gxTv_SdtRatingProfesional_Mode = "" ;
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z = cal.getTime() ;
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

   public int getRatingprofesionalid( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalid ;
   }

   public void setRatingprofesionalid( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalid = value ;
   }

   public int getSgprofesionalprofesionalid( )
   {
      return gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid ;
   }

   public void setSgprofesionalprofesionalid( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid = value ;
   }

   public int getSgpacientepacienteid( )
   {
      return gxTv_SdtRatingProfesional_Sgpacientepacienteid ;
   }

   public void setSgpacientepacienteid( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Sgpacientepacienteid = value ;
   }

   public short getRatingprofesionalcitaid( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalcitaid ;
   }

   public void setRatingprofesionalcitaid( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalcitaid = value ;
   }

   public short getRatingprofesionalrating( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalrating ;
   }

   public void setRatingprofesionalrating( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalrating = value ;
   }

   public java.util.Date getRatingprofesionalfecharegistro( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro ;
   }

   public void setRatingprofesionalfecharegistro( java.util.Date value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtRatingProfesional_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtRatingProfesional_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Initialized = value ;
   }

   public int getRatingprofesionalid_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalid_Z ;
   }

   public void setRatingprofesionalid_Z( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalid_Z = value ;
   }

   public int getSgprofesionalprofesionalid_Z( )
   {
      return gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z ;
   }

   public void setSgprofesionalprofesionalid_Z( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z = value ;
   }

   public int getSgpacientepacienteid_Z( )
   {
      return gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z ;
   }

   public void setSgpacientepacienteid_Z( int value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z = value ;
   }

   public short getRatingprofesionalcitaid_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z ;
   }

   public void setRatingprofesionalcitaid_Z( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z = value ;
   }

   public short getRatingprofesionalrating_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z ;
   }

   public void setRatingprofesionalrating_Z( short value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z = value ;
   }

   public java.util.Date getRatingprofesionalfecharegistro_Z( )
   {
      return gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z ;
   }

   public void setRatingprofesionalfecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtRatingProfesional_N = (byte)(0) ;
      gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z = value ;
   }

   private byte gxTv_SdtRatingProfesional_N ;
   protected short gxTv_SdtRatingProfesional_Ratingprofesionalcitaid ;
   protected short gxTv_SdtRatingProfesional_Ratingprofesionalrating ;
   protected short gxTv_SdtRatingProfesional_Initialized ;
   protected short gxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z ;
   protected short gxTv_SdtRatingProfesional_Ratingprofesionalrating_Z ;
   protected int gxTv_SdtRatingProfesional_Ratingprofesionalid ;
   protected int gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid ;
   protected int gxTv_SdtRatingProfesional_Sgpacientepacienteid ;
   protected int gxTv_SdtRatingProfesional_Ratingprofesionalid_Z ;
   protected int gxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z ;
   protected int gxTv_SdtRatingProfesional_Sgpacientepacienteid_Z ;
   protected String gxTv_SdtRatingProfesional_Mode ;
   protected java.util.Date gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro ;
   protected java.util.Date gxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z ;
}

