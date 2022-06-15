package com.projectthani ;
import com.genexus.*;

public final  class StructSdtRatingPlataforma implements Cloneable, java.io.Serializable
{
   public StructSdtRatingPlataforma( )
   {
      this( -1, new ModelContext( StructSdtRatingPlataforma.class ));
   }

   public StructSdtRatingPlataforma( int remoteHandle ,
                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro = cal.getTime() ;
      gxTv_SdtRatingPlataforma_Mode = "" ;
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z = cal.getTime() ;
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

   public int getRatingplataformaid( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformaid ;
   }

   public void setRatingplataformaid( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformaid = value ;
   }

   public int getSgpacientepacienteid( )
   {
      return gxTv_SdtRatingPlataforma_Sgpacientepacienteid ;
   }

   public void setSgpacientepacienteid( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Sgpacientepacienteid = value ;
   }

   public short getRatingplataformacitaid( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformacitaid ;
   }

   public void setRatingplataformacitaid( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformacitaid = value ;
   }

   public short getRatingplataformarating( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformarating ;
   }

   public void setRatingplataformarating( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformarating = value ;
   }

   public java.util.Date getRatingplataformafecharegistro( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro ;
   }

   public void setRatingplataformafecharegistro( java.util.Date value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtRatingPlataforma_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtRatingPlataforma_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Initialized = value ;
   }

   public int getRatingplataformaid_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformaid_Z ;
   }

   public void setRatingplataformaid_Z( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformaid_Z = value ;
   }

   public int getSgpacientepacienteid_Z( )
   {
      return gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z ;
   }

   public void setSgpacientepacienteid_Z( int value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z = value ;
   }

   public short getRatingplataformacitaid_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z ;
   }

   public void setRatingplataformacitaid_Z( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z = value ;
   }

   public short getRatingplataformarating_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformarating_Z ;
   }

   public void setRatingplataformarating_Z( short value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformarating_Z = value ;
   }

   public java.util.Date getRatingplataformafecharegistro_Z( )
   {
      return gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z ;
   }

   public void setRatingplataformafecharegistro_Z( java.util.Date value )
   {
      gxTv_SdtRatingPlataforma_N = (byte)(0) ;
      gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z = value ;
   }

   private byte gxTv_SdtRatingPlataforma_N ;
   protected short gxTv_SdtRatingPlataforma_Ratingplataformacitaid ;
   protected short gxTv_SdtRatingPlataforma_Ratingplataformarating ;
   protected short gxTv_SdtRatingPlataforma_Initialized ;
   protected short gxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z ;
   protected short gxTv_SdtRatingPlataforma_Ratingplataformarating_Z ;
   protected int gxTv_SdtRatingPlataforma_Ratingplataformaid ;
   protected int gxTv_SdtRatingPlataforma_Sgpacientepacienteid ;
   protected int gxTv_SdtRatingPlataforma_Ratingplataformaid_Z ;
   protected int gxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z ;
   protected String gxTv_SdtRatingPlataforma_Mode ;
   protected java.util.Date gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro ;
   protected java.util.Date gxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z ;
}

