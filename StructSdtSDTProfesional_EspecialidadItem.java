package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTProfesional_EspecialidadItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTProfesional_EspecialidadItem( )
   {
      this( -1, new ModelContext( StructSdtSDTProfesional_EspecialidadItem.class ));
   }

   public StructSdtSDTProfesional_EspecialidadItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo = "" ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre = "" ;
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
      return gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid ;
   }

   public void setEspecialidadid( short value )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid = value ;
   }

   public String getEspecialidadcodigo( )
   {
      return gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo ;
   }

   public void setEspecialidadcodigo( String value )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo = value ;
   }

   public String getEspecialidadnombre( )
   {
      return gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre ;
   }

   public void setEspecialidadnombre( String value )
   {
      gxTv_SdtSDTProfesional_EspecialidadItem_N = (byte)(0) ;
      gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre = value ;
   }

   protected byte gxTv_SdtSDTProfesional_EspecialidadItem_N ;
   protected short gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid ;
   protected String gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo ;
   protected String gxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre ;
}

