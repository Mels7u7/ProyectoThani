package com.projectthani ;
import com.genexus.*;

public final  class StructSdtReclamo implements Cloneable, java.io.Serializable
{
   public StructSdtReclamo( )
   {
      this( -1, new ModelContext( StructSdtReclamo.class ));
   }

   public StructSdtReclamo( int remoteHandle ,
                            ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtReclamo_Reclamodescripcion = "" ;
      gxTv_SdtReclamo_Reclamofecha = cal.getTime() ;
      gxTv_SdtReclamo_Mode = "" ;
      gxTv_SdtReclamo_Reclamofecha_Z = cal.getTime() ;
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

   public int getReclamoid( )
   {
      return gxTv_SdtReclamo_Reclamoid ;
   }

   public void setReclamoid( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Reclamoid = value ;
   }

   public int getPacienteid( )
   {
      return gxTv_SdtReclamo_Pacienteid ;
   }

   public void setPacienteid( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Pacienteid = value ;
   }

   public String getReclamodescripcion( )
   {
      return gxTv_SdtReclamo_Reclamodescripcion ;
   }

   public void setReclamodescripcion( String value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Reclamodescripcion = value ;
   }

   public java.util.Date getReclamofecha( )
   {
      return gxTv_SdtReclamo_Reclamofecha ;
   }

   public void setReclamofecha( java.util.Date value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Reclamofecha = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtReclamo_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtReclamo_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Initialized = value ;
   }

   public int getReclamoid_Z( )
   {
      return gxTv_SdtReclamo_Reclamoid_Z ;
   }

   public void setReclamoid_Z( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Reclamoid_Z = value ;
   }

   public int getPacienteid_Z( )
   {
      return gxTv_SdtReclamo_Pacienteid_Z ;
   }

   public void setPacienteid_Z( int value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Pacienteid_Z = value ;
   }

   public java.util.Date getReclamofecha_Z( )
   {
      return gxTv_SdtReclamo_Reclamofecha_Z ;
   }

   public void setReclamofecha_Z( java.util.Date value )
   {
      gxTv_SdtReclamo_N = (byte)(0) ;
      gxTv_SdtReclamo_Reclamofecha_Z = value ;
   }

   private byte gxTv_SdtReclamo_N ;
   protected short gxTv_SdtReclamo_Initialized ;
   protected int gxTv_SdtReclamo_Reclamoid ;
   protected int gxTv_SdtReclamo_Pacienteid ;
   protected int gxTv_SdtReclamo_Reclamoid_Z ;
   protected int gxTv_SdtReclamo_Pacienteid_Z ;
   protected String gxTv_SdtReclamo_Mode ;
   protected String gxTv_SdtReclamo_Reclamodescripcion ;
   protected java.util.Date gxTv_SdtReclamo_Reclamofecha ;
   protected java.util.Date gxTv_SdtReclamo_Reclamofecha_Z ;
}

