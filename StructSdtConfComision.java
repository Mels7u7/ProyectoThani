package com.projectthani ;
import com.genexus.*;

public final  class StructSdtConfComision implements Cloneable, java.io.Serializable
{
   public StructSdtConfComision( )
   {
      this( -1, new ModelContext( StructSdtConfComision.class ));
   }

   public StructSdtConfComision( int remoteHandle ,
                                 ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtConfComision_Fechadesde = cal.getTime() ;
      gxTv_SdtConfComision_Fechahasta = cal.getTime() ;
      gxTv_SdtConfComision_Estado = "" ;
      gxTv_SdtConfComision_Mode = "" ;
      gxTv_SdtConfComision_Fechadesde_Z = cal.getTime() ;
      gxTv_SdtConfComision_Fechahasta_Z = cal.getTime() ;
      gxTv_SdtConfComision_Estado_Z = "" ;
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

   public short getConfcomisionid( )
   {
      return gxTv_SdtConfComision_Confcomisionid ;
   }

   public void setConfcomisionid( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Confcomisionid = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtConfComision_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Profesionalid = value ;
   }

   public short getEspecialidadid( )
   {
      return gxTv_SdtConfComision_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Especialidadid = value ;
   }

   public short getSedeid( )
   {
      return gxTv_SdtConfComision_Sedeid ;
   }

   public void setSedeid( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Sedeid = value ;
   }

   public java.util.Date getFechadesde( )
   {
      return gxTv_SdtConfComision_Fechadesde ;
   }

   public void setFechadesde( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Fechadesde = value ;
   }

   public java.util.Date getFechahasta( )
   {
      return gxTv_SdtConfComision_Fechahasta ;
   }

   public void setFechahasta( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Fechahasta = value ;
   }

   public short getPorcentaje( )
   {
      return gxTv_SdtConfComision_Porcentaje ;
   }

   public void setPorcentaje( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Porcentaje = value ;
   }

   public String getEstado( )
   {
      return gxTv_SdtConfComision_Estado ;
   }

   public void setEstado( String value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Estado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtConfComision_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtConfComision_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Initialized = value ;
   }

   public short getConfcomisionid_Z( )
   {
      return gxTv_SdtConfComision_Confcomisionid_Z ;
   }

   public void setConfcomisionid_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Confcomisionid_Z = value ;
   }

   public int getProfesionalid_Z( )
   {
      return gxTv_SdtConfComision_Profesionalid_Z ;
   }

   public void setProfesionalid_Z( int value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Profesionalid_Z = value ;
   }

   public short getEspecialidadid_Z( )
   {
      return gxTv_SdtConfComision_Especialidadid_Z ;
   }

   public void setEspecialidadid_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Especialidadid_Z = value ;
   }

   public short getSedeid_Z( )
   {
      return gxTv_SdtConfComision_Sedeid_Z ;
   }

   public void setSedeid_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Sedeid_Z = value ;
   }

   public java.util.Date getFechadesde_Z( )
   {
      return gxTv_SdtConfComision_Fechadesde_Z ;
   }

   public void setFechadesde_Z( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Fechadesde_Z = value ;
   }

   public java.util.Date getFechahasta_Z( )
   {
      return gxTv_SdtConfComision_Fechahasta_Z ;
   }

   public void setFechahasta_Z( java.util.Date value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Fechahasta_Z = value ;
   }

   public short getPorcentaje_Z( )
   {
      return gxTv_SdtConfComision_Porcentaje_Z ;
   }

   public void setPorcentaje_Z( short value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Porcentaje_Z = value ;
   }

   public String getEstado_Z( )
   {
      return gxTv_SdtConfComision_Estado_Z ;
   }

   public void setEstado_Z( String value )
   {
      gxTv_SdtConfComision_N = (byte)(0) ;
      gxTv_SdtConfComision_Estado_Z = value ;
   }

   private byte gxTv_SdtConfComision_N ;
   protected short gxTv_SdtConfComision_Confcomisionid ;
   protected short gxTv_SdtConfComision_Especialidadid ;
   protected short gxTv_SdtConfComision_Sedeid ;
   protected short gxTv_SdtConfComision_Porcentaje ;
   protected short gxTv_SdtConfComision_Initialized ;
   protected short gxTv_SdtConfComision_Confcomisionid_Z ;
   protected short gxTv_SdtConfComision_Especialidadid_Z ;
   protected short gxTv_SdtConfComision_Sedeid_Z ;
   protected short gxTv_SdtConfComision_Porcentaje_Z ;
   protected int gxTv_SdtConfComision_Profesionalid ;
   protected int gxTv_SdtConfComision_Profesionalid_Z ;
   protected String gxTv_SdtConfComision_Estado ;
   protected String gxTv_SdtConfComision_Mode ;
   protected String gxTv_SdtConfComision_Estado_Z ;
   protected java.util.Date gxTv_SdtConfComision_Fechadesde ;
   protected java.util.Date gxTv_SdtConfComision_Fechahasta ;
   protected java.util.Date gxTv_SdtConfComision_Fechadesde_Z ;
   protected java.util.Date gxTv_SdtConfComision_Fechahasta_Z ;
}

