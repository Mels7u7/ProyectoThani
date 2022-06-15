package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTDoctores implements Cloneable, java.io.Serializable
{
   public StructSdtSDTDoctores( )
   {
      this( -1, new ModelContext( StructSdtSDTDoctores.class ));
   }

   public StructSdtSDTDoctores( int remoteHandle ,
                                ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTDoctores_Apellidosnombres = "" ;
      gxTv_SdtSDTDoctores_Fotografia = "" ;
      gxTv_SdtSDTDoctores_Fotografia_gxi = "" ;
      gxTv_SdtSDTDoctores_Especialidad = "" ;
      gxTv_SdtSDTDoctores_Tipocita = "" ;
      gxTv_SdtSDTDoctores_Calificacion = "" ;
      gxTv_SdtSDTDoctores_Direccion = "" ;
      gxTv_SdtSDTDoctores_Disponibilidad = cal.getTime() ;
      gxTv_SdtSDTDoctores_Precioconsulta = "" ;
      gxTv_SdtSDTDoctores_Disponibilidad_N = (byte)(1) ;
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

   public String getApellidosnombres( )
   {
      return gxTv_SdtSDTDoctores_Apellidosnombres ;
   }

   public void setApellidosnombres( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Apellidosnombres = value ;
   }

   public String getFotografia( )
   {
      return gxTv_SdtSDTDoctores_Fotografia ;
   }

   public void setFotografia( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Fotografia = value ;
   }

   public String getFotografia_gxi( )
   {
      return gxTv_SdtSDTDoctores_Fotografia_gxi ;
   }

   public void setFotografia_gxi( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Fotografia_gxi = value ;
   }

   public String getEspecialidad( )
   {
      return gxTv_SdtSDTDoctores_Especialidad ;
   }

   public void setEspecialidad( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Especialidad = value ;
   }

   public short getEspecialidadid( )
   {
      return gxTv_SdtSDTDoctores_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Especialidadid = value ;
   }

   public String getTipocita( )
   {
      return gxTv_SdtSDTDoctores_Tipocita ;
   }

   public void setTipocita( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Tipocita = value ;
   }

   public String getCalificacion( )
   {
      return gxTv_SdtSDTDoctores_Calificacion ;
   }

   public void setCalificacion( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Calificacion = value ;
   }

   public String getDireccion( )
   {
      return gxTv_SdtSDTDoctores_Direccion ;
   }

   public void setDireccion( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Direccion = value ;
   }

   public java.util.Date getDisponibilidad( )
   {
      return gxTv_SdtSDTDoctores_Disponibilidad ;
   }

   public void setDisponibilidad( java.util.Date value )
   {
      gxTv_SdtSDTDoctores_Disponibilidad_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Disponibilidad = value ;
   }

   public String getPrecioconsulta( )
   {
      return gxTv_SdtSDTDoctores_Precioconsulta ;
   }

   public void setPrecioconsulta( String value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Precioconsulta = value ;
   }

   public int getProfesionalid( )
   {
      return gxTv_SdtSDTDoctores_Profesionalid ;
   }

   public void setProfesionalid( int value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Profesionalid = value ;
   }

   public short getSdtdoctoresverperfil( )
   {
      return gxTv_SdtSDTDoctores_Sdtdoctoresverperfil ;
   }

   public void setSdtdoctoresverperfil( short value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Sdtdoctoresverperfil = value ;
   }

   public short getSdtdoctoresreservarcita( )
   {
      return gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita ;
   }

   public void setSdtdoctoresreservarcita( short value )
   {
      gxTv_SdtSDTDoctores_N = (byte)(0) ;
      gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita = value ;
   }

   protected byte gxTv_SdtSDTDoctores_Disponibilidad_N ;
   protected byte gxTv_SdtSDTDoctores_N ;
   protected short gxTv_SdtSDTDoctores_Especialidadid ;
   protected short gxTv_SdtSDTDoctores_Sdtdoctoresverperfil ;
   protected short gxTv_SdtSDTDoctores_Sdtdoctoresreservarcita ;
   protected int gxTv_SdtSDTDoctores_Profesionalid ;
   protected String gxTv_SdtSDTDoctores_Calificacion ;
   protected String gxTv_SdtSDTDoctores_Apellidosnombres ;
   protected String gxTv_SdtSDTDoctores_Fotografia_gxi ;
   protected String gxTv_SdtSDTDoctores_Especialidad ;
   protected String gxTv_SdtSDTDoctores_Tipocita ;
   protected String gxTv_SdtSDTDoctores_Direccion ;
   protected String gxTv_SdtSDTDoctores_Precioconsulta ;
   protected String gxTv_SdtSDTDoctores_Fotografia ;
   protected java.util.Date gxTv_SdtSDTDoctores_Disponibilidad ;
}

