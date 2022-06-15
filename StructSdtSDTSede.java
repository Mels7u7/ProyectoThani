package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTSede implements Cloneable, java.io.Serializable
{
   public StructSdtSDTSede( )
   {
      this( -1, new ModelContext( StructSdtSDTSede.class ));
   }

   public StructSdtSDTSede( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtSDTSede_Sgespecialidadsedenombre = "" ;
      gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre = "" ;
      gxTv_SdtSDTSede_Sedefullname = "" ;
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

   public short getSgespecialidadsedeid( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedeid ;
   }

   public void setSgespecialidadsedeid( short value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedeid = value ;
   }

   public String getSgespecialidadsedenombre( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedenombre ;
   }

   public void setSgespecialidadsedenombre( String value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedenombre = value ;
   }

   public short getSgespecialidadsedeclinicaid( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid ;
   }

   public void setSgespecialidadsedeclinicaid( short value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid = value ;
   }

   public String getSgespecialidadsedeclinicanombre( )
   {
      return gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre ;
   }

   public void setSgespecialidadsedeclinicanombre( String value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre = value ;
   }

   public String getSedefullname( )
   {
      return gxTv_SdtSDTSede_Sedefullname ;
   }

   public void setSedefullname( String value )
   {
      gxTv_SdtSDTSede_N = (byte)(0) ;
      gxTv_SdtSDTSede_Sedefullname = value ;
   }

   protected byte gxTv_SdtSDTSede_N ;
   protected short gxTv_SdtSDTSede_Sgespecialidadsedeid ;
   protected short gxTv_SdtSDTSede_Sgespecialidadsedeclinicaid ;
   protected String gxTv_SdtSDTSede_Sgespecialidadsedenombre ;
   protected String gxTv_SdtSDTSede_Sgespecialidadsedeclinicanombre ;
   protected String gxTv_SdtSDTSede_Sedefullname ;
}

