package com.projectthani ;
import com.genexus.*;

public final  class StructSdtEspecialidad_Sede implements Cloneable, java.io.Serializable
{
   public StructSdtEspecialidad_Sede( )
   {
      this( -1, new ModelContext( StructSdtEspecialidad_Sede.class ));
   }

   public StructSdtEspecialidad_Sede( int remoteHandle ,
                                      ModelContext context )
   {
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre = "" ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre = "" ;
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta = new java.math.BigDecimal(0) ;
      gxTv_SdtEspecialidad_Sede_Mode = "" ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z = "" ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z = "" ;
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z = new java.math.BigDecimal(0) ;
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
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid ;
   }

   public void setSgespecialidadsedeid( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid = value ;
   }

   public String getSgespecialidadsedenombre( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre ;
   }

   public void setSgespecialidadsedenombre( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre = value ;
   }

   public short getSgespecialidadsedeclinicaid( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid ;
   }

   public void setSgespecialidadsedeclinicaid( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid = value ;
   }

   public String getSgespecialidadsedeclinicanombre( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre ;
   }

   public void setSgespecialidadsedeclinicanombre( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre = value ;
   }

   public java.math.BigDecimal getSedecostoconsulta( )
   {
      return gxTv_SdtEspecialidad_Sede_Sedecostoconsulta ;
   }

   public void setSedecostoconsulta( java.math.BigDecimal value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtEspecialidad_Sede_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtEspecialidad_Sede_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtEspecialidad_Sede_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Initialized = value ;
   }

   public short getSgespecialidadsedeid_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z ;
   }

   public void setSgespecialidadsedeid_Z( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z = value ;
   }

   public String getSgespecialidadsedenombre_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z ;
   }

   public void setSgespecialidadsedenombre_Z( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z = value ;
   }

   public short getSgespecialidadsedeclinicaid_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z ;
   }

   public void setSgespecialidadsedeclinicaid_Z( short value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z = value ;
   }

   public String getSgespecialidadsedeclinicanombre_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z ;
   }

   public void setSgespecialidadsedeclinicanombre_Z( String value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z = value ;
   }

   public java.math.BigDecimal getSedecostoconsulta_Z( )
   {
      return gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z ;
   }

   public void setSedecostoconsulta_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEspecialidad_Sede_N = (byte)(0) ;
      gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z = value ;
   }

   private byte gxTv_SdtEspecialidad_Sede_N ;
   protected short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid ;
   protected short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid ;
   protected short gxTv_SdtEspecialidad_Sede_Modified ;
   protected short gxTv_SdtEspecialidad_Sede_Initialized ;
   protected short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z ;
   protected short gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z ;
   protected String gxTv_SdtEspecialidad_Sede_Mode ;
   protected String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre ;
   protected String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre ;
   protected String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z ;
   protected String gxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z ;
   protected java.math.BigDecimal gxTv_SdtEspecialidad_Sede_Sedecostoconsulta ;
   protected java.math.BigDecimal gxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z ;
}

