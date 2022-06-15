package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTDisponibilidadIds implements Cloneable, java.io.Serializable
{
   public StructSdtSDTDisponibilidadIds( )
   {
      this( -1, new ModelContext( StructSdtSDTDisponibilidadIds.class ));
   }

   public StructSdtSDTDisponibilidadIds( int remoteHandle ,
                                         ModelContext context )
   {
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

   public int getId( )
   {
      return gxTv_SdtSDTDisponibilidadIds_Id ;
   }

   public void setId( int value )
   {
      gxTv_SdtSDTDisponibilidadIds_N = (byte)(0) ;
      gxTv_SdtSDTDisponibilidadIds_Id = value ;
   }

   protected byte gxTv_SdtSDTDisponibilidadIds_N ;
   protected int gxTv_SdtSDTDisponibilidadIds_Id ;
}

