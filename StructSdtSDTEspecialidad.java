package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTEspecialidad implements Cloneable, java.io.Serializable
{
   public StructSdtSDTEspecialidad( )
   {
      this( -1, new ModelContext( StructSdtSDTEspecialidad.class ));
   }

   public StructSdtSDTEspecialidad( int remoteHandle ,
                                    ModelContext context )
   {
      gxTv_SdtSDTEspecialidad_Especialidadnombre = "" ;
      gxTv_SdtSDTEspecialidad_Especialidadcodigo = "" ;
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

   public short getEspecialidadid( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadid = value ;
   }

   public String getEspecialidadnombre( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadnombre ;
   }

   public void setEspecialidadnombre( String value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadnombre = value ;
   }

   public String getEspecialidadcodigo( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadcodigo ;
   }

   public void setEspecialidadcodigo( String value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadcodigo = value ;
   }

   public boolean getEspecialidadcheck( )
   {
      return gxTv_SdtSDTEspecialidad_Especialidadcheck ;
   }

   public void setEspecialidadcheck( boolean value )
   {
      gxTv_SdtSDTEspecialidad_N = (byte)(0) ;
      gxTv_SdtSDTEspecialidad_Especialidadcheck = value ;
   }

   protected byte gxTv_SdtSDTEspecialidad_N ;
   protected short gxTv_SdtSDTEspecialidad_Especialidadid ;
   protected boolean gxTv_SdtSDTEspecialidad_Especialidadcheck ;
   protected String gxTv_SdtSDTEspecialidad_Especialidadnombre ;
   protected String gxTv_SdtSDTEspecialidad_Especialidadcodigo ;
}

